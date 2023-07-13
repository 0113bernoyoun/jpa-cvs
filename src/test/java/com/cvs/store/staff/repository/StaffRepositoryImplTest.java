package com.cvs.store.staff.repository;

import com.cvs.store.staff.domain.Staff;
import com.cvs.store.staff.domain.StaffRole;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
@Transactional
class StaffRepositoryImplTest {
    
    @Autowired
    private StaffRepository staffRepository;

    @Test
    @Commit
    public void 직원_저장_테스트() throws Exception{
        // given
        Staff staff1 = new Staff("직원1", StaffRole.NORMAL);
        Staff staff2 = new Staff("매니저1", StaffRole.MANAGER);
        // when
        Long staff1Id = staffRepository.save(staff1);
        Long staff2Id = staffRepository.save(staff2);
        // then
        Assertions.assertEquals(staff1.getId(), staff1Id, "staff1의 아이디가 일치해야합니다.");
        Assertions.assertEquals(staff2.getId(), staff2Id, "staff2의 아이디가 일치해야합니다.");
    }

    @Test
    public void 직원_영속성_객체_테스트() throws Exception{
        // given
        Staff staff1 = new Staff("직원1", StaffRole.NORMAL);
        Staff staff2 = new Staff("매니저1", StaffRole.MANAGER);
        // when
        Long staff1Id = staffRepository.save(staff1);
        Long staff2Id = staffRepository.save(staff2);

        Staff findStaff1 = staffRepository.find(staff1Id);
        Staff findStaff2 = staffRepository.find(staff2Id);

        System.out.println("staff1 :: " + staff1);
        System.out.println("findStaff1 :: " + findStaff1);

        System.out.println("staff2 :: " + staff2);
        System.out.println("findStaff2 :: " + findStaff2);

        // then
        Assertions.assertEquals(staff1, findStaff1, "staff1의 해쉬코드가 일치해야합니다.");
        Assertions.assertEquals(staff2, findStaff2, "staff2의 해쉬코드가 일치해야합니다.");
    }

}