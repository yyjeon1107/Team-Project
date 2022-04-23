package team.project.WhatToEatToday.domain;

import lombok.Getter;
import lombok.Setter;
import team.project.WhatToEatToday.domain.member.Manager;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Item {

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "eating_house_id")
    @JsonIgnore
    private EatingHouse eatingHouse;

    private String name;
    private int price;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();

    @OneToMany(mappedBy = "item")
    List<OrderItem> orderItems = new ArrayList<>();
    
    public void setEatingHouse(EatingHouse eatingHouse) {
    	this.eatingHouse = eatingHouse;
    	eatingHouse.getItems().add(this);
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setItem(this);
    }
}
