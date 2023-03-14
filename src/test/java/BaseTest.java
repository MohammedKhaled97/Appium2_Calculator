import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest
{
    public static AndroidDriver driver;
    public static DesiredCapabilities caps;
    public static AppiumDriverLocalService service;

    @BeforeTest
    public void SetCab() throws MalformedURLException
    {
        //To Start Server Automatically*******************************************************************************************
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("C:\\Users\\mabdelbaky\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();
        //*************************************************************************************************************************
        caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        caps.setCapability(MobileCapabilityType.UDID,"b4874359");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        caps.setCapability("ignoreHiddenApiPolicyError",true);
        caps.setCapability("autoGrantPermissions",true);
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.coloros.calculator");
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.android.calculator2.Calculator");
        caps.setCapability("uiautomator2ServerInstallTimeout","10000");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),caps);
    }
    @AfterTest
    public void CloseDriver()
    {
        driver.quit();
        //To Close Server Automatically
        service.stop();
        //*****************************
    }
}
