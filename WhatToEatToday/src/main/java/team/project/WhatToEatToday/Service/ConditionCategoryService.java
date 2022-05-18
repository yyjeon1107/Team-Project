package team.project.WhatToEatToday.Service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import team.project.WhatToEatToday.domain.Category;
import team.project.WhatToEatToday.domain.ConditionCategory;
import team.project.WhatToEatToday.repository.ConditionCategoryRepository;

@Service
@RequiredArgsConstructor
public class ConditionCategoryService {

	private final ConditionCategoryRepository conditionCategoryRepository;
	
	
	 public ConditionCategory findOne(Long condcateId) {
	        return conditionCategoryRepository.findOne(condcateId);
	    }
	
}
