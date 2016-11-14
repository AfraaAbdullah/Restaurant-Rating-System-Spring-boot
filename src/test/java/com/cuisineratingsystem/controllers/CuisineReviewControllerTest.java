package com.cuisineratingsystem.controllers;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.cuisineratingsystem.CuisineratingsystemApplication;
import com.cuisineratingsystem.model.Cuisine;
import com.cuisineratingsystem.model.CuisineReview;
import com.cuisineratingsystem.model.Restaurant;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CuisineratingsystemApplication.class)
public class CuisineReviewControllerTest {

	private MockMvc mockmvc;
	private CuisineReview cuisineReview;
	
	@Before
	public void setUp() throws Exception{
		Restaurant restaurant = new Restaurant(); 
		restaurant.setRestaurant_ID(1);
		restaurant.setRest_name("test name");
		restaurant.setLatitude(11);
		restaurant.setLongitude(11);
		restaurant.setCity("charlotte");
		restaurant.setZipcode(12345);
		
		Cuisine cuisine = new Cuisine();
		cuisine.setCuisine_ID(1); 
		cuisine.setCuisine_name("test cuisine name");
		cuisine.setNo_of_raters(1);
		cuisine.setRating(3);
		cuisine.setRestaurant(restaurant);
		
		cuisineReview = new CuisineReview();
		cuisineReview.setCuisine(cuisine);
		cuisineReview.setCuisine_comment_ID(1);
		cuisineReview.setCuisineCommentDesc("Test comment");
		
	}
	@Test
	public void testAddReview() {
		try {
			mockmvc.perform(post("/addCuisineReview",cuisineReview))
			.andExpect(status().isOk());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}