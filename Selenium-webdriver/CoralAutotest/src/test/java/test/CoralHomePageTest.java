package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.CoralHomePage;

public class CoralHomePageTest {

    private WebDriver driver;
    private ChromeOptions option = new ChromeOptions().setHeadless(true);

    @BeforeMethod(alwaysRun = true)
    public void setupBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\tools\\driver\\chrome\\chromedriver95.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void enterSameDepartureAndArrivalPlaces() {
        final String EXPECTED_ERROR_TEXT = "Чтобы начать поиск, введите страну, город или отель.";
        CoralHomePage homePage = new CoralHomePage(driver);

        CoralHomePage resultsPage = homePage.openHomePage()
                .openDatePickerAndSelectDate()
                .search();

       Assert.assertEquals(resultsPage.getErrorText(), EXPECTED_ERROR_TEXT);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownBrowser() {
        driver.quit();
    }
}
