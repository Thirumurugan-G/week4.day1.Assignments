package week4.day1.Assignments;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Table 
{

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/table.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement tableElement=driver.findElement(By.id("table_id"));
		List<WebElement> rowList=tableElement.findElements(By.tagName("tr"));
		System.out.println("Number of rows is : "+rowList.size());
		WebElement row1=rowList.get(1);
		List<WebElement> columnList=row1.findElements(By.tagName("td"));
		System.out.println("Number of column is : "+columnList.size());
		for(int i=0;i<rowList.size();i++)
		{
			WebElement row=rowList.get(i);
			List<WebElement> column=row.findElements(By.tagName("td"));
			for(int j=0;j<column.size();j++)
			if(column.get(j).getText().contains("Learn to interact with Elements"))
			{
				System.out.println("The progress value is "+column.get(1).getText());
			}
			else if(column.get(j).getText().equals("30%"))
			{
				driver.findElement(By.xpath("(//input)[3]")).click();
			}
		}
	}
}
