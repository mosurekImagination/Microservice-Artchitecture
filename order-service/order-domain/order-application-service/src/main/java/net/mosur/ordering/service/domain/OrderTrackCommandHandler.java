package net.mosur.ordering.service.domain;

import lombok.extern.slf4j.Slf4j;
import net.mosur.ordering.service.domain.mapper.OrderDataMapper;
import net.mosur.ordering.order.service.domain.entity.Order;
import net.mosur.ordering.order.service.domain.exception.OrderNotFoundException;
import net.mosur.ordering.order.service.domain.valueobject.TrackingId;
import net.mosur.ordering.service.domain.ports.output.repository.OrderRepository;
import net.mosur.ordering.service.domain.dto.track.TrackOrderQuery;
import net.mosur.ordering.service.domain.dto.track.TrackOrderResponse;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Component
public class OrderTrackCommandHandler {

    private final OrderRepository orderRepository;
    private final OrderDataMapper orderDataMapper;

    public OrderTrackCommandHandler(OrderRepository orderRepository, OrderDataMapper orderDataMapper) {
        this.orderRepository = orderRepository;
        this.orderDataMapper = orderDataMapper;
    }

    @Transactional(readOnly = true)
    public TrackOrderResponse trackOrder(TrackOrderQuery trackOrderQuery){
        Optional<Order> order = orderRepository.findByTrackingId(new TrackingId(trackOrderQuery.getOrderTrackingId()));
        if(order.isEmpty()){
            String message = String.format("Order with id %s cannot be found", trackOrderQuery.getOrderTrackingId());
            throw new OrderNotFoundException(message);
        }
        return orderDataMapper.orderToTrackingOrderResponse(order.get());
    }
}
