package com.epages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodResource {

	private final Food food;
	
	@Autowired
	public FoodResource(Food food) {
		this.food = food;
	}
	
	@RequestMapping(method=RequestMethod.POST, path = "/")
	public Food consumeFood() throws OutOfFoodException {
		food.consume();
		return getFood();
	}

	@RequestMapping(method=RequestMethod.GET, path="/")
	private Food getFood() {
		return food;
	}
}
