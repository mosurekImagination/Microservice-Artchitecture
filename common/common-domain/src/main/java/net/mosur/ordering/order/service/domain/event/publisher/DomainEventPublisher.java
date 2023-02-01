package net.mosur.ordering.order.service.domain.event.publisher;

import net.mosur.ordering.order.service.domain.event.DomainEvent;

public interface DomainEventPublisher<T extends DomainEvent> {

    void publish(T domainEvent);
}
