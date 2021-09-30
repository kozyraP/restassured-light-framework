package org.example.get;

import org.example.RestAssuredConfig;
import org.junit.jupiter.api.BeforeAll;

public abstract class BaseTestClass {

    @BeforeAll
    public static void setUpAll() {
        RestAssuredConfig.setUp();
    }
}
