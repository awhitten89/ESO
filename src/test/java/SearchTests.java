import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Execution(ExecutionMode.CONCURRENT)
public class SearchTests extends BaseTest {

    @BeforeEach
    public void acceptCookies(){
        HomePage homePage = new HomePage(driver);
        homePage.acceptCookies();
    }

    @Test
    public void myLocationTest(){
        HomePage homePage = new HomePage(driver);
        ResultsPage resultsPage = homePage.searchMyLocation();
        Assertions.assertEquals("PROPERTY FOR SALE NEAR MY LOCATION, 0.75 MILE RADIUS", resultsPage.searchResultMyLocation());
    }

    @Test
    public void bt6Test(){
        HomePage homePage = new HomePage(driver);
        ResultsPage resultsPage = homePage.searchBT6();
        Assertions.assertEquals("PROPERTY FOR SALE IN BT6", resultsPage.searchResult());
    }

    @Test
    public void searchReturnsNoResults(){
        HomePage homePage = new HomePage(driver);
        ResultsPage resultsPage = homePage.searchNoResults();
        Assertions.assertEquals("SORRY, NO PROPERTIES FOUND", resultsPage.searchResult());
    }
}
