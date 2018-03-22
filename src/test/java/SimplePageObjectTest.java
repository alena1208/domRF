import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.MainPage;

public class SimplePageObjectTest {

    private WebDriver driver;
    private MainPage mainPage;

    @BeforeClass
    public void setUpPages() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        mainPage = PageFactory.initElements(driver, MainPage.class);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.close();
    }

    @Test
    public void simpleMediaTest() {
        mainPage.open(driver);
        mainPage.checkPageTitle(driver);
        mainPage.checkPresenceOfLinkMediateka();
    }
}
