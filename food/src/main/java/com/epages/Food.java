package com.epages;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Food implements HealthIndicator {

	private final AtomicLong stock = new AtomicLong(10);

	private final String type = new String[]{"tasty","crispy","juicy","delicious"}[ThreadLocalRandom.current().nextInt(0, 4)];

	private final String meat = new String[]{"beef","chicken","fish","tofu"}[ThreadLocalRandom.current().nextInt(0, 4)];

	public void consume() throws OutOfFoodException {
		if (stock.get() <= 0) {
			log.warn("No more food!");
			throw new OutOfFoodException();
		}
		log.info("Take one down and pass it around...");
		stock.decrementAndGet();
	}

	@Override
	public Health health() {
		return stock.get() > 0 ? Health.up().build() : Health.down().build();
	}

	public long getRemainingStock() {
		return stock.get();
	}
	
	public String getMeatType() {
		return type + " " + meat;
	}
}
