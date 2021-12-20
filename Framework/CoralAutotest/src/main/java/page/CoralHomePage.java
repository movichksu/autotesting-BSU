package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CoralHomePage extends AbstractPage{

    private static final String HOMEPAGE_URL = "https://www.coral.by/";
    private static final String INFO_PAGE_URL = "https://www.coral.by/poleznaya-informatsiya";

    private By searchButton = By.xpath("//button[@id=\"searchtour\"]");

    // select location
    private By fromInputField = By.xpath("//input[@id=\"fastSearch\"]");
    private By autocompleteSuggestion = By.xpath("//span[@class='autocomplete-suggestion_value'][1]");

    // select date
    private By datePicker = By.xpath("//div[@class='datepick-popup']");
    private By dateInputField = By.xpath("//div[@class='search-panel_calendar']");
    private By selectedDate = By.xpath("//a[@href='javascript:void(0)' and text()='31'][1]");

    // subscribe to news
    private By subscribeButton = By.xpath("//button[text()='Подписаться']");
    private By emailInputField = By.xpath("//input[@class='subscription_input' and @type='email']");
    private By checkbox = By.xpath("//input[@type='checkbox']");

    // currency on each elements
    private By currency = By.xpath("//i[@class='currency icon-byr __short']");
    private By languageSwitcher = By.xpath("//div[@class='lang-switcher']");
    private By languageDropdown = By.xpath("//div[@class='lang-switcher_dropdown']");
    private By languageItem = By.xpath("//span[@class='lang-dropdown_label'][1]");

    public CoralHomePage(WebDriver driver) {
        super(driver);
    }

    public CoralHomePage openHomePage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public ViewingApplicationsPage openAppsPage() {
        driver.get(INFO_PAGE_URL);
        return new ViewingApplicationsPage(driver);
    }

    public CoralHomePage clickOnSearchButton() {
        findElementAndClick(searchButton);
        return this;
    }

    public CoralHomeResultPage clickOnSubscribeButton() {
        findElementAndClick(subscribeButton);
        return new CoralHomeResultPage(driver);
    }

    public CoralHomePage enterPlaceLocation(String location) {
        findElementAndClick(fromInputField).sendKeys(location);
        findElementAndClick(autocompleteSuggestion);
        return this;
    }

    public CoralHomePage enterDepartureDate() {
        findElementAndClick(dateInputField);
        findElementAndWaitForDisplay(datePicker);
        findElementAndClick(selectedDate);
        return this;
    }

    public CoralHomePage subscribeToNews(String email) {
        findElementAndClick(emailInputField).sendKeys(email);
        findElementAndClick(checkbox);
        return this;
    }

    public CoralHomeResultPage selectCurrencyValue() {
        findElementAndClick(languageSwitcher);
        findElementAndWaitForDisplay(languageDropdown);
        findElementAndClick(languageItem);
        return new CoralHomeResultPage(driver);
    }
}
