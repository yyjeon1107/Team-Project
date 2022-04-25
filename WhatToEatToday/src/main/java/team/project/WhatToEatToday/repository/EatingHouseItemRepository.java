package team.project.WhatToEatToday.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import team.project.WhatToEatToday.domain.EatingHouse;
import team.project.WhatToEatToday.domain.Item;
import team.project.WhatToEatToday.domain.member.Manager;

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
    
    public EatingHouse findOne(Long id) {
    	return em.find(EatingHouse.class, id);
    }
    
    public List<Item> findAll() {
        return em.createQuery("SELECT e FROM Item e", Item.class)
                .getResultList();
    }
    
   
    public EatingHouse findId(Manager id) { // 없는 id 찾을시 비어있는 list출력 (error X)
        return em.createQuery("SELECT e FROM EatingHouse e where manager_id = :id", EatingHouse.class)
                .setParameter("id", id)
                .getSingleResult();
    }
    
    public void removeItem(Long id) {
    	Item item = em.find(Item.class, id);
    	em.remove(item);
    }


}
