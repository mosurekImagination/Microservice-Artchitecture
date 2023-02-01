package net.mosur.ordering.service.domain.ports.output.repository;

import net.mosur.ordering.order.service.domain.entity.Order;
import net.mosur.ordering.order.service.domain.entity.Restaurant;
import net.mosur.ordering.order.service.domain.valueobject.TrackingId;

import java.util.Optional;

public interface RestaurantRepository {

    Optional<Restaurant> findRestaurantInformation(Restaurant restaurant);

}
