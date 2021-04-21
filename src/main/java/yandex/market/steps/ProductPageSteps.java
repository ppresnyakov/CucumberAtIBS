package yandex.market.steps;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;
import yandex.market.GeneralMethods;
import yandex.market.pageObjects.ProductPage;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class ProductPageSteps {
    WebDriver driver;
    private ProductPage productPage;
    private List<WebElement> oldItems;
    private String oldItemName;

    public ProductPageSteps(WebDriver driver) {
        this.driver = driver;
        this.productPage = new ProductPage();
    }

    @Step("Заголовок  открывшейся страницы = \"{0}\"")
    public void checkTitle(String title) {
        assertTrue(
                productPage.checkTitle(driver, title)
        );
    }

    @Step("Установить \"{0}\" - \"{1}\"")
    public void setPriceTo(String priceType, String priceValue) {
        productPage.setPriceTo(priceType, priceValue);
        GeneralMethods.getScreenshot(driver);
    }

    @Step("Выбрать производителя - \"{0}\"")
    public void selectManufacturer(String name) {
        productPage.selectManufacturer(name);
        GeneralMethods.getScreenshot(driver);
    }

    @Step("Отображено товаров больше чем \"{0}\"")
    public void checkItemsQuantity(int threshold) throws InterruptedException {
        oldItems = productPage.getItems();
        assertTrue(
                productPage.getItemsCount(oldItems) >= threshold
        );
    }

    @Step("Выполнить поиск по товару под номером \"{0}\"")
    public void searchByItemNumber(int number) {
        oldItemName = productPage.getItemTitle(oldItems.get(number));
        productPage.searchByHeaderInput(oldItemName);
    }

    @Step("Проверить что название товара после поиска не изменилось")
    public void checkItemTitle(int number) throws InterruptedException {
        List<WebElement> newItems = productPage.getItems();
        String newItemName = productPage.getItemTitle(newItems.get(number));

        assertTrue(
                oldItemName.equals(newItemName)
        );
    }

}
