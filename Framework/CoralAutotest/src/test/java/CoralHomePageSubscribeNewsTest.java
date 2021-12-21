import org.testng.Assert;
import org.testng.annotations.Test;
import page.CoralHomePage;
import page.CoralHomeResultPage;

public class CoralHomePageSubscribeNewsTest extends CommonConditions{

    private static final String EMAIL = "test@gmail.com";

    @Test
    public void subscribeButtonShouldBeDisabled() {
        CoralHomePage homePage = new CoralHomePage(driver);
        CoralHomeResultPage resultPage = new CoralHomeResultPage(driver);

        homePage.openHomePage();

        Assert.assertFalse(resultPage.isSubscribeButtonEnabled());
    }

    @Test
    public void subscribeToNewsShouldReturnSuccessMessage() {
        final String EXPECTED_MESSAGE = "Internal Server Error";
        CoralHomePage homePage = new CoralHomePage(driver);

        CoralHomeResultPage resultsPage = homePage
                .openHomePage()
                .subscribeToNews(EMAIL)
                .clickOnSubscribeButton();

        Assert.assertEquals(resultsPage.getSubscriptionResultText(), EXPECTED_MESSAGE);
        Assert.assertTrue(resultsPage.isSubscribeButtonEnabled());
    }
}
