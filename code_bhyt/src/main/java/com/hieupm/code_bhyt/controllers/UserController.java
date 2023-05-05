package com.hieupm.code_bhyt.controllers;

import com.hieupm.code_bhyt.dto.request.AddUserRequest;
import com.hieupm.code_bhyt.dto.request.CoQuanBHXHDTO;
import com.hieupm.code_bhyt.models.CoQuanBHXH;
import com.hieupm.code_bhyt.models.ERole;
import com.hieupm.code_bhyt.models.Role;
import com.hieupm.code_bhyt.models.User;
import com.hieupm.code_bhyt.payload.response.Response;
import com.hieupm.code_bhyt.repository.RoleRepository;
import com.hieupm.code_bhyt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @GetMapping("/get")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Response> getUser() {
        return ResponseEntity.ok(new Response("success","Get User for ADMIN, MODERATOR"));
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Response> addUser(@RequestBody AddUserRequest addUserRequest) {
        User user = new User(addUserRequest.getBhxh(),addUserRequest.getCccd(),addUserRequest.getHoTen(),
                addUserRequest.getNgaySinh(),addUserRequest.getTinhThanhPho(),addUserRequest.getQuanHuyen(),
                addUserRequest.getPhuongXa(),addUserRequest.getDiaChi(),addUserRequest.getGioiTinh(),
                null, addUserRequest.getQuanHeChuHo(), addUserRequest.getAddressGks());
        Set<String> strRoles = addUserRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
          Role userRole = roleRepository.findByName(ERole.ROLE_USER)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(userRole);
        } else {
          strRoles.forEach(role -> {
            switch (role) {
            case "admin":
              Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                  .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
              roles.add(adminRole);

              break;
            case "mod":
              Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
                  .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
              roles.add(modRole);

              break;
            default:
              Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                  .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
              roles.add(userRole);
            }
          });
        }
        user.setRoles(roles);
        userRepository.save(user);
        return ResponseEntity.ok(new Response("success","Thêm thành công User"));
    }

//    @PutMapping("/update")
//    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
//    public ResponseEntity<Response> updateUser(@RequestBody CoQuanBHXHDTO coQuanBHXHDTO) {
//        Optional<CoQuanBHXH> opCoQuanBHXH = coQuanBHXHRepository.findByCode(coQuanBHXHDTO.getCode());
//        if(!opCoQuanBHXH.isPresent()){
//            return ResponseEntity.ok(new Response("fail","Cơ quan BHXH không tồn tại !"));
//        }
//        CoQuanBHXH coQuanBHXH = opCoQuanBHXH.get();
//        coQuanBHXH.setName(coQuanBHXHDTO.getDiaPhuong());
//        coQuanBHXHRepository.save(coQuanBHXH);
//        String mess = "Cập nhật thành công "+coQuanBHXHDTO.getDiaPhuong();
//        return ResponseEntity.ok(new Response("success",mess));
//    }
}
