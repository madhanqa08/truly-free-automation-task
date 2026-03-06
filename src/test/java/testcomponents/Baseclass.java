package testcomponents;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import pageobjectmodel.LandingPage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
public class Baseclass
{
    public static WebDriver driver;
    public LandingPage landingPage;
    private static final ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public WebDriver getDriver()
    {
        return tlDriver.get();
    }

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
        tlDriver.set(driver);
        landingPage = new LandingPage(driver);
        landingPage.goTo("https://trulyfreehome.dev/");
        return  landingPage;
    }


    public String takeScreenShoot(String testcaseName) throws IOException
    {
        WebDriver driver = getDriver();  // USE ThreadLocal driver
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String folderPath = System.getProperty("user.dir") + "/reports/screenshots/";
        File directory = new File(folderPath);
        if (!directory.exists())
            directory.mkdirs();
        String fileName = testcaseName + "_" + System.currentTimeMillis() + ".png";
        File fullPath = new File(folderPath + fileName);
        FileUtils.copyFile(src, fullPath);
        return "screenshots/" + fileName;
    }

//    @AfterMethod
//    public void quit()
//    {
//        driver.quit();
//    }
}
