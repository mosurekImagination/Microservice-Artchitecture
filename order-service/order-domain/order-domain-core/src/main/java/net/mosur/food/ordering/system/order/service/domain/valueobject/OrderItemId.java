package net.mosur.food.ordering.system.order.service.domain.valueobject;

import net.mosur.food.ordering.system.domain.valueobject.BaseId;

public class OrderItemId extends BaseId<Long> {
    public OrderItemId(Long value) {
        super(value);
    }
}
