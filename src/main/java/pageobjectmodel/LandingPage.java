
package pageobjectmodel;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
import java.util.List;

public class LandingPage
{

    WebDriver driver;
    WebDriverWait wait;

    public LandingPage(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators

    By loginAccount = By.xpath("//div[@data-testid='login-account']");
    By createAccountBtn = By.xpath("//button[.='Create Account']");
    By countryCode = By.xpath("//div[@class='selected-flag']");
    By indiaOption = By.xpath("//ul[@class='country-list']//li//span[text()='India (भारत)']");
    By phoneInput = By.id("regPhoneInput");
    By continueBtn = By.xpath("//button[.='CONTINUE']");
    By otpFields = By.xpath("//input[@maxlength='1']");
    By firstName = By.xpath("//input[@data-testid='first-name-input']");
    By lastName = By.xpath("//input[@data-testid='last-name-input']");
    By email = By.xpath("//input[@data-testid='email-input']");
    By finalCreateAccount = By.xpath("//button[.='Create Account']");


    // Actions

    public void clickLoginAccount()
    {
        driver.findElement(loginAccount).click();
    }

    public void clickCreateAccount()
    {
        wait.until(ExpectedConditions.elementToBeClickable(createAccountBtn)).click();
    }

    public void selectIndiaCountry()
    {
        wait.until(ExpectedConditions.elementToBeClickable(countryCode)).click();
        wait.until(ExpectedConditions.elementToBeClickable(indiaOption)).click();
    }

    public void enterMobile(String mobile) throws InterruptedException
    {
        WebElement phone = wait.until(ExpectedConditions.elementToBeClickable(phoneInput));
        phone.click();

        for(char c : mobile.toCharArray())
        {
            phone.sendKeys(String.valueOf(c));
            Thread.sleep(50);
        }
    }

    public void clickContinue()
    {
        wait.until(ExpectedConditions.elementToBeClickable(continueBtn)).click();
    }

    public void enterOTP(String otp)
    {
        List<WebElement> fields = driver.findElements(otpFields);

        for(int i=0;i<fields.size();i++)
        {
            fields.get(i).sendKeys(String.valueOf(otp.charAt(i)));
        }
    }

    public void enterUserDetails(String fName,String lName,String emailId)
    {
        driver.findElement(firstName).sendKeys(fName);
        driver.findElement(lastName).sendKeys(lName);
        driver.findElement(email).sendKeys(emailId);
    }

    public void submitSignup()
    {
        wait.until(ExpectedConditions.elementToBeClickable(finalCreateAccount)).click();
    }

    public void goTo(String url)
    {
        driver.get(url);
    }
}