package com.cvs.store.staff.service;

import com.cvs.store.staff.domain.Staff;
import com.cvs.store.staff.domain.StaffRole;
import com.cvs.store.staff.model.dto.FindStaffDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class StaffServiceImplTest {

    @Autowired
    private StaffService staffService;

    @Test
    public void 직원_저장_테스트() throws Exception{
        // given
        String staff1Name = "직원1";
        StaffRole staff1Role = StaffRole.NORMAL;
        String staff2Name = "매니저1";
        StaffRole staff2Role = StaffRole.MANAGER;

        //when
        Long staff1Id = staffService.saveStaff(staff1Name, staff1Role);
        Long staff2Id = staffService.saveStaff(staff2Name, staff2Role);

        // then
        Assertions.assertNotNull(staff1Id, "staff1Id는 null이 아니여야합니다.");
        Assertions.assertNotNull(staff2Id, "staff2Id는 null이 아니여야합니다.");
    }

    @Test
    public void 직원_찾기_테스트() throws Exception{
        // given
        String staff1Name = "직원1";
        StaffRole staff1Role = StaffRole.NORMAL;
        String staff2Name = "매니저1";
        StaffRole staff2Role = StaffRole.MANAGER;

        Long staff1Id = staffService.saveStaff(staff1Name, staff1Role);
        Long staff2Id = staffService.saveStaff(staff2Name, staff2Role);

        //when
        FindStaffDTO staff1 = staffService.getStaffById(staff1Id);
        FindStaffDTO staff2 = staffService.getStaffById(staff2Id);

        // then
        Assertions.assertEquals(staff1.id(), staff1Id, "staff1의 Id가 동일해야합니다.");
        Assertions.assertEquals(staff2.id(), staff2Id, "staff2의 Id가 동일해야합니다.");
        Assertions.assertNotEquals(staff1.id(), staff2.id(), "staff1과 staff2의 id는 동일하지 않아야합니다.");
    }
}