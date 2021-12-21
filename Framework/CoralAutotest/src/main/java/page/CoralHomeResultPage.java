package page;

import model.Currency;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CoralHomeResultPage extends AbstractPage{

    private By searchButton = By.xpath("//button[@id=\"searchtour\"]");

    private By subscribeButton = By.xpath("//button[@class='subscription_btn __blue disabledBtn']");

    private By flightErrorInfo = By.xpath("//div[@class='search-panel_flight_info']");

    private By errorPopupText = By.xpath("//div[@class='fastsearchinfo-popup_success-text'] ");

    private By subscriptionMessage = By.xpath("//div[@id='subscriptionMessage']/span");

    private By infoHotelItem = By.xpath("//*[@class='infoHotel']");
    private By dollarIconItem = By.xpath("//span[@class='hotel-info_price']//i[@class='currency icon-dollar']");
    private By euroIconItem = By.xpath("//span[@class='hotel-info_price']//i[@class='currency icon-euro']");
    private By blrIconItem = By.xpath("//span[@class='hotel-info_price']//i[@class='currency icon-byr __short']");

    public CoralHomeResultPage(WebDriver driver) {
        super(driver);
    }

    public Boolean isSearchButtonEnabled() {
        return findElement(searchButton).isEnabled();
    }

    public Boolean isSubscribeButtonEnabled() {
        return findElement(subscribeButton).isEnabled();
    }

    public String getFlightInfoErrorText() {
        return findElementAndWaitForDisplay(flightErrorInfo).getText();
    }

    public String getPopupErrorText() {
        return findElementAndGetText(errorPopupText);
    }

    public String getSubscriptionResultText() {
        return findElementAndWaitForDisplay(subscriptionMessage).getText();
    }

    public int getCountOfHotelsWithPrice() {
        List<WebElement> currencyItems = findAll(infoHotelItem);
        return currencyItems.size();
    }

    public int getCountOfHotelsWithValue(Currency currency) {
        int countElements = 0;
        switch (currency) {
            case BYN: countElements = getCountOfCurrencyItemsWithBynValue();
                      break;
            case EUR: countElements = getCountOfCurrencyItemsWithEuroValue();
                      break;
            case USD: countElements = getCountOfCurrencyItemsWithDollarValue();
                      break;
        }
        return countElements;
    }

    public int getCountOfCurrencyItemsWithDollarValue() {
        List<WebElement> dollarItems = findAll(dollarIconItem);
        return dollarItems.size();
    }

    public int getCountOfCurrencyItemsWithEuroValue() {
        List<WebElement> dollarItems = findAll(euroIconItem);
        return dollarItems.size();
    }

    public int getCountOfCurrencyItemsWithBynValue() {
        List<WebElement> dollarItems = findAll(blrIconItem);
        return dollarItems.size();
    }
}
