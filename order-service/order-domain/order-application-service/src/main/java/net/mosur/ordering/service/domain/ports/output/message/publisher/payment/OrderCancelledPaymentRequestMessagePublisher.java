package net.mosur.ordering.service.domain.ports.output.message.publisher.payment;

import net.mosur.ordering.order.service.domain.event.OrderCancelledEvent;
import net.mosur.ordering.order.service.domain.event.OrderCreatedEvent;
import net.mosur.ordering.order.service.domain.event.publisher.DomainEventPublisher;

public interface OrderCancelledPaymentRequestMessagePublisher extends DomainEventPublisher<OrderCancelledEvent> {

    
}
