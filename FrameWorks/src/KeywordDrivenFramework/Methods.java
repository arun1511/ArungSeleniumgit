package KeywordDrivenFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Methods {

	WebDriver driver;
	public void openBrowser () {
		driver = new ChromeDriver();
	}
	
	public void maxBrowserWindow () {
	 driver.manage().window().maximize();;
	}
	
	public void AddImplicitWait () {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	public void navigateToApplication (String url) {
		driver.get(url);
	}
	public void enterInTextBoxUserName (String locvalue,String testdata) {
		driver.findElement(By.id(locvalue)).sendKeys(testdata);
		
	}
	public void ClickButton (String loc,String locvalue) {
		if(loc.equals("name")) {
	 driver.findElement(By.name(locvalue)).click();
	}
		else if(loc.equals("xpath")) {
			driver.findElement(By.xpath(locvalue)).click();
		}
			
		}
	public String verifyErrorMessage (String locate, String locvalue) {
		
		String ErrorMsg=null;
	
		if(locate.equals("cssSelector")) {
		ErrorMsg = driver.findElement(By.cssSelector(locvalue)).getText();
	}
		
	else if(locate.equals("id")) {
		ErrorMsg = driver.findElement(By.id(locvalue)).getText();
		
	}
		return ErrorMsg;
	}
	public void closeApplication () {
		driver.close();
	}

}
