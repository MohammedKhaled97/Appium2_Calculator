import Pages.CalculatorPage;
import org.testng.annotations.Test;
import java.time.Duration;


public class Adding extends BaseTest
{
    CalculatorPage Co;
    @Test
    public void Add()
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
        Co = new CalculatorPage(driver);
        Co.Calc_Add();
    }

}
