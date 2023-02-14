package net.mosur.ordering.restaurant.service.domain.ports.output.repository;

import net.mosur.ordering.restaurant.service.domain.entity.OrderApproval;

public interface OrderApprovalRepository {
    OrderApproval save(OrderApproval orderApproval);
}
