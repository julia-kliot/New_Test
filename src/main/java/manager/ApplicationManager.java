package manager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    BoardHelper board;
    UserHelper user;



    public void init() throws InterruptedException {
      ChromeOptions chromeOptions = new ChromeOptions();
      WebDriverManager.chromedriver().setup();
      wd= new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\julia\\Documents\\QA\\QA_Automation\\QA\\New_Test\\chromedriver.exe");
      wd.manage().window().maximize();
      wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      wd.navigate().to("https://trello.com/");

      board = new BoardHelper(wd);
      user = new UserHelper(wd);
        user.login("juliakliot.jk@gmail.com","misha240613");
  }
  public void stop(){
        //wd.quit();

  }

    public BoardHelper getBoard() {
        return board;
    }

    public UserHelper getUser() {
        return user;
    }
}
