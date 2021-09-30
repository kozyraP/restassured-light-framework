package org.example.get;

import org.example.mapping.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.example.endpoints.Endpoint.CATEGORIES;


class CategoriesTests extends BaseTestClass {

    private static List<Category> categories;


    @BeforeAll
    public static void setUp2() {
        categories = given()
                .when()
                .get(CATEGORIES)
                .then()
                .statusCode(200)
                .extract()
                .body().jsonPath().getList("categories", Category.class);
    }


    @Test()
    void categorySizeIs13Test() {
        Assertions.assertEquals(13, categories.size());
    }


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
            "Zdrowie,    121882",
            "FakeCategory,        Not exist"
    })
    void eachCategoryHasCorrectIdTest(String categoryName, String expectedId) {
        Assertions.assertEquals(
                categories.stream()
                        .filter(name -> name.getName().equals(categoryName))
                        .findFirst()
                        .map(Category::getId)
                        .orElse("Not exist"),
                expectedId
        );
    }

}
