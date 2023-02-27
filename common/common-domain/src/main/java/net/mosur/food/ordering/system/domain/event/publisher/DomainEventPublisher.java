package net.mosur.food.ordering.system.domain.event.publisher;

import net.mosur.food.ordering.system.domain.event.DomainEvent;

public interface DomainEventPublisher<T extends DomainEvent> {

    void publish(T domainEvent);
}
