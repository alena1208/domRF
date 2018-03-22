package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static org.testng.AssertJUnit.assertEquals;

public class MainPage {

    @FindBy(css = "a[href='#drop-tab3']" )
    private WebElement menuItemMedia;

    @FindBy(xpath = "//div[contains(@class, 'drop-tab')]//a[@href='/media/gallery/']")
    private WebElement linkMediateka;

    public void open(WebDriver driver){
        driver.navigate().to("https://new.ahml.test/");
    }

    public void checkPageTitle(WebDriver driver){
        assertEquals(driver.getTitle(), "Дом.рф");
    }

    public void checkPresenceOfLinkMediateka(){
        menuItemMedia.click();
        Assert.assertTrue(linkMediateka.isDisplayed());
        Assert.assertEquals(linkMediateka.getText(), "Медиатека");
    }
}
