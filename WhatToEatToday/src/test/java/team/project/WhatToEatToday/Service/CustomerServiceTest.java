package team.project.WhatToEatToday.Service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import team.project.WhatToEatToday.domain.member.Customer;
import team.project.WhatToEatToday.repository.member.CustomerRepository;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CustomerServiceTest {

    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    EntityManager em;

    @Test
//    @Rollback(false)
    public void 회원가입() throws Exception {

        //given
        Customer customer = new Customer();
        customer.setId("customer1");

        //when
        String savedId = customerService.join(customer);

        //then
//        em.flush();
        assertEquals(customer, customerRepository.findOne(savedId));

    }

    @Test(expected = IllegalStateException.class)
    public void 중복_회원_예외() throws Exception {
        //given
        Customer customer1 = new Customer();
        customer1.setId("kim");

        //when
        Customer customer2 = new Customer();
        customer2.setId("kim");
        //then

        customerService.join(customer1);
        customerService.join(customer2);

        fail("예외가 발생해야 한다.");
    }
}