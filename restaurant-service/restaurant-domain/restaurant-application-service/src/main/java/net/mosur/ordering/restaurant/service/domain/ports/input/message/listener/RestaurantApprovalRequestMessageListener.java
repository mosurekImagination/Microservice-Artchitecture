package net.mosur.ordering.restaurant.service.domain.ports.input.message.listener;

import net.mosur.ordering.restaurant.service.domain.dto.RestaurantApprovalRequest;

public interface RestaurantApprovalRequestMessageListener {
    void approveOrder(RestaurantApprovalRequest restaurantApprovalRequest);
}
