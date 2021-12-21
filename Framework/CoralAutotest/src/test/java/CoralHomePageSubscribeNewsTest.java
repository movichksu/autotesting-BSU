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
        final String EXPECTED_MESSAGE = "Вы подписаны на новости!";
        CoralHomePage homePage = new CoralHomePage(driver);

        CoralHomeResultPage resultsPage = homePage
                .openHomePage()
                .subscribeToNews(EMAIL)
                .clickOnSubscribeButton();

        Assert.assertTrue(resultsPage.isSubscribeButtonEnabled());
        Assert.assertEquals(resultsPage.getSubscriptionResultText(), EXPECTED_MESSAGE);
    }
}
