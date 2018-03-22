package base;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;

public abstract class TestBaseSelenide {

    @BeforeMethod
    public void setUpSuite() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;

        Configuration.timeout = 6000;
        Configuration.pollingInterval = 200;
        Configuration.collectionsPollingInterval = 300;
    }
}
