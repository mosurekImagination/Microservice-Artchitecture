package net.mosur.ordering.payment.service.domain.ports.output.repository;

import net.mosur.ordering.domain.valueobject.CustomerId;
import net.mosur.ordering.payment.service.domain.entity.CreditHistory;

import java.util.List;
import java.util.Optional;

public interface CreditHistoryRepository {

    CreditHistory save(CreditHistory creditHistory);

    Optional<List<CreditHistory>> findByCustomerId(CustomerId customerId);
}
