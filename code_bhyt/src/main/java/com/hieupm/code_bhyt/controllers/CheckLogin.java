package com.hieupm.code_bhyt.controllers;

import com.hieupm.code_bhyt.models.User;
import com.hieupm.code_bhyt.payload.request.LoginRequest;
import com.hieupm.code_bhyt.payload.response.CheckResponse;
import com.hieupm.code_bhyt.payload.response.JwtResponse;
import com.hieupm.code_bhyt.repository.UserRepository;
import com.hieupm.code_bhyt.security.jwt.AuthTokenFilter;
import com.hieupm.code_bhyt.security.jwt.JwtUtils;
import com.hieupm.code_bhyt.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/check")
public class CheckLogin {
    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private AuthTokenFilter authTokenFilter;
    @GetMapping("/trang-chu")
    public ResponseEntity<?> checkTrangChu(HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");
        String token = null;
        String username = null;

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            token = authorizationHeader.substring(7);
            username = jwtUtils.getUserNameFromJwtToken(token);
        }

        if (username != null) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            if (jwtUtils.validateToken(token, userDetails)) {
                List<String> roles = userDetails.getAuthorities().stream()
                        .map(item -> item.getAuthority())
                        .collect(Collectors.toList());
                User user = userRepository.findByUsername(username).get();
                System.out.println(user.getHoTen());
                CheckResponse checkResponse = new CheckResponse();
                checkResponse.setStatus("success");
                checkResponse.setUsername(user.getUsername());
                checkResponse.setHoTen(user.getHoTen());
                checkResponse.setRoles(roles);
                return ResponseEntity.ok(checkResponse);
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

}
