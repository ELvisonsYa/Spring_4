package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;


import java.util.List;


public class MainPage {
    private WebDriver driver;

    // Кнопка куки
    private By cookieButton = By.className("App_CookieButton__3cvqF");

    //Кнопка заказать в шапке страницы
    private By orderButton = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");

    //Кнопка заказать внизу страницы
    private By orderButtonMiddle = By.className("Button_Middle__1CSJM");

    //Вопросы о важном
    private By faqItemsHeadingFiled = By.xpath(".//div[@class='accordion__button']");

    //Ответы на вопросы о важном
    private By faqItemsPanelField = By.xpath(".//div[@role='region']");

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    public void clickOrderButtonMiddle() {
        driver.findElement(orderButtonMiddle).click();
    }

    public void clickFaqItem(int number) {
        List<WebElement> faqItems =  driver.findElements(faqItemsHeadingFiled);
        faqItems.get(number).click();
    }
    public String getTextFaqItemHeading(int number) {
        List<WebElement> faqItems =  driver.findElements(faqItemsHeadingFiled);
        WebElement textItem = faqItems.get(number);
        return textItem.getText();
    }
    public String getTextFaqItemPanel(int number) {
        List<WebElement> faqItems =  driver.findElements(faqItemsPanelField);
        WebElement textItem = faqItems.get(number);
        new Actions(driver).scrollToElement(textItem).perform();
        return textItem.getText();
    }

    public void clickCookieButton() {
        driver.findElement(cookieButton).click();
    }

}
