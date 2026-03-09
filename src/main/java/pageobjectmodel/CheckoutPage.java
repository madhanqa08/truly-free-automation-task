package pageobjectmodel;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
public class CheckoutPage
{
    WebDriver driver;
    WebDriverWait wait;

    public CheckoutPage(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    By firstName = By.id("firstName");
    By lastName = By.id("lastName");
    By address = By.xpath("//input[@data-testid='address']");
    By pin = By.id("zipCode");
    By saveContinue = By.xpath("//button[.='Save and Continue']");
    By savedname = By.xpath("//div[contains(@class,'user-details')]//h3");

    public PaymentPage fillAddress(String fName,String lName,String addr,String zipcode)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).sendKeys(fName);
        driver.findElement(lastName).sendKeys(lName);
        driver.findElement(address).sendKeys(addr);
        driver.findElement(pin).clear();
        driver.findElement(pin).sendKeys(zipcode);
        wait.until(ExpectedConditions.elementToBeClickable(saveContinue)).click();
        return new PaymentPage(driver);
    }

    public boolean isaddressSaved()
    {
        return  wait.until(ExpectedConditions.visibilityOf(driver.findElement(savedname))).isDisplayed();
    }
}
