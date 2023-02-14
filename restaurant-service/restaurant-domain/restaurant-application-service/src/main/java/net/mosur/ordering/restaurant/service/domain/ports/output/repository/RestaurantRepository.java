package net.mosur.ordering.restaurant.service.domain.ports.output.repository;

import net.mosur.ordering.restaurant.service.domain.entity.Restaurant;

import java.util.Optional;

public interface RestaurantRepository {
    Optional<Restaurant> findRestaurantInformation(Restaurant restaurant);
}
