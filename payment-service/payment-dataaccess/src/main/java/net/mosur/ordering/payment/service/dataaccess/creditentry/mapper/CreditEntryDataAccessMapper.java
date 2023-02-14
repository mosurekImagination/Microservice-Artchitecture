package net.mosur.ordering.payment.service.dataaccess.creditentry.mapper;

import net.mosur.ordering.domain.valueobject.CustomerId;
import net.mosur.ordering.domain.valueobject.Money;
import net.mosur.ordering.payment.service.dataaccess.creditentry.entity.CreditEntryEntity;
import net.mosur.ordering.payment.service.domain.entity.CreditEntry;
import net.mosur.ordering.payment.service.domain.valueobject.CreditEntryId;
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
