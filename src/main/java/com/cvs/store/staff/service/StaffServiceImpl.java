package com.cvs.store.staff.service;

import com.cvs.store.staff.domain.Staff;
import com.cvs.store.staff.domain.StaffRole;
import com.cvs.store.staff.model.dto.FindStaffDTO;
import com.cvs.store.staff.model.dto.StaffDTO;
import com.cvs.store.staff.repository.StaffRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class StaffServiceImpl implements StaffService{

    private final StaffRepository staffRepository;

    @Override
    public FindStaffDTO getStaffById(Long id) {
        Staff staff = staffRepository.find(id);
        return new FindStaffDTO(staff.getId(), new StaffDTO(staff.getName(), staff.getRole()));
    }

    @Override
    public Long saveStaff(String name, StaffRole staffRole) {
        return staffRepository.save(new Staff(name, staffRole));
    }
}
