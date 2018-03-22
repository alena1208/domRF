import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class SimpleTest1 {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 30);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.close();
    }

    @Test(groups = {"smoke"})
    public void simpleMediaTest() {
        driver.manage().window().maximize();

        driver.navigate().to("https://new.ahml.test/");
        Assert.assertEquals(driver.getTitle(), "Дом.рф");

        WebElement menuItemMedia = driver.findElement(By.cssSelector("a[href='#drop-tab3']"));
        menuItemMedia.click();

        WebElement linkMediateka = driver.findElement(By.xpath("//div[contains(@class, 'drop-tab')]//a[@href='/media/gallery/']"));
        Assert.assertTrue(linkMediateka.isDisplayed());
        Assert.assertEquals(linkMediateka.getText(), "Медиатека");
    }
}
