package net.mosur.ordering.order.service.domain;

import lombok.extern.slf4j.Slf4j;
import net.mosur.ordering.order.service.domain.dto.create.CreateOrderCommand;
import net.mosur.ordering.order.service.domain.dto.create.CreateOrderResponse;
import net.mosur.ordering.order.service.domain.mapper.OrderDataMapper;
import net.mosur.ordering.order.service.domain.ports.output.message.publisher.payment.OrderCreatedPaymentRequestMessagePublisher;
import net.mosur.ordering.order.service.domain.event.OrderCreatedEvent;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderCreateCommandHandler {

    private final OrderDataMapper orderDataMapper;
    private final OrderCreateCommandHelper orderCreateCommandHelper;
    private final OrderCreatedPaymentRequestMessagePublisher orderCreatedPaymentRequestMessagePublisher;

    public OrderCreateCommandHandler(OrderDataMapper orderDataMapper, OrderCreateCommandHelper orderCreateCommandHelper, OrderCreatedPaymentRequestMessagePublisher orderCreatedPaymentRequestMessagePublisher) {
        this.orderDataMapper = orderDataMapper;
        this.orderCreateCommandHelper = orderCreateCommandHelper;
        this.orderCreatedPaymentRequestMessagePublisher = orderCreatedPaymentRequestMessagePublisher;
    }

    public CreateOrderResponse createOrder(CreateOrderCommand createOrderCommand) {
        OrderCreatedEvent orderCreatedEvent = orderCreateCommandHelper.persistOrder(createOrderCommand);
        orderCreatedPaymentRequestMessagePublisher.publish(orderCreatedEvent);
        return orderDataMapper.orderToCreateOrderResponse(orderCreatedEvent.getOrder(), "Order created successfully");
    }

}