import base.TestBaseSelenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import listeners.AllureAttachmentListener;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;
import static com.codeborne.selenide.Condition.visible;

@Listeners(AllureAttachmentListener.class)
@Features({"Selenide Test Suite"})
@Stories({"Login tests"})
public class SelenideSimpleTest extends TestBaseSelenide{

    @AfterMethod
    public void closeBrowser() {
        WebDriverRunner.closeWebDriver();
    }

    @Test
    public void lableMediaTest1() {
        open("https://new.ahml.test/");
        assertEquals(getWebDriver().getTitle(), "Дом.рф");

        $("a[href='#drop-tab3']").click();

        SelenideElement linkMediateka = $(By.xpath("//div[contains(@class, 'drop-tab')]//a[@href='/media/gallery/']"));
        linkMediateka.should(visible);
        linkMediateka.should(text("Медиатека"));
    }

    @Test
    public void lableMediaTest2() {
        open("https://new.ahml.test/");
        assertEquals(getWebDriver().getTitle(), "Дом.рф");

        $("a[href='#drop-tab3']").click();

        SelenideElement linkMediateka = $(By.xpath("//div[contains(@class, 'drop-tab')]//a[@href='/media/gallery/']"));
        linkMediateka.should(visible);
        linkMediateka.should(text("Медиатека"));
    }

    @Test
    public void lableMediaTest3() {
        open("https://new.ahml.test/");
        assertEquals(getWebDriver().getTitle(), "Дом.рф");

        $("a[href='#drop-tab3']").click();

        SelenideElement linkMediateka = $(By.xpath("//div[contains(@class, 'drop-tab')]//a[@href='/media/gallery/']"));
        linkMediateka.should(visible);
        linkMediateka.should(text("Медиатека"));
    }
}
