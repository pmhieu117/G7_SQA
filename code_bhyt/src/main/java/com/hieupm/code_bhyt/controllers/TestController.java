package com.hieupm.code_bhyt.controllers;

import com.hieupm.code_bhyt.payload.response.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
  @GetMapping("/all")
  public ResponseEntity<Response> allAccess() {
    return ResponseEntity.ok(new Response("200 OK","Everybody can access this url !"));
  }

  @GetMapping("/user")
  @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
  public ResponseEntity<Response> userAccess() {
    return ResponseEntity.ok(new Response("200 OK","USER - MODERATOR - ADMIN"));
  }

  @GetMapping("/mod")
  @PreAuthorize("hasRole('MODERATOR')")
  public ResponseEntity<Response> moderatorAccess() {
    return ResponseEntity.ok(new Response("200 OK","MODERATOR"));
  }

  @GetMapping("/admin")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<Response> adminAccess() {
    return ResponseEntity.ok(new Response("200 OK","ADMIN"));
  }
}
