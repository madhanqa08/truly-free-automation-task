package pageobjectmodel;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
import java.util.List;
public class BrandPage
{

    WebDriver driver;
    WebDriverWait wait;
    public BrandPage(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    By brandsMenu = By.xpath("//div[contains(@class,'megamenu_container')]//nav//ul//li/span");
    By alphabets = By.xpath("(//div[contains(@class,'alphabet_column')]//div)");
    By brands = By.xpath("(//div[contains(@class,'brands_list_column')]//div//a//p)");
    By brandPage = By.xpath("//span[.='ADIDAS']");

    public void hoverOnBrandsMenu()
    {
        WebElement menu = driver.findElement(brandsMenu);

        Actions actions = new Actions(driver);
        actions.moveToElement(menu).perform();
    }

    public void selectAlphabet(String letter)
    {
        List<WebElement> alphabetList = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(alphabets)
        );

        for(WebElement alphabet : alphabetList)
        {
            if(alphabet.getText().equalsIgnoreCase(letter))
            {
                alphabet.click();
                break;
            }
        }
    }

    public ProductPage selectBrand(String brandName)
    {
        List<WebElement> brandList = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(brands)
        );

        for(WebElement brand : brandList)
        {
            if(brand.getText().equalsIgnoreCase(brandName))
            {
                brand.click();
                break;
            }
        }
        return new ProductPage(driver);
    }

    public String brandpage()
    {
         return  wait.until(ExpectedConditions.visibilityOf(driver.findElement(brandPage))).getText();
    }
}