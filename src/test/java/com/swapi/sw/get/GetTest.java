package com.swapi.sw.get;

import com.swapi.base.BaseTest;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetTest extends BaseTest {

    @DisplayName("Get all info about Star Wars")
    @ParameterizedTest(name = "Display {0}, count: {1}")
    @MethodSource("createData")
    public void readAllStarWarsInfo(String endpoint, String count) {

        Response response = given()
                .when()
                .get(BASE_URL + "/" + endpoint)
                .then()
                .statusCode(200)
                .extract()
                .response();

        JsonPath json = response.jsonPath();
        assertEquals(count,json.getString("count"));
    }

    private static Stream<Arguments> createData() {
        return Stream.of(
                Arguments.of(PEOPLE, "87"),
                Arguments.of(PLANETS, "61"),
                Arguments.of(FILMS, "7"),
                Arguments.of(SPECIES, "37"),
                Arguments.of(VEHICLES, "39"),
                Arguments.of(STARSHIPS, "36"));
    }
}
