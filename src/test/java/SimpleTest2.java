import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;

public class SimpleTest2 extends TestBase {

    @Test
    public void simpleMediaTest(){
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
