package pageobjectmodel;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
import java.util.List;
public class ProductPage {

    WebDriver driver;
    WebDriverWait wait;

    public ProductPage(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    By productList = By.xpath("//div[@data-testid='category-products']//div//h2");

    By addToCartBtn = By.xpath("//button[@data-testid='add-to-cart']");

    By productname = By.xpath("//p[@data-testid='product-name']");

    By productPrice = By.xpath("//span[contains(@class,'current_price')]");

    By productQuantity =  By.xpath("(//div[contains(@class,'react-select__single')]//span)[2]");

    By addtocartcount = By.xpath("//span[@data-testid='cart-count']");

    public void selectProduct(String productName)
    {
        List<WebElement> items = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(productList)
        );

        for(WebElement element : items)
        {
            if(element.getText().contains(productName))
            {
                element.click();
                break;
            }
        }
    }

    public  boolean isAddtocartVisible()
    {
        return wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).isDisplayed();
    }
    public CartPage addToCart()
    {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
        return new CartPage(driver);
    }

    public String productName()
    {
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(productname))).getText();
    }

    public String getPrice()
    {
       return wait.until(ExpectedConditions.visibilityOf(driver.findElement(productPrice))).getText();
    }

    public String getQuantity()
    {
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(productQuantity))).getText();
    }

    public String getcartCount()
    {
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(addtocartcount))).getText();
    }

}