package net.mosur.ordering.domain.event.publisher;

import net.mosur.ordering.domain.event.DomainEvent;

public interface DomainEventPublisher<T extends DomainEvent> {

    void publish(T domainEvent);
}
