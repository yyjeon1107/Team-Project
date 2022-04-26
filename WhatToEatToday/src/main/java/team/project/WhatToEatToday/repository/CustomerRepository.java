package team.project.WhatToEatToday.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import team.project.WhatToEatToday.domain.member.Customer;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CustomerRepository {
    public final EntityManager em;

    public void save(Customer customer) {
        em.persist(customer);
    }

    public Customer findOne(String id) {
        return em.find(Customer.class, id);
    }

    public List<Customer> findAll() {
        return em.createQuery("SELECT c FROM Customer c", Customer.class)
                .getResultList();
    }
    public List<Customer> findById(String id) {
        return em.createQuery("SELECT c FROM Customer c where c.id = :id", Customer.class)
                .setParameter("id", id)
                .getResultList();
    }
}
