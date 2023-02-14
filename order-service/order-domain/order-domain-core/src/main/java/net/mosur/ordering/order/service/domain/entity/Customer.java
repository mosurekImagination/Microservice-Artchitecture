package net.mosur.ordering.order.service.domain.entity;

import net.mosur.ordering.domain.entity.AggregateRoot;
import net.mosur.ordering.domain.valueobject.CustomerId;

public class Customer extends AggregateRoot<CustomerId> {

    private String username;
    private String firstName;
    private String lastName;

    public Customer(CustomerId customerId, String username, String firstName, String lastName) {
        super.setId(customerId);
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Customer(CustomerId customerId) {
        super.setId(customerId);
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
