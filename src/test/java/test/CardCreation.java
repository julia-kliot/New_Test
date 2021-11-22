package test;

import models.Card;
import org.testng.annotations.Test;

public class CardCreation extends TestBase{



    @Test
            public void cardCreation(){
        Card card = Card.builder().cardName("New Card").color("green").build();
        app.getBoard().ClickOnfirstBoard();
        if(app.getList().getCount()==0) {
            app.getList().create("Test");
        }
        app.getCard().initCreation();
        app.getCard().fillCreationForm(card);
        app.getCard().submitCreation();
    }
    @Test(enabled = false)
    public void cardCreationWithoutColor(){
        Card card = Card.builder().cardName("New Card").build();
        app.getBoard().ClickOnfirstBoard();
        app.getList().create("Test");
        app.getCard().initCreation();
        app.getCard().fillCreationForm(card);
        app.getCard().submitCreation();
    }


}
