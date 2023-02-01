package net.mosur.ordering.service.domain.dto.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import net.mosur.ordering.order.service.domain.valueobject.OrderStatus;
import net.mosur.ordering.order.service.domain.valueobject.PaymentStatus;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class PaymentResponse {
    @NotNull
    private final String id;
    @NotNull
    private final String sagaId;
    @NotNull
    private final String orderId;
    @NotNull
    private final String paymentId;
    @NotNull
    private final String customerId;

    @NotNull
    private final BigDecimal price;
    @NotNull
    private final Instant createdAt;
    @NotNull
    private final PaymentStatus paymentStatus;
    @NotNull
    private final List<String> failureMessages;
}

