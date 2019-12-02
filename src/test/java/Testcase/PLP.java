package Testcase;



import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class PLP extends Login{
	boolean present;

	public void Fluids() throws Exception{

		Thread.sleep(2000);
		action.moveToElement(driver.findElement(By.xpath(Prop("Men")))).build().perform();
		Thread.sleep(2000);
		action.moveToElement(driver.findElement(By.xpath(Prop("Tops")))).build().perform();	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Prop("Jackets")))).click();
	}

	public void Plppage() throws Exception{

		try{
			driver.findElement(By.xpath(Prop("Header")));
			present=true;
		}
		catch(NoSuchElementException e){
			present=false;
		}
		Assert.assertTrue(present, "PLP page is broken");
	}
	public void add() throws Exception{

		List<WebElement> allProducts = driver.findElements(By.xpath(Prop("mousemovess")));
		Random rand = new Random();
		int randomProduct = rand.nextInt(allProducts.size());

		js.executeScript("arguments[0].scrollIntoView();",allProducts.get(randomProduct));
		action.moveToElement((allProducts).get(randomProduct)).click().build().perform();
	}

}
