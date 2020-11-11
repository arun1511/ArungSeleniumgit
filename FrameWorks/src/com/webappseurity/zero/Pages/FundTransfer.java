package com.webappseurity.zero.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FundTransfer {
	
	@FindBy(id= "tf_fromAccountId")
	private WebElement fromAcct;
	
	@FindBy(id= "tf_toAccountId")
	private WebElement toAcct;
	
	@FindBy(id = "tf_amount")
	private WebElement Amount;
	
	@FindBy(id="tf_description")
	private WebElement discr;
	
	@FindBy(id ="btn_submit")
	private WebElement continuebtn;

	public FundTransfer(WebDriver driver) {
		PageFactory.initElements(driver, this);
	
	}
	
	public void fundTransfer (String amount, String description) {
		
		Select fromActDD = new Select(fromAcct);
		fromActDD.selectByIndex(2);
		
		Select toAcctDD = new Select(toAcct);
		toAcctDD.selectByIndex(3);
		
		Amount.sendKeys(amount);
		discr.sendKeys(description);
		
		continuebtn.click();
		
	}
	
}
