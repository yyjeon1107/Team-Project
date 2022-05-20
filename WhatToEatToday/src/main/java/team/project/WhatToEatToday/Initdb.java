//
//package team.project.WhatToEatToday;
//
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import team.project.WhatToEatToday.domain.*;
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
//        initService.dbInit6();
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
//        }
//
//
//        public void dbInit6() {
//        	ConditionCategory concate1 = createConditionCategory(1L, "기분");
//        	em.persist(concate1);
//        	ConditionCategory concate2 = createConditionCategory(2L, "날씨");
//        	em.persist(concate2);
//        	ConditionCategory concate3 = createConditionCategory(3L, "상황");
//        	em.persist(concate3);
//
//
//        	Condition condition1 = createCondition(1L, "즐거운", concate1);
//        	em.persist(condition1);
//        	Condition condition2 = createCondition(2L, "무기력한", concate1);
//        	em.persist(condition2);
//        	Condition condition3 = createCondition(3L, "입이 심심한", concate1);
//        	em.persist(condition3);
//        	Condition condition4 = createCondition(4L, "허전한", concate1);
//        	em.persist(condition4);
//        	Condition condition5 = createCondition(5L, "행복한", concate1);
//        	em.persist(condition5);
//        	Condition condition6 = createCondition(6L, "설레는", concate1);
//        	em.persist(condition6);
//        	Condition condition7 = createCondition(7L, "긴장되는", concate1);
//        	em.persist(condition7);
//        	Condition condition8 = createCondition(8L, "짜증나는", concate1);
//        	em.persist(condition8);
//        	Condition condition9 = createCondition(9L, "피곤한", concate1);
//        	em.persist(condition9);
//        	Condition condition10 = createCondition(10L, "기쁜", concate1);
//        	em.persist(condition10);
//        	Condition condition11 = createCondition(11L, "슬픈", concate1);
//        	em.persist(condition11);
//        	Condition condition12 = createCondition(12L, "답답한", concate1);
//        	em.persist(condition12);
//        	Condition condition13 = createCondition(13L, "우울한", concate1);
//        	em.persist(condition13);
//        	Condition condition14 = createCondition(14L, "예민한", concate1);
//        	em.persist(condition14);
//        	Condition condition15 = createCondition(15L, "스트레스 받는", concate1);
//        	em.persist(condition15);
//
//
//        	Condition condition16 = createCondition(16L, "화창한", concate2);
//        	em.persist(condition16);
//        	Condition condition17 = createCondition(17L, "선선한", concate2);
//        	em.persist(condition17);
//        	Condition condition18 = createCondition(18L, "추운", concate2);
//        	em.persist(condition18);
//        	Condition condition19 = createCondition(19L, "더운", concate2);
//        	em.persist(condition19);
//        	Condition condition20 = createCondition(20L, "비가오는", concate2);
//        	em.persist(condition20);
//        	Condition condition21 = createCondition(21L, "눈오는", concate2);
//        	em.persist(condition21);
//        	Condition condition22 = createCondition(22L, "바람부는", concate2);
//        	em.persist(condition22);
//        	Condition condition23 = createCondition(23L, "미세먼지 심한", concate2);
//        	em.persist(condition23);
//        	Condition condition24 = createCondition(24L, "따뜻한", concate2);
//        	em.persist(condition24);
//        	Condition condition25 = createCondition(25L, "번개치는", concate2);
//        	em.persist(condition25);
//        	Condition condition26 = createCondition(26L, "안개 낀", concate2);
//        	em.persist(condition26);
//        	Condition condition27 = createCondition(27L, "쌀쌀한", concate2);
//        	em.persist(condition27);
//        	Condition condition28 = createCondition(28L, "건조한", concate2);
//        	em.persist(condition28);
//        	Condition condition29 = createCondition(29L, "습한", concate2);
//        	em.persist(condition29);
//        	Condition condition30 = createCondition(30L, "흐린", concate2);
//        	em.persist(condition30);
//
//
//        	Condition condition31 = createCondition(31L, "다이어트 3일차 날", concate3);
//        	em.persist(condition31);
//        	Condition condition32 = createCondition(32L, "회사점심회식 날", concate3);
//        	em.persist(condition32);
//        	Condition condition33 = createCondition(33L, "가족식사 날", concate3);
//        	em.persist(condition33);
//        	Condition condition34 = createCondition(34L, "집들이 날", concate3);
//        	em.persist(condition34);
//        	Condition condition35 = createCondition(35L, "손님 대접하는 날", concate3);
//        	em.persist(condition35);
//        	Condition condition36 = createCondition(36L, "단체 주문 있는 날", concate3);
//        	em.persist(condition36);
//        	Condition condition37 = createCondition(37L, "야식 당기는 날", concate3);
//        	em.persist(condition37);
//        	Condition condition38 = createCondition(38L, "소화 안 되는 날", concate3);
//        	em.persist(condition38);
//        	Condition condition39 = createCondition(39L, "데이트 하는 날", concate3);
//        	em.persist(condition39);
//        	Condition condition40 = createCondition(40L, "당기는 음식이 없는 날", concate3);
//        	em.persist(condition40);
//        	Condition condition41 = createCondition(41L, "잠 안오는 날", concate3);
//        	em.persist(condition41);
//        	Condition condition42 = createCondition(42L, "배부른데 입 심심한 날", concate3);
//        	em.persist(condition42);
//        	Condition condition43 = createCondition(43L, "혼밥하는 날", concate3);
//        	em.persist(condition43);
//        	Condition condition44 = createCondition(44L, "면접 날", concate3);
//        	em.persist(condition44);
//        	Condition condition45 = createCondition(45L, "기념일", concate3);
//        	em.persist(condition45);
//
////            ConditionMenu conditionMenu011 = createConditionMenu(1L, "치킨", condition1);
////            em.persist(conditionMenu011);
////            ConditionMenu conditionMenu012 = createConditionMenu(2L, "피자", condition1);
////            em.persist(conditionMenu012);
////            ConditionMenu conditionMenu013 = createConditionMenu(3L, "고기", condition1);
////            em.persist(conditionMenu013);
////            ConditionMenu conditionMenu021 = createConditionMenu(4L, "카레", condition2);
////            em.persist(conditionMenu021);
////            ConditionMenu conditionMenu022 = createConditionMenu(5L, "연어", condition2);
////            em.persist(conditionMenu022);
////            ConditionMenu conditionMenu023 = createConditionMenu(6L, "녹차", condition2);
////            em.persist(conditionMenu023);
////            ConditionMenu conditionMenu031 = createConditionMenu(7L, "커피", condition3);
////            em.persist(conditionMenu031);
////            ConditionMenu conditionMenu032 = createConditionMenu(8L, "아이스크림", condition3);
////            em.persist(conditionMenu032);
////            ConditionMenu conditionMenu033 = createConditionMenu(9L, "과자", condition3);
////            em.persist(conditionMenu033);
////            ConditionMenu conditionMenu041 = createConditionMenu(10L, "닭볶음탕", condition4);
////            em.persist(conditionMenu041);
////            ConditionMenu conditionMenu042 = createConditionMenu(11L, "떡볶이", condition4);
////            em.persist(conditionMenu042);
////            ConditionMenu conditionMenu043 = createConditionMenu(12L, "아이스크림", condition4);
////            em.persist(conditionMenu043);
////            ConditionMenu conditionMenu051 = createConditionMenu(13L, "스테이크", condition5);
////            em.persist(conditionMenu051);
////            ConditionMenu conditionMenu052 = createConditionMenu(14L, "디저트", condition5);
////            em.persist(conditionMenu052);
////            ConditionMenu conditionMenu053 = createConditionMenu(15L, "파스타", condition5);
////            em.persist(conditionMenu053);
////            ConditionMenu conditionMenu061 = createConditionMenu(16L, "치킨", condition6);
////            em.persist(conditionMenu061);
////            ConditionMenu conditionMenu062 = createConditionMenu(17L, "짜장면", condition6);
////            em.persist(conditionMenu062);
////            ConditionMenu conditionMenu063 = createConditionMenu(18L, "족발", condition6);
////            em.persist(conditionMenu063);
////            ConditionMenu conditionMenu071 = createConditionMenu(19L, "마라탕", condition7);
////            em.persist(conditionMenu071);
////            ConditionMenu conditionMenu072 = createConditionMenu(20L, "바나나", condition7);
////            em.persist(conditionMenu072);
////            ConditionMenu conditionMenu073 = createConditionMenu(21L, "고구마", condition7);
////            em.persist(conditionMenu073);
////            ConditionMenu conditionMenu081 = createConditionMenu(22L, "다크초콜릿", condition6);
////            em.persist(conditionMenu081);
////            ConditionMenu conditionMenu082 = createConditionMenu(23L, "연어", condition6);
////            em.persist(conditionMenu082);
////            ConditionMenu conditionMenu083 = createConditionMenu(24L, "견과류", condition6);
////            em.persist(conditionMenu083);
//
//
//            ConditionMenu conditionMenu1 = createConditionMenu("견과류", condition1);
//            em.persist(conditionMenu1);
//            ConditionMenu conditionMenu2 = createConditionMenu("견과류", condition2);
//            em.persist(conditionMenu2);
//            ConditionMenu conditionMenu3 = createConditionMenu("견과류", condition3);
//            em.persist(conditionMenu3);
//            ConditionMenu conditionMenu4 = createConditionMenu("견과류", condition4);
//            em.persist(conditionMenu4);
//            ConditionMenu conditionMenu5 = createConditionMenu("견과류", condition5);
//            em.persist(conditionMenu5);
//            ConditionMenu conditionMenu6 = createConditionMenu("견과류", condition6);
//            em.persist(conditionMenu6);
//            ConditionMenu conditionMenu7 = createConditionMenu("견과류", condition7);
//            em.persist(conditionMenu7);
//            ConditionMenu conditionMenu8 = createConditionMenu("견과류", condition8);
//            em.persist(conditionMenu8);
//            ConditionMenu conditionMenu9 = createConditionMenu("견과류", condition9);
//            em.persist(conditionMenu9);
//            ConditionMenu conditionMenu10 = createConditionMenu("견과류", condition10);
//            em.persist(conditionMenu10);
//            ConditionMenu conditionMenu11 = createConditionMenu("견과류", condition11);
//            em.persist(conditionMenu11);
//            ConditionMenu conditionMenu12 = createConditionMenu("견과류", condition12);
//            em.persist(conditionMenu12);
//            ConditionMenu conditionMenu13 = createConditionMenu("견과류", condition13);
//            em.persist(conditionMenu13);
//            ConditionMenu conditionMenu14 = createConditionMenu("견과류", condition14);
//            em.persist(conditionMenu14);
//            ConditionMenu conditionMenu15 = createConditionMenu("견과류", condition15);
//            em.persist(conditionMenu15);
//
//
//
//
//
//        }
//
//
//
//
//
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
//
//        public ConditionCategory createConditionCategory(Long id, String name) {
//        	ConditionCategory concate = new ConditionCategory();
//        	concate.setId(id);
//        	concate.setName(name);
//        	return concate;
//        }
//
//        public Condition createCondition(Long id, String name, ConditionCategory concate) {
//        	Condition condition = new Condition();
//        	condition.setId(id);
//        	condition.setName(name);
//        	condition.setConditionCategory(concate);
//        	return condition;
//        }
//
//        public ConditionMenu createConditionMenu(String name, Condition condition){
//            ConditionMenu conditionMenu = new ConditionMenu();
////            conditionMenu.setId(id);
//            conditionMenu.setName(name);
//            conditionMenu.setCondition(condition);
//            return conditionMenu;
//        }
//
//
//    }
//}
//
