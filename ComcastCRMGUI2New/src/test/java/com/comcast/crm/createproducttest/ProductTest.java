
package com.comcast.crm.createproducttest;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.baseutility.BaseClass;
import com.comcast.crm.createproduct.CreateNewProductPage;
import com.comcast.crm.createproduct.HomePage;
import com.comcast.crm.createproduct.ProductInfoPage;
import com.comcast.crm.createproduct.ProductPage;
import com.comcast.crm.listenerutility.ListenerImplementationClass;

@Listeners(com.comcast.crm.listenerutility.ListenerImplementationClass.class)
public class ProductTest extends BaseClass {
	@Test
	public void createProduct() throws Exception {
		ListenerImplementationClass.test.log(Status.INFO,"Read data from excel");
		String product = eLib.readDataFromExcel("Product", 2, 2) + jLib.getRandomNumber();
		
		ListenerImplementationClass.test.log(Status.INFO,"Navigate to home page");
		HomePage hp = new HomePage(d);
		ListenerImplementationClass.test.log(Status.INFO,"Click on product link");
		hp.getProductLnk().click();

		ListenerImplementationClass.test.log(Status.INFO,"Navigate to product page");
		ProductPage pp = new ProductPage(d);
		pp.getCreateProduct().click();

		ListenerImplementationClass.test.log(Status.INFO,"Create new product ");
		CreateNewProductPage cnpp = new CreateNewProductPage(d);
		cnpp.getProductEdt().sendKeys(product);
		//Assert.assertEquals("sdsd", "sdsfsfsf");
		cnpp.getSaveBtn().click();
		
		ListenerImplementationClass.test.log(Status.INFO,"Created new product "+product);
		ProductInfoPage pip = new ProductInfoPage(d);
		String actProductHeader = pip.getProductHeaderInfo().getText();

		if (actProductHeader.contains(product)) {
			System.out.println("Verification successful");
		} else {
			System.out.println("Verification failed");
		}
		String actProductName = pip.getProductEdtInfo().getText();

		// Assert.assertEquals(actProductName, product);
		// Assert.assertEquals(actProductName, "abc");
		if (actProductName.trim().equals(product)) {
			System.out.println("Verification successful");
		} else {
			System.out.println("Verification failed");
		}
	}

	@Test
	public void createProductWithProductCategory() throws Exception {
		String product = eLib.readDataFromExcel("Product", 2, 2) + jLib.getRandomNumber();
		String proCat = eLib.readDataFromExcel("Product", 2, 0);
		HomePage hp = new HomePage(d);
		hp.getProductLnk().click();

		ProductPage pp = new ProductPage(d);
		pp.getCreateProduct().click();

		CreateNewProductPage cnpp = new CreateNewProductPage(d);
//		cnpp.getProductEdt().sendKeys(product);
//		cnpp.getSaveBtn().click();

		cnpp.productCatdd(product, proCat);
		cnpp.getSaveBtn().click();

	}

	@Test
	public void createProductWithManufacturer() throws Exception {
		String product = eLib.readDataFromExcel("Product", 2, 2) + jLib.getRandomNumber();
		String manufact = eLib.readDataFromExcel("Product", 1, 1);
		HomePage hp = new HomePage(d);
		hp.getProductLnk().click();

		ProductPage pp = new ProductPage(d);
		pp.getCreateProduct().click();

		CreateNewProductPage cnpp = new CreateNewProductPage(d);

		cnpp.manufacturerdd(product, manufact);
		cnpp.getSaveBtn().click();

	}

}
