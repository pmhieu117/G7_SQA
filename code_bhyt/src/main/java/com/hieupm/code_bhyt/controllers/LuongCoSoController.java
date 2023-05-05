package com.hieupm.code_bhyt.controllers;

import com.hieupm.code_bhyt.dto.request.CoQuanBHXHDTO;
import com.hieupm.code_bhyt.dto.request.LuongCoSoDTO;
import com.hieupm.code_bhyt.models.CoQuanBHXH;
import com.hieupm.code_bhyt.models.LuongCoSo;
import com.hieupm.code_bhyt.payload.response.Response;
import com.hieupm.code_bhyt.repository.CoQuanBHXHRepository;
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
@RequestMapping("/api/luong-co-so")
public class LuongCoSoController {
    @Autowired
    LuongCoSoRepository luongCoSoRepository;

    @GetMapping("/get")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Response> getLuongCoSo() {
        return ResponseEntity.ok(new Response("success","Get LuongCoSo for ADMIN, MODERATOR"));
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Response> addLuongCoSo(@RequestBody LuongCoSoDTO luongCoSoDTO) {
        LuongCoSo luongCoSo = new LuongCoSo(luongCoSoDTO.getNgayBatDau(),luongCoSoDTO.getMucLuongCoSo());
        luongCoSoRepository.save(luongCoSo);
        return ResponseEntity.ok(new Response("success","Thêm thành công lương cơ sở !"));
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Response> updateCoQuanBHXH(@RequestBody LuongCoSoDTO luongCoSoDTO) {
        Optional<LuongCoSo> opLuongCoSo = luongCoSoRepository.findById(luongCoSoDTO.getId());
        if(!opLuongCoSo.isPresent()){
            return ResponseEntity.ok(new Response("fail","Không tìm thầy luong cơ sở theo id !"));
        }
        LuongCoSo luongCoSo = opLuongCoSo.get();
        luongCoSo.setMucLuongCoSo(luongCoSoDTO.getMucLuongCoSo());
        try {
            luongCoSo.setNgayBatDau(new SimpleDateFormat("dd/MM/yyyy").parse(luongCoSoDTO.getNgayBatDau()));
        } catch (ParseException e) {
            return ResponseEntity.ok(new Response("fail","Yêu cầu định dạng thời gian dd/MM/yyyy !"));
        }
        return ResponseEntity.ok(new Response("success","Cập nhật thành công lương cơ sở !"));
    }
}
