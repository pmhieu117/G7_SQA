package com.hieupm.code_bhyt.controllers;

import com.hieupm.code_bhyt.dto.request.DongBHYTCaNhanRequest;
import com.hieupm.code_bhyt.dto.request.TinhBHYTCaNhanRequest;
import com.hieupm.code_bhyt.dto.response.DongBHYTCaNhanResponse;
import com.hieupm.code_bhyt.models.User;
import com.hieupm.code_bhyt.payload.response.Response;
import com.hieupm.code_bhyt.repository.ChiTietHoaDonRepository;
import com.hieupm.code_bhyt.repository.LuongCoSoRepository;
import com.hieupm.code_bhyt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/tinh-bhyt-ca-nhan")
public class TinhBHYTCaNhan {
    @Autowired
    UserRepository userRepository;
    @Autowired
    LuongCoSoRepository luongCoSoRepository;
    @Autowired
    ChiTietHoaDonRepository chiTietHoaDonRepository;

    @PostMapping("/get")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity getTinhBHYTCaNhan(@RequestBody TinhBHYTCaNhanRequest tinhBHYTCaNhanRequest) {
        String maDoiTuong = tinhBHYTCaNhanRequest.getBhyt().substring(0,2);
        Optional<User> optionalUser = userRepository.findByBhyt(tinhBHYTCaNhanRequest.getBhyt());
        if(!optionalUser.isPresent()){
            return ResponseEntity.ok(new Response("fail","Không tìm thấy thông tin về BHYT trong CSDL QG !"));
        }
        User user = optionalUser.get();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date hienTai = null;
        try {
            hienTai = simpleDateFormat.parse(tinhBHYTCaNhanRequest.getThoiGianGiaHan());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        double luongCoSo=luongCoSoRepository.findMucLuongCoSoByNgayGanNhat(hienTai);
        if(maDoiTuong.equals("GD")){
            double thanhTien = luongCoSo * 0.045 * (double) tinhBHYTCaNhanRequest.getGiaHan();
            Date tuNgayDate = chiTietHoaDonRepository.findNgayKetThucByBHYTNguoiThuhuong(user.getBhyt());
            if(tuNgayDate==null){
                tuNgayDate = hienTai;
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(tuNgayDate);
            calendar.add(Calendar.DATE, -1);
            calendar.add(Calendar.MONTH, tinhBHYTCaNhanRequest.getGiaHan());
            Date denNgayDate = calendar.getTime();
            String tuNgay=simpleDateFormat.format(tuNgayDate);
            String denNgay=simpleDateFormat.format(denNgayDate);
            DongBHYTCaNhanResponse dongBHYTCaNhanResponse = new DongBHYTCaNhanResponse();
            dongBHYTCaNhanResponse.setBhyt(user.getBhyt());
            dongBHYTCaNhanResponse.setHoTen(user.getHoTen());
            dongBHYTCaNhanResponse.setTuNgay(tuNgay);
            dongBHYTCaNhanResponse.setDenNgay(denNgay);
            dongBHYTCaNhanResponse.setThanhTien(String.valueOf(thanhTien));
            dongBHYTCaNhanResponse.setCoQuanBHXH(user.getChiTietCoQuanBHXH().getName());
            return ResponseEntity.ok(new Response("success","Thông tin gia hạn thành công !",dongBHYTCaNhanResponse));
        }
        if (maDoiTuong.equals("HS") || maDoiTuong.equals("SV") || maDoiTuong.equals("GB")){
            double thanhTien = luongCoSo * 0.045 * (double) tinhBHYTCaNhanRequest.getGiaHan();
            thanhTien*=0.7;
            Date tuNgayDate = chiTietHoaDonRepository.findNgayKetThucByBHYTNguoiThuhuong(user.getBhyt());
            if(tuNgayDate==null){
                tuNgayDate = hienTai;
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(tuNgayDate);
            calendar.add(Calendar.DATE, -1);
            calendar.add(Calendar.MONTH, tinhBHYTCaNhanRequest.getGiaHan());
            Date denNgayDate = calendar.getTime();
            String tuNgay=simpleDateFormat.format(tuNgayDate);
            String denNgay=simpleDateFormat.format(denNgayDate);
            DongBHYTCaNhanResponse dongBHYTCaNhanResponse = new DongBHYTCaNhanResponse();
            dongBHYTCaNhanResponse.setBhyt(user.getBhyt());
            dongBHYTCaNhanResponse.setHoTen(user.getHoTen());
            dongBHYTCaNhanResponse.setTuNgay(tuNgay);
            dongBHYTCaNhanResponse.setDenNgay(denNgay);
            dongBHYTCaNhanResponse.setThanhTien(String.valueOf(thanhTien));
            dongBHYTCaNhanResponse.setCoQuanBHXH(user.getChiTietCoQuanBHXH().getName());
            return ResponseEntity.ok(new Response("success","Thông tin gia hạn thành công !",tinhBHYTCaNhanRequest));
        }
        return ResponseEntity.ok(new Response("fail","BHYT không thuộc nhóm đối tượng được thanh toán trên hệ thống !"));
    }
}
