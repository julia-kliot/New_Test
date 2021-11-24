package test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UserModification extends TestBase {


    @Test
    public void test() throws InterruptedException {
        app.getUser().openTabAndSwitchToIt();
    }

    @Test()
    public void testChangeUserAvatar() throws InterruptedException {
        app.getUser().clickOnAvatar();
        app.getUser().openUsersProfile();
        app.getUser().goToAtlassianAccount();
        Thread.sleep(7000);
        String url = app.getURL();
        Assert.assertEquals(url, "https://id.atlassian.com/manage-profile/profile-and-visibility", "Wrong url" + app.getURL());

        app.getAtlassian().initChangePhoto();
        app.getAtlassian().uploadPhoto();


        app.getUser().returnToTrelloFromAtlassian();
        String currUrl = app.getURL();
        Assert.assertTrue(currUrl.contains("https://trello.com/"), "Current Url is " + app.getURL());


    }

}