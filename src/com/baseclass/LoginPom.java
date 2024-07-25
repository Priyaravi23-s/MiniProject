package com.baseclass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPom extends BaseClass{
	
	public LoginPom(){
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "(//input[@placeholder='Search for Products...'])[2]")
	private WebElement search;

	public WebElement getSearch() {
		return search;
	}
	
	@FindBy(xpath = "(//div/h3//span[.='fresho!'])[1]")
	private WebElement send;
	
	public WebElement getSend() {
		return send;
	}
   
	@FindBy(xpath = "(//div/button[.='Add to basket'])[1]")
    private WebElement addCart;

	public WebElement getAddCart() {
		return addCart;
	}
}



