package com.trabalho.crud.core.dto;

import lombok.Data;

@Data
public class PetDto {
	private Long id;

	private String name;

	private String species; 

	private boolean vaccinated;

	private int age;

	private String owner; 

	private double weight;

	private String gender;

}
