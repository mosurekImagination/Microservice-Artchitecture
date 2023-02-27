package net.mosur.food.ordering.system.restaurant.service.domain.ports.output.repository;

import net.mosur.food.ordering.system.restaurant.service.domain.entity.Restaurant;

import java.util.Optional;

public interface RestaurantRepository {
    Optional<Restaurant> findRestaurantInformation(Restaurant restaurant);
}
