package net.mosur.ordering.order.service.domain.ports.output.repository;

import net.mosur.ordering.order.service.domain.entity.Order;
import net.mosur.ordering.order.service.domain.valueobject.TrackingId;

import java.util.Optional;

public interface OrderRepository {

    Order save(Order order);

    Optional<Order> findByTrackingId(TrackingId trackingId);
}
