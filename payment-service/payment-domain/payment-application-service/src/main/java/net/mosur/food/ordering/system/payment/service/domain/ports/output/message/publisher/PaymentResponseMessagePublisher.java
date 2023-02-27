package net.mosur.food.ordering.system.payment.service.domain.ports.output.message.publisher;

import net.mosur.food.ordering.system.outbox.OutboxStatus;
import net.mosur.food.ordering.system.payment.service.domain.outbox.model.OrderOutboxMessage;

import java.util.function.BiConsumer;

public interface PaymentResponseMessagePublisher {
    void publish(OrderOutboxMessage orderOutboxMessage,
                 BiConsumer<OrderOutboxMessage, OutboxStatus> outboxCallback);
}
