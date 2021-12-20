package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewingApplicationsResultPage extends AbstractPage{

    private By requestErrorText = By.xpath("//div[@class='info_form_text'] ");

    public ViewingApplicationsResultPage(WebDriver driver) {
        super(driver);
    }

    public String getRequestErrorText() {
        return findElementAndWaitForDisplay(requestErrorText).getText();
    }
}
