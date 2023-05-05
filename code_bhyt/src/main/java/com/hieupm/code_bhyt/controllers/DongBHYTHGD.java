package com.hieupm.code_bhyt.controllers;

import com.hieupm.code_bhyt.dto.request.ChuHoDTO;
import com.hieupm.code_bhyt.dto.request.DongBHYTHGDRequest;
import com.hieupm.code_bhyt.dto.request.HoGiaDinhDTO;
import com.hieupm.code_bhyt.dto.request.ThanhVienHGDRequest;
import com.hieupm.code_bhyt.dto.response.DongBHYTHGDResponse;
import com.hieupm.code_bhyt.models.User;
import com.hieupm.code_bhyt.payload.response.Response;
import com.hieupm.code_bhyt.repository.ChiTietHoaDonRepository;
import com.hieupm.code_bhyt.repository.HoGiaDinhRepository;
import com.hieupm.code_bhyt.repository.LuongCoSoRepository;
import com.hieupm.code_bhyt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/dong-bhyt-hgd")
public class DongBHYTHGD {
    @Autowired
    HoGiaDinhRepository hoGiaDinhRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    LuongCoSoRepository luongCoSoRepository;

    @Autowired
    ChiTietHoaDonRepository chiTietHoaDonRepository;

//    @GetMapping("/get")
//    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
//    public ResponseEntity<Response> getDongBHYTHGD() {
//        return ResponseEntity.ok(new Response("success","Get DongBHYTHGD for USER, ADMIN, MODERATOR"));
//    }

    @PostMapping("/get")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity addDongBHYTHGD(@RequestBody DongBHYTHGDRequest dongBHYTHGDRequest) {
        if(dongBHYTHGDRequest.getChuHoDTO()==null || dongBHYTHGDRequest.getThanhVienHGDRequestList() == null){
            return ResponseEntity.ok(new Response("fail","Vui lòng điền đầy đủ thông tin hộ gia đình !"));
        }
        ChuHoDTO chuHoDTO = dongBHYTHGDRequest.getChuHoDTO();
        Optional<User> opChuHo = userRepository.findByCccd(chuHoDTO.getCccd());
        if(!opChuHo.isPresent()){
            return ResponseEntity.ok(new Response("fail","Thông tin công dân của chủ hộ chưa được Cơ sở dữ liệu quốc gia về dân cư xác thực !"));
        }
        User chuHo = opChuHo.get();
        if(!chuHo.getQuanHeChuHo().equals("Chủ hộ")){
            return ResponseEntity.ok(new Response("fail","Thông tin chủ hộ không hợp lệ"));
        }
        if (chuHo.getHoTen().equals(chuHoDTO.getHoTen())==false){
            return ResponseEntity.ok(new Response("fail","Họ tên của chủ hộ không trùng khớp với Cơ sở dữ liệu quốc gia về dân cư"));
        }
        if (chuHo.getNgaySinh().equals(chuHoDTO.getNgaySinh())==false){
            return ResponseEntity.ok(new Response("fail","Ngày sinh của chủ hộ không trùng khớp với Cơ sở dữ liệu quốc gia về dân cư"));
        }
        if (chuHo.getGioiTinh().equals(chuHoDTO.getGioiTinh())==false){
            return ResponseEntity.ok(new Response("fail","Giới tính của chủ hộ không trùng khớp với Cơ sở dữ liệu quốc gia về dân cư"));
        }
        List<ThanhVienHGDRequest> thanhVien = (ArrayList) dongBHYTHGDRequest.getThanhVienHGDRequestList();
        String maHGD = chuHo.getHoGiaDinh().getCode();
        List<User> users = userRepository.findByMaHoGiaDinh(maHGD);
        if(thanhVien.size() != users.size()){
            return ResponseEntity.ok(new Response("fail","Vui lòng điền chính xác thông tin hộ gia đình"));
        }
        for (ThanhVienHGDRequest i : thanhVien){
            int ok=0;
            for (User j:users){
                if(i.getCccd().equals(j.getCccd())){
                    if(i.getHoTen().equals(j.getHoTen())==false){
                        String mess="Họ tên thành viên mã định danh "+i.getCccd()+" không trùng khớp với CSDL QG";
                        return ResponseEntity.ok(new Response("fail",mess));
                    }
                    if(i.getNgaySinh().equals(j.getNgaySinh())==false){
                        String mess="Ngày sinh thành viên mã định danh "+i.getCccd()+" không trùng khớp với CSDL QG";
                        return ResponseEntity.ok(new Response("fail",mess));
                    }
                    if(i.getGioiTinh().equals(j.getGioiTinh())==false){
                        String mess="Giới tính thành viên mã định danh "+i.getCccd()+" không trùng khớp với CSDL QG";
                        return ResponseEntity.ok(new Response("fail",mess));
                    }
                    ok=1;
                }
            }
            if(ok==0){
                String resp = "Không tồn tại thành viên mã định danh: "+i.getCccd()+" trong hộ gia đình của chủ hộ "+chuHo.getHoTen();
                return ResponseEntity.ok(new Response("fail",resp));
            }
        }
        List<DongBHYTHGDResponse> responses  = new ArrayList<>();
        int dem=0;
        Date hienTai = new Date();
        double luongCoSo=luongCoSoRepository.findMucLuongCoSoByNgayGanNhat(hienTai);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        double tongTien = 0;
        for (ThanhVienHGDRequest i:thanhVien){
            DongBHYTHGDResponse dongBHYTHGDResponse = new DongBHYTHGDResponse();
            dongBHYTHGDResponse.setCccd(i.getCccd());
            dongBHYTHGDResponse.setHoTen(i.getHoTen());
            dongBHYTHGDResponse.setNgaySinh(i.getNgaySinh());
            dongBHYTHGDResponse.setGioiTinh(i.getGioiTinh());
            dongBHYTHGDResponse.setGiaHan(i.getGiaHan());
            User nguoiNhan = userRepository.findByCccd(i.getCccd()).get();
            dongBHYTHGDResponse.setBhxh(nguoiNhan.getUsername());
            dongBHYTHGDResponse.setBhyt(nguoiNhan.getBhyt());
            String maBHYT = nguoiNhan.getBhyt();
            String maDoiTuong = maBHYT.substring(0,2);

            // cập nhật thời hạn
            Date tuNgayDate = chiTietHoaDonRepository.findNgayKetThucByBHYTNguoiThuhuong(nguoiNhan.getBhyt());
            if(tuNgayDate==null){
                tuNgayDate = hienTai;
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(tuNgayDate);
            calendar.add(Calendar.DATE, -1);
            calendar.add(Calendar.MONTH, i.getGiaHan());
            Date denNgayDate = calendar.getTime();
            String tuNgay=simpleDateFormat.format(tuNgayDate);
            String denNgay=simpleDateFormat.format(denNgayDate);
            dongBHYTHGDResponse.setTuNgay(tuNgay);
            dongBHYTHGDResponse.setDenNgay(denNgay);
            double thanhTien = luongCoSo * 0.045;
            if(maDoiTuong.equals("GD")){
                if(dem==0){
                    thanhTien = thanhTien * (double)i.getGiaHan();
                    dongBHYTHGDResponse.setTiLe("100 %");
                    dem+=1;
                }else if(dem==1){
                    thanhTien = thanhTien *0.7 * (double)i.getGiaHan();
                    dongBHYTHGDResponse.setTiLe("70 %");
                    dem+=1;
                }else if(dem==2){
                    thanhTien = thanhTien *0.6 * (double)i.getGiaHan();
                    dongBHYTHGDResponse.setTiLe("60 %");
                    dem+=1;
                }else if(dem==3){
                    thanhTien = thanhTien *0.5 * (double)i.getGiaHan();
                    dongBHYTHGDResponse.setTiLe("50 %");
                    dem+=1;
                }else {
                    thanhTien = thanhTien *0.4 * (double)i.getGiaHan();
                    dongBHYTHGDResponse.setTiLe("40 %");
                    dem+=1;
                }
            }else if(maDoiTuong.equals("HS") ||maDoiTuong.equals("SV") || maDoiTuong.equals("GB") ){
                thanhTien = thanhTien *0.7 * (double)i.getGiaHan();
                dongBHYTHGDResponse.setTiLe("70 %");
            }else {
                thanhTien = 0;
                dongBHYTHGDResponse.setTiLe("0 %");
                dongBHYTHGDResponse.setTuNgay("dd/MM/yyyy");
                dongBHYTHGDResponse.setDenNgay("dd/MM/yyyy");
            }
            dongBHYTHGDResponse.setThanhTien(thanhTien);
            tongTien+=thanhTien;
            responses.add(dongBHYTHGDResponse);
        }
        String message = "Total: "+String.valueOf(tongTien);
        return ResponseEntity.ok(new Response("success",message,responses));
    }
}
