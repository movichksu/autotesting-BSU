package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CoralHomePage {
    private WebDriver driver;
    private static final String HOMEPAGE_URL = "https://www.coral.by/";

    private By searchButton = By.xpath("//*[@id=\"searchtour\"]");

    private By errorPopupText = By.xpath("//div[@class='fastsearchinfo-popup_success-text'] ");

    private By datePicker = By.xpath("//i[@class='search-panel_calendar-icon datepick-trigger'] ");
    private By readyPickerButton = By.xpath("//a[text()='Готово'] ");
    private By selectDate = By.xpath("/html/body/div[2]/div/div[1]/div[2]/table/tbody/tr[3]/td[5]");

    public CoralHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public CoralHomePage openHomePage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public CoralHomePage openDatePickerAndSelectDate() {
        findElementAndClick(datePicker);
        findElementAndClick(selectDate);
        findElementAndClick(readyPickerButton);
        return this;
    }

    public String getErrorText() {
        return findElementAndClick(errorPopupText).getText();
    }

    public CoralHomePage search() {
        findElementAndClick(searchButton);
        return this;
    }

    public WebElement findElementAndClick(By locator) {
        WebElement element =
                new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(locator));
        element.click();
        return element;
    }
}
