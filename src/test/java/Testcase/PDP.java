package Testcase;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class PDP extends Login{
	boolean present1;

	public void PDPpage() throws Exception{

		try{
			driver.findElement(By.xpath(Prop("More")));
			present=true;
		}
		catch(NoSuchElementException e ){
			present=false;
		}
		Assert.assertTrue(present, "PDP page is broken");
	}

	public void colours() throws Exception{
		Thread.sleep(3000);
		List<WebElement> col = driver.findElements(By.xpath(Prop("Colour")));
		Random random = new Random();
		int radomcolour = random.nextInt(col.size());
		action.moveToElement((col).get(radomcolour)).click().build().perform();
	}

	public void QTY () throws Exception{
		Thread.sleep(4000);
		List<WebElement> Qty = driver.findElements(By.xpath(Prop("qty")));
		Random random = new Random();
		int Quanity = random.nextInt(Qty.size());
		action.moveToElement((Qty).get(Quanity)).click().build().perform();
		((Qty).get(Quanity)).sendKeys(Prop("QTYS"));

	}

	public void Add() throws Exception{

		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Prop("Addtocart")))).click();

	}

	public void itemadded() throws Exception{

		Thread.sleep(3000);
		try{
			driver.findElement(By.xpath(Prop("Message")));
			present1=true;
		}
		catch(NoSuchElementException e ){
			present1=false;
		}
		Assert.assertTrue(present1, "Item is not added to cart");
	}
}
