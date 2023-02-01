package net.mosur.ordering.order.service.domain.entity;

import net.mosur.ordering.order.service.domain.valueobject.CustomerId;

public class Customer extends AggregateRoot<CustomerId> {

    public Customer(CustomerId customerId) {
        super.setId(customerId);
    }
}
