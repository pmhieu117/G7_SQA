package com.hieupm.code_bhyt.controllers;

import com.hieupm.code_bhyt.dto.request.CoQuanBHXHDTO;
import com.hieupm.code_bhyt.models.CoQuanBHXH;
import com.hieupm.code_bhyt.payload.response.Response;
import com.hieupm.code_bhyt.repository.CoQuanBHXHRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/co-quan-bhxh")
public class CoQuanBHXHController {
    @Autowired
    CoQuanBHXHRepository coQuanBHXHRepository;

    @GetMapping("/get")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Response> getCoQuanBHXH() {
        return ResponseEntity.ok(new Response("success","Get CoQuanBHXH for ADMIN, MODERATOR"));
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Response> addCoQuanBHXH(@RequestBody CoQuanBHXHDTO coQuanBHXHDTO) {
        CoQuanBHXH coQuanBHXH = new CoQuanBHXH(coQuanBHXHDTO.getCode(),coQuanBHXHDTO.getDiaPhuong(),null,null);
        coQuanBHXHRepository.save(coQuanBHXH);
        String mess = "Thêm thành công "+coQuanBHXHDTO.getDiaPhuong();
        return ResponseEntity.ok(new Response("success",mess));
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Response> updateCoQuanBHXH(@RequestBody CoQuanBHXHDTO coQuanBHXHDTO) {
        Optional<CoQuanBHXH> opCoQuanBHXH = coQuanBHXHRepository.findByCode(coQuanBHXHDTO.getCode());
        if(!opCoQuanBHXH.isPresent()){
            return ResponseEntity.ok(new Response("fail","Cơ quan BHXH không tồn tại !"));
        }
        CoQuanBHXH coQuanBHXH = opCoQuanBHXH.get();
        coQuanBHXH.setName(coQuanBHXHDTO.getDiaPhuong());
        coQuanBHXHRepository.save(coQuanBHXH);
        String mess = "Cập nhật thành công "+coQuanBHXHDTO.getDiaPhuong();
        return ResponseEntity.ok(new Response("success",mess));
    }

//    @DeleteMapping("/delete")
//    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
//    public ResponseEntity<Response> deleteCoQuanBHXH(@RequestBody CoQuanBHXHDTO coQuanBHXHDTO) {
//        String mess = "Xóa thành công "+coQuanBHXHDTO.getDiaPhuong();
//        return ResponseEntity.ok(new Response("200 OK",mess));
//    }

}
