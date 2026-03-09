
package pageobjectmodel;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
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
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }


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

    By acc = By.xpath("//div[@data-testid='profile-btn']");
    By logout = By.xpath("//p[.='Logout']");
    By log = By.xpath("//button[.='Logout']");
    //driver.findElement(By.xpath("//a[contains(@href,'account')]")).click();
    //        driver.findElement(By.xpath("//a[contains(text(),'Log out')]")).click();
    By accName =By.xpath("(//div[@data-testid='profile-btn']//span)[2]");



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
            Thread.sleep(200);
        }
    }

    public void clickContinue()
    {
        wait.until(ExpectedConditions.elementToBeClickable(continueBtn)).click();
    }

    public void enterOTP(String otp) throws InterruptedException
    {
        List<WebElement> fields = driver.findElements(otpFields);

        for(int i=0;i<fields.size();i++)
        {
            fields.get(i).sendKeys(String.valueOf(otp.charAt(i)));
            Thread.sleep(200L);
        }
    }

    public void enterUserDetails(String fName,String lName,String emailId)
    {
        driver.findElement(firstName).sendKeys(fName);
        driver.findElement(lastName).sendKeys(lName);
        driver.findElement(email).sendKeys(emailId);
    }

    public BrandPage submitSignup() throws InterruptedException
    {
        wait.until(ExpectedConditions.elementToBeClickable(finalCreateAccount)).click();
        Thread.sleep(3000L);
        driver.navigate().refresh();
        return new BrandPage(driver);
    }

    public void goTo(String url)
    {
        driver.get(url);
    }

    public void logout()
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(acc)).build().perform();
        actions.moveToElement(driver.findElement(logout)).build().perform();
        driver.findElement(logout).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(log)));
        driver.findElement(log).click();
    }

    public String getaccname()
    {
        return  wait.until(ExpectedConditions.visibilityOf(driver.findElement(accName))).getText();
    }
}