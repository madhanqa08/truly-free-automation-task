package tests;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageobjectmodel.*;
import pojofiles.PlaceorderPojo;
import pojofiles.SiginPojo;
import testcomponents.Baseclass;
import utilities.generation.MobileGenerations;
import java.time.Duration;
import java.util.List;
@Listeners(testcomponents.ListenersClass.class)
public class StandAloneTest extends Baseclass
{
    SiginPojo siginPojo = new SiginPojo();
    PlaceorderPojo placeorderPojo = new PlaceorderPojo();
    String productName = "COOFANDY Mens Muscle";

    @Test(priority = 1)
    public void Signup() throws InterruptedException
    {
        LandingPage signupPage = new LandingPage(driver);
        signupPage.clickLoginAccount();
        signupPage.clickCreateAccount();
        signupPage.selectIndiaCountry();
        siginPojo.setMobile(MobileGenerations.generateMobileNumber());
        String mobile = siginPojo.getMobile();
        signupPage.enterMobile(mobile);
        signupPage.clickContinue();
        signupPage.enterOTP("1111");
        signupPage.enterUserDetails("Madhan", "Kumar B", siginPojo.getEmail()
        );
        signupPage.submitSignup();
    }

    @Test(priority = 2)
    public void NavigateToBrand() throws InterruptedException
    {
        login();
        BrandPage brandPage = new BrandPage(driver);
        brandPage.hoverOnBrandsMenu();
        brandPage.selectAlphabet("a");
        brandPage.selectBrand("Adidas");
    }

    @Test(dependsOnMethods = "NavigateToBrand", priority = 3)
    public void productSelection()
    {
        ProductPage productPage = new ProductPage(driver);
        productPage.selectProduct(productName);
    }


    @Test(priority = 4)
    public void addProductToCart() throws InterruptedException
    {
        login();
        BrandPage brandPage = new BrandPage(driver);
        ProductPage productPage = new ProductPage(driver);
        brandPage.hoverOnBrandsMenu();
        brandPage.selectAlphabet("a");
        brandPage.selectBrand("Adidas");
        productPage.selectProduct(productName);
        productPage.addToCart();
    }

    @Test(priority = 5)
    public void cartPageValidation() throws InterruptedException
    {
        login();
        CartPage cartPage = new CartPage(driver);
        cartPage.openCart();
        if(cartPage.verifyProductInCart(productName))
        {
            System.out.println("Product is Verified");
        }
    }


    @Test(priority = 6)
    public void checkout() throws InterruptedException
    {
        login();
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        PaymentPage paymentPage = new PaymentPage(driver);
        cartPage.openCart();
        cartPage.proceedToCheckout();
        checkoutPage.fillAddress(
                placeorderPojo.getFirstname(),
                placeorderPojo.getLastname(),
                placeorderPojo.getAddress(),
                placeorderPojo.getPin()
        );
        paymentPage.enterCardNumber(placeorderPojo.getCard_number());
        paymentPage.enterCVV(placeorderPojo.getCvv());
        paymentPage.enterExpiryAndName(
                placeorderPojo.getExpire(),
                placeorderPojo.getCardName()
        );
        paymentPage.placeOrder();

        if(paymentPage.verifyOrderSuccess())
        {
            System.out.println("Order Placed Successfully");
        }
    }



    public void login() throws InterruptedException
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.xpath("//div[@data-testid='login-account']")).click();
        By contryCode = By.xpath("//div[@class='selected-flag']");
        wait.until(ExpectedConditions.elementToBeClickable(contryCode)).click();
        By clickIndia = By.xpath("//ul[@class='country-list']//li//span[text()='India (भारत)']");
        wait.until(ExpectedConditions.elementToBeClickable(clickIndia)).click();
        WebElement loginPhone = driver.findElement(By.id("loginPhoneInput"));
        WebElement phone = wait.until(
                ExpectedConditions.elementToBeClickable(loginPhone)
        );
        phone.click();
        String number = siginPojo.getMobile();
        for (char c : number.toCharArray())
        {
            phone.sendKeys(String.valueOf(c));
            Thread.sleep(100);
        }
        WebElement contine = driver.findElement(By.xpath("//button[.='Continue']"));
        wait.until(ExpectedConditions.elementToBeClickable(contine)).click();
        List<WebElement> otpField = driver.findElements(By.xpath("//input[@maxlength='1']"));
        String otp = "1111";
        for (int i = 0; i < otpField.size(); i++)
        {
            otpField.get(i).sendKeys(String.valueOf(otp.charAt(i)));
        }
    }
}

