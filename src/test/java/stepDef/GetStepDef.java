package stepDef;

import books.pojo.Book;
import books.pojo.Books;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class GetStepDef extends Common{

    @Given("I send generic GET call")
    public void sendGETCall() {

        RequestSpecification request = RestAssured.given();
        response = request.get("/BookStore/v1/Books");

        jsonString = response.asString();

    }

    @Then("I receive GET response")
    public void receiveGETResponse() {
        ResponseBody respBody = response.getBody().prettyPeek();
        int statusCode = response.getStatusCode();
        Assert.assertTrue(statusCode==200);
        books = response.then().extract().as(Books.class);
    }
    @Then("I GET a list of existing books")
    public void getListOfExistingBooks() {
        sendGETCall();
        receiveGETResponse();
    }

    @When("I send generic GET by Id call Existing")
    public void iSendGenericGETByIdCallExisting() {
        RequestSpecification request = RestAssured.given();
        response = request.get(path+"/"+book.getId());
        book = response.then().extract().as(Book.class);
    }

    @And("I verify the book update")
    public void iVerifyTheBookUpdate() {
        Book updatedBook = book;
        iSendGenericGETByIdCallExisting();
        Assert.assertEquals(updatedBook, book);
    }

    @And("I verify the book was removed")
    public void iVerifyTheBookWasRemoved() {
        Book deletedBook = book;
        iSendGenericGETByIdCallExisting();
        Assert.assertTrue(book.isEmpty());//cannot findById
    }

    @And("I verify book created")
    @And("I verify the book exist")
    public void iVerifyTheBookExist() {
        Book book2find = book;
        iSendGenericGETByIdCallExisting();
        Assert.assertEquals(book2find, book);
        receiveGETResponse();
        Assert.assertTrue(books.hasTheBook(book2find));
    }

    @And("I GET that book")
    public void iGETThatBook() {
        Book book2find = book;
        Assert.assertTrue(books.hasTheBook(book2find));
    }

    @When("I send generic GET by Id call not Existing")
    public void iSendGenericGETByIdCallNotExisting() {
        RequestSpecification request = RestAssured.given();
        response = request.get(path+"/"+(books.getBookWithMaxId().getId()+1));
    }

    @And("I can find the Book by Id")
    public void iCanFindTheBookById() {
        Book book2find = book;
        iSendGenericGETByIdCallExisting();
        Assert.assertEquals(book2find, book);
    }
}
