package team.project.WhatToEatToday.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class EatingHouseItemForm {

   
    private Long id;
    private String name;
    private int price;

}
