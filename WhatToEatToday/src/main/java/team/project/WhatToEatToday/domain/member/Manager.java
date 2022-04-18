package team.project.WhatToEatToday.domain.member;

import lombok.Getter;
import lombok.Setter;
import team.project.WhatToEatToday.domain.EatingHouse;
import team.project.WhatToEatToday.domain.Order;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("M")
@Table(name = "managers")
@Getter
@Setter
public class Manager extends Member {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id")
    private Admin admin;

    @OneToMany(mappedBy = "manager")
    private List<EatingHouse> EatingHouses  = new ArrayList<>();

    public void setAdmin(Admin admin) {
        this.admin = admin;
        admin.getManagers().add(this);
    }
}
