package com.geekseat.theta.controller;

import com.geekseat.theta.model.Shop;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.jdbc.Sql;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Sql(scripts = {"/sql/delete-data-sample.sql", "/sql/insert-data-sample.sql"})
public class ShopControllerTests {

    /* Test Controller with Rest Assured */

    @LocalServerPort
    private Integer serverPort;

    @BeforeEach
    public void setup() {
        baseURI = "http://localhost/theta";
        port = serverPort;
    }

    @Test
    public void testListShop() {
        when().get("/shop/list").then().statusCode(200)
                .assertThat()
                .body("slug", hasItems("slug-001"));
    }

    @Test
    public void testCreateShop() {
        Shop shop = new Shop();
        shop.setMap(new HashMap<>());
        shop.setTransitMap(new HashMap<>());
        shop.setSlug("Slug test");
        shop.setName("Shop test");
        shop.setAdditionalProductList(null);
        shop.setMainProduct(null);

        with().body(shop).contentType(ContentType.JSON)
                .when().post("/shop/")
                .then().statusCode(201);
    }
}
