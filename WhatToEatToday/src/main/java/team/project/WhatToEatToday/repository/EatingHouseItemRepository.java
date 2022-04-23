package team.project.WhatToEatToday.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import team.project.WhatToEatToday.domain.EatingHouse;
import team.project.WhatToEatToday.domain.Item;

@Repository
@RequiredArgsConstructor
public class EatingHouseItemRepository {
    private final EntityManager em;

    public void save(Item item){
        if(item.getId() == null) {
            em.persist(item);
        } else {
            em.merge(item);
        }
    }
<<<<<<< Updated upstream
=======
    
    public Item findOne(Long id) {
    	return em.find(Item.class, id);
    }
    
>>>>>>> Stashed changes
    public List<Item> findAll() {
        return em.createQuery("SELECT e FROM Item e", Item.class)
                .getResultList();
    }
    
<<<<<<< Updated upstream
=======
   
    public Item findId(Manager id) { 
        return em.createQuery("SELECT e FROM Item e where manager_id = :id", Item.class)
                .setParameter("id", id)
                .getSingleResult();
    }
>>>>>>> Stashed changes
    

}
