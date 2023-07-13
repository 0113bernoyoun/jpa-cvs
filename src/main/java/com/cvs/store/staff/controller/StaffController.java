package com.cvs.store.staff.controller;

import com.cvs.store.common.model.CommonResponse;
import com.cvs.store.staff.domain.StaffRole;
import com.cvs.store.staff.model.dto.FindStaffDTO;
import com.cvs.store.staff.model.dto.StaffDTO;
import com.cvs.store.staff.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/staff")
@RequiredArgsConstructor
public class StaffController {
    private final StaffService staffService;
    @PostMapping("/hire")
    public CommonResponse hireStaff(@RequestBody StaffDTO requestData){
        staffService.saveStaff(requestData.name(), requestData.staffRole());
        return new CommonResponse<>(null,200);
    }

    @GetMapping("/{staffId}")
    public CommonResponse findStaff(@PathVariable String staffId){
        FindStaffDTO staffById = staffService.getStaffById(Long.parseLong(staffId));
        return new CommonResponse(staffById, 200);
    }

//    @GetMapping("/all")
//    public CommonResponse findAllStaff(){
//
//    }
}
