package org.example.endpoints;

public final class Endpoint {

    private Endpoint() {
        throw new IllegalStateException("Utility class");
    }

    public static final String API_URL = "https://api.allegro.pl.allegrosandbox.pl/";
    public static final String CATEGORIES = "sale/categories/";
    public static final String PARAMETERS = "/parameters";
    public static final String ALLEGRO_BASE = "https://allegro.pl.allegrosandbox.pl";

}
