package team.project.WhatToEatToday.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import team.project.WhatToEatToday.domain.EatingHouse;

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

}
