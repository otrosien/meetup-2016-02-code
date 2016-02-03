package com.epages;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor(onConstructor=@__(@Autowired))
@Component
@Slf4j
public class FoodServiceClientImpl implements FoodServiceClient {

	private final RestTemplate restTemplate;

	@Override
	@HystrixCommand(fallbackMethod="fallback")
	public Optional<Food> fetchSomeFood() {
		return Optional.of(restTemplate.postForObject("http://food-service/", "", Food.class));
	}

	Optional<Food> fallback() {
		log.warn("No food there... What happened?");
		return Optional.empty();
	}
}
