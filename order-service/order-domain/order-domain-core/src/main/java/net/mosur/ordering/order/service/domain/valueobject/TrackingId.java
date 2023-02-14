package net.mosur.ordering.order.service.domain.valueobject;

import net.mosur.ordering.domain.valueobject.BaseId;

import java.util.UUID;

public class TrackingId extends BaseId<UUID> {

    public TrackingId(UUID value) {
        super(value);
    }
}
