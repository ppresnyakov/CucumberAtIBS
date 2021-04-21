package yandex.market.steps;


import cucumber.runtime.junit.Assertions;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;
import yandex.market.pageObjects.MainPage;
import yandex.market.pageObjects.MainPage;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import yandex.market.pageObjects.MainPage;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import yandex.market.pageObjects.MainPage;


public class MainPageSteps {
    WebDriver driver;
    private MainPage mainPage;

    public MainPageSteps(WebDriver driver) {
        this.driver = driver;
        this.mainPage = new MainPage();
    }

    @Step("Заголовок  открывшейся страницы = '{0}'")
    public void checkTitle(String title) {
        assertTrue(mainPage.checkTitle(driver, title));
    }

    @Step("Нажать на сервис - '{0}'")
    public void clickOnService(String service) {
        mainPage.clickOnService(service);
    }

}
