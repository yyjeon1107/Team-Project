package team.project.WhatToEatToday.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.project.WhatToEatToday.domain.member.Manager;
import team.project.WhatToEatToday.repository.ManagerRepository;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ManagerService {
    private final EntityManager em;
    private final ManagerRepository managerRepository;

    @Transactional
    public String join(Manager manager) {
        validateDuplicateAdmin(manager);
        managerRepository.save(manager);
        return manager.getId();
    }

    private void validateDuplicateAdmin(Manager manager) {
        List<Manager> findAdmins = managerRepository.findById(manager.getId());
        if(!findAdmins.isEmpty()) {
            throw new IllegalStateException();
        }
    }

    //회원 전체 조회
    public List<Manager> findManagers() {
        return managerRepository.findAll();
    }

    public Manager findOne(String managerId) {
        return managerRepository.findOne(managerId);
    }
    public List<Manager> findById(String id) { // 없는 id 찾을시 비어있는 list출력 (error X)
        return em.createQuery("SELECT categoryid FROM Manager m where m.id = :id", Manager.class)
                .setParameter("id", id)
                .getResultList();
    }
}
