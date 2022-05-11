package team.project.WhatToEatToday.domain;

import lombok.Getter;
import lombok.Setter;
import team.project.WhatToEatToday.domain.member.Manager;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Entity
@Getter @Setter
public class Menu {

    @Id
    @GeneratedValue
    @Column(name = "menu_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "eating_house_id")
    private EatingHouse eatingHouse;

    private String name;
    private int price;

    @OneToMany(mappedBy = "menu")
    List<OrderMenu> orderMenus = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category categorys;

    public void setCategory(Category category) {
        this.categorys = category;
        category.getMenu().add(this);
    }

    public void setEatingHouse(EatingHouse eatingHouse) {
        this.eatingHouse = eatingHouse;
        HashSet<String> categorySet = eatingHouse.getCategorys();
        categorySet.add(categorys.getName());
        eatingHouse.getMenus().add(this);
    }

    public void addOrderMenu(OrderMenu orderMenu) {
        orderMenus.add(orderMenu);
        orderMenu.setMenu(this);
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", eatingHouse=" + eatingHouse +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", orderMenus=" + orderMenus +
                ", categorys=" + categorys +
                '}';
    }
}
