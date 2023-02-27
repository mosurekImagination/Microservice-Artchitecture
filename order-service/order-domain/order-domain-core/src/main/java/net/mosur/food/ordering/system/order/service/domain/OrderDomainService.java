package net.mosur.food.ordering.system.order.service.domain;

import net.mosur.food.ordering.system.order.service.domain.entity.Order;
import net.mosur.food.ordering.system.order.service.domain.entity.Restaurant;
import net.mosur.food.ordering.system.order.service.domain.event.OrderCancelledEvent;
import net.mosur.food.ordering.system.order.service.domain.event.OrderCreatedEvent;
import net.mosur.food.ordering.system.order.service.domain.event.OrderPaidEvent;

import java.util.List;

public interface OrderDomainService {

    OrderCreatedEvent validateAndInitiateOrder(Order order, Restaurant restaurant);

    OrderPaidEvent payOrder(Order order);

    void approveOrder(Order order);

    OrderCancelledEvent cancelOrderPayment(Order order, List<String> failureMessages);

    void cancelOrder(Order order, List<String> failureMessages);
}
