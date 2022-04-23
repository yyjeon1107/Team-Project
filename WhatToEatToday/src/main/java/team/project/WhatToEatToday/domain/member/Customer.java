package team.project.WhatToEatToday.domain.member;

import lombok.Getter;
import lombok.Setter;
import team.project.WhatToEatToday.domain.Order;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("C")
@Table(name = "customers")
@Getter
@Setter
public class Customer extends Member {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id")
    @JsonIgnore
    private Admin admin;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders = new ArrayList<>();

    public void setAdmin(Admin admin) {
        this.admin = admin;
        admin.getCustomers().add(this);
    }
}
