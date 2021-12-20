package page;

import model.Request;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewingApplicationsPage extends AbstractPage {

    private By searchButton = By.xpath("//button[@class='whiteText']");
    private By voucherIdField = By.xpath("//input[@name='voucherId']");
    private By passportField = By.xpath("//input[@name='passportNumber']");

    public ViewingApplicationsPage(WebDriver driver) {
        super(driver);
    }

    public ViewingApplicationsPage clickOnSearchButton() {
        findElementAndClick(searchButton);
        return this;
    }

    public ViewingApplicationsResultPage enterRequestData(Request request) {
        findElementAndClick(voucherIdField).sendKeys(request.getRequestNumber());
        findElementAndClick(passportField).sendKeys(request.getRequestPasswordNumber());
        return new ViewingApplicationsResultPage(driver);
    }
}
