//
//package team.project.WhatToEatToday;
//
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import team.project.WhatToEatToday.domain.Category;
//import team.project.WhatToEatToday.domain.EatingHouse;
//import team.project.WhatToEatToday.domain.member.Admin;
//import team.project.WhatToEatToday.domain.member.Customer;
//import team.project.WhatToEatToday.domain.member.Manager;
//import team.project.WhatToEatToday.repository.CategoryRepository;
//import team.project.WhatToEatToday.repository.EatingHouseRepository;
//
//import javax.annotation.PostConstruct;
//import javax.persistence.EntityManager;
//
//@Component
//@RequiredArgsConstructor
//public class Initdb {
//
//    private final InitService initService;
//
//    @PostConstruct
//    public void init() {
//        initService.dbInit1();
//        initService.dbInit2();
//        initService.dbInit3();
//        initService.dbInit4();
//        initService.dbInit5();
//    }
//
//    @Component
//    @Transactional
//    @RequiredArgsConstructor
//    static class InitService {
//
//        private final EntityManager em;
//        private final CategoryRepository categoryRepository;
//
//        public void dbInit1() {
////        	EatingHouse eatingHouse = new EatingHouse();
////        	eatingHouse.setName("cys");
////        	eatingHouseRepository.save(eatingHouse) ;
//            System.out.println("Init1" + this.getClass());
//            Admin admin = createAdmin("admin", "admin", "admin", "admin", "admin", null);
//            em.persist(admin);
//        }
//
//        public void dbInit2() {
//            System.out.println("Init2" + this.getClass());
//            Manager manager1 = createManager("manager1", "manager1", "manager1", "manager1", "manager1", null);
//            em.persist(manager1);
//            Manager manager2 = createManager("manager2", "manager2", "manager2", "manager2", "manager2", null);
//            em.persist(manager2);
//            Manager manager3 = createManager("manager3", "manager3", "manager3", "manager3", "manager3", null);
//            em.persist(manager3);
//        }
//
//        public void dbInit3() {
//            System.out.println("Init3" + this.getClass());
//            Customer customer = createCustomer("customer", "customer", "customer", "customer", "customer", null);
//            em.persist(customer);
//        }
//        public void dbInit4() {
//            Category category = createCategoryOne(1L, "전체메뉴");
//            category.setParent(category);
//            em.persist(category);
//        }
//
//        public void dbInit5() {
//            Category category = categoryRepository.findOne(1L);
//            Category category1 = createCategory(2L, "한식", category);
//            em.persist(category1);
//            Category category2 = createCategory(3L, "일식", categoryRepository.findOne(1L));
//            em.persist(category2);
//            Category category3 = createCategory(4L, "중식", categoryRepository.findOne(1L));
//            em.persist(category3);
//            Category category4 = createCategory(5L, "양식", categoryRepository.findOne(1L));
//            em.persist(category4);
//            Category category5 = createCategory(6L, "치킨", categoryRepository.findOne(1L));
//            em.persist(category5);
//            Category category6 = createCategory(7L, "분식", categoryRepository.findOne(1L));
//            em.persist(category6);
//            Category category7 = createCategory(8L, "디저트", categoryRepository.findOne(1L));
//            em.persist(category7);
//
//
//        }
//        private Admin createAdmin(String id, String password, String name, String email, String tel, String address) {
//            Admin admin = new Admin();
//            admin.setId(id);
//            admin.setPassword(password);
//            admin.setName(name);
//            admin.setEmail(email);
//            admin.setTel(tel);
//            admin.setAddress(address);
//            return admin;
//        }
//
//        private Manager createManager(String id, String password, String name, String email, String tel, String address) {
//            Manager manager = new Manager();
//            manager.setId(id);
//            manager.setPassword(password);
//            manager.setName(name);
//            manager.setEmail(email);
//            manager.setTel(tel);
//            manager.setAddress(address);
//            return manager;
//        }
//
//        private Customer createCustomer(String id, String password, String name, String email, String tel, String address) {
//            Customer customer = new Customer();
//            customer.setId(id);
//            customer.setPassword(password);
//            customer.setName(name);
//            customer.setEmail(email);
//            customer.setTel(tel);
//            customer.setAddress(address);
//            return customer;
//        }
//        public Category createCategoryOne(Long id, String name) {
//            Category category = new Category();
//            category.setId(id);
//            category.setName(name);
//            return category;
//        }
//        public Category createCategory(Long id, String name, Category ids) {
//            Category cate = ids;
//            Category category = new Category();
//            category.setId(id);
//            category.setName(name);
//            category.setParent(cate);
//            return category;
//        }
//    }
//}

