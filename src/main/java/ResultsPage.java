import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ResultsPage extends BasePage {

    public ResultsPage(WebDriver driver) {
        super(driver);
    }

    ///////////////PRIVATE REUSABLE ELEMENTS//////////////////////
    private String searchResultsURL(){
        return "https://www.propertypal.com/property-for-sale/";
    }

    private WebElement resultsTitle(){
        return driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/article[1]/div[2]/div[1]/h1[1]"));
    }

    ///////////////PUBLIC TEST STEPS//////////////////////
    public String searchResultMyLocation(){
        waitForLoad().until(ExpectedConditions.urlContains(
                "https://www.propertypal.com/search?"));
        return readText(resultsTitle());
    }

    public String searchResult(){
        waitForLoad().until(ExpectedConditions.urlContains(searchResultsURL()));
        return readText(resultsTitle());
    }
}
