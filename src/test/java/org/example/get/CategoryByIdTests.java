package org.example.get;

import org.example.endpoints.Endpoint;
import org.example.mapping.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static io.restassured.RestAssured.given;

class CategoryByIdTests extends TestClass {

    @ParameterizedTest
    @CsvSource({
            "Dom i Ogród,    5",
            "Dziecko,    11763",
            "Elektronika,    42540aec-367a-4e5e-b411-17c09b08e41f",
            "Firma i usługi,    4bd97d96-f0ff-46cb-a52c-2992bd972bb1",
            "Kolekcje i sztuka,    a408e75a-cede-4587-8526-54e9be600d9f",
            "Kultura i rozrywka,    38d588fd-7e9c-4c42-a4ae-6831775eca45",
            "Moda,    ea5b98dd-4b6f-4bd0-8c80-22c2629132d0",
            "Motoryzacja,    3",
            "Nieruchomości,    20782",
            "Sport i turystyka,    3919",
            "Supermarket,    258832",
            "Uroda,    1429",
            "Zdrowie,    121882"
    })
    void getCategoryByCorrectIdTest(String categoryName, String expectedId) {
        Category category = given()
                .when()
                .get(Endpoint.CATEGORIES + "/" + expectedId)
                .then()
                .statusCode(200)
                .extract().as(Category.class);

        Assertions.assertEquals(category.getName(), categoryName);
    }

    @ParameterizedTest
    @CsvSource({"WrongID1", "WrongID2", "WrongID3",})
    void getCategoryByWrongIdTest(String wrongId) {
        given()
        .when()
            .get(Endpoint.CATEGORIES + "/" + wrongId)
        .then()
            .statusCode(404);
    }


}
