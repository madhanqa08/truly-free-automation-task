package pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage
{
    WebDriver driver;
    WebDriverWait wait;


    By message = By.xpath("//div[contains(@class,'thank-you-header')]//h1");

    By orderid = By.xpath("//p[contains(@class,'order-number')]");

    public OrderPage(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public String getMessage()
    {
       return wait.until(ExpectedConditions.visibilityOf(driver.findElement(message))).getText();
    }

    public boolean isvalidOrderId()
    {
        String id = wait.until(ExpectedConditions.visibilityOf(driver.findElement(orderid))).getText();
        return id.contains("MID");
    }

}
