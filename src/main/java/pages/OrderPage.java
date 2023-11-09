package pages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {
    private WebDriver driver;

    //Поле Имя
    private By nameField = By.xpath(".//input[@placeholder='* Имя']");

    //Поле Фамилия
    private By lastNameField = By.xpath(".//input[@placeholder='* Фамилия']");

    //Поле Адрес
    private By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    //Поле Метро
    private By metroField = By.xpath(".//input[@placeholder='* Станция метро']");

    //Поле Телефон
    private By phoneField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    //Копка Далее
    private By nextButton = By.xpath(".//button[contains(text(), 'Далее')]");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void setLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void setAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    public void setMetro(String metro) {
        driver.findElement(metroField).sendKeys(metro);
        driver.findElement(metroField).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
    }

    public void setPhone(String phone) {
        driver.findElement(phoneField).sendKeys(phone);
    }

    public void setNextButtonClick() {
        driver.findElement(nextButton).click();
    }

    public void setOrderParams(String name, String lastName, String address, String metro, String phone) {
        setName(name);
        setLastName(lastName);
        setAddress(address);
        setMetro(metro);
        setPhone(phone);
    }

    public void waitToNextButtonToBeClickable() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(nextButton));
    }
}
