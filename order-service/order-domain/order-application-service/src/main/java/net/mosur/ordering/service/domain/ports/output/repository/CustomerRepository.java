package net.mosur.ordering.service.domain.ports.output.repository;

import net.mosur.ordering.order.service.domain.entity.Customer;
import net.mosur.ordering.order.service.domain.entity.Order;
import net.mosur.ordering.order.service.domain.valueobject.TrackingId;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository {

 Optional<Customer> findCustomer(UUID customerId);
}
