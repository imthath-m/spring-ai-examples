package org.springframework.ai.mcp.sample.server;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
public class WeatherController {

	private final WeatherService weatherService;

	public WeatherController(WeatherService weatherService) {
		this.weatherService = weatherService;
	}

	@GetMapping("/forecast")
	public String getWeather(@RequestParam double latitude, @RequestParam double longitude) {
		return weatherService.getWeatherForecastByLocation(latitude, longitude);
	}

	@GetMapping("/alerts/{state}")
	public String alerts(@PathVariable String state) {
		return weatherService.getAlerts(state);
	}

}
