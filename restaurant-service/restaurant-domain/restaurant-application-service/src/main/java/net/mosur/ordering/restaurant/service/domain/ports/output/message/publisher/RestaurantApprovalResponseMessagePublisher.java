package net.mosur.ordering.restaurant.service.domain.ports.output.message.publisher;

import net.mosur.ordering.outbox.OutboxStatus;
import net.mosur.ordering.restaurant.service.domain.outbox.model.OrderOutboxMessage;

import java.util.function.BiConsumer;

public interface RestaurantApprovalResponseMessagePublisher {

    void publish(OrderOutboxMessage orderOutboxMessage,
                 BiConsumer<OrderOutboxMessage, OutboxStatus> outboxCallback);
}
