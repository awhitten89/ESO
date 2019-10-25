import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

/**
 * Base page that hold driver instance and common methods used by all pages
 */
public class BasePage {

    WebDriver driver;

    BasePage(WebDriver driver) {
        this.driver = driver;
    }

    Wait<WebDriver> waitForLoad(){
        FluentWait<WebDriver> wait;
        return wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
    }


    //Package private Click Method
    void click(WebElement element) {
        try{
            element.click();
            System.out.println("clicked " + element);
        } catch (ElementNotVisibleException | NoSuchElementException | ElementNotSelectableException e) {
            //TODO: LOG ERROR
        }
    }

    //Package private Write Text
    void writeText(WebElement element, String text) {
        System.out.println("entering " + text);
        try {
            element.sendKeys(text);
        } catch (ElementNotVisibleException | NoSuchElementException | ElementNotSelectableException e) {
            //TODO: LOG ERROR
        }
    }

    //Package private Read Text
    String readText(WebElement element) {
        try {
            return element.getText();
        } catch (ElementNotVisibleException | NoSuchElementException | ElementNotSelectableException e) {
            /* TODO: LOG ERROR */
        }
        return null;
    }

    //Package private Read Attribute
    String readAttribute (WebElement element, String attribute) {
        try {
            return element.getAttribute(attribute);
        } catch (ElementNotVisibleException | ElementNotSelectableException | NoSuchElementException e) {
            //TODO: LOG ERROR
        }
        return null;
    }
}
