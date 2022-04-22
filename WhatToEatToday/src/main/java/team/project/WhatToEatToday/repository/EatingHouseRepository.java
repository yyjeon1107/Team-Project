package team.project.WhatToEatToday.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import team.project.WhatToEatToday.domain.EatingHouse;
import team.project.WhatToEatToday.domain.member.Customer;
import team.project.WhatToEatToday.domain.member.Manager;

import java.util.List;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class EatingHouseRepository {
    private final EntityManager em;

    public void save(EatingHouse eatingHouse){
        if(eatingHouse.getId() == null) {
            em.persist(eatingHouse);
        } else {
            em.merge(eatingHouse);
        }
    }
    public List<EatingHouse> findAll() {
        return em.createQuery("SELECT e FROM EatingHouse e", EatingHouse.class)
                .getResultList();
    }
    public EatingHouse findOne(Long id) {	// 없는 id 찾을시 error
        return em.find(EatingHouse.class, id);
    }
    public List<EatingHouse> findById(String id) { // 없는 id 찾을시 비어있는 list출력 (error X)
        return em.createQuery("SELECT e FROM EatingHouse e where e.id = :id", EatingHouse.class)
                .setParameter("id", id)
                .getResultList();
    }
    
    public EatingHouse findId(Manager id) { // 없는 id 찾을시 비어있는 list출력 (error X)
        return em.createQuery("SELECT e FROM EatingHouse e where manager_id = :id", EatingHouse.class)
                .setParameter("id", id)
                .getSingleResult();
    }
    

}
