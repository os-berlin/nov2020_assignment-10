package com.coderscampus.olaf.assignment10.dto;

import java.util.List;

public class DayResponse {

	private List<SingleMeal> meals;
	private Nutrients nutrients;

	public List<SingleMeal> getMeals() {
		return meals;
	}

	public void setMeals(List<SingleMeal> meals) {
		this.meals = meals;
	}

	public Nutrients getNutrients() {
		return nutrients;
	}

	public void setNutrients(Nutrients nutrients) {
		this.nutrients = nutrients;
	}

}
