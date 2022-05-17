package team.project.WhatToEatToday.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import team.project.WhatToEatToday.Service.CategoryService;
import team.project.WhatToEatToday.Service.EatingHouseService;
import team.project.WhatToEatToday.Service.ManagerService;
import team.project.WhatToEatToday.Service.MenuService;
import team.project.WhatToEatToday.domain.Category;
import team.project.WhatToEatToday.domain.EatingHouse;
import team.project.WhatToEatToday.domain.Menu;
import team.project.WhatToEatToday.domain.member.Manager;
import team.project.WhatToEatToday.domain.member.Member;
import team.project.WhatToEatToday.dto.EatingHouseForm;
import team.project.WhatToEatToday.dto.MenuForm;
import team.project.WhatToEatToday.repository.CategoryRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/manager")
@RequiredArgsConstructor
public class ManagerController {

    private final ManagerService managerService;
    private final EatingHouseService eatingHouseService;
    private final MenuService menuService;
    private final CategoryService categoryService;


    @GetMapping("/eating_house")
    public String getManager(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        try {
            Member member = (Member) session.getAttribute("member");
            Manager manager = managerService.findOne(member.getId());
            model.addAttribute("page", "manager");
            model.addAttribute("eatingHouses", manager.getEatingHouses());
            return "layout";
        } catch (Exception e){
            session.setAttribute("message", "유저 정보가 올바르지 않습니다.");
            return "redirect:/logout";
        }

    }

    @GetMapping("/eating_house/add")
    public String getAddEatingHouse(Model model) {
        model.addAttribute("page", "addEatingHouse");
        model.addAttribute("eatingHouseForm", new EatingHouseForm());
        return "layout";
    }

    @PostMapping("/eating_house/add")
    public String postAddEatingHouse(HttpServletRequest request, @Valid EatingHouseForm eatingHouseForm) {
        HttpSession session = request.getSession();
        try {
            EatingHouse eatingHouse = new EatingHouse();
            eatingHouse.setName(eatingHouseForm.getName());
            eatingHouse.setDescription(eatingHouseForm.getDescription());
            Member member = (Member) session.getAttribute("member");
            Manager manager = managerService.findOne(member.getId());
            eatingHouse.setManager(manager);
            eatingHouse.setAddress(eatingHouseForm.getAddress());
            eatingHouse.setAddressDetail(eatingHouseForm.getAddressDetail());
            eatingHouseService.join(eatingHouse);
            session.setAttribute("message", "매장 등록 성공");
            return "redirect:/manager/eating_house";
        } catch (Exception e) {
            session.setAttribute("message", "매장 등록 실패");
            return "redirect:/manager/eating_house/add";
        }
    }


    @GetMapping("/eating_house/edit/{eatingHouseId}")
    public String getEatingHouseEdit(@PathVariable Long eatingHouseId, Model model, EatingHouseForm eatingHouseForm) {
        model.addAttribute("page", "editEatingHouse");
        model.addAttribute("eatingHouseForm", eatingHouseForm);
        model.addAttribute("eatingHouse", eatingHouseService.findOne(eatingHouseId));
        return "layout";
    }

    @PostMapping("/eating_house/edit/{eatingHouseId}")
    public String postEatingHouseDetail(@PathVariable Long eatingHouseId, @Valid EatingHouseForm eatingHouseForm) {
        EatingHouse eatingHouse = eatingHouseService.findOne(eatingHouseId);
        eatingHouse.setName(eatingHouseForm.getName());
        eatingHouse.setDescription(eatingHouseForm.getDescription());
        eatingHouse.setAddress(eatingHouseForm.getAddress());
        eatingHouse.setAddressDetail(eatingHouseForm.getAddressDetail());
        eatingHouseService.join(eatingHouse);
        return "redirect:/manager/eating_house";
    }

    @GetMapping("/eating_house/delete/{eatingHouseId}")
    public String deleteEatingHouseDetail(HttpServletRequest request, @PathVariable Long eatingHouseId) {
        HttpSession session = request.getSession();
        session.setAttribute("message", "삭제완료");
        EatingHouse eatingHouse = eatingHouseService.findOne(eatingHouseId);
        eatingHouseService.delete(eatingHouse);
        return "redirect:/manager/eating_house";
    }

    @GetMapping("/eating_house/edit/{eatingHouseId}/menu/add")
    public String getAddMenu(@PathVariable Long eatingHouseId, Model model, MenuForm menuForm){

        model.addAttribute("page", "addMenu");
        model.addAttribute("menuForm", menuForm);
        List<Category> categoryList = categoryService.findCategoryExOne();

        model.addAttribute("cate", categoryList);
        model.addAttribute("eatingHouse", eatingHouseService.findOne(eatingHouseId));
        return "layout";
    }

    @PostMapping("/eating_house/edit/{eatingHouseId}/menu/add")
    public String postAddMenu(HttpServletRequest request, @PathVariable Long eatingHouseId, @Valid MenuForm menuForm){
        HttpSession session = request.getSession();
        Menu menu = new Menu();
        menu.setName(menuForm.getName());
        menu.setPrice(menuForm.getPrice());
        menu.setCategorys(categoryService.findOne(menuForm.getCategory()));

        menu.setEatingHouse(eatingHouseService.findOne(eatingHouseId));
        menuService.join(menu);
        session.setAttribute("message", "메뉴추가");
        return "redirect:/manager/eating_house/edit/" + eatingHouseId;
    }

    @GetMapping("/eating_house/edit/{eatingHouseId}/menu/edit/{menuId}")
    public String getEditMenu(
            @PathVariable Long eatingHouseId,
            @PathVariable Long menuId, Model model, MenuForm menuForm){
        model.addAttribute("page", "editMenu");
        model.addAttribute("menuForm", menuForm);
        List<Category> categoryList = categoryService.findCategoryExOne();
        model.addAttribute("cate", categoryList);
        Menu menu = menuService.findOne(menuId);
        Category category = categoryService.findOne(menu.getCategorys().getId());

        model.addAttribute("cateid", category.getId());
        model.addAttribute("menu", menuService.findOne(menuId));
        model.addAttribute("eatingHouse", eatingHouseService.findOne(eatingHouseId));
        return "layout";
    }
    @PostMapping("/eating_house/edit/{eatingHouseId}/menu/edit/{menuId}")
    public String postEditMenu(
            HttpServletRequest request,
            @PathVariable Long eatingHouseId,
            @PathVariable Long menuId,
            @Valid MenuForm menuForm){
        HttpSession session = request.getSession();
        session.setAttribute("message", "메뉴수정");
        Menu menu = menuService.findOne(menuId);
        menu.setName(menuForm.getName());
        menu.setPrice(menuForm.getPrice());
        menu.setCategorys(categoryService.findOne(menuForm.getCategory()));

        menuService.join(menu);
        return "redirect:/manager/eating_house/edit/" + eatingHouseId;
    }

    @GetMapping("/eating_house/edit/{eatingHouseId}/menu/delete/{menuId}")
    public String deleteMenu(
            HttpServletRequest request,
            @PathVariable Long eatingHouseId,
            @PathVariable Long menuId){
        HttpSession session = request.getSession();
        session.setAttribute("message", "메뉴삭제");
        Menu menu = menuService.findOne(menuId);
        menuService.delete(menu);
        return "redirect:/manager/eating_house/edit/" + eatingHouseId;
    }
}
