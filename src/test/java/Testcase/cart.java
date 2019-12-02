package Testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class cart extends Login {

	public void minicart() throws Exception{
		Thread.sleep(2000);
		wait=new WebDriverWait(driver, 30);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Prop("Minicart")))).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Prop("View")))).click();
	}

	public void cartpage() throws Exception{
		try{
			driver.findElement(By.xpath(Prop("cartpage")));
			present1=true;
		}
		catch(NoSuchElementException e ){
			present1=false;
		}
		Assert.assertTrue(present1, "Cart page is broken");
	}


	public void proceed() throws Exception{
		checkPageIsReady();
		Thread.sleep(2000);
		action.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Prop("Proceed"))))).click().build().perform();
	}


}
