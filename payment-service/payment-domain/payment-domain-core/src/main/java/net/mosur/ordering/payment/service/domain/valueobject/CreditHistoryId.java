package net.mosur.ordering.payment.service.domain.valueobject;

import net.mosur.ordering.domain.valueobject.BaseId;

import java.util.UUID;

public class CreditHistoryId extends BaseId<UUID> {
    public CreditHistoryId(UUID value) {
        super(value);
    }
}
