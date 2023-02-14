package net.mosur.ordering.payment.service.dataaccess.payment.mapper;

import net.mosur.ordering.domain.valueobject.CustomerId;
import net.mosur.ordering.domain.valueobject.Money;
import net.mosur.ordering.domain.valueobject.OrderId;
import net.mosur.ordering.payment.service.dataaccess.payment.entity.PaymentEntity;
import net.mosur.ordering.payment.service.domain.entity.Payment;
import net.mosur.ordering.payment.service.domain.valueobject.PaymentId;
import org.springframework.stereotype.Component;

@Component
public class PaymentDataAccessMapper {

    public PaymentEntity paymentToPaymentEntity(Payment payment) {
        return PaymentEntity.builder()
                .id(payment.getId().getValue())
                .customerId(payment.getCustomerId().getValue())
                .orderId(payment.getOrderId().getValue())
                .price(payment.getPrice().getAmount())
                .status(payment.getPaymentStatus())
                .createdAt(payment.getCreatedAt())
                .build();
    }

    public Payment paymentEntityToPayment(PaymentEntity paymentEntity) {
        return Payment.builder()
                .paymentId(new PaymentId(paymentEntity.getId()))
                .customerId(new CustomerId(paymentEntity.getCustomerId()))
                .orderId(new OrderId(paymentEntity.getOrderId()))
                .price(new Money(paymentEntity.getPrice()))
                .createdAt(paymentEntity.getCreatedAt())
                .build();
    }

}
