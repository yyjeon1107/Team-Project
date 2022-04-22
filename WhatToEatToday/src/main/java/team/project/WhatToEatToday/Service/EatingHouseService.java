package team.project.WhatToEatToday.Service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import team.project.WhatToEatToday.domain.EatingHouse;
import team.project.WhatToEatToday.repository.EatingHouseRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EatingHouseService {
	private final EntityManager em;
    private final EatingHouseRepository eatingHouseRepository;

    @Transactional
    public Long join(EatingHouse eatinghouse) {
    	eatingHouseRepository.save(eatinghouse);
        return eatinghouse.getId();
    }  

    public List<EatingHouse> findAll(){
    	return eatingHouseRepository.findAll();
    }
    
   
    
}
