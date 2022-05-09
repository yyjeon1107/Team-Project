package team.project.WhatToEatToday.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
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

    public void setEatingHouse(EatingHouse eatingHouse) {
        this.eatingHouse = eatingHouse;
        eatingHouse.getMenus().add(this);
    }

    public void addOrderMenu(OrderMenu orderMenu) {
        orderMenus.add(orderMenu);
        orderMenu.setMenu(this);
    }
}
