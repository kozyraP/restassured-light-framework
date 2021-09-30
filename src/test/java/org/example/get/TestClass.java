package org.example.get;

import org.example.RestAssuredConfig;
import org.junit.jupiter.api.BeforeAll;

public class TestClass {

    @BeforeAll
    public static void setUpAll() {
        RestAssuredConfig.setUp();
    }
}
