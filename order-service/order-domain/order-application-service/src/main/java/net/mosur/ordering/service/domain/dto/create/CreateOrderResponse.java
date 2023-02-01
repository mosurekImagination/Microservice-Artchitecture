package net.mosur.ordering.service.domain.dto.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import net.mosur.ordering.order.service.domain.valueobject.OrderStatus;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;
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

