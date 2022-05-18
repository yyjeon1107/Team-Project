package team.project.WhatToEatToday.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;
import team.project.WhatToEatToday.domain.member.Manager;

@Entity
@Getter
@Setter
public class Condition {

	
	@Id 
	private Long id;
	
	private String name;
	
	
	@OneToMany(mappedBy = "condition")
    private List<Menu> menus = new ArrayList<>();
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "conditioncategory_id")
	private ConditionCategory concate;
	
	
    public void setConditionCategory(ConditionCategory concate) {
        this.concate = concate;
        concate.getCondition().add(this);
    }
	
   
	
}
