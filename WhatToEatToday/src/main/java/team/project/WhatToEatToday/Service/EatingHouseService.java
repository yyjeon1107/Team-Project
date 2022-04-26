package team.project.WhatToEatToday.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import team.project.WhatToEatToday.domain.EatingHouse;
import team.project.WhatToEatToday.domain.Item;
import team.project.WhatToEatToday.domain.member.Manager;
import team.project.WhatToEatToday.repository.EatingHouseRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EatingHouseService {
	
    private final EatingHouseRepository eatingHouseRepository;

    @Transactional
    public Long join(EatingHouse eatinghouse) {
    	eatingHouseRepository.save(eatinghouse);
        return eatinghouse.getId();
    }  
    
    public List<EatingHouse> findAll(){
    	return eatingHouseRepository.findAll();
    }
    
    public EatingHouse findOne(Long eatingHouseId) {
        return eatingHouseRepository.findOne(eatingHouseId);
    }
    public List<EatingHouse> findById(String id) { 
        return eatingHouseRepository.findById(id);
    }
    
    public EatingHouse findId(Manager id) { 
        return eatingHouseRepository.findId(id);
    }
    
    
    
    
}
