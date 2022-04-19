package team.project.WhatToEatToday.domain;

import lombok.Getter;
import lombok.Setter;
import team.project.WhatToEatToday.domain.member.Manager;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "eating_houses")
@Getter
@Setter
public class EatingHouse {

    @Id
    @GeneratedValue//AutoIncrement
    @Column(name = "eating_house_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id") //매니저 id
    private Manager manager;

    @OneToMany(mappedBy = "eatingHouse")
    private List<Item> items = new ArrayList<>();

    private String Name; //가게명
}
