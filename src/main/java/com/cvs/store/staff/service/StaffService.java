package com.cvs.store.staff.service;

import com.cvs.store.staff.domain.Staff;
import com.cvs.store.staff.domain.StaffRole;
import com.cvs.store.staff.model.dto.FindStaffDTO;

public interface StaffService {
    public FindStaffDTO getStaffById(Long id);

    public Long saveStaff(String name, StaffRole staffRole);
}
