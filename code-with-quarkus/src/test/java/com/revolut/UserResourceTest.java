package com.revolut;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class UserResourceTest {

    @Test
    public void testGetUser() {
        given()
                .when().get("/api/v1/users/1")
                .then()
                .statusCode(200);
    }

}