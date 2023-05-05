package com.hieupm.code_bhyt.controllers;

import com.hieupm.code_bhyt.dto.request.HoGiaDinhDTO;
import com.hieupm.code_bhyt.payload.response.Response;
import com.hieupm.code_bhyt.repository.HoGiaDinhRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/ho-gia-dinh")
public class HoGiaDinhController {
    @Autowired
    HoGiaDinhRepository hoGiaDinhRepository;

    @GetMapping("/get")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Response> getLuongCoSo() {
        return ResponseEntity.ok(new Response("success","Get HoGiaDinh for ADMIN, MODERATOR"));
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Response> addLuongCoSo(@RequestBody HoGiaDinhDTO hoGiaDinhDTO) {
        return ResponseEntity.ok(new Response("success","Thêm thành công hộ gia đình !"));
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Response> updateCoQuanBHXH(@RequestBody HoGiaDinhDTO hoGiaDinhDTO) {
        return ResponseEntity.ok(new Response("success","Cập nhật thành công hộ gia đình !"));
    }
}
