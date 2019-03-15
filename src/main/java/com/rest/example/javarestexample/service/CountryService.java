package com.rest.example.javarestexample.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.example.javarestexample.model.CountryModel;
import com.rest.example.javarestexample.repository.CountryRepository;

@Service
public class CountryService {

	@Autowired
	private CountryRepository countryRepository;
	
	@Transactional
	public CountryModel getCountryById(long countryId) {
		return countryRepository.selectCountryById(countryId);
	}
	
	@Transactional
	public void addCountry(CountryModel country) {
		countryRepository.insertCountry(country);
	}
	
	@Transactional
	public void updateCountry(CountryModel country) {
		countryRepository.updateCountry(country); 
	}
	
	@Transactional
	public List<CountryModel> getAllCountries(){
		return countryRepository.getAllCountries();
	}
	
	@Transactional
	public void removeCountry(long countryId) {
		countryRepository.deleteCountry(countryId);
	}
	
}
