package com.cuisineratingsystem.controllers;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cuisineratingsystem.model.Cuisine;
import com.cuisineratingsystem.model.Restaurant;
import com.cuisineratingsystem.services.CuisineService;

@RestController
public class CuisineController {

	private CuisineService cuisineService;
	
	@Autowired
	public CuisineController(CuisineService cuisineService){
		this.cuisineService = cuisineService;
	}
	
	@RequestMapping(path="/updateCuisineRating", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public int UpdateCusuineRating(@RequestBody Cuisine cuisine, HttpServletRequest request)
	{
		
		return cuisineService.updateRatingForCuisine(cuisine.getCuisine_ID(), cuisine.getRating(), cuisine.getNo_of_raters());
		
	}
	
	@RequestMapping(path="/api/cuisines", method=RequestMethod.GET)
	public List<Cuisine> getAllCuisines(){
		
		return cuisineService.getAllCuisines();
	}
	
	@RequestMapping(path="/api/cuisines/{id}", method=RequestMethod.GET)
	public Cuisine getCuisineById(@PathVariable int id){
		
		return cuisineService.getCuisineById(id);
	}
	
	@RequestMapping(path="/api/cuisines/search", method=RequestMethod.GET)
	public List<Cuisine> searchCuisines(@RequestParam("searchToken") String searchToken){
		
		return cuisineService.searchCuisines(searchToken);
	}
	
	@RequestMapping(path="/api/cuisines/restaurants/{restid}", method=RequestMethod.GET)
	public List<Cuisine> getAllCuisineByRestId(@PathVariable("restid") int restid){
		
		return cuisineService.getAllCuisinesByRestId(restid);
	}
	
	
	
}