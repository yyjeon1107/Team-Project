package team.project.WhatToEatToday.repository;

<<<<<<< Updated upstream
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import team.project.WhatToEatToday.domain.EatingHouse;
=======
import java.util.List;
>>>>>>> Stashed changes

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import team.project.WhatToEatToday.domain.EatingHouse;

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
<<<<<<< Updated upstream
=======
    
    public EatingHouse findOne(Long id) {
    	return em.find(EatingHouse.class, id);
    }
    
    public List<EatingHouse> findAll() {
        return em.createQuery("SELECT e FROM EatingHouse e", EatingHouse.class)
                .getResultList();
    }
    
    public List<EatingHouse> findById(String id) {
        return em.createQuery("SELECT e FROM Member e where e.id = :id", EatingHouse.class)
                .setParameter("id", id)
                .getResultList();
    }
    
    
>>>>>>> Stashed changes

}
