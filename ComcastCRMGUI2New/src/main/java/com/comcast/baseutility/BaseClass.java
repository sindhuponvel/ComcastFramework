package com.comcast.baseutility;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.comcast.crm.createproduct.HomePage;
import com.comcast.crm.createproduct.LoginPage;
import com.comcast.crm.generic.javautility.JavaUtility;
import com.comcast.crm.generic.javautility.WebDriverUtility;


public class BaseClass {
	public com.comcast.crm.genericutility.FileUtility fLib = new com.comcast.crm.genericutility.FileUtility();
	public com.comcast.crm.genericutility.ExcelUtility eLib = new com.comcast.crm.genericutility.ExcelUtility();
	public com.comcast.crm.genericutility.DatabaseUtility dLib = new com.comcast.crm.genericutility.DatabaseUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public WebDriver d;
	public static WebDriver sdriver;

	@BeforeSuite
	public void configBS() throws SQLException {
		System.out.println("======Connect to db ,Report config====");
		dLib.getDBConnection();
	}

	@BeforeClass
	public void configBC() throws Exception {
		System.out.println("Launch the browser");
		String BROWSER = fLib.readDataFromProperties("Browser");
		if (BROWSER.contains("Chrome")) {
			d = new ChromeDriver();
		} else if (BROWSER.contains("Edge")) {
			d = new EdgeDriver();
		} else {
			d = new FirefoxDriver();
		}
		sdriver =d;
	}

	@BeforeMethod
	public void configBM() throws Exception {
		System.out.println("Login to application");
		String URL = fLib.readDataFromProperties("Url");
		d.get(URL);
		String USERNAME = fLib.readDataFromProperties("Username");
		String PASSWORD = fLib.readDataFromProperties("Password");
		LoginPage lp = new LoginPage(d);
		lp.loginToApp(USERNAME, PASSWORD);

	}

	@AfterMethod
	public void configAM() {
		System.out.println("Logout of the application");
		HomePage hp = new HomePage(d);
		hp.logOut();
	}

	@AfterClass
	public void configAC() {
		System.out.println("Closing browser");
		d.quit();

	}

	@AfterSuite
	public void congigAS() {
		System.out.println("Disconnected from database");
		dLib.closeDBConnection();
	}

}
