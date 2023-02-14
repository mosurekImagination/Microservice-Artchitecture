package net.mosur.ordering.restaurant.service.domain.valueobject;

import net.mosur.ordering.domain.valueobject.BaseId;

import java.util.UUID;

public class OrderApprovalId extends BaseId<UUID> {
    public OrderApprovalId(UUID value) {
        super(value);
    }
}
