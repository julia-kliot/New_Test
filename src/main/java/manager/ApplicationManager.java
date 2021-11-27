package manager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
    // WebDriver wd;
    EventFiringWebDriver wd;
    BoardHelper board;
    UserHelper user;
    String browser;
    CardHelper card;
    ListHelper list;
    AtlassianHelper atlassian;
    Properties properties;

    public ApplicationManager(String browser) {
        this.browser = browser;
        properties = new Properties();
    }

    public void init() throws InterruptedException, IOException {
        String target = System.setProperty("target", "config");
        properties.load(new FileReader(new File(String.format("src/test/resources/config.properties/%s", target))));

        if (browser.equals(BrowserType.CHROME)) {
            wd = new EventFiringWebDriver(new ChromeDriver());
        } else if (browser.equals(BrowserType.EDGE)) {
            wd = new EventFiringWebDriver(new EdgeDriver());
        }
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        wd = new EventFiringWebDriver(new ChromeDriver());
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\julia\\Documents\\QA\\QA_Automation\\QA\\New_Test\\chromedriver.exe");
        wd.manage().window().maximize();
        logger.info("Tests starts on ChromeDriver");
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //wd.navigate().to("https://trello.com/");
        wd.navigate().to(properties.getProperty("web.baseUrl"));
        board = new BoardHelper(wd);
        user = new UserHelper(wd);
        card = new CardHelper(wd);
        list = new ListHelper(wd);
        atlassian = new AtlassianHelper(wd);
        user.login("juliakliot.jk@gmail.com", "misha240613");
        wd.register(new MyListener());

    }

    public void stop() {
        logger.info("Tests passed");
        wd.quit();

    }

    public BoardHelper getBoard() {
        return board;
    }

    public UserHelper getUser() {
        return user;
    }

    public CardHelper getCard() {
        return card;
    }

    public ListHelper getList() {
        return list;
    }

    public AtlassianHelper getAtlassian() {
        return atlassian;
    }

    public String getURL() {
        return wd.getCurrentUrl();
    }
}
