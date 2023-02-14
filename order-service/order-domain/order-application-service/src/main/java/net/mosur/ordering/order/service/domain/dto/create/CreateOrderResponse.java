package net.mosur.ordering.order.service.domain.dto.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import net.mosur.ordering.domain.valueobject.OrderStatus;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateOrderResponse {
    @NotNull
    private final UUID trackingOrderId;
    @NotNull
    private final OrderStatus orderStatus;
    @NotNull
    private final String message;
}

