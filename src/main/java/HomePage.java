import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    ///////////////PRIVATE REUSABLE ELEMENTS//////////////////////
    private WebElement searchBox(){
        return driver.findElement(By.xpath("//div[contains(@class,'search-row')]//input[@id='query']"));
    }

    private WebElement myLocation(){
        return driver.findElement(By.xpath("//strong[contains(text(),'My Location')]"));
    }

    private WebElement cookieAccept(){
        return driver.findElement(By.xpath("//button[@class='qc-cmp-button']"));
    }

    ///////////////PUBLIC TEST STEPS//////////////////////
    public void acceptCookies(){
        waitForLoad().until(ExpectedConditions.urlMatches("https://www.propertypal.com/"));
        waitForLoad().until(ExpectedConditions.visibilityOf(cookieAccept()));
        click(cookieAccept());
    }


    public ResultsPage searchMyLocation() {
        click(searchBox());
        WebElement myLocation = waitForLoad().until(webDriver -> myLocation());
        click(myLocation);
        waitForLoad().until(ExpectedConditions.attributeContains(searchBox(), "value", "My Location"));
        searchBox().sendKeys(Keys.RETURN);

        return new ResultsPage(driver);
    }

    public ResultsPage searchBT6(){
        writeText(searchBox(), "BT6");
        driver.findElement(By.xpath("//div[contains(@class,'search-row')]//input[@id='query']")).sendKeys(Keys.RETURN);
        return new ResultsPage(driver);
    }

    public ResultsPage searchNoResults(){
        writeText(searchBox(), "SW5");
        driver.findElement(By.xpath("//div[contains(@class,'search-row')]//input[@id='query']")).sendKeys(Keys.RETURN);
        return new ResultsPage(driver);
    }
}
