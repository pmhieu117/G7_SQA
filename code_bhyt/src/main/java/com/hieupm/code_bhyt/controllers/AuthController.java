package com.hieupm.code_bhyt.controllers;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.hieupm.code_bhyt.models.User;
import com.hieupm.code_bhyt.payload.request.LoginRequest;
import com.hieupm.code_bhyt.payload.request.SignupRequest;
import com.hieupm.code_bhyt.payload.response.JwtResponse;
import com.hieupm.code_bhyt.payload.response.Response;
import com.hieupm.code_bhyt.repository.RoleRepository;
import com.hieupm.code_bhyt.repository.UserRepository;
import com.hieupm.code_bhyt.security.jwt.JwtUtils;
import com.hieupm.code_bhyt.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UserRepository userRepository;

  @Autowired
  RoleRepository roleRepository;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;

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

  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);
    
    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
    List<String> roles = userDetails.getAuthorities().stream()
        .map(item -> item.getAuthority())
        .collect(Collectors.toList());

    return ResponseEntity.ok(new JwtResponse(jwt,
                         userDetails.getId(), 
                         userDetails.getUsername(), 
                         userDetails.getHoTen(),
                         roles, "success"));
  }

  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
    if (!userRepository.existsByUsername(signUpRequest.getUsername())) {
      return ResponseEntity
          .badRequest()
          .body(new Response("fail","Mã BHXH không hợp lệ!"));
    }

    Optional<User> opUser = userRepository.findByUsername(signUpRequest.getUsername());
    User user = opUser.get();
    if(user.getPassword()!= null){
      Response response = new Response();
      response.setStatus("fail");
      response.setMessage("Mã số " + user.getUsername() + " đã đăng ký giao dịch điện tử với cơ quan BHXH, số điện thoại đăng ký " + user.getSoDienThoai() + ". Liên hệ 1900.9068 để được hỗ trợ !");
      return ResponseEntity
              .badRequest()
              .body(response);
    }

    if(user.getHoTen().equals(signUpRequest.getHoTen())==false){
      return ResponseEntity
              .badRequest()
              .body(new Response("fail","Tên của bạn không khớp với tên kê khai trong CSDL QG về bảo hiểm !"));
    }

    if(user.getCccd().equals(signUpRequest.getCccd())==false){
      return ResponseEntity
              .badRequest()
              .body(new Response("fail","Thông tin công dân của bạn chưa được Cơ sở dữ liệu quốc gia về dân cư xác thực !"));
    }
    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
      return ResponseEntity
          .badRequest()
          .body(new Response("fail","Đã tồn tại email người dùng !"));
    }

    if (userRepository.existsBySoDienThoai(signUpRequest.getSoDienThoai())) {
      return ResponseEntity
              .badRequest()
              .body(new Response("fail","Đã tồn tại số điện thoại người dùng !"));
    }

    // Create new user's account
    String random = "12345";
    String matKhau = encoder.encode(random);
    user.setTinhThanhPho(signUpRequest.getTinhThanhPho());
    user.setQuanHuyen(signUpRequest.getQuanHuyen());
    user.setPhuongXa(signUpRequest.getPhuongXa());
    user.setDiaChi(signUpRequest.getDiaChi());
    user.setSoDienThoai(signUpRequest.getSoDienThoai());
    user.setEmail(signUpRequest.getEmail());
    if(signUpRequest.getImgChanDung()!=null){
      user.setImgChanDung(this.cloudinary(signUpRequest.getImgChanDung(),signUpRequest.getUsername(),"avt"));
    }
    if(signUpRequest.getCccdTruoc()!=null){
      user.setCccdTruoc(this.cloudinary(signUpRequest.getCccdTruoc(),signUpRequest.getUsername(),"cccd_truoc"));
    }
    if(signUpRequest.getCccdSau()!=null){
      user.setCccdSau(this.cloudinary(signUpRequest.getCccdSau(),signUpRequest.getUsername(),"cccd_sau"));
    }
    user.setPassword(matKhau);
    userRepository.save(user);
    return ResponseEntity.ok(new Response("success",random));
  }
}
//user.setChiTietCoQuanBHXH("xxx");
//    User user = new User(signUpRequest.getUsername(),
//               signUpRequest.getEmail(), matKhau);

//    Set<String> strRoles = signUpRequest.getRole();
//    Set<Role> roles = new HashSet<>();
//
//    if (strRoles == null) {
//      Role userRole = roleRepository.findByName(ERole.ROLE_USER)
//          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//      roles.add(userRole);
//    } else {
//      strRoles.forEach(role -> {
//        switch (role) {
//        case "admin":
//          Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
//              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//          roles.add(adminRole);
//
//          break;
//        case "mod":
//          Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
//              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//          roles.add(modRole);
//
//          break;
//        default:
//          Role userRole = roleRepository.findByName(ERole.ROLE_USER)
//              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//          roles.add(userRole);
//        }
//      });
//    }
//
//    user.setRoles(roles);