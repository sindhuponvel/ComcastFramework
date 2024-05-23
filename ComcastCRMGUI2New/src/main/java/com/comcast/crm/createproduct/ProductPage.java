package com.comcast.crm.createproduct;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	WebDriver d;

	public ProductPage(WebDriver d) {
		this.d = d;
		PageFactory.initElements(d, this);
	}

	@FindBy(xpath = "//img[@alt='Create Product...']")
	private WebElement createProduct;

	public WebElement getCreateProduct() {
		return createProduct;
	}

}
