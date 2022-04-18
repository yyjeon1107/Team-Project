package team.project.WhatToEatToday.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import team.project.WhatToEatToday.domain.member.Admin;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class AdminRepository {
    public final EntityManager em;

    public void save(Admin admin) {
        em.persist(admin);
    }

    public Admin findOne(String id) {
        return em.find(Admin.class, id);
    }

    public List<Admin> findAll() {
        return em.createQuery("SELECT m FROM admin m", Admin.class)
                .getResultList();
    }

    public List<Admin> findById(String id) {
        return em.createQuery("SELECT a FROM Admin a where a.id = :id", Admin.class)
                .setParameter("id", id)
                .getResultList();
    }
}
