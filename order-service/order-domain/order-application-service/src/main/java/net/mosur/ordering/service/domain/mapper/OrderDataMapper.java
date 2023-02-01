package net.mosur.ordering.service.domain.mapper;

import net.mosur.ordering.order.service.domain.entity.Order;
import net.mosur.ordering.order.service.domain.entity.OrderItem;
import net.mosur.ordering.order.service.domain.entity.Product;
import net.mosur.ordering.order.service.domain.entity.Restaurant;
import net.mosur.ordering.order.service.domain.valueobject.*;
import net.mosur.ordering.service.domain.dto.create.CreateOrderCommand;
import net.mosur.ordering.service.domain.dto.create.CreateOrderResponse;
import net.mosur.ordering.service.domain.dto.create.OrderAddress;
import net.mosur.ordering.service.domain.dto.track.TrackOrderResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class OrderDataMapper {

    public Restaurant createOrderCommandToRestaurant(CreateOrderCommand createOrderCommand){
        Restaurant restaurant = Restaurant.Builder.builder()
                .restaurantId(new RestaurantId(createOrderCommand.getRestaurantId()))
                .products(createOrderCommand.getItems().stream().map(orderItem ->
                        new Product(new ProductId(orderItem.getProductId()))
                        ).collect(Collectors.toList()))
                .build();
        return restaurant;
    }

    public Order createOrderCommandToOrder(CreateOrderCommand createOrderCommand){
        Order order = Order.Builder.builder()
                .customerId(new CustomerId(createOrderCommand.getCustomerId()))
                .restaurantId(new RestaurantId(createOrderCommand.getRestaurantId()))
                .deliveryAddress(orderAddressToStreetAddress(createOrderCommand.getAddress()))
                .price(new Money(createOrderCommand.getPrice()))
                .items(orderItemsToOrderItemsEntities(createOrderCommand.getItems()))
                .build();
        return order;
    }

    private List<OrderItem> orderItemsToOrderItemsEntities(List<net.mosur.ordering.service.domain.dto.create.OrderItem> items) {
        return items.stream().map(orderItem ->
                OrderItem.Builder.builder()
                        .product(new Product(new ProductId(orderItem.getProductId())))
                        .price(new Money(orderItem.getPrice()))
                        .quantity(orderItem.getQuantity())
                        .subTotal(new Money(orderItem.getSubTotal()))
                        .build()).collect(Collectors.toList());
    }

    private StreetAddress orderAddressToStreetAddress(OrderAddress address) {
        return new StreetAddress(
                UUID.randomUUID(),
                address.getStreet(),
                address.getPostalCode(),
                address.getCity()
        );
    }

    public CreateOrderResponse orderToCreateOrderResponse(Order order, String message) {
        return CreateOrderResponse.builder()
                .trackingOrderId(order.getTrackingId().getValue())
                .orderStatus(order.getOrderStatus())
                .message(message)
                .build();
    }

    public TrackOrderResponse orderToTrackingOrderResponse(Order order){
        return TrackOrderResponse.builder()
                .orderTrackingId(order.getTrackingId().getValue())
                .orderStatus(order.getOrderStatus())
                .failureMessages(order.getFailureMessages())
                .build();
    }
}
