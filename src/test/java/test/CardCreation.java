package test;

import models.Card;
import org.testng.annotations.Test;

public class CardCreation extends TestBase{



    @Test
            public void cardCreation(){
        Card card = Card.builder().card("New Card").build();
        app.getBoard().ClickOnfirstBoard();
        app.getList().create("Test");
        app.getCard().initCreation();
        app.getCard().fillCreationForm(card);
        app.getCard().submitCreation();
    }


}
