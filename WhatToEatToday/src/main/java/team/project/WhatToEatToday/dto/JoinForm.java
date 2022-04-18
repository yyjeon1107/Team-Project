package team.project.WhatToEatToday.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class JoinForm {

    @NotEmpty(message = "회원 이름은 필수 입니다.")
    private String id;
    private String password;
    private String name;
    private String email;
    private String tel;
    private String address;
}
