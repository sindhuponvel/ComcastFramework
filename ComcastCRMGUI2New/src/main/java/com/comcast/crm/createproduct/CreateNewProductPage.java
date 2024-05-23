package com.comcast.crm.createproduct;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.javautility.JavaUtility;
import com.comcast.crm.generic.javautility.WebDriverUtility;

public class CreateNewProductPage {

	WebDriver d;

	public CreateNewProductPage(WebDriver d) {
		this.d = d;
		PageFactory.initElements(d, this);
	}

	@FindBy(xpath = "//input[@name='productname']")
	private WebElement productEdt;

	public WebElement getProductEdt() {
		return productEdt;
	}

	public WebElement getProductCategoryDropdown() {
		return productCategoryDropdown;
	}

	public WebElement getSalesStartDateEdt() {
		return salesStartDateEdt;
	}

	public WebElement getSalesEndDateEdt() {
		return salesEndDateEdt;
	}

	public WebElement getManufactureDropdown() {
		return manufactureDropdown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	@FindBy(xpath = "//select[@name='productcategory']")
	private WebElement productCategoryDropdown;

	@FindBy(xpath = "//input[@name='sales_start_date']")
	private WebElement salesStartDateEdt;

	@FindBy(xpath = "//input[@name='sales_end_date']")
	private WebElement salesEndDateEdt;

	@FindBy(xpath = "//select[@name='manufacturer']")
	private WebElement manufactureDropdown;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public void productCatdd(String product, String productdd) {
		WebDriverUtility wLib = new WebDriverUtility();
		productEdt.sendKeys(product);
		wLib.select(productCategoryDropdown, productdd);
	}

	public void manufacturerdd(String product, String manufacdd) {
		WebDriverUtility wLib = new WebDriverUtility();
		productEdt.sendKeys(product);
		wLib.select(manufactureDropdown, manufacdd);
	}

	public void productWithSalesDate(String product) {

		JavaUtility jLib = new JavaUtility();
		productEdt.sendKeys(product);
		String startDate = jLib.getSystemDate();
		salesStartDateEdt.sendKeys(startDate);
		String lastDate = jLib.getReqDate(40);
		salesEndDateEdt.sendKeys(lastDate);
	}
}
