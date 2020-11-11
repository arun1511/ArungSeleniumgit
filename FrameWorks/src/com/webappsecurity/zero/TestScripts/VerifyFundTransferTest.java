package com.webappsecurity.zero.TestScripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.webappseurity.zero.Pages.AccountSummary;
import com.webappseurity.zero.Pages.FundTransfer;
import com.webappseurity.zero.Pages.FundTransferConfirmation;
import com.webappseurity.zero.Pages.FundTransferVerifyPage;
import com.webappseurity.zero.Pages.Login;

import Utils.GenericMethods;

public class VerifyFundTransferTest {

	WebDriver driver;
	@BeforeTest
	public void openApplication() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://zero.webappsecurity.com/login.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test

	public void verifyFundTransfer () throws IOException {
		Login lp = new Login (driver);
		AccountSummary AS = new AccountSummary(driver);
		FundTransfer FT = new FundTransfer(driver);
		FundTransferVerifyPage FTV = new FundTransferVerifyPage(driver);
		FundTransferConfirmation FTC = new FundTransferConfirmation(driver);

		String[][] data = GenericMethods.getData("C:\\SeleniumScreenshots\\TestData.xlsx", "Sheet1");
		
		for (int i=1; i<data.length;i++) {
			lp.applicationLogin(data[i][0],data[i][1]);
			AS.clickFundTransfer();
			FT.fundTransfer(data[i][2],data[i][3]);
			FTV.verifyFundTransfer();
			String actualconfMsg = FTC.getConfirmationMsg();
			String expectedconfMsg = data [i][4];
			Assert.assertEquals(actualconfMsg, expectedconfMsg);
			FTC.logoutFromApp();
			driver.navigate().to("http://zero.webappsecurity.com/login.html");
		}
		


		}
		@AfterTest

		public void closeApplication () {
			driver.close();
		}

	}
