package net.mosur.ordering.service.domain.ports.input.service;

import net.mosur.ordering.service.domain.dto.create.CreateOrderCommand;
import net.mosur.ordering.service.domain.dto.create.CreateOrderResponse;
import net.mosur.ordering.service.domain.dto.track.TrackOrderQuery;
import net.mosur.ordering.service.domain.dto.track.TrackOrderResponse;

import javax.validation.Valid;

public interface OrderApplicationService {

    CreateOrderResponse createOrder(@Valid CreateOrderCommand createOrderCommand);

    TrackOrderResponse trackOrder(@Valid TrackOrderQuery trackOrderQuery);
}
