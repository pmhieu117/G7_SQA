package com.hieupm.code_bhyt.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.hieupm.code_bhyt.dto.request.KhaiBaoBHYTRequest;
import com.hieupm.code_bhyt.dto.response.KhaiBaoThongTinResponse;
import com.hieupm.code_bhyt.dto.response.ThanhVienHGD;
import com.hieupm.code_bhyt.dto.response.ThongTinTaiKhoanResponse;
import com.hieupm.code_bhyt.models.HoGiaDinh;
import com.hieupm.code_bhyt.models.User;
import com.hieupm.code_bhyt.payload.response.Response;
import com.hieupm.code_bhyt.repository.UserRepository;
import com.hieupm.code_bhyt.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/khai-bao-thong-tin")
public class KhaiBaoThongTinBHYT {
    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    UserRepository userRepository;

    public String cloudinary(String url_cropper, String bhxh, String type_img){
        // Configure
        Map config = new HashMap();
        config.put("cloud_name", "hieupm117");
        config.put("api_key", "549159477241646");
        config.put("api_secret", "FuNyl1QZnPA0eegTh3dKvyLP9as");
        Cloudinary cloudinary = new Cloudinary(config);
        String name = bhxh+"_"+type_img;
        try {
            cloudinary.uploader().upload(url_cropper, ObjectUtils.asMap("public_id", name));
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
        String url = cloudinary.url().generate(name);
        System.out.println(url);
        return url;
    }

    @GetMapping("/get")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> getKhaiBaoThongTin(HttpServletRequest request) {
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
                KhaiBaoThongTinResponse khaiBaoThongTinResponse = new KhaiBaoThongTinResponse();
                khaiBaoThongTinResponse.setHoTen(user.getHoTen());
                khaiBaoThongTinResponse.setNgaySinh(user.getNgaySinh());
                khaiBaoThongTinResponse.setGioiTinh(user.getGioiTinh());

                return ResponseEntity.ok(new Response("success","Thông tin tài khoản !",khaiBaoThongTinResponse));
            }
        }
        return ResponseEntity.ok(new Response("fail", "Trạng thái đăng nhập không xác định !"));
    }
    @PutMapping("/update")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Response> updateKhaoBaoThongTin(HttpServletRequest request,@RequestBody KhaiBaoBHYTRequest khaiBaoBHYTRequest) {
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
                if(user.getBhyt().equals(khaiBaoBHYTRequest.getBhyt())==false){
                    return ResponseEntity.ok(new Response("fail","Thông tin mã bảo hiểm y tế không trùng khớp với cơ sở dữ liệu quốc gia !"));
                }
                user.setDiaChiKcb(khaiBaoBHYTRequest.getKcbBhyt());
                user.setDiaChiBhyt(khaiBaoBHYTRequest.getDiaChiCapBhyt());
                if(khaiBaoBHYTRequest.getImgBhyt()!=null){
                    user.setImgBhyt(this.cloudinary(khaiBaoBHYTRequest.getImgBhyt(),user.getUsername(),"bhyt"));
                }
                userRepository.save(user);
                return ResponseEntity.ok(new Response("success","Xác thực khai báo hoàn tất !"));
            }
        }
        return ResponseEntity.ok(new Response("fail", "Trạng thái đăng nhập không xác định !"));
    }
}
