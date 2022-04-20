package team.project.WhatToEatToday.Service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import team.project.WhatToEatToday.domain.member.Admin;
import team.project.WhatToEatToday.domain.member.Member;
import team.project.WhatToEatToday.repository.AdminRepository;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class AdminServiceTest {

    @Autowired
    AdminService adminService;

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    EntityManager em;

    @Test
//    @Rollback(false)
    public void 회원가입() throws Exception {

        //given
        Admin admin = new Admin();
        admin.setId("admin1");

        //when
        String savedId = adminService.join(admin);

        //then
//        em.flush();
        assertEquals(admin, adminRepository.findOne(savedId));

    }

    @Test(expected = IllegalStateException.class)
    public void 중복_회원_예외() throws Exception {
        //given
        Admin admin1 = new Admin();
        admin1.setId("kim");

        //when
        Admin admin2 = new Admin();
        admin2.setId("kim");
        //then

        adminService.join(admin1);
        adminService.join(admin2);

        fail("예외가 발생해야 한다.");
    }


}