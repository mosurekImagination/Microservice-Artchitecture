package net.mosur.ordering.payment.service.domain;

import net.mosur.ordering.payment.service.domain.entity.CreditEntry;
import net.mosur.ordering.payment.service.domain.entity.CreditHistory;
import net.mosur.ordering.payment.service.domain.entity.Payment;
import net.mosur.ordering.payment.service.domain.event.PaymentEvent;

import java.util.List;

public interface PaymentDomainService {

    PaymentEvent validateAndInitiatePayment(Payment payment,
                                            CreditEntry creditEntry,
                                            List<CreditHistory> creditHistories,
                                            List<String> failureMessages);

    PaymentEvent validateAndCancelPayment(Payment payment,
                                          CreditEntry creditEntry,
                                          List<CreditHistory> creditHistories,
                                          List<String> failureMessages);
}
