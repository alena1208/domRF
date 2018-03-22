import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;


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

    // Проверка того что верхнее меню появляется на главной странице
    @Test
    public void mySamTest() throws Exception {
        driver.manage().window().maximize();
        driver.get("https://new.ahml.test");
        //?
        driver.findElements(By.cssSelector(".row-date__day")).get(5).click();

        WebElement myElem = driver.findElements(By.cssSelector(".row-date__day")).get(4);
        Actions actions = new Actions(driver);
        actions.moveToElement(myElem).sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).
                sendKeys(Keys.ARROW_UP).build().perform();
        WebElement myWebEl = driver.findElements(By.cssSelector(".main-drop__opener.hidden-lg-down")).get(1);
        String menuName = myWebEl.getAttribute("textContent");
        //System.out.println(menuName);
        Assert.assertTrue(menuName.equals("Медиа"));

//        wait.until(elementToBeClickable(myWebEl));
        Thread.sleep(5000);
        myWebEl.click();
    }
}
