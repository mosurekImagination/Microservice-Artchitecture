package net.mosur.ordering.payment.service.domain.ports.input.message.listener;

import net.mosur.ordering.payment.service.domain.dto.PaymentRequest;

public interface PaymentRequestMessageListener {

    void completePayment(PaymentRequest paymentRequest);

    void cancelPayment(PaymentRequest paymentRequest);
}
