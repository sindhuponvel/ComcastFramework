package com.comcast.crm.createproduct;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.baseutility.BaseClass;
/**
 * @author arjun
 * contains Login Page  elements and business libraries like login()
 * 
 * 
 * 
 */
public class LoginPage extends BaseClass {

	WebDriver d;
	public  LoginPage(WebDriver d)
	{
		this.d=d;
		PageFactory.initElements(d,this);
	}
	
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	
	@FindBy(xpath="//input[@name='user_password']")
	private WebElement passwordEdt;
	
	@FindBy(xpath="//input[@id='submitButton']")
	private WebElement loginBtn;
	
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	/**
	 * 
	 * login to application based on username and password arguments
	 * 
	 * 
	 * @param username
	 * @param password
	 */
	public void loginToApp(String username,String password)
	{
		wLib.waitForPageToLoad(d);
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}
	
}
