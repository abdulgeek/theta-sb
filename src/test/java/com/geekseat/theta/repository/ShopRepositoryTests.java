package com.geekseat.theta.repository;

import com.geekseat.theta.model.Shop;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.HashMap;

@SpringBootTest
@Sql(scripts = {"/sql/delete-data-sample.sql", "/sql/insert-data-sample.sql"})
public class ShopRepositoryTests {
    @Autowired
    private ShopRepository shopRepository;

    @Test
    public void testGetPerson() {
        Iterable<Shop> all = shopRepository.findAll();
        Assertions.assertNotNull(all);
    }

    @Test
    public void testSaveShop() {
        Shop shop = new Shop();
        shop.setMap(new HashMap<>());
        shop.setTransitMap(new HashMap<>());
        shop.setSlug("Slug test repository");
        shop.setName("Shop test repository");
        shop.setAdditionalProductList(null);
        shop.setMainProduct(null);
        Shop save = shopRepository.save(shop);
        Assertions.assertNotNull(save);
    }
}
