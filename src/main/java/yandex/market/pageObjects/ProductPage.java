package yandex.market.pageObjects;

import com.sun.corba.se.impl.oa.poa.ActiveObjectMap;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import yandex.market.steps.Hooks;
import java.util.List;

public class ProductPage extends Page{
    private WebDriver driver;

    @FindBy(xpath = "//legend[contains(text(), 'Цена, ₽')]/parent::node()")
    WebElement priceBlock;

    @FindBy(xpath = "//legend[contains(text(), 'Производитель')]/parent::node()")
    WebElement manufacturer;

    @FindBy(xpath = "//input[@id='header-search']")
    WebElement headerSearchInput;

    @FindBy(xpath = "//div[@data-zone-data= '{\"viewType\":\"list\"}']")
    WebElement itemsContainer;

    public ProductPage() {
        this.driver = Hooks.getDriver();
        PageFactory.initElements(driver, this);
    }

    @Override
    public boolean checkTitle(WebDriver driver, String title) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.titleContains(title));
        return true;
    }

    public void setPriceTo(String type, String value) {
        priceBlock.findElement(By.xpath(".//input[@name='" + type + "']"))
        .sendKeys(value);
    }
    public void selectManufacturer(String name) {

        if (elementIsNotPresent(".//input[@name='Поле поиска']"));
        {manufacturer.findElement(By.xpath("//button[contains(text(), 'Показать всё')][1]")).click();}
        manufacturer.findElement(By.xpath(".//input[@name='Поле поиска']")).sendKeys(name);
        manufacturer.findElement(By.xpath(".//span[contains(text(), '" + name + "')]")).click();
        manufacturer.findElement(By.xpath(".//input[@name='Поле поиска']")).clear();
        manufacturer.findElement(By.xpath(".//input[@name='Поле поиска']")).sendKeys("\n");
    }

    public int getItemsCount(List<WebElement> items) throws InterruptedException {
        return items.size();
    }

    public List<WebElement> getItems() throws InterruptedException {
        //не нашёл как по другому дождаться обновления товаров
        Thread.sleep(10000);

        return itemsContainer.findElements(By.xpath(".//article"));
    }

    public String getItemTitle(WebElement item) {
        return item.findElement(By.xpath(".//a[@title]")).getAttribute("title");
    }

    public void searchByHeaderInput(String text) {
        headerSearchInput.click();
        headerSearchInput.sendKeys(text);
        headerSearchInput.sendKeys(Keys.ENTER);
    }
    public boolean elementIsNotPresent(String xpath){
        return driver.findElements(By.xpath(xpath)).isEmpty();

    }
}
