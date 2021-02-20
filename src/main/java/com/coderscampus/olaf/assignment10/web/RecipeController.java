package com.coderscampus.olaf.assignment10.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.olaf.assignment10.Spoonacular.SpoonacularIntegration;
import com.coderscampus.olaf.assignment10.dto.DayResponse;
import com.coderscampus.olaf.assignment10.dto.WeekResponse;

@RestController
public class RecipeController {

	@Autowired
	SpoonacularIntegration spoonacularIntegration;

	@GetMapping("mealplanner/week")
	public ResponseEntity<WeekResponse> getWeekMeals(String numCalories, String diet, String exclusions) {
		return spoonacularIntegration.getWeekMeals(numCalories, diet, exclusions);
	}

	@GetMapping("mealplanner/day")
	public ResponseEntity<DayResponse> getDayMeals(String numCalories, String diet, String exclusions) {
		return spoonacularIntegration.getDayMeals(numCalories, diet, exclusions);
	}

}