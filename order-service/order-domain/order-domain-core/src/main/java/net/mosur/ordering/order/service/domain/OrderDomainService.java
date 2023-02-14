package net.mosur.ordering.order.service.domain;

import net.mosur.ordering.order.service.domain.entity.Order;
import net.mosur.ordering.order.service.domain.entity.Restaurant;
import net.mosur.ordering.order.service.domain.event.OrderPaidEvent;
import net.mosur.ordering.order.service.domain.event.OrderCancelledEvent;
import net.mosur.ordering.order.service.domain.event.OrderCreatedEvent;

import java.util.List;

public interface OrderDomainService {
    OrderCreatedEvent validateAndInitiateOrder(Order order, Restaurant restaurant);
    OrderPaidEvent payOrder(Order order);
    void approveOrder(Order order);
    OrderCancelledEvent cancelOrderPayment(Order order, List<String> failureMessages);
    void cancelOrder (Order order, List<String> failureMessages);
}
