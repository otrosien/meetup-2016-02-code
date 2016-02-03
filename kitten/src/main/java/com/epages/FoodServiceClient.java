package com.epages;

import java.util.Optional;

public interface FoodServiceClient {
	Optional<Food> fetchSomeFood();
}
