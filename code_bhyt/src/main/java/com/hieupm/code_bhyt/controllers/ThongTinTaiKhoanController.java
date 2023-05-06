package com.hieupm.code_bhyt.controllers;

import com.hieupm.code_bhyt.dto.response.ThanhVienHGD;
import com.hieupm.code_bhyt.dto.response.ThongTinTaiKhoanResponse;
import com.hieupm.code_bhyt.models.HoGiaDinh;
import com.hieupm.code_bhyt.models.User;
import com.hieupm.code_bhyt.payload.response.Response;
import com.hieupm.code_bhyt.repository.UserRepository;
import com.hieupm.code_bhyt.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/thong-tin-tai-khoan")
public class ThongTinTaiKhoanController {
    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;
    @GetMapping("/get")
    public ResponseEntity<?> doiMatKhau(HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");
        String token = null;
        String username = null;

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            token = authorizationHeader.substring(7);
            username = jwtUtils.getUserNameFromJwtToken(token);
        }

        if (username != null) {
            Optional<User> opUser = userRepository.findByUsername(username);
            if(opUser.isPresent()==false){
                return ResponseEntity.ok(new Response("fail", "Không tìm thấy người dùng trong CSDL QG"));
            }else {
                User user = opUser.get();
                ThongTinTaiKhoanResponse thongTinTaiKhoanResponse = new ThongTinTaiKhoanResponse();
                thongTinTaiKhoanResponse.setHoTen(user.getHoTen());
                thongTinTaiKhoanResponse.setBhxh(user.getUsername());
                thongTinTaiKhoanResponse.setCccd(user.getCccd());
                thongTinTaiKhoanResponse.setTinhThanhPho(user.getTinhThanhPho());
                thongTinTaiKhoanResponse.setQuanHuyen(user.getQuanHuyen());
                thongTinTaiKhoanResponse.setPhuongXa(user.getPhuongXa());
                thongTinTaiKhoanResponse.setDiaChi(user.getDiaChi());
                thongTinTaiKhoanResponse.setEmail(user.getEmail());
                thongTinTaiKhoanResponse.setSoDienThoai(user.getSoDienThoai());
                thongTinTaiKhoanResponse.setImgChanDung(user.getImgChanDung());
                thongTinTaiKhoanResponse.setImgCccdSau(user.getCccdSau());
                thongTinTaiKhoanResponse.setImgCccdTruoc(user.getCccdTruoc());
                HoGiaDinh hoGiaDinh = user.getHoGiaDinh();
                List<User> userList = userRepository.findUserByHoGiaDinh(hoGiaDinh);
                List<ThanhVienHGD> thanhVienHGDList = new ArrayList<>();
                for (User i:userList){
                    if(i.getQuanHeChuHo().equals("Chủ hộ")){
                        thanhVienHGDList.add(new ThanhVienHGD(1,i.getUsername(),i.getHoTen(),i.getQuanHeChuHo()));
                    }
                }
                int cnt=2;
                for (User i:userList){
                    if(!i.getQuanHeChuHo().equals("Chủ hộ")){
                        thanhVienHGDList.add(new ThanhVienHGD(cnt,i.getUsername(),i.getHoTen(),i.getQuanHeChuHo()));
                        cnt+=1;
                    }
                }
                thongTinTaiKhoanResponse.setThanhVienHGD(thanhVienHGDList);
                return ResponseEntity.ok(new Response("success","Thông tin tài khoản !",thongTinTaiKhoanResponse));
            }
        }
        return ResponseEntity.ok(new Response("fail", "Trạng thái đăng nhập không xác định !"));
    }
//    @PutMapping("/update")
//    public ResponseEntity<?> doiMatKhau(HttpServletRequest request,@RequestBody DoiMatKhauRequest doiMatKhauRequest) {
//        if(doiMatKhauRequest.getMatKhauMoi().equals(doiMatKhauRequest.getXacThuc())==false){
//            return ResponseEntity.ok(new Response("fail", "Xác thực mật khẩu không trùng khớp với mật khẩu mới !"));
//        }
//        String authorizationHeader = request.getHeader("Authorization");
//        String token = null;
//        String username = null;
//
//        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
//            token = authorizationHeader.substring(7);
//            username = jwtUtils.getUserNameFromJwtToken(token);
//        }
//
//        if (username != null) {
//            Optional<User> opUser = userRepository.findByUsername(username);
//            if(opUser.isPresent()==false){
//                return ResponseEntity.ok(new Response("fail", "Không tìm thấy người dùng trong CSDL QG"));
//            }else {
//                User user = opUser.get();
//                String matKhauHienTai = user.getPassword();
//                if(encoder.matches(doiMatKhauRequest.getMatKhauCu(),matKhauHienTai)==false){
//                    return ResponseEntity.ok(new Response("fail", "Mật khẩu hiện tại không chính xác"));
//                }else{
//                    matKhauHienTai = encoder.encode(doiMatKhauRequest.getMatKhauMoi());
//                    user.setPassword(matKhauHienTai);
//                    userRepository.save(user);
//                    return ResponseEntity.ok(new Response("success", "Đổi mật khẩu thành công !"));
//                }
//            }
//        }
//        return ResponseEntity.ok(new Response("fail", "Trạng thái đăng nhập không xác định !"));
//    }
}
