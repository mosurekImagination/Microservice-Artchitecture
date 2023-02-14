package net.mosur.ordering.payment.service.domain.valueobject;

import net.mosur.ordering.domain.valueobject.BaseId;

import java.util.UUID;

public class PaymentId extends BaseId<UUID> {
    public PaymentId(UUID value) {
        super(value);
    }
}
