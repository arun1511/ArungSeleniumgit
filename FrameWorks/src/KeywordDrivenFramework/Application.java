package KeywordDrivenFramework;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.GenericMethods;

public class Application {
	
	@Test
	public void verifyInvalidLogin () throws IOException {
		String[][] data = GenericMethods.getData("C:\\SeleniumScreenshots\\TestData.xlsx", "Keyword");
		
		Methods mtd = new Methods();
		for (int i=1;i<data.length;i++) {
			switch(data[i][3]) {
			//Making changes to the code after release 1.1
			case "openBrowser":
			mtd.openBrowser();
			break;
			case "maxBrowser":
			mtd.maxBrowserWindow();
			break;
			case "impWait":
			mtd.AddImplicitWait();
			break;
			case "navigateToApp":
			mtd.navigateToApplication(data[i][6]);
			break;
			case "enterInTextBox":
			mtd.enterInTextBoxUserName(data[i][5], data[i][6]);
			break;
			case "click":
			mtd.ClickButton(data[i][4],data[i][5]);
			break;
			case "verifyErrorMessage":
			String actualMsg = mtd.verifyErrorMessage(data[i][4],data[i][5]);
			Assert.assertEquals(actualMsg, data[i][6]);
			break;
			case "closeApp":
			mtd.closeApplication();
			break;
			}
		}
	}

}
