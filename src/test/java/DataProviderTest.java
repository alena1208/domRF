import enums.MainPageMenuItemsEnums;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.MainPage;

import java.util.List;

import static enums.MainPageMenuItemsEnums.*;

public class DataProviderTest {
    @DataProvider(parallel = true)
    public Object[][] menuItemsDP() {
        return new Object[][]{
                {0, DEYATELNOST.text},
                {1, RAZVITIE.text},
                {2, MEDIA.text},
                {3, ABOUT_COMPANY.text},
                {4, INVESTORS.text},
                {5, CARIER.text},
                {6, CONTACTS.text}};
    }

    @Test(dataProvider = "menuItemsDP")
    public void menuItemsTest (int num, String text){
        System.setProperty("webdriver.chrome", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Open main page
        driver.navigate().to("https://new.ahml.test/");

        //Check menu items
        List<WebElement> items = driver.findElements(By.cssSelector("div.main-nav_dark-skin li.main-drop-wrap"));
        WebElement item = items.get(num);
        Assert.assertEquals(item.getText().toLowerCase(), text);
        driver.close();
    }
}
