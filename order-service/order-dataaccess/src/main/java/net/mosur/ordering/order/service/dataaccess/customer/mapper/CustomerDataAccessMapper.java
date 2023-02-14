package net.mosur.ordering.order.service.dataaccess.customer.mapper;

import net.mosur.ordering.order.service.dataaccess.customer.entity.CustomerEntity;
import net.mosur.ordering.order.service.domain.entity.Customer;
import net.mosur.ordering.domain.valueobject.CustomerId;
import org.springframework.stereotype.Component;

@Component
public class CustomerDataAccessMapper {

    public Customer customerEntityToCustomer(CustomerEntity customerEntity) {
        return new Customer(new CustomerId(customerEntity.getId()));
    }

    public CustomerEntity customerToCustomerEntity(Customer customer) {
        return CustomerEntity.builder()
                .id(customer.getId().getValue())
                .username(customer.getUsername())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .build();
    }
}
