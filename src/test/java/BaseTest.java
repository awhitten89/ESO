import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Base Test to instantiate the driver and navigate to base url
 */
public class BaseTest {

    WebDriver driver;

    @BeforeEach
    public void setUpTest() {
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        driver.navigate().to("https://www.propertypal.com/");
    }

    @AfterEach
    public void tearDownTest(){
        driver.quit();
    }
}
