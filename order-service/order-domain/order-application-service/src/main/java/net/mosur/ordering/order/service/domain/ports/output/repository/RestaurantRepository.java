package net.mosur.ordering.order.service.domain.ports.output.repository;

import net.mosur.ordering.order.service.domain.entity.Restaurant;

import java.util.Optional;

public interface RestaurantRepository {

    Optional<Restaurant> findRestaurantInformation(Restaurant restaurant);

}
