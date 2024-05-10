package model.requestSpec;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

public interface generalReqSpec {
    public default void setup(){
        RestAssured.baseURI = "http://77.102.250.113:17354/api";
        RestAssured.basePath = "v1/books";
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());

        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200).build();
    }
}
