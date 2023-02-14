package net.mosur.ordering.order.service.domain.ports.output.repository;

import net.mosur.ordering.order.service.domain.entity.Customer;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository {

    Optional<Customer> findCustomer(UUID customerId);
}
