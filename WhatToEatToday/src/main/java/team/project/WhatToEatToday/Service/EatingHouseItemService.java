package team.project.WhatToEatToday.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import team.project.WhatToEatToday.domain.EatingHouse;
import team.project.WhatToEatToday.domain.Item;
import team.project.WhatToEatToday.repository.EatingHouseItemRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EatingHouseItemService {
	
    private final EatingHouseItemRepository eatingHouseItemRepository;

    @Transactional
    public Long join(Item item) {
    	eatingHouseItemRepository.save(item);
        return item.getId();
    }  
   /* public EatingHouse findOne(String eatingHouseId) {
        return eatingHouseItemRepository.findOne(eatingHouseId);
    }*/
}
