package team.project.WhatToEatToday.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class EatingHouseItemForm {

    @NotEmpty(message = "메뉴 이름은 필수 입니다.")
    private String name;
    private int price;

}
