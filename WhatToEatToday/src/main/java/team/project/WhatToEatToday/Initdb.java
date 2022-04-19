package team.project.WhatToEatToday;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import team.project.WhatToEatToday.domain.member.Admin;
import team.project.WhatToEatToday.domain.member.Customer;
import team.project.WhatToEatToday.domain.member.Manager;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

@Component //component-scan을 선언에 의해 특정 패키지 안의 클래스들을 스캔하고, @Component Annotation이 있는 클래스에 대하여 bean 인스턴스를 생성
@RequiredArgsConstructor //final이나 @NonNull인 필드 값만 파라미터로 받는 생성자를 추가한다
public class Initdb {

    private final InitService initService; //InitService 클래스

    @PostConstruct
    public void init() {
        initService.dbInit1();
        initService.dbInit2();
        initService.dbInit3();
    }

    @Component
    @Transactional //일반적으로 DB데이터를 등록/수정/삭제하는 Service 메소드는 @Transactional을 필수적으로 가져감
    @RequiredArgsConstructor
    static class InitService {

        private final EntityManager em; //EntityManager의 객체 em 생성 -> @RequiredArgsConstructor를 이용해 Entitymanager클래스의 생성자 주입

        public void dbInit1() {
            System.out.println("Init1" + this.getClass());
            Admin admin = createAdmin("admin", "admin", "admin", "admin", "admin", "admin");
            em.persist(admin); // EntityManger.persist(enitity); --> 엔티티 객체를 DB(JPA 영속성 컨테스트)에 저장하는 것

        }
        public void dbInit2() {
            System.out.println("Init2" + this.getClass());
            Manager manager1 = createManager("manager1", "manager1", "manager1", "manager1", "manager1", "manager1");
            em.persist(manager1);
            Manager manager2 = createManager("manager2", "manager2", "manager2", "manager2", "manager2", "manager2");
            em.persist(manager2);
            Manager manager3 = createManager("manager3", "manager3", "manager3", "manager3", "manager3", "manager3");
            em.persist(manager3);
        }
        public void dbInit3() {
            System.out.println("Init3" + this.getClass());
            Customer customer = createCustomer("customer", "customer", "customer", "customer", "customer", "customer");
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
