package com.epages;

import static com.epages.Kitten.Status.HUNGRY;
import static com.epages.Kitten.Status.SLEEPY;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Getter
public class Kitten {

	static enum Status {
		SLEEPY,
		HUNGRY
	}

	private Status status = HUNGRY;

	public void eat(Food food) {
		log.info("Eating {}", food.getMeatType());
		if(status == HUNGRY) {
			status = SLEEPY;
			log.info("Meow! Now I'm sleepy!");
		}
	}

	@Scheduled(fixedDelay= 10_000)
	public void sleep() {
		if(status == SLEEPY) {
			status = HUNGRY;
			log.info("Meow! Now I'm hungry!");
		}
	}

}
