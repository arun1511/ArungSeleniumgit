package com.webappseurity.zero.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FundTransferVerifyPage {
	
	@FindBy(id="btn_submit")
	private WebElement submit;
	

	public FundTransferVerifyPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
		
		public void verifyFundTransfer () {
			submit.click();
		}
	

}
