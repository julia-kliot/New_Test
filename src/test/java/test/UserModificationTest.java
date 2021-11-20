package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UserModificationTests extends TestBase {


    @Test
    public void test() throws InterruptedException {
        app.session().openTabAndSwitchToIt();
    }

    @Test
    public void testChangeUserAvatar() throws InterruptedException {
        app.session().clickOnAvatar();
        app.session().openUsersProfile();
        app.session().goToAtlassianAccount();
        Thread.sleep(7000);
        String url = app.getURL();
        Assert.assertEquals(url, "https://id.atlassian.com/manage-profile/profile-and-visibility", "Wrong url" + app.getURL());

        app.atlassian().initChangePhoto();
        app.atlassian().uploadPhoto();


        app.session().returnToTrelloFromAtlassian();
        String currUrl = app.getURL();
        Assert.assertTrue(currUrl.contains("https://trello.com/"), "Current Url is " + app.getURL());


    }

}
© 2021 GitHub, Inc.
        Term
