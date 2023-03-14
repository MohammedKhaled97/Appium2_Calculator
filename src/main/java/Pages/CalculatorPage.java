package Pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
public class CalculatorPage extends BasePage
{
    public CalculatorPage(AndroidDriver driver)
    {
        super(driver);
    }
    @AndroidFindBy(id = "com.coloros.calculator:id/digit_8")
    public WebElement FirstNumber;

    @AndroidFindBy(id = "com.coloros.calculator:id/digit_2")
    public WebElement SecondNumber;

    @AndroidFindBy(accessibility = "Add")
    public WebElement AddSign;

    @AndroidFindBy(accessibility = "Subtract")
    public WebElement SubtractSign;

    @AndroidFindBy(accessibility = "Equals")
    public WebElement EqualSign;


    public void Calc_Add()
    {
        FirstNumber.click();
        AddSign.click();
        SecondNumber.click();
        EqualSign.click();
        //Assertion*****************
        String Result = driver.findElement(AppiumBy.androidUIAutomator("text(\"10\")")).getText();
        System.err.println("The Adding Result IS : "+Result);
        Assert.assertEquals(Result,"10");
        //*************************
    }

    public void Calc_Sub()
    {
        FirstNumber.click();
        SubtractSign.click();
        SecondNumber.click();
        EqualSign.click();
        //Assertion*****************
        String Result = driver.findElement(AppiumBy.id("com.coloros.calculator:id/result")).getText();
        System.err.println("The Adding Result IS : "+Result);
        Assert.assertEquals(Result,"6");
        //*************************

    }
}
