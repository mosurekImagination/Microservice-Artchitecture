package net.mosur.ordering.payment.service.domain.valueobject;

import net.mosur.ordering.domain.valueobject.BaseId;

import java.util.UUID;

public class CreditEntryId extends BaseId<UUID> {
    public CreditEntryId(UUID value) {
        super(value);
    }
}
