package com.epages;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor(onConstructor=@__(@Autowired))
public class KittenResource {

	private final Kitten kitten;

	private final FoodServiceClient foodService;
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public Kitten getKitten() {
		return kitten;
	}

	@RequestMapping(path="/feed", method=RequestMethod.POST)
	public Kitten feedKitten() {
		Optional<Food> someFood = foodService.fetchSomeFood();
		if(someFood.isPresent()) {
			kitten.eat(someFood.get());
		}
		return getKitten();
	}
}
