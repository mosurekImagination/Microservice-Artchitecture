package net.mosur.food.ordering.system.payment.service.domain.ports.output.repository;

import net.mosur.food.ordering.system.domain.valueobject.CustomerId;
import net.mosur.food.ordering.system.payment.service.domain.entity.CreditHistory;

import java.util.List;
import java.util.Optional;

public interface CreditHistoryRepository {

    CreditHistory save(CreditHistory creditHistory);

    Optional<List<CreditHistory>> findByCustomerId(CustomerId customerId);
}
