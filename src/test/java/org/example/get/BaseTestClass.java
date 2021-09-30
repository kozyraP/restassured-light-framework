package org.example.get;

import org.example.config.RestAssuredConfig;
import org.junit.jupiter.api.BeforeAll;

public abstract class BaseTestClass {

    @BeforeAll
    public static void setUpAll() {
        RestAssuredConfig.setUp();
    }
}
