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
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By firstName = By.id("firstName");
    By lastName = By.id("lastName");
    By address = By.xpath("//input[@data-testid='address']");
    By pin = By.id("zipCode");
    By saveContinue = By.xpath("//button[.='Save and Continue']");

    public void fillAddress(String fName,String lName,String addr,String zipcode)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).sendKeys(fName);
        driver.findElement(lastName).sendKeys(lName);
        driver.findElement(address).sendKeys(addr);
        driver.findElement(pin).sendKeys(zipcode);

        wait.until(ExpectedConditions.elementToBeClickable(saveContinue)).click();
    }
}
