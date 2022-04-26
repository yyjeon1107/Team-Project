package team.project.WhatToEatToday.domain;

import lombok.Getter;
import lombok.Setter;
import team.project.WhatToEatToday.domain.member.Customer;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter @Setter
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderMenu> orderMenus = new ArrayList<>();

    private LocalDateTime orderDateTime;

    private OrderStatus status;

    public void setCustomer(Customer customer) {
        this.customer = customer;
        customer.getOrders().add(this);
    }

    public void addOrderMenu(OrderMenu orderMenu) {
        orderMenus.add(orderMenu);
        orderMenu.setOrder(this);
    }
}
