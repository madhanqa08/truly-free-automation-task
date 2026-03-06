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
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locator
    By productList = By.xpath("//div[@data-testid='category-products']//div//h2");

    By addToCartBtn = By.xpath("//button[@data-testid='add-to-cart']");


    // Action
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

    // Add to cart
    public void addToCart()
    {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
    }
}