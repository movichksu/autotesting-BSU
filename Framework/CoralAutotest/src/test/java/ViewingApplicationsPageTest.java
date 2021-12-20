import model.Request;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.CoralHomePage;
import page.ViewingApplicationsPage;
import page.ViewingApplicationsResultPage;
import service.RequestCreator;

public class ViewingApplicationsPageTest extends CommonConditions {

    @Test
    public void callRequestErrorText() {
        final String EXPECTED_ERROR_TEXT = "Такая заявка не найдена. Проверьте номер или позвоните в агентство.";
        CoralHomePage homePage = new CoralHomePage(driver);
        Request testRequest= RequestCreator.requestFromProperty();
        ViewingApplicationsPage appsPage = homePage.openAppsPage();

        ViewingApplicationsResultPage resultsPage =
                appsPage.clickOnSearchButton()
                        .enterRequestData(testRequest);

        Assert.assertEquals(resultsPage.getRequestErrorText(), EXPECTED_ERROR_TEXT);
    }
}
