package net.mosur.food.ordering.system.customer.service.domain;

import net.mosur.food.ordering.system.customer.service.domain.entity.Customer;
import net.mosur.food.ordering.system.customer.service.domain.event.CustomerCreatedEvent;

public interface CustomerDomainService {

    CustomerCreatedEvent validateAndInitiateCustomer(Customer customer);

}
