package pageobjectmodel;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
import java.util.List;
public class CartPage
{
    WebDriver driver;
    WebDriverWait wait;
    public CartPage(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    By cartIcon = By.xpath("//li[@data-testid='cart-icon']");
    By cartItems = By.xpath("//div[@class='cart_items_wrapper']//div//div[@class='cart_product_list_grp']//h2");
    By proceedCheckout = By.xpath("(//button[.='Proceed to Checkout'])[1]");

    // Actions

    public void openCart()
    {
        WebElement icon = wait.until(ExpectedConditions.visibilityOfElementLocated(cartIcon));
        icon.click();
    }

    public boolean verifyProductInCart(String productName)
    {
        List<WebElement> items = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(cartItems)
        );

        for(WebElement element : items)
        {
            if(element.getText().contains(productName))
            {
                return true;
            }
        }
        return false;
    }

    public void proceedToCheckout()
    {
        wait.until(ExpectedConditions.elementToBeClickable(proceedCheckout)).click();
    }
}
