package team.project.WhatToEatToday;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import team.project.WhatToEatToday.domain.EatingHouse;
import team.project.WhatToEatToday.domain.member.Admin;
import team.project.WhatToEatToday.domain.member.Customer;
import team.project.WhatToEatToday.domain.member.Manager;
import team.project.WhatToEatToday.repository.EatingHouseRepository;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

@Component
@RequiredArgsConstructor
public class Initdb {

    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.dbInit1();
        initService.dbInit2();
        initService.dbInit3();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {

        private final EntityManager em;
        private final EatingHouseRepository eatingHouseRepository;

        public void dbInit1() {
        	EatingHouse eatingHouse = new EatingHouse();
        	eatingHouse.setName("cys");
        	eatingHouseRepository.save(eatingHouse) ;
            System.out.println("Init1" + this.getClass());
            Admin admin = createAdmin("admin", "admin", "admin", "admin", "admin", null);
            em.persist(admin);
        }

        public void dbInit2() {
            System.out.println("Init2" + this.getClass());
            Manager manager1 = createManager("manager1", "manager1", "manager1", "manager1", "manager1", null);
            em.persist(manager1);
            Manager manager2 = createManager("manager2", "manager2", "manager2", "manager2", "manager2", null);
            em.persist(manager2);
            Manager manager3 = createManager("manager3", "manager3", "manager3", "manager3", "manager3", null);
            em.persist(manager3);
        }

        public void dbInit3() {
            System.out.println("Init3" + this.getClass());
            Customer customer = createCustomer("customer", "customer", "customer", "customer", "customer", null);
            em.persist(customer);
        }

        private Admin createAdmin(String id, String password, String name, String email, String tel, String address) {
            Admin admin = new Admin();
            admin.setId(id);
            admin.setPassword(password);
            admin.setName(name);
            admin.setEmail(email);
            admin.setTel(tel);
            admin.setAddress(address);
            return admin;
        }

        private Manager createManager(String id, String password, String name, String email, String tel, String address) {
            Manager manager = new Manager();
            manager.setId(id);
            manager.setPassword(password);
            manager.setName(name);
            manager.setEmail(email);
            manager.setTel(tel);
            manager.setAddress(address);
            return manager;
        }

        private Customer createCustomer(String id, String password, String name, String email, String tel, String address) {
            Customer customer = new Customer();
            customer.setId(id);
            customer.setPassword(password);
            customer.setName(name);
            customer.setEmail(email);
            customer.setTel(tel);
            customer.setAddress(address);
            return customer;
        }
    }
}
