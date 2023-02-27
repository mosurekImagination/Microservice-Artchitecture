package net.mosur.food.ordering.system.restaurant.service.domain.ports.input.message.listener;

import net.mosur.food.ordering.system.restaurant.service.domain.dto.RestaurantApprovalRequest;

public interface RestaurantApprovalRequestMessageListener {
    void approveOrder(RestaurantApprovalRequest restaurantApprovalRequest);
}
