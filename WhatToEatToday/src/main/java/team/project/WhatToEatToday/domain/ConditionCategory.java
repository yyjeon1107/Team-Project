package team.project.WhatToEatToday.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ConditionCategory {
	
	
	@Id
	private Long id;
	
	private String name;
	
	@OneToMany(mappedBy = "concate")
	private List<Condition> condition = new ArrayList<>();
	
	
	

}
