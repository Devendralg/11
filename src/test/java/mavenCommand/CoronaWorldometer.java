package mavenCommand;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.obs.generic.utilities.WebdriverUtils;

public class CoronaWorldometer {
	@Test
	public void emi() throws InterruptedException
	{
		WebdriverUtils w = new WebdriverUtils();
		WebDriver driver = new ChromeDriver();
		w.maximizeWindow(driver);
		
		w.waitForPageLoad(driver, 30);
		
		driver.get("https://www.worldometers.info/coronavirus/?");
		w.scrollXY(driver, 0, 1200);
		List<WebElement> nodes = driver.findElements(By.xpath("//div[@class=\"tabbable-panel-cases\"]//*[name()='g' and @class=\"highcharts-series highcharts-series-0 highcharts-column-series highcharts-tracker highcharts-dense-data\"]//*[name()='rect']"));
		
		 for(WebElement e : nodes)
		 {
			 w.actionObj(driver).moveToElement(e).perform();
			// Thread.sleep(200);
			 List<WebElement> values = driver.findElements(By.xpath("//*[name()='g' and @class=\"highcharts-label highcharts-tooltip highcharts-color-undefined\"]//*[name()='tspan']"));
			 for(WebElement e1 : values)
			 {
				 System.out.println(e1.getText());
			 }
		 }
		
	}

}
