package team.project.WhatToEatToday.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import team.project.WhatToEatToday.domain.member.Manager;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ManagerRepository {
    public final EntityManager em;

    public void save(Manager manager) {
        em.persist(manager);
    }
    public Manager findOne(String id) {	// 없는 id 찾을시 error
        return em.find(Manager.class, id);
    }

    public List<Manager> findAll() {
        return em.createQuery("SELECT m FROM Manager m", Manager.class)
                .getResultList();
    }

    public List<Manager> findById(String id) { // 없는 id 찾을시 비어있는 list출력 (error X)
        return em.createQuery("SELECT m FROM Manager m where m.id = :id", Manager.class)
                .setParameter("id", id)
                .getResultList();
    }
}
