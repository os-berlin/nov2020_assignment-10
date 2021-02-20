package com.coderscampus.olaf.assignment10.Spoonacular;

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.coderscampus.olaf.assignment10.dto.DayResponse;
import com.coderscampus.olaf.assignment10.dto.WeekResponse;

@Service	
public class SpoonacularIntegration {
	
	@Value("${spoonacular.urls.base}")
	private String SpoonacularBaseUrl;
	@Value("${spoonacular.urls.mealplan}")
	private String SpoonacularMealplanUrl;
	@Value("${spoonacular.api.key}")
	private String apiKey;
	
	private RestTemplate rt = new RestTemplate();
	
	public ResponseEntity<DayResponse> getDayMeals(String numCalories, String diet, String exclusions) {
		
			URI spoonacularUri = UriComponentsBuilder.fromHttpUrl(SpoonacularBaseUrl + SpoonacularMealplanUrl)
													 .queryParam("timeFrame", "day")
													 .queryParam("targetCalories", Integer.parseInt(numCalories))
													 .queryParam("diet", diet)
													 .queryParam("exclude", exclusions)
													 .queryParam("apiKey", apiKey)
													 .build()
													 .toUri();

			return (rt.getForEntity(spoonacularUri, DayResponse.class));
	}
	
	public ResponseEntity<WeekResponse> getWeekMeals(String numCalories, String diet, String exclusions) {
		
		URI spoonacularUri = UriComponentsBuilder.fromHttpUrl(SpoonacularBaseUrl + SpoonacularMealplanUrl)
												 .queryParam("timeFrame", "week")
												 .queryParam("targetCalories", Integer.parseInt(numCalories))
												 .queryParam("diet", diet)
												 .queryParam("exclude", exclusions)
												 .queryParam("apiKey", apiKey)
												 .build()
												 .toUri();

		return (rt.getForEntity(spoonacularUri, WeekResponse.class));
	}
}
