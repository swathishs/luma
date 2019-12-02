package Data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;

public class DataProvider {

  public static WebDriver driver;
  public static Properties Prop;
  public static FileInputStream file;
  public static WebDriverWait wait;
  
	    
	public static String Prop(String value) throws Exception {
		
		try{
			Prop = new Properties();
			file = new FileInputStream("E:\\eclipse\\Workspace\\Smokesuite\\src\\main\\java\\Data\\Data.properties");
			Prop.load(file);
			return Prop.getProperty(value);
		}
		catch(IOException e){
			
		}
		return value;

	}
	@BeforeSuite(alwaysRun=true)
	public static  void Browserselection() throws Exception {
		
		if (Prop("browser").equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\swathish\\Selenium\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			wait=new WebDriverWait(driver, 30);
			
		} else if (Prop("browser").equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\swathish\\Selenium\\Chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			wait=new WebDriverWait(driver, 30);
			
		} else {
			System.out.println("Issue in initializing Web Browser");
		}
		}
}
