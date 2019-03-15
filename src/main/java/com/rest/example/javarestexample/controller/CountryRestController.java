package com.rest.example.javarestexample.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rest.example.javarestexample.model.CountryModel;
import com.rest.example.javarestexample.service.CountryService;

@RestController
public class CountryRestController {

	@Autowired
	private CountryService countryService;
	
	@CrossOrigin(origins = "*")
	@GetMapping("/country/all")
	public List<CountryModel> getCountries() {
		return countryService.getAllCountries();
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/country/create")
	public void createCountry(@Valid @RequestBody CountryModel country) {
		countryService.addCountry(country);
	}
	
	@GetMapping("/country/check")
	public String check() {
		return "working!!!";
	}
}
