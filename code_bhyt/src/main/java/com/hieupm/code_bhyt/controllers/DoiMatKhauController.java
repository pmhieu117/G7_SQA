package com.hieupm.code_bhyt.controllers;

import com.hieupm.code_bhyt.dto.request.DoiMatKhauRequest;
import com.hieupm.code_bhyt.models.User;
import com.hieupm.code_bhyt.payload.response.CheckResponse;
import com.hieupm.code_bhyt.payload.response.Response;
import com.hieupm.code_bhyt.repository.UserRepository;
import com.hieupm.code_bhyt.security.jwt.AuthTokenFilter;
import com.hieupm.code_bhyt.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/doi-mat-khau")
public class DoiMatKhauController {
    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @PostMapping("/update")
    public ResponseEntity<?> doiMatKhau(HttpServletRequest request,@RequestBody DoiMatKhauRequest doiMatKhauRequest) {
        if(doiMatKhauRequest.getMatKhauMoi().equals(doiMatKhauRequest.getXacThuc())==false){
            return ResponseEntity.ok(new Response("fail", "Xác thực mật khẩu không trùng khớp với mật khẩu mới !"));
        }
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
                String matKhauHienTai = user.getPassword();
                if(encoder.matches(doiMatKhauRequest.getMatKhauCu(),matKhauHienTai)==false){
                    return ResponseEntity.ok(new Response("fail", "Mật khẩu hiện tại không chính xác"));
                }else{
                    matKhauHienTai = encoder.encode(doiMatKhauRequest.getMatKhauMoi());
                    user.setPassword(matKhauHienTai);
                    userRepository.save(user);
                    return ResponseEntity.ok(new Response("success", "Đổi mật khẩu thành công !"));
                }
            }
        }
        return ResponseEntity.ok(new Response("fail", "Trạng thái đăng nhập không xác định !"));
    }
}
