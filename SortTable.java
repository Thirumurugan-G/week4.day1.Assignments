package week4.day1.Assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SortTable 
{
	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/sorttable.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		ArrayList<String> namelist=new ArrayList<String>();
		ArrayList<String> namelist1=new ArrayList<String>();
		WebElement table=driver.findElement(By.id("table_id_wrapper"));
		List<WebElement> row=table.findElements(By.tagName("tr"));
		System.out.println("\nBefore sorted\n");
		for(int i=1;i<row.size();i++)
		{
			WebElement column=row.get(i);
			List<WebElement> columnList=column.findElements(By.tagName("td"));
			String name=columnList.get(1).getText();
			namelist.add(name);
			System.out.println(name);
		}
		Collections.sort(namelist);
		System.out.println("\nAfter sorted\n"+namelist);
		driver.findElement(By.className("sorting_asc")).click();
		WebElement table1=driver.findElement(By.id("table_id_wrapper"));
		List<WebElement> row1=table1.findElements(By.tagName("tr"));
		System.out.println("\nAfter clicking Names header\n");
		for(int i=1;i<row1.size();i++)
		{
			WebElement column1=row1.get(i);
			List<WebElement> columnList1=column1.findElements(By.tagName("td"));
			String name1=columnList1.get(1).getText();
			namelist1.add(name1);
			System.out.println(name1);
		}
		if(namelist.equals(namelist1))
		{
			System.out.println("\nIt is sorted");
		}
		else
		{
			System.out.println("\nIt is not sorted");
		}
	}
}
