package yandex.market.steps;



import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;
import yandex.market.pageObjects.ElectronicsPage;
import yandex.market.pageObjects.MainPage;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ElectronicsPageSteps {

    WebDriver driver;
    private ElectronicsPage electronicsPage;

    public ElectronicsPageSteps(WebDriver driver) {
        this.driver = driver;
        this.electronicsPage = new ElectronicsPage();
    }

    @Step("Заголовок  открывшейся страницы = '{0}'")
    public void checkTitle(String title) {
        assertTrue(electronicsPage.checkTitle(driver, title));

    }

    @Step("Нажать на элемент каталога - '{0}'")
    public void clickOnCatalogItem(String name) {
        electronicsPage.clickOnCatalogItem(name);
    }
}
