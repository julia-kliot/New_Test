package test;

import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login extends TestBase {

    @BeforeMethod(alwaysRun = true)
    public void preConditions() {
        if (app.getUser().isLogged()) {
            app.getUser().logOut();
        }

    }

    @Test(groups = {"lo"})
    public void testLogin() throws InterruptedException {
        //User user = new User().withEmail("juliakliot.jk@gmail.com").withPassword("misha240613");


        User user = User.builder().email("juliakliot.jk@gmail.com").password("misha240613").build();
        logger.info("Login Tests starts with:" + user.getEmail() + "   " + user.getPassword());
        app.getUser().initLogin();
       // app.getUser().fillLoginForm("juliakliot.jk@gmail.com", "misha240613");
        app.getUser().fillLoginForm(user);
        Thread.sleep(15000);
        app.getUser().submitLogin();
        //Thread.sleep(15000);
        app.getUser().isLoggedSuccess();
        Assert.assertTrue(app.getUser().isLoggedSuccess());
        //Assert.assertTrue(app.getUser().returnToHomePage();
    }

    @Test
    public void negativeLoginwithoutPassword() throws InterruptedException {
        app.getUser().initLogin();
        app.getUser().fillLoginForm("juliakliot.jk@gmail.com", "");
        app.getUser().submitLogin();

    }
    @Test
    public void negativeLoginwithoutEmail() throws InterruptedException {
        app.getUser().initLogin();
        app.getUser().fillLoginForm("", "");


    }
    @Test
    public void negativeLoginIncorrectEmail() throws InterruptedException {

        app.getUser().initLogin();
        app.getUser().fillLoginForm("juliakliot.jkgmail.com", "");


    }


    @AfterMethod(alwaysRun = true)
    public void postConditions(){
        app.getUser().clickOnLoginButton();
    }
}







