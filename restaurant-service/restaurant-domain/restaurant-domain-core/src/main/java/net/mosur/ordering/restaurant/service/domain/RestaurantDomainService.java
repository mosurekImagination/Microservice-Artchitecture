package net.mosur.ordering.restaurant.service.domain;

import net.mosur.ordering.restaurant.service.domain.entity.Restaurant;
import net.mosur.ordering.restaurant.service.domain.event.OrderApprovalEvent;

import java.util.List;

public interface RestaurantDomainService {

    OrderApprovalEvent validateOrder(Restaurant restaurant, List<String> failureMessages);
}
