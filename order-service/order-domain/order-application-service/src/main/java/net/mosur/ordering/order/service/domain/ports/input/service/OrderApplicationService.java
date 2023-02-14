package net.mosur.ordering.order.service.domain.ports.input.service;

import net.mosur.ordering.order.service.domain.dto.create.CreateOrderCommand;
import net.mosur.ordering.order.service.domain.dto.track.TrackOrderQuery;
import net.mosur.ordering.order.service.domain.dto.track.TrackOrderResponse;
import net.mosur.ordering.order.service.domain.dto.create.CreateOrderResponse;

import javax.validation.Valid;

public interface OrderApplicationService {

    CreateOrderResponse createOrder(@Valid CreateOrderCommand createOrderCommand);

    TrackOrderResponse trackOrder(@Valid TrackOrderQuery trackOrderQuery);
}
