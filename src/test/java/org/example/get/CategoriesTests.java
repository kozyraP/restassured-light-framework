package org.example.get;

import org.example.mapping.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

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

    @DisplayName("when GET all categories should return 13 category objects")
    @Test()
    void categorySizeIs13Test() {
        Assertions.assertEquals(13, categories.size());
    }

    @DisplayName("when GET all categories each category have correct id")
    @ParameterizedTest
    @CsvFileSource(resources = "/category_with_id.csv", numLinesToSkip = 1)
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
