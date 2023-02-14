package net.mosur.ordering.payment.service.domain.ports.output.message.publisher;

import net.mosur.ordering.outbox.OutboxStatus;
import net.mosur.ordering.payment.service.domain.outbox.model.OrderOutboxMessage;

import java.util.function.BiConsumer;

public interface PaymentResponseMessagePublisher {
    void publish(OrderOutboxMessage orderOutboxMessage,
                 BiConsumer<OrderOutboxMessage, OutboxStatus> outboxCallback);
}
