package mavenCommand;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.obs.generic.utilities.WebdriverUtils;

public class EmiCalculator {
	
	@Test
	public void emi()
	{
		WebdriverUtils w = new WebdriverUtils();
		WebDriver driver = new ChromeDriver();
		w.maximizeWindow(driver);
		driver.get("https://emicalculator.net/");
		
		w.waitForPageLoad(driver, 40);
		
		w.scrollXY(driver, 0, 1300);
		
		List<WebElement> nodes = driver.findElements(By.xpath("//*[name()='g'  and @class=\"highcharts-markers highcharts-series-2 highcharts-spline-series highcharts-tracker\"]/*[name()='path']"));
		Actions act = new Actions(driver);
		for(WebElement e : nodes)
		{
			act.moveToElement(e).perform();
			//String nodeValues = driver.findElement(By.xpath("//*[name()='g' and @class=\"highcharts-label highcharts-tooltip highcharts-color-undefined\"]//*[name()='text']")).getText();
			 List<WebElement> nodeValues = driver.findElements(By.xpath("//*[name()='g' and @class=\"highcharts-label highcharts-tooltip highcharts-color-undefined\"]//*[name()='tspan']"));
			for(WebElement e1 : nodeValues)
			{
			System.out.println(e1.getText());
			}
			
			System.out.println();
			System.out.println();
		}
		
		driver.quit();
	}

}
