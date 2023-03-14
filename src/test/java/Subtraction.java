import Pages.CalculatorPage;
import org.testng.annotations.Test;

import java.time.Duration;

public class Subtraction extends BaseTest
{

    CalculatorPage CO;
    @Test
    public void Subtract()
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
        CO = new CalculatorPage(driver);
        CO.Calc_Sub();
    }

}
