package org.example.get;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static io.restassured.RestAssured.given;
import static org.example.endpoints.Endpoint.CATEGORIES;
import static org.example.endpoints.Endpoint.PARAMETERS;
import static org.hamcrest.Matchers.*;


class ParametersSupportedByCategoryTests extends TestClass {

    @ParameterizedTest
    @CsvSource({
            "5,3,Stan,Waga produktu z opakowaniem jednostkowym, EAN",
            "11763,3,Stan,Waga produktu z opakowaniem jednostkowym, EAN",
            "42540aec-367a-4e5e-b411-17c09b08e41f,3,Stan,Waga produktu z opakowaniem jednostkowym, EAN"
    })
    void parametersSupportedByCategoryTest(String catId, String paramAmount, String cat1, String cat2, String cat3) {
        given().get(CATEGORIES + "/" + catId + PARAMETERS)
                .then()
                .statusCode(200)
                .body("parameters", hasSize(Integer.parseInt(paramAmount)))
                .body("parameters", hasItems(allOf(hasEntry("name", cat1)),
                        allOf(hasEntry("name", cat2)),
                        allOf(hasEntry("name", cat3))));
    }

    @ParameterizedTest
    @CsvSource({"WrongID1", "WrongID2", "WrongID3"})
    void parametersSupportedByCategoryWrongIdTest(String catId) {
        given().get(CATEGORIES + "/" + catId + PARAMETERS)
                .then()
                .statusCode(404);
    }

}
