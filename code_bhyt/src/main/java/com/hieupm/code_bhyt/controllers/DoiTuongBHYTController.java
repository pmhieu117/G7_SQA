package com.hieupm.code_bhyt.controllers;

import com.hieupm.code_bhyt.dto.request.LuongCoSoDTO;
import com.hieupm.code_bhyt.models.LuongCoSo;
import com.hieupm.code_bhyt.payload.response.Response;
import com.hieupm.code_bhyt.repository.DoiTuongBHYTRepository;
import com.hieupm.code_bhyt.repository.LuongCoSoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/doi-tuong-bhyt")
public class DoiTuongBHYTController {
    @Autowired
    DoiTuongBHYTRepository doiTuongBHYTRepository;

    @GetMapping("/get")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Response> getLuongCoSo() {
        return ResponseEntity.ok(new Response("success","Get DoiTuongBHYT for ADMIN, MODERATOR"));
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Response> addDoiTuongBHYT(@RequestBody LuongCoSoDTO luongCoSoDTO) {
        return ResponseEntity.ok(new Response("success","Thêm thành công đối tượng bhyt !"));
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Response> updateDoiTuongBHYT(@RequestBody LuongCoSoDTO luongCoSoDTO) {
        return ResponseEntity.ok(new Response("success","Cập nhật thành công đối tượng bhyt !"));
    }
}
