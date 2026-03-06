package pageobjectmodel;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
public class PaymentPage
{
    WebDriver driver;
    WebDriverWait wait;
    public PaymentPage(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By cardFrame = By.xpath("//iframe[contains(@id,'spreedly-number-frame')]");
    By cvvFrame = By.xpath("//iframe[contains(@id,'spreedly-cvv-frame')]");

    By cardNumber = By.id("card_number");
    By cvv = By.id("cvv");

    By expiry = By.id("expiry_date");
    By cardName = By.id("full_name");

    By placeOrder = By.xpath("//button[contains(@class,'style-module_btn__1-rqT')]");


    public void enterCardNumber(String number)
    {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(cardFrame));
        wait.until(ExpectedConditions.visibilityOfElementLocated(cardNumber)).sendKeys(number);
        driver.switchTo().defaultContent();
    }

    public void enterCVV(String cvvCode)
    {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(cvvFrame));
        driver.findElement(cvv).sendKeys(cvvCode);
        driver.switchTo().defaultContent();
    }

    public void enterExpiryAndName(String exp,String name)
    {
        driver.findElement(expiry).sendKeys(exp);
        driver.findElement(cardName).sendKeys(name);
    }

    public void placeOrder()
    {
        wait.until(ExpectedConditions.elementToBeClickable(placeOrder)).click();
    }

    public boolean verifyOrderSuccess()
    {
        return driver.getCurrentUrl().contains("thank-you");
    }
}
