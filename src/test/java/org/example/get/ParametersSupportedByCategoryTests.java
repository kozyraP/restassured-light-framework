package org.example.get;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static io.restassured.RestAssured.given;
import static org.example.endpoints.Endpoint.CATEGORIES;
import static org.example.endpoints.Endpoint.PARAMETERS;
import static org.hamcrest.Matchers.*;


class ParametersSupportedByCategoryTests extends BaseTestClass {

    @DisplayName("when GET category by id should return correct params")
    @ParameterizedTest
    @CsvFileSource(resources = "/parameters_test_file.csv", numLinesToSkip = 1)
    void parametersSupportedByCategoryTest(String catId, String paramAmount, String cat1, String cat2, String cat3) {
        given().get(CATEGORIES + catId + PARAMETERS)
                .then()
                .statusCode(200)
                .body("parameters", hasSize(Integer.parseInt(paramAmount)))
                .body("parameters", hasItems(allOf(hasEntry("name", cat1)),
                        allOf(hasEntry("name", cat2)),
                        allOf(hasEntry("name", cat3))));
    }

    @DisplayName("when GET category params by wrong id should return 404")
    @ParameterizedTest
    @CsvFileSource(resources = "/wrong_id_examples.csv")
    void parametersSupportedByCategoryWrongIdTest(String catId) {
        given().get(CATEGORIES + catId + PARAMETERS)
                .then()
                .statusCode(404);
    }

}
