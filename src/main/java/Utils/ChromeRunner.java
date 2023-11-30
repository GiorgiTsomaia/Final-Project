package Utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.open;

public class ChromeRunner {
    @BeforeMethod(description = "Configure browser before tests")
    public void setup(){
        open("https://vitamini.ge");
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";

    }

    @AfterMethod
    public void teardown() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        Selenide.closeWindow();
        Selenide.closeWebDriver();
    }
}
