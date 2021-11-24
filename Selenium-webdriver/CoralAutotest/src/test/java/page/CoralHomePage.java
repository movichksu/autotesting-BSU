package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CoralHomePage {
    private WebDriver driver;
    private static final String HOMEPAGE_URL = "https://www.coral.by/";

    private By searchButton = By.xpath("//*[@id=\"searchtour\" and @class='btn search-panel_action-btn __orange']");

    private By errorPopupText = By.xpath("//div[@class='fastsearchinfo-popup_success-text'] ");

    public CoralHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public CoralHomePage openHomePage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public String getErrorText() {
        return findElement(errorPopupText).getText();
    }

    public CoralHomePage search() {
        findElement(searchButton).click();
        return this;
    }

    public WebElement findElement(By locator) {
        WebElement element =
                new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(locator));
        return element;
    }
}
