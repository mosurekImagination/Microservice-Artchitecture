package net.mosur.ordering.order.service.domain.ports.output.message.publisher.payment;

import net.mosur.ordering.order.service.domain.event.OrderPaidEvent;
import net.mosur.ordering.domain.event.publisher.DomainEventPublisher;

public interface OrderPaidPaymentRequestMessagePublisher extends DomainEventPublisher<OrderPaidEvent> {

}
