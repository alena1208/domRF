import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleTest3 {

    @Test(invocationCount = 3, threadPoolSize = 3)
    public void SimpleMediaTest() {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.navigate().to("https://new.ahml.test/");
        Assert.assertEquals(driver.getTitle(), "Дом.рф");

        WebElement menuItemMedia = driver.findElement(By.cssSelector("a[href='#drop-tab3']"));
        menuItemMedia.click();

        WebElement linkMediateka = driver.findElement(By.xpath("//div[contains(@class, 'drop-tab')]//a[@href='/media/gallery/']"));
        Assert.assertTrue(linkMediateka.isDisplayed());
        Assert.assertEquals(linkMediateka.getText(), "Медиатека");

        driver.close();
    }
}
