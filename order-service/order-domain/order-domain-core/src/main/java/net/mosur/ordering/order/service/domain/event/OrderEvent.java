package net.mosur.ordering.order.service.domain.event;

import net.mosur.ordering.order.service.domain.entity.Order;
import net.mosur.ordering.domain.event.DomainEvent;

import java.time.ZonedDateTime;

abstract class OrderEvent implements DomainEvent<Order> {

    private final Order order;
    private final ZonedDateTime createdAt;

    public OrderEvent(Order order, ZonedDateTime createdAt) {
        this.order = order;
        this.createdAt = createdAt;
    }

    public Order getOrder() {
        return order;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }
}
