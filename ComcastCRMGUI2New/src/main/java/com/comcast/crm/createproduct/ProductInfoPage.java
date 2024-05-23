package com.comcast.crm.createproduct;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoPage {
	WebDriver d;
	public ProductInfoPage(WebDriver d)
	{
		this.d=d;
		PageFactory.initElements(d,this);
	}
	
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement productHeaderInfo;
	
	
	@FindBy(xpath="//td[@id='mouseArea_Product Name']")
	private WebElement productEdtInfo;
	
	public WebElement getProductHeaderInfo() {
		return productHeaderInfo;
	}

	public WebElement getProductEdtInfo() {
		return productEdtInfo;
	}

	
	
	
	

}
