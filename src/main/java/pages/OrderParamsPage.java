package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class OrderParamsPage {
    private WebDriver driver;

    //Поле Дата
    private By dateField = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");

    //Поле Срок
    private By timeField = By.className("Dropdown-control");

    //Элементы списка срока аренды
    private By timeValue = By.className("Dropdown-option");

    //Радиобаттон Черный цвет
    private By colorBlackField = By.id("black");

    //Радиобкнопка Серый цвет
    private By colorGreyField = By.id("grey");

    //Поле Комментарий
    private By commentField = By.xpath(".//input[@placeholder = 'Комментарий для курьера']");

    //Кнопка Заказать
    private By orderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']//button[2]");

    //Кнопка Да
    private By confirmButton = By.xpath(".//div[@class='Order_Modal__YZ-d3']//button[2]");

    //Заголовок окна Успех
    private By successText = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and contains(text(), 'Заказ оформлен')]");

    public OrderParamsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setDate(String date){
        driver.findElement(dateField).sendKeys(date, Keys.ENTER);
    }

    public void setTime(String time){
        driver.findElement(timeField).click();
        WebElement timeItem = driver.findElement(By.xpath(".//div[@class='Dropdown-option' and text()='"+ time +"']"));
        timeItem.click();
    }
    public void setBlackColor(){
        driver.findElement(colorBlackField).click();
    }

    public void setGrayColor(){
        driver.findElement(colorGreyField).click();
    }

    public void setColor(String color){
        if(color.equals("черный")){
            setBlackColor();
        } else {
            setGrayColor();
        }
    }

    public void setComment(String comment){
        driver.findElement(commentField).sendKeys(comment);
    }

    public void orderButtonClick(){
        driver.findElement(orderButton).click();
    }

    public void confirmButtonClick(){
        driver.findElement(confirmButton).click();
    }

    public void setOrderParams(String date, String time, String color, String comment){
        setDate(date);
        setTime(time);
        setColor(color);
        setComment(comment);
        orderButtonClick();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        confirmButtonClick();
    }

    public String getSuccessText() {
        return driver.findElement(successText).getText();
    }
}
