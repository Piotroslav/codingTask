package stepDef;

import books.pojo.Book;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class CommonStepDef extends Common{


    @Then("operation is successful")
    public void statusCodePositive() {
        ResponseBody respBody = response.getBody().prettyPeek();
        int statusCode = response.getStatusCode();
        Assert.assertTrue(statusCode==200 || statusCode==201 || statusCode==202 );
    }

    @And("I create a new Book")
    public void iCreateANewBook() {
        Book newBook = Book.randomBook();
        RequestSpecification request = RestAssured.given();
        response = request.body(book).post(path);
    }
}
