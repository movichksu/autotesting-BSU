import model.Currency;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.CoralHomePage;
import page.CoralHomeResultPage;

public class CoralHomePageTest extends CommonConditions {

    private static final String TURKEY_LOCATION = "Турция";
    private static final String EGYPT_LOCATION = "Египет";
    private static final String ARRIVE_PERIOD = "31.12";
    private static final String EMAIL = "test@gmail.com";

    @Test
    public void callPopupWithErrorText() {
        final String EXPECTED_ERROR_TEXT = "Чтобы начать поиск, введите страну, город или отель.";
        CoralHomePage homePage = new CoralHomePage(driver);
        CoralHomeResultPage resultPage = new CoralHomeResultPage(driver);

        homePage.openHomePage()
                .clickOnSearchButton();

        Assert.assertEquals(resultPage.getPopupErrorText(), EXPECTED_ERROR_TEXT);
    }

    @Test
    public void callFlightInfoErrorText() {
        final String EXPECTED_ERROR_INFO_TEXT = ARRIVE_PERIOD + ".2021 - из Минска нет рейсов в выбранном вами направлении";
        CoralHomePage homePage = new CoralHomePage(driver);
        CoralHomeResultPage resultPage = new CoralHomeResultPage(driver);

        homePage.openHomePage()
                .enterDepartureDate()
                .enterPlaceLocation(EGYPT_LOCATION);

        Assert.assertEquals(resultPage.getFlightInfoErrorText(), EXPECTED_ERROR_INFO_TEXT);
        Assert.assertFalse(resultPage.isSearchButtonEnabled());
    }

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
