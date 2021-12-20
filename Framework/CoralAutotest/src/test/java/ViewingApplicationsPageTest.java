import model.Request;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.CoralHomePage;
import page.ViewingApplicationsPage;
import page.ViewingApplicationsResultPage;
import service.RequestCreator;

public class ViewingApplicationsPageTest {
    private WebDriver driver;

    private static final String TURKEY_LOCATION = "Турция";
    private static final String EGYPT_LOCATION = "Египет";
    private static final String ARRIVE_PERIOD = "14.12";

    @BeforeMethod(alwaysRun = true)
    public void setupBrowser() {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");
//        driver = new ChromeDriver(options);
//        driver.manage().window().maximize();

        System.setProperty("webdriver.chrome.driver", "C:\\tools\\driver\\chrome\\chromedriver96.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

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

    @AfterMethod(alwaysRun = true)
    public void tearDownBrowser() {
        //  driver.quit();
    }
}
