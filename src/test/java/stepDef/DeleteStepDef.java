package stepDef;

import books.pojo.Books;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class DeleteStepDef extends Common{



    @Given("I send generic Delete call on the book")
    @When("I delete the Book")
    public void iSendGenericDeleteCallOnTheBook() {
        RequestSpecification request = RestAssured.given();
        response = request.get(path+"/"+book.getId());

    }


    @And("Book is deleted")
    public void bookIsDeleted() {
        books = response.then().extract().as(Books.class);
        Assert.assertFalse(books.hasTheBook(book));
    }

    @And("I receive Delete response")
    public void iReceiveDeleteResponse() {
        books = response.then().extract().as(Books.class);
    }
}
