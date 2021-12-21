import model.Currency;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.CoralHomePage;
import page.CoralHomeResultPage;

public class CoralHomePageCurrencyTest extends CommonConditions {

    @Test
    public void currencyTest() {
        CoralHomePage homePage = new CoralHomePage(driver);
        Currency model = Currency.USD;

        CoralHomeResultPage resultsPage = homePage
                .openHomePage()
                .selectCurrencyValue();

        Assert.assertEquals(
                resultsPage.getCountOfHotelsWithValue(model),
                resultsPage.getCountOfHotelsWithPrice()
        );
    }
}
