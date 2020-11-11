package com.webappsecurity.zero.TestScripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.webappseurity.zero.Pages.AccountSummary;
import com.webappseurity.zero.Pages.FundTransfer;
import com.webappseurity.zero.Pages.FundTransferConfirmation;
import com.webappseurity.zero.Pages.FundTransferVerifyPage;
import com.webappseurity.zero.Pages.Login;

import Utils.GenericMethods;

public class VerifyFundTransferTest2 {
	
	WebDriver driver;
	@BeforeTest
	public void openApplication() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://zero.webappsecurity.com/login.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void verifyFundTransfer() throws IOException {
		Login lp = new Login (driver);
		AccountSummary acc = new AccountSummary(driver);
		FundTransfer tf = new FundTransfer(driver);
		FundTransferVerifyPage ftv = new FundTransferVerifyPage(driver);
		FundTransferConfirmation ftc = new FundTransferConfirmation(driver);


		String[][] data = GenericMethods.getData("C:\\SeleniumScreenshots\\TestData.xlsx", "Sheet1");

		for(int i=1;i<data.length;i++) {

			lp.applicationLogin(data[i][0], data[i][1]);
			acc.clickFundTransfer();
			tf.fundTransfer(data[i][2], data[i][3]);
			ftv.verifyFundTransfer();
			String actualMsg = ftc.getConfirmationMsg();
			String expectedMsg = data[i][4];
			Assert.assertEquals(actualMsg, expectedMsg);
			ftc.logoutFromApp();
			
			driver.get("http://zero.webappsecurity.com/login.html");
		}
	}

}
