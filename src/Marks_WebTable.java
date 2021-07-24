import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Marks_WebTable
{
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "X:\\Selenium jar and drivers\\drivers\\ChromeDrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("file:///C:/Users/Arshad/IdeaProjects/FindElements/src/Marks.html");

        //Count Rows
        List<WebElement> allRows = driver.findElements(By.xpath("//tr"));
        int totalRows = allRows.size();
        System.out.println("Total number of rows in the table is :" + totalRows);

        //Count Columns
        List<WebElement> allColumns = driver.findElements(By.xpath("//th"));
        int totalColumns = allColumns.size();
        System.out.println("total number of column present in the table is :"+ totalColumns);

        //Count cells
        List<WebElement> allCells = driver.findElements(By.xpath("//th|//td"));
        int totalCells = allCells.size();
        System.out.println("total number of cell present in the table is :"+ totalCells);

        int sum =0;
        for(int index = 2; index <=allRows.size()-1; index++) {
            String mark = driver.findElement(By.xpath("//tr[" + index +"]/td[3]")).getText();
            try{
                int number = Integer.parseInt(mark);
                System.out.println(" " + number);
                sum = sum + number;
            }catch (Exception e) {

            }
        }
        System.out.println("Total sum :" + sum);

        String totalMarks = driver.findElement(By.xpath("//tr[" + totalRows + "]/td")).getText();
        int totalMarksInt =Integer.parseInt(totalMarks);

        if(sum == totalMarksInt){
            System.out.println("Total sum of marks are equal to total marks");
        }else{
            System.out.println("Total sum of marks are not equal to total marks");
        }
        driver.close();
    }
}
