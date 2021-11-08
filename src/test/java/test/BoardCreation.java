package test;

import models.Board;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreation extends TestBase {


    @Test
    public void testBoardCreation() throws InterruptedException {
       // Board board = new Board().withTitle("test");
       //int bordCountBeforeCreation = app.getBoard().getBordCount();

        app.getBoard().initBoardCreationfromHeader();
        app.getBoard().fillBoardCreationForm("test");
        Thread.sleep(15000);
        app.getBoard().isSubmitionConfirmed();
        app.getBoard().submitBoardCreation();
        app.getBoard().isCreated();
        //Thread.sleep(15000);

        //app.getBoard().returnToHomePage();
        //int bordCountAfterCreation = app.getBoard().getBordCount();

        //Assert.assertEquals(bordCountBeforeCreation, bordCountAfterCreation + 1);
Assert.assertTrue(app.getBoard().isCreated());
    }

}

