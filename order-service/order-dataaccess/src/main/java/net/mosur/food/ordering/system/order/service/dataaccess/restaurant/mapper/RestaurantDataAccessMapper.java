package net.mosur.food.ordering.system.order.service.dataaccess.restaurant.mapper;

import net.mosur.food.ordering.system.dataaccess.restaurant.entity.RestaurantEntity;
import net.mosur.food.ordering.system.dataaccess.restaurant.exception.RestaurantDataAccessException;
import net.mosur.food.ordering.system.domain.valueobject.Money;
import net.mosur.food.ordering.system.domain.valueobject.ProductId;
import net.mosur.food.ordering.system.domain.valueobject.RestaurantId;
import net.mosur.food.ordering.system.order.service.domain.entity.Product;
import net.mosur.food.ordering.system.order.service.domain.entity.Restaurant;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class RestaurantDataAccessMapper {

    public List<UUID> restaurantToRestaurantProducts(Restaurant restaurant) {
        return restaurant.getProducts().stream()
                .map(product -> product.getId().getValue())
                .collect(Collectors.toList());
    }

    public Restaurant restaurantEntityToRestaurant(List<RestaurantEntity> restaurantEntities) {
        RestaurantEntity restaurantEntity =
                restaurantEntities.stream().findFirst().orElseThrow(() ->
                        new RestaurantDataAccessException("Restaurant could not be found!"));

        List<Product> restaurantProducts = restaurantEntities.stream().map(entity ->
                new Product(new ProductId(entity.getProductId()), entity.getProductName(),
                        new Money(entity.getProductPrice()))).toList();

        return Restaurant.builder()
                .restaurantId(new RestaurantId(restaurantEntity.getRestaurantId()))
                .products(restaurantProducts)
                .active(restaurantEntity.getRestaurantActive())
                .build();
    }
}
