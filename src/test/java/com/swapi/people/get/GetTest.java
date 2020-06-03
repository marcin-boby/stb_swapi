package com.swapi.people.get;

import com.swapi.base.BaseTest;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetTest extends BaseTest {

    @Test
    public void readAllPeople() {

        Response response = given()
                .when()
                .get(BASE_URL + "/" + PEOPLE)
                .then()
                .statusCode(200)
                .extract()
                .response();

        JsonPath json = response.jsonPath();
        assertEquals("87",json.getString("count"));
    }
}
