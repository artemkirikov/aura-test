package org.example.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ApiClient {

    @Value("${base.uri}")
    private String baseUri;

    @PostConstruct
    public void init() {
        RestAssured.baseURI = baseUri;
    }

    public Response get(String path) {
        return RestAssured.given()
                .headers(ApiHeadersProvider.defaultHeaders())
                .when()
                .get(path)
                .then()
                .extract().response();
    }

    public Response post(String path, Object body) {
        return RestAssured.given()
                .contentType("application/json")
                .headers(ApiHeadersProvider.defaultHeaders())
                .body(body)
                .when()
                .post(path)
                .then()
                .extract().response();
    }

    public Response put(String path, Object body) {
        return RestAssured.given()
                .contentType("application/json")
                .body(body)
                .when()
                .put(path)
                .then()
                .extract().response();
    }

    public Response delete(String path) {
        return RestAssured.given()
                .when()
                .delete(path)
                .then()
                .extract().response();
    }

    public Response getWithHeaders(String path, Map<String, String> headers) {
        return RestAssured.given()
                .headers(headers)
                .when()
                .get(path)
                .then()
                .extract().response();
    }
} 