package stepDef;

import books.pojo.Book;
import books.pojo.Books;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;

import static model.APIUser.testAPIUser;

public class Common {
    public Common() {
        RestAssured.baseURI = "http://77.102.250.113:17354/api";
//        RestAssured.basePath = "v1/books";
        RestAssured.authentication = RestAssured.basic(testAPIUser.getName(), testAPIUser.getPassword());

        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());

        RestAssured.requestSpecification = new RequestSpecBuilder().setContentType("application/json").build();
    }
    static final String path = "/v1/books";


     static Response response;
     static String jsonString;
     static Book book;
     static Book updatedBook;
     static Books books;



}
