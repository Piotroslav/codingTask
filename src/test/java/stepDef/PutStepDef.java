package stepDef;

import books.pojo.Book;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class PutStepDef extends Common{



    @Then("I receive PUT response")
    public void iReceivePUTResponse() {
//        RequestSpecification request = RestAssured.given();
//        response = request.body(book).put(path+"/"+(book.getId()));
        book = response.then().extract().as(Book.class);
    }

    @When("I send generic PUT call for last book")
    public void iSendGenericPUTCallForLastBook() {
        book = books.getLastBook();
        RequestSpecification request = RestAssured.given();
        response = request.body(book).put(path+"/"+(book.getId()));

    }

    @When("I send generic PUT call for nextId book")
    public void iSendGenericPUTCallForNextIdBook() {
        RequestSpecification request = RestAssured.given();
        response = request.body(book).put(path+"/"+(book.getId()+1));
    }

    @When("I send generic PUT call for existing book with existingId")
    public void iSendGenericPUTCallForExistingBookWithExistingId() {
        Book aBook = books.getBookWithMaxId();
        RequestSpecification request = RestAssured.given();
        response = request.body(aBook).put(path+"/"+(books.getBookWithMinId().getId()));
    }

    @When("I send generic PUT call for existing book with null as Id")
    public void iSendGenericPUTCallForExistingBookWithNullAsId() {
        Book aBook = books.getBookWithMaxId();
        aBook.setId(null);
        RequestSpecification request = RestAssured.given();
        response = request.body(aBook).put(path+"/"+(books.getBookWithMinId().getId()));
    }

    @When("I update the Book")
    public void iUpdateTheBook() {
        updatedBook = Book.randomBook();
        updatedBook.setId(book.getId());
        RequestSpecification request = RestAssured.given();
        response = request.body(updatedBook).put(path+"/"+(updatedBook.getId()));
    }

    @And("Book is updated")
    public void bookIsUpdated() {
        book = response.then().extract().as(Book.class);
        Assert.assertEquals(updatedBook, book);
    }
}
