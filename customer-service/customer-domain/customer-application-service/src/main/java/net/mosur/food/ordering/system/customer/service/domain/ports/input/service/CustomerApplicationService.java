package net.mosur.food.ordering.system.customer.service.domain.ports.input.service;

import net.mosur.food.ordering.system.customer.service.domain.create.CreateCustomerCommand;
import net.mosur.food.ordering.system.customer.service.domain.create.CreateCustomerResponse;

import javax.validation.Valid;

public interface CustomerApplicationService {

    CreateCustomerResponse createCustomer(@Valid CreateCustomerCommand createCustomerCommand);

}
