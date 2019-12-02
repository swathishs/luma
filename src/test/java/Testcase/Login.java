package Testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import Data.DataProvider;

public class Login extends DataProvider{
	boolean present,present1;
	Actions action = new Actions(driver);
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public  void Signin() throws Exception{

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Prop("Signin")))).click();
	}


	public void validateHomepage()throws Exception{


		if (driver.getCurrentUrl().contains("http://magento2demo.firebearstudio.com")){

		}
		else{
			driver.get(Prop("Homepage"));
		}	
	}


	public void loginpage() throws Exception{

		try
		{
			driver.findElement(By.xpath(Prop("Header")));
			present=true;
		}
		catch(NoSuchElementException e){
			present=false;
		}

		Assert.assertTrue(present,"Login page is broken/not loaded" );
	}

	public void checkPageIsReady() {

		JavascriptExecutor js = ((JavascriptExecutor)driver);


		//Initially bellow given if condition will check ready state of page.
		if (js.executeScript("return document.readyState").toString().equals("complete")){ 

			return; 
		} 

		//This loop will rotate for 25 times to check If page Is ready after every 1 second.
		//You can replace your value with 25 If you wants to Increase or decrease wait time.
		for (int i=0; i<30; i++){ 
			try {
				Thread.sleep(1000);
			}catch (InterruptedException e) {} 
			//To check page ready state.
			if (js.executeScript("return document.readyState").toString().equals("complete")){ 
				break; 
			}   
		}
	}



	public void credentials() throws Exception{

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Prop("userxpath")))).sendKeys(Prop("Username"));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Prop("Passxpath")))).sendKeys(Prop("Password"));

	}
	public void myaccount() throws Exception{
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Prop("sign")))).click();
	}

	public void dashboard() throws Exception{
		try
		{

			driver.findElement(By.xpath(Prop("Home")));
			present1=true;
		}
		catch(NoSuchElementException e){
			present1=false;
		}
		Assert.assertTrue(present1,"Homepage page is borken" );
		String HomeName=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Prop.getProperty("Home")))).getText();
		Assert.assertEquals(HomeName, "FireBear Studio","Homepage Should have My Account");
	}
}

