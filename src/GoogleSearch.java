import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class GoogleSearch
{
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "X:\\Selenium jar and drivers\\drivers\\ChromeDrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");

        driver.findElement(By.name("q")).sendKeys("Selenium");
        Thread.sleep(3000);

        List<WebElement> allOptions = driver.findElements(By.xpath("//*[contains(text(),'selenium')]"));
        int count = allOptions.size();
        System.out.println("Number of values present in the dropdown is:" + count);

        String expectedValue="selenium interview questions";
        for (WebElement option : allOptions) {
            String text = option.getText();

            if (text.equalsIgnoreCase(expectedValue)) {
                System.out.println(" " + text);
                option.click();
                break;
            }
        }
    }
}
