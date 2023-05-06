package com.hieupm.code_bhyt.controllers;

import com.hieupm.code_bhyt.dto.request.DoiMatKhauRequest;
import com.hieupm.code_bhyt.dto.request.TimKiemBhxhRequest;
import com.hieupm.code_bhyt.dto.response.TimKiemBhxhResponse;
import com.hieupm.code_bhyt.models.User;
import com.hieupm.code_bhyt.payload.response.Response;
import com.hieupm.code_bhyt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TimKiemBhxhController {
    @Autowired
    UserRepository userRepository;
    @PostMapping("/tim-kiem-bhxh")
    public ResponseEntity<?> timKiemBHXH(@RequestBody TimKiemBhxhRequest timKiemBhxhRequest) {
        List<User> users = userRepository.findUserByTinhThanhPhoAndHoTenAndNgaySinh(timKiemBhxhRequest.getTinhThanhPho(),
                timKiemBhxhRequest.getHoTen(), timKiemBhxhRequest.getNgaySinh());
        List<TimKiemBhxhResponse> timKiemBhxhResponseList = new ArrayList<>();
        for (User i:users){
            timKiemBhxhResponseList.add(new TimKiemBhxhResponse(i.getUsername(),i.getCccd(),i.getHoTen(),
                    i.getNgaySinh(),i.getTinhThanhPho()));
        }
        return ResponseEntity.ok(new Response("success","Danh sách thông tin",timKiemBhxhResponseList));
    }
}
