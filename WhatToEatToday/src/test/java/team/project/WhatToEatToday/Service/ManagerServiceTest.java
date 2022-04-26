package team.project.WhatToEatToday.Service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import team.project.WhatToEatToday.domain.member.Manager;
import team.project.WhatToEatToday.repository.ManagerRepository;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ManagerServiceTest {

    @Autowired
    ManagerService managerService;

    @Autowired
    ManagerRepository managerRepository;

    @Autowired
    EntityManager em;

    @Test
//    @Rollback(false)
    public void 회원가입() throws Exception {

        //given
        Manager manager = new Manager();
        manager.setId("manager");

        //when
        String savedId = managerService.join(manager);

        //then
//        em.flush();
        assertEquals(manager, managerRepository.findOne(savedId));

    }

    @Test(expected = IllegalStateException.class)
    public void 중복_회원_예외() throws Exception {
        //given
        Manager manager1 = new Manager();
        manager1.setId("kim");

        //when
        Manager manager2 = new Manager();
        manager2.setId("kim");
        //then

        managerService.join(manager1);
        managerService.join(manager2);

        fail("예외가 발생해야 한다.");
    }
}