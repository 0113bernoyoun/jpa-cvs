package com.cvs.store.staff.repository;

import com.cvs.store.staff.domain.Staff;

public interface StaffRepository {

    Long save(Staff staff);

    Staff find(Long id);
}
