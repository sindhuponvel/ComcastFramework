package com.comcast.crm.createproduct;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class HomePage {
	WebDriver d;

	public HomePage(WebDriver d) {
		this.d = d;
		PageFactory.initElements(d, this);
	}

	@FindBy(xpath = "//a[text()='Organizations']")
	private WebElement OrgLnk;

	@FindBy(xpath = "//a[text()='Contacts']")
	private WebElement contactLnk;

	@FindBy(xpath = "//a[text()='Products']")
	private WebElement productLnk;

	@FindBy(xpath = "//a[text()='More']")
	private WebElement moreLnk;

	@FindBy(xpath = "//a[text()='Campaigns']")
	private WebElement campaignLnk;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;

	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signOutLnk;

	public void logOut() {
		WebDriverUtility wLib = new WebDriverUtility();

		wLib.moveMouseOnElement(d, adminImg);
		signOutLnk.click();
	}

	public WebElement getSignOutLnk() {
		return signOutLnk;
	}

	public void campaignLnk() {
		WebDriverUtility wLib = new WebDriverUtility();
		wLib.moveMouseOnElement(d, adminImg);
		campaignLnk.click();
	}

	public WebElement getOrgLnk() {
		return OrgLnk;
	}

	public WebElement getContactLnk() {
		return contactLnk;
	}

	public WebElement getProductLnk() {
		return productLnk;
	}

	public WebElement getMoreLnk() {
		return moreLnk;
	}

	public WebElement getCampaignLnk() {
		return campaignLnk;
	}

}
