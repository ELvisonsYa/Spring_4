import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.Assert;
import org.junit.runners.Parameterized;

import pages.*;

@RunWith(Parameterized.class)
public class TestClass {
    private final String name;
    private WebDriver driver;
    private final String lastName;
    private final String address;
    private final String metro;
    private final String phone;
    private final String date;
    private final String time;
    private final String color;
    private final String comment;
    private final String result;

    public TestClass(String name, String lastName, String address, String metro, String phone, String date, String time, String color, String comment, String result) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
        this.date = date;
        this.time = time;
        this.color = color;
        this.comment = comment;
        this.result = result;
    }

    // Тестовые данные
    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][]{
                {"Влад", "Иванов", "Кутузовская 7", "Лубянка", "89999999999", "11.11.2023", "сутки", "черный", "Скорее", "Заказ оформлен"},
                {"Иван", "Власов", "Пролетарская 9", "Лужники", "89650879012", "15.11.2023", "двое суток", "серый", "Быстрее", "Заказ оформлен"},
        };
    }

    @Test
    public void checkOrderLine() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        driver = new ChromeDriver(options);

        driver.get("https://qa-scooter.praktikum-services.ru/");

        MainPage objMainPage = new MainPage(driver);

        objMainPage.clickCookieButton();

        objMainPage.clickOrderButton();

        OrderPage objOrderPage = new OrderPage(driver);

        objOrderPage.setOrderParams(name, lastName, address, metro, phone);

        objOrderPage.waitToNextButtonToBeClickable();

        objOrderPage.setNextButtonClick();

        OrderParamsPage objOrderParamsPage = new OrderParamsPage(driver);

        objOrderParamsPage.setOrderParams(date, time, color, comment);

        String actualSuccessText = objOrderParamsPage.getSuccessText();

        Assert.assertEquals("Текст с окна не совпадает", result, actualSuccessText);
    }

    @After
    public void ternDown() {
        driver.quit();
    }
}


