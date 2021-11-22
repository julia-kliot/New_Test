package test;

import models.Board;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;

public class BoardCreation extends TestBase {


    @Test
    public void testBoardCreation() throws InterruptedException {
        // Board board = new Board().withTitle("test");
        Board board = Board.builder().title("test").build();
        //int bordCountBeforeCreation = app.getBoard().getBordCount();

        app.getBoard().initBoardCreationfromHeader();
        //app.getBoard().fillBoardCreationForm("test");
        app.getBoard().fillBoardCreationForm(board);

        app.getBoard().isSubmitionConfirmed();
        app.getBoard().submitBoardCreation();
        app.getBoard().isCreated();
        //Thread.sleep(15000);

        //app.getBoard().returnToHomePage();
        //int bordCountAfterCreation = app.getBoard().getBordCount();

        //Assert.assertEquals(bordCountBeforeCreation, bordCountAfterCreation + 1);
        Assert.assertTrue(app.getBoard().isCreated());
    }

    @Test(enabled = false)
    public void testBoardCreation2() throws InterruptedException {
        Board board = Board.builder().title("test 2").build();

        int bordCountBeforeCreation = app.getBoard().getBordCount();
        System.out.println(bordCountBeforeCreation);
        app.getBoard().initBoardCreationfromHeader();
        //app.getBoard().fillBoardCreationForm("test");
        app.getBoard().fillBoardCreationForm(board);

        app.getBoard().isSubmitionConfirmed();
        app.getBoard().submitBoardCreation();
        app.getBoard().isCreated();
        app.getBoard().returnToHomePage();
        int bordCountAfterCreation = app.getBoard().getBordCount();
        System.out.println(bordCountAfterCreation);

        Assert.assertEquals(bordCountAfterCreation, bordCountBeforeCreation + 1);
        //Assert.assertTrue(app.getBoard().isCreated());
    }

    @Test
    public void testBoardCreation3() throws InterruptedException {
        Board board = Board.builder().title("test 2").build();
        app.getBoard().initBoardCreationfromHeader();
        app.getBoard().fillBoardCreationForm(board);
       app.getBoard().newCreation();
       Thread.sleep(5000);
        app.getBoard().submitBoardCreation();
        app.getBoard().isCreated();
        app.getBoard().returnToHomePage();
    }
}

