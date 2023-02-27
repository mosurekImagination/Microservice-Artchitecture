package net.mosur.food.ordering.system.outbox;

public interface OutboxScheduler {
    void processOutboxMessage();
}
