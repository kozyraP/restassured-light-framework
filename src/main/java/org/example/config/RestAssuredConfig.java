package org.example.config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import org.aeonbits.owner.ConfigFactory;

import static io.restassured.RestAssured.given;
import static org.example.endpoints.Endpoint.ALLEGRO_BASE;
import static org.example.endpoints.Endpoint.API_URL;

public class RestAssuredConfig {

    private static RequestSpecification requestSpecification;

    private RestAssuredConfig() {
        throw new IllegalStateException("Utility class");
    }

    public static void setUp() {
        if (requestSpecification != null) return;

        CredentialConfiguration credentials = ConfigFactory.create(CredentialConfiguration.class);

        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(API_URL)
                .addHeader("Authorization", "Bearer " + getAccessToken(credentials.clientId(),
                        credentials.clientSecret()))
                .addHeader("Accept", "application/vnd.allegro.public.v1+json")
                .addHeader("Content-Type", "application/vnd.allegro.public.v1+json")
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
        RestAssured.requestSpecification = requestSpecification;
    }

    private static String getAccessToken(String clientId, String clientSecretId) {
        return given()
                .baseUri(ALLEGRO_BASE)
                .auth()
                .preemptive()
                .basic(clientId, clientSecretId)
                .log()
                .ifValidationFails()
                .formParam("grant_type", "client_credentials")
                .post("/auth/oauth/token")
                .then()
                .statusCode(200)
                .extract()
                .response()
                .jsonPath()
                .getString("access_token");
    }
}
