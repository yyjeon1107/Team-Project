package team.project.WhatToEatToday.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import team.project.WhatToEatToday.domain.Menu;

import javax.persistence.EntityManager;
import java.util.List;


@Repository
@RequiredArgsConstructor
public class MenuRepository {
    public final EntityManager em;

    public void save(Menu menu) {
        if(menu.getId() == null) {
            em.persist(menu);
        } else {
            em.merge(menu);
        }
    }

    public Menu findOne(Long id) {
        return em.find(Menu.class, id);
    }

    public List<Menu> findAll() {
        return em.createQuery("SELECT m FROM Menu m", Menu.class)
                .getResultList();
    }
    public List<Menu> findById(Long id) {
        return em.createQuery("SELECT m FROM Menu m where m.id = :id", Menu.class)
                .setParameter("id", id)
                .getResultList();
    }
}
