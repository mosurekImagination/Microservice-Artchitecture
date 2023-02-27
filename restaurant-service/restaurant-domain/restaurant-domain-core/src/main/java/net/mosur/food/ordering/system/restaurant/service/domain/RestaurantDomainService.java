package net.mosur.food.ordering.system.restaurant.service.domain;

import net.mosur.food.ordering.system.restaurant.service.domain.entity.Restaurant;
import net.mosur.food.ordering.system.restaurant.service.domain.event.OrderApprovalEvent;

import java.util.List;

public interface RestaurantDomainService {

    OrderApprovalEvent validateOrder(Restaurant restaurant, List<String> failureMessages);
}
