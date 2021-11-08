package test;

import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login extends TestBase {

    @BeforeMethod
    public void preConditions() {
        if (app.getUser().isLogged()) {
            app.getUser().logOut();
        }

    }

    @Test
    public void testLogin() throws InterruptedException {
        //User user = new User().withEmail("juliakliot.jk@gmail.com").withPassword("misha240613");
        app.getUser().initLogin();
        app.getUser().fillLoginForm("juliakliot.jk@gmail.com", "misha240613");
        Thread.sleep(15000);
        app.getUser().submitLogin();
        //Thread.sleep(15000);
        //app.getUser().isLoggedSuccess();
        Assert.assertTrue(app.getUser().isLogged());
        //Assert.assertTrue(app.getUser().returnToHomePage();
    }

    @Test(enabled = false)
    public void negativeLoginwithoutPassword() throws InterruptedException {
        app.getUser().initLogin();
        app.getUser().fillLoginForm("juliakliot.jk@gmail.com", "");
        app.getUser().submitLogin();
    }

    // @AfterMethod
    // public void postConditions() {
    //if (app.getUser().isLogged()) {
    //  app.getUser().logOut();
    //}
    //}
    @AfterMethod
    public void posrConditions(){
        app.getUser().clickOnLoginButton();
    }
}







