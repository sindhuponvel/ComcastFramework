package com.comcast.crm.generic.javautility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	public void waitForPageToLoad(WebDriver d )
	{
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void waitForElementPresent(WebDriver d,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(d,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void navigateWindowOnUrl(WebDriver d,String partialUrl)
	{
		Set<String> set= d.getWindowHandles();
		Iterator<String> it= set.iterator();
		while(it.hasNext())
		{
			String windowID=it.next();
			d.switchTo().window(windowID);
			String actUrl=d.getCurrentUrl();
			if(actUrl.contains(partialUrl))
			{
				break;
			}
		}
	}

	public void navigateWindowOnTitle(WebDriver d,String partialTitle)
	{
		Set<String> set= d.getWindowHandles();
		Iterator<String> it= set.iterator();
		while(it.hasNext())
		{
			String windowID=it.next();
			d.switchTo().window(windowID);
			String actTitle=d.getTitle();
			if(actTitle.contains(partialTitle))
			{
				break;
			}
		}
	}
	
	public void select(WebElement element,String text)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	public void select(WebElement element,int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	public void frame(WebDriver d,String name)
	{
		d.switchTo().frame(name);
	}
	
	public void frame(WebDriver d,WebElement element)
	{
		d.switchTo().frame(element);
	}
	
	public void frame(WebDriver d,int index)
	{
		d.switchTo().frame(index);
	}
	
	public void alertAndAccept(WebDriver d)
	{
		
     d.switchTo().alert().accept();
	
	}
	
	public void alertAndDismiss(WebDriver d)
	{
		d.switchTo().alert().dismiss();
	}
	
	public void moveToElement(WebDriver d,WebElement element)
	{
		Actions act = new Actions(d);
		act.moveToElement(element).perform();
	}

	public void doubleClick(WebDriver d,WebElement element)
	{
		Actions act = new Actions(d);
		act.doubleClick(element).perform();
	}
	public void contextClick(WebDriver d,WebElement element)
	{
		Actions act = new Actions(d);
		act.contextClick(element).perform();
	}
	
	public void dragAndDrop(WebDriver d,WebElement ele1,WebElement ele2)
	{
		Actions act = new Actions(d);
		act.dragAndDrop(ele1,ele2).perform();
	}
			

}
