package Deposit.Task.Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class DriverFactory {
	/***Preconditions:
	 * - Create Drivers directory contains IE, gecko and chrome executable drivers.
	 ***How it works?
	 * 1) This class is to Create WebDriver instance based on the passed argument
	 * 2) It returns Internet explorer instance when the passed argument is IE or ie
	 * 3) It returns FireFox instance when the passed argument is FireFox or firefox
	 * 4) Otherwise, it returns Chrome instance (The default instance)
	 * 5) It maximizes the window
	 * - You can add any other driver by adding its executable file in Driver directory.
	 */
	public static WebDriver getWebDriver(String selectedDriver){
		WebDriver driver = null;
		if(selectedDriver.toUpperCase().equals("IE")){
			System.setProperty("webdriver.ie.driver", "Drivers\\IEDriver.exe");
			driver = new InternetExplorerDriver();
		}else if(selectedDriver.toLowerCase().equals("firefox")){
			System.setProperty("webdriver.gecko.driver", "Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else {
			System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;	
	}
}
