package api.client;

import config.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestClient {

    private static RequestSpecification baseRequest() {

        return RestAssured
                .given()
                .baseUri(ConfigReader.get("apiBaseUrl"))
                .header("Content-Type", "application/json")
                .accept("application/json")
                .log().all();
    }

    public static Response get(String endpoint) {
        return baseRequest().get(endpoint);
    }

    public static Response post(String endpoint, Object body) {
        return baseRequest().body(body).post(endpoint);
    }

    public static Response put(String endpoint, Object body, String token) {
        return baseRequest()
                .header("Cookie", "token=" + token)
                .body(body)
                .put(endpoint);
    }

    public static Response delete(String endpoint, String token) {
        return baseRequest()
                .header("Cookie", "token=" + token)
                .delete(endpoint);
    }

}