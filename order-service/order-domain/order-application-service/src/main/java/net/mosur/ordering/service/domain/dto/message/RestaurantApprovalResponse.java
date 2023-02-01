package net.mosur.ordering.service.domain.dto.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import net.mosur.ordering.order.service.domain.valueobject.OrderApprovalStatus;

import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class RestaurantApprovalResponse {
    @NotNull
    private final String id;
    @NotNull
    private final String sagaId;
    @NotNull
    private final String orderId;
    @NotNull
    private final String restaurantId;
    @NotNull
    private final Instant createdAt;
    @NotNull
    private final OrderApprovalStatus orderApprovalStatus;
    private final List<String> failureMessages;
}

