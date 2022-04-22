package team.project.WhatToEatToday.domain;

import lombok.Getter;
import lombok.Setter;
import team.project.WhatToEatToday.domain.member.Manager;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
<<<<<<< Updated upstream
    @JoinColumn(name = "manager_id") //매니저 id
=======
    @JoinColumn(name = "manager_id")
    @JsonIgnore
>>>>>>> Stashed changes
    private Manager manager;

    @OneToMany(mappedBy = "eatingHouse")
    private List<Item> items = new ArrayList<>();

<<<<<<< Updated upstream
    private String Name; //가게명
=======


    @Column(length=2000)
    private String address;

    
    private String addressDetail;
    
    private String tel;




    
    public void setManager(Manager manager) {
    	this.manager = manager;
    	manager.getEatingHouses().add(this);
    }
    
    public void addItem(Item item) {
    	this.items.add(item);
    	item.setEatingHouse(this);
    }
    
    
>>>>>>> Stashed changes
}
