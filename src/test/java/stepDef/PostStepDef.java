package stepDef;

import books.pojo.Book;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class PostStepDef extends Common{



    @When("I send generic POST call")
    public void iSendGenericPOSTCall() {
        Book newBook = Book.randomBook();
        RequestSpecification request = RestAssured.given();
        response = request.body(newBook).put(path);
    }

    @And("I receive POST response")
    public void iReceivePOSTResponse() {
        book = response.then().extract().as(Book.class);
    }
}
