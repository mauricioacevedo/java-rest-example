package com.rest.example.javarestexample.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.rest.example.javarestexample.model.CountryModel;

@Repository
public class CountryRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	public CountryModel selectCountryById(long userId) {
		return entityManager.find(CountryModel.class, userId);
	}
	
	public void insertCountry(CountryModel country) {
		entityManager.persist(country);
	}
	
	public void deleteCountry(long countryId) {
		entityManager.remove(selectCountryById(countryId));
	}
	
	public void updateCountry(CountryModel country) {
		CountryModel countryToUpdate = selectCountryById(country.getId());
		
		countryToUpdate.setName(country.getName());
		countryToUpdate.setPopulation(country.getPopulation());
		
		entityManager.flush();
	}
	
	public List<CountryModel> getAllCountries(){
		Query query = entityManager.createQuery("from CountryModel");
		return (List<CountryModel>) query.getResultList();
	}
}
