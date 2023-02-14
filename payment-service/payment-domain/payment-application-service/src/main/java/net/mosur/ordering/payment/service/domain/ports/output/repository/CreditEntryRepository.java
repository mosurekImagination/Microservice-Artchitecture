package net.mosur.ordering.payment.service.domain.ports.output.repository;

import net.mosur.ordering.domain.valueobject.CustomerId;
import net.mosur.ordering.payment.service.domain.entity.CreditEntry;

import java.util.Optional;

public interface CreditEntryRepository {

    CreditEntry save(CreditEntry creditEntry);

    Optional<CreditEntry> findByCustomerId(CustomerId customerId);
}
