package net.mosur.food.ordering.system.payment.service.dataaccess.creditentry.mapper;

import net.mosur.food.ordering.system.domain.valueobject.CustomerId;
import net.mosur.food.ordering.system.domain.valueobject.Money;
import net.mosur.food.ordering.system.payment.service.dataaccess.creditentry.entity.CreditEntryEntity;
import net.mosur.food.ordering.system.payment.service.domain.entity.CreditEntry;
import net.mosur.food.ordering.system.payment.service.domain.valueobject.CreditEntryId;
import org.springframework.stereotype.Component;

@Component
public class CreditEntryDataAccessMapper {

    public CreditEntry creditEntryEntityToCreditEntry(CreditEntryEntity creditEntryEntity) {
        return CreditEntry.builder()
                .creditEntryId(new CreditEntryId(creditEntryEntity.getId()))
                .customerId(new CustomerId(creditEntryEntity.getCustomerId()))
                .totalCreditAmount(new Money(creditEntryEntity.getTotalCreditAmount()))
                .build();
    }

    public CreditEntryEntity creditEntryToCreditEntryEntity(CreditEntry creditEntry) {
        return CreditEntryEntity.builder()
                .id(creditEntry.getId().getValue())
                .customerId(creditEntry.getCustomerId().getValue())
                .totalCreditAmount(creditEntry.getTotalCreditAmount().getAmount())
                .build();
    }

}
