package net.mosur.ordering.service.domain.ports.input.message.listener.payment;

import net.mosur.ordering.service.domain.dto.message.PaymentResponse;

public interface PaymentResponseMessageListener {

    void paymentCompleted(PaymentResponse paymentResponse);

    void paymentCancelled(PaymentResponse paymentResponse);
}
