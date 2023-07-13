package com.cvs.store.staff.repository;

import com.cvs.store.staff.domain.Staff;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StaffRepositoryImpl implements StaffRepository{

    private final EntityManager em;
    @Override
    @Transactional
    public Long save(Staff staff) {
            em.persist(staff);
            return find(staff.getId()).getId();
    }

    @Override
    public Staff find(Long id) {
        return em.find(Staff.class, id);
    }


}
