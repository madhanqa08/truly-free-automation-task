package testcomponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageobjectmodel.LandingPage;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
public class Baseclass
{
    public static WebDriver driver;
    public LandingPage landingPage;
    public WebDriver initilizeDriver() throws IOException
    {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(
                System.getProperty("user.dir") + "//src//main//resources//GlobalData.properties"
        );
        properties.load(fileInputStream);
        String browser= System.getProperty("browser")!=null ? System.getProperty("browser") : properties.getProperty("browser");
        if(browser.equalsIgnoreCase("chrome"))
        {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--guest");
            options.addArguments("--force-device-scale-factor=1");
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
        }
        else if (browser.equalsIgnoreCase("edge"))
        {
            driver = new EdgeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }

    @BeforeMethod(alwaysRun = true)
    public LandingPage launchApplication() throws IOException
    {
        driver = initilizeDriver();
        landingPage = new LandingPage(driver);
        landingPage.goTo("https://trulyfreehome.dev/");
        return  landingPage;
    }


//    @AfterMethod
//    public void quit()
//    {
//        driver.quit();
//    }
}
