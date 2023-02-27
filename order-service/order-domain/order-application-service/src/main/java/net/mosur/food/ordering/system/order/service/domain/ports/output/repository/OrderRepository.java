package net.mosur.food.ordering.system.order.service.domain.ports.output.repository;

import net.mosur.food.ordering.system.domain.valueobject.OrderId;
import net.mosur.food.ordering.system.order.service.domain.entity.Order;
import net.mosur.food.ordering.system.order.service.domain.valueobject.TrackingId;

import java.util.Optional;

public interface OrderRepository {

    Order save(Order order);

    Optional<Order> findById(OrderId orderId);

    Optional<Order> findByTrackingId(TrackingId trackingId);
}
