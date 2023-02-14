package net.mosur.ordering.order.service.domain;

import lombok.extern.slf4j.Slf4j;
import net.mosur.ordering.order.service.domain.dto.create.CreateOrderCommand;
import net.mosur.ordering.order.service.domain.mapper.OrderDataMapper;
import net.mosur.ordering.order.service.domain.ports.output.repository.CustomerRepository;
import net.mosur.ordering.order.service.domain.ports.output.repository.OrderRepository;
import net.mosur.ordering.order.service.domain.ports.output.repository.RestaurantRepository;
import net.mosur.ordering.order.service.domain.entity.Customer;
import net.mosur.ordering.order.service.domain.entity.Order;
import net.mosur.ordering.order.service.domain.entity.Restaurant;
import net.mosur.ordering.order.service.domain.event.OrderCreatedEvent;
import net.mosur.ordering.order.service.domain.exception.OrderDomainException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class OrderCreateCommandHelper {

    private final OrderDataMapper orderDataMapper;

    private final OrderDomainService orderDomainService;
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final RestaurantRepository restaurantRepository;

    public OrderCreateCommandHelper(OrderDataMapper orderDataMapper, OrderDomainService orderDomainService, OrderRepository orderRepository, CustomerRepository customerRepository, RestaurantRepository restaurantRepository) {
        this.orderDataMapper = orderDataMapper;
        this.orderDomainService = orderDomainService;
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.restaurantRepository = restaurantRepository;
    }


    @Transactional
    // OrderCreateCommand Helper is extracted because Spring @Transactional annotation works only if it is called by another bean
    // inner methods called by bean itself doesn't work
    // spring creates proxy classes with transaction logic
    // also only public methods should be marked with @Transactional.
    public OrderCreatedEvent persistOrder(CreateOrderCommand createOrderCommand) {
        checkCustomer(createOrderCommand.getCustomerId());
        Restaurant restaurant = checkRestaurant(createOrderCommand);
        Order order = orderDataMapper.createOrderCommandToOrder(createOrderCommand);
        OrderCreatedEvent orderCreatedEvent = orderDomainService.validateAndInitiateOrder(order, restaurant);
        persistOrder(order);
        return orderCreatedEvent;
    }

    private Order persistOrder(Order order) {
        Order savedOrder = orderRepository.save(order);
        if (savedOrder == null) {
            String message = "Couldn't save order!";
            log.error(message);
            throw new OrderDomainException(message);
        }
        log.info("Order is saved with id {}", savedOrder.getId().getValue());
        return savedOrder;
    }

    private void checkCustomer(UUID customerId) {
        Optional<Customer> customer = customerRepository.findCustomer(customerId);
        if (customer.isEmpty()) {
            String errorMessage = String.format("Customer with id: %s doesn't exist!", customerId);
            log.warn(errorMessage);
            throw new OrderDomainException(errorMessage);
        }

    }

    private Restaurant checkRestaurant(CreateOrderCommand createOrderCommand) {
        Restaurant restaurant = orderDataMapper.createOrderCommandToRestaurant(createOrderCommand);
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findRestaurantInformation(restaurant);
        if (optionalRestaurant.isEmpty()) {
            String errorMessage = String.format("Restaurant with id: %s doesn't exist!", createOrderCommand.getRestaurantId());
            log.warn(errorMessage);
            throw new OrderDomainException(errorMessage);
        }
        return optionalRestaurant.get();
    }

}
