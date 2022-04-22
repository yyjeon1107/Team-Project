package team.project.WhatToEatToday.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import team.project.WhatToEatToday.domain.EatingHouse;
import team.project.WhatToEatToday.domain.member.Customer;

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
    
    

}
