package testcomponents;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import resources.ExtentedReports;
public class ListenersClass extends Baseclass implements ITestListener
{

    ExtentReports reports = ExtentedReports.getReport();
    ThreadLocal<ExtentTest> thread = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result)
    {
        ExtentTest test = reports.createTest(result.getMethod().getMethodName());
        thread.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        thread.get().log(Status.PASS, result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result)
    {
        thread.get().log(Status.FAIL, result.getMethod().getMethodName());
        thread.get().log(Status.FAIL, result.getThrowable());

        try
        {
            String screenshotPath = takeScreenShoot(result.getMethod().getMethodName());
            thread.get().addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ITestContext context)
    {
        reports.flush();
    }
}
