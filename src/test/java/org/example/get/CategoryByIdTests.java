package org.example.get;

import org.example.endpoints.Endpoint;
import org.example.mapping.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static io.restassured.RestAssured.given;

class CategoryByIdTests extends BaseTestClass {

    @DisplayName("when GET category by correct id should return 200 and have correct category name")
    @ParameterizedTest
    @CsvFileSource(resources = "/category_with_id.csv", numLinesToSkip = 1)
    void getCategoryByCorrectIdTest(String categoryName, String expectedId) {
        Category category = given()
                .when()
                .get(Endpoint.CATEGORIES + expectedId)
                .then()
                .statusCode(200)
                .extract().as(Category.class);

        Assertions.assertEquals(category.getName(), categoryName);
    }

    @DisplayName("when GET category by wrong id should return 404")
    @ParameterizedTest
    @CsvFileSource(resources = "/wrong_id_examples.csv")
    void getCategoryByWrongIdTest(String wrongId) {
        given()
                .when()
                .get(Endpoint.CATEGORIES + "/" + wrongId)
                .then()
                .statusCode(404);
    }


}
