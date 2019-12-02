package Testcase;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class checkout extends Login {
	boolean pres;
	public void checkoutpage1() throws Exception{
		Thread.sleep(2000);
		try{
			driver.findElement(By.xpath(Prop("checkoutpage1")));
			pres=true;
		}
		catch(NoSuchElementException e ){
			pres=false;
		}
		Assert.assertTrue(pres, "checkout1 page is broken");
	}

	public void checkbox() throws Exception{

		Thread.sleep(3000);
	
		List<WebElement> check = driver.findElements(By.xpath(Prop("Check")));
		Random c = new Random();
		int checkbox = c.nextInt(check.size());
		//action.moveToElement((check).get(checkbox)).click().build().perform();
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", (check).get(checkbox));
	}
	public void next() throws Exception{
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Prop("Next")))).click();
	}

	public void checkoutpage2() throws Exception{
		try{
			driver.findElement(By.xpath(Prop("checkoutpage2")));
			present=true;
		}
		catch(NoSuchElementException e ){
			present=false;
		}
		Assert.assertTrue(present, "checkout2 page is broken");
	}
	public void checkmo() throws Exception{
		Thread.sleep(2000);
		checkPageIsReady();
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", driver.findElement(By.xpath(Prop("Checkmo"))));
	}
	public void placeorder() throws Exception{

		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Prop("placeorder")))).click();
	}
	public void success() throws Exception{

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Prop("test")))).click();
	}
}
