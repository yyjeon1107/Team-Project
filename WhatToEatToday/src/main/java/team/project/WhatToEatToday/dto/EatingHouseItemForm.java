package team.project.WhatToEatToday.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EatingHouseItemForm {

   
    private Long id;
    private String name;
    private int price;
    private List categories;

}
