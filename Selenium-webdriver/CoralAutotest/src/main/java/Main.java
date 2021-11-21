import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\tools\\driver\\chrome\\chromedriver95.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.coral.by/");
    }
}
