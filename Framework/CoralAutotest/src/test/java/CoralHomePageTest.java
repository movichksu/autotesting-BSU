import model.Currency;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.CoralHomePage;
import page.CoralHomeResultPage;

public class CoralHomePageTest extends CommonConditions {

    private static final String TURKEY_LOCATION = "Турция";
    private static final String EGYPT_LOCATION = "Египет";
    private static final String ARRIVE_PERIOD = "31.12";

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
}
