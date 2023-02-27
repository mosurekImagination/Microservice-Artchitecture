package net.mosur.food.ordering.system.order.service.domain;

import net.mosur.food.ordering.system.order.service.domain.dto.message.CustomerModel;
import net.mosur.food.ordering.system.order.service.domain.entity.Customer;
import net.mosur.food.ordering.system.order.service.domain.exception.OrderDomainException;
import net.mosur.food.ordering.system.order.service.domain.mapper.OrderDataMapper;
import net.mosur.food.ordering.system.order.service.domain.ports.input.message.listener.customer.CustomerMessageListener;
import net.mosur.food.ordering.system.order.service.domain.ports.output.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomerMessageListenerImpl implements CustomerMessageListener {

    private final CustomerRepository customerRepository;
    private final OrderDataMapper orderDataMapper;

    public CustomerMessageListenerImpl(CustomerRepository customerRepository, OrderDataMapper orderDataMapper) {
        this.customerRepository = customerRepository;
        this.orderDataMapper = orderDataMapper;
    }

    @Override
    public void customerCreated(CustomerModel customerModel) {
        Customer customer = customerRepository.save(orderDataMapper.customerModelToCustomer(customerModel));
        if (customer == null) {
            log.error("Customer could not be created in order database with id: {}", customerModel.getId());
            throw new OrderDomainException("Customer could not be created in order database with id " +
                    customerModel.getId());
        }
        log.info("Customer is created in order database with id: {}", customer.getId());
    }
}
