import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Product_Webtable
{
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "X:\\Selenium jar and drivers\\drivers\\ChromeDrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("file:///C:/Users/Arshad/IdeaProjects/FindElements/src/Product.html");

        //Count Rows
        List<WebElement> allRows = driver.findElements(By.xpath("//tr"));
        int totalRows = allRows.size();
        System.out.println("total number of rows present in the table is :"+ totalRows);

        //Count Columns
        List<WebElement> allColumns = driver.findElements(By.xpath("//th"));
        int totalColumns = allColumns.size();
        System.out.println("total number of column present in the table is :"+ totalColumns);

        //Count Cells
        List<WebElement> allCells = driver.findElements(By.xpath("//th|//td"));
        int totalCells = allCells.size();
        System.out.println("total number of cell present in the table is :"+ totalCells);

        int countNumberValue = 0;
        int sum=0;
        for(WebElement cell:allCells) {
            String cellValue = cell.getText();
            try {
               int number = Integer.parseInt(cellValue);
                System.out.println(""+number);
                countNumberValue++;
                sum = sum + number;
            } catch (Exception e) {

            }
        }
        System.out.println("Total count of numeric values is :"+countNumberValue);
        System.out.println("Total sum of all the numeric values is :"+sum);

        driver.close();
    }
}
