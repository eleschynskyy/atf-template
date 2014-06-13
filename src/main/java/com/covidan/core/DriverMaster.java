package com.covidan.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.covidan.utils.ConfigProperties;

public class DriverMaster {

	private static String chromeDriverMode = ConfigProperties
			.getSystemProperties("chromeDriverMode");

	private DriverMaster() {};

	public static WebDriver getDriver(String driverKey) {
		BrowserType browser = BrowserType.get(driverKey);
		WebDriver driver;
		switch (browser) {
		case FIREFOX:
			driver = new FirefoxDriver();
			break;
		case CHROME:
			setChromeDriver();
			ChromeOptions option = new ChromeOptions();
			option.addArguments(chromeDriverMode);
			driver = new ChromeDriver(option);
			break;
		case IE:
			setIEDriver();
			driver = new InternetExplorerDriver();
			break;
		default:
			driver = new FirefoxDriver();
			break;
		}
		return driver;
	}

	private static void setChromeDriver() {
		String os = System.getProperty("os.name").toLowerCase().substring(0, 3);
		String chromeBinary = "src/main/resources/drivers/chrome/chromedriver"
				+ (os.equals("win") ? ".exe" : "");
		System.setProperty("webdriver.chrome.driver", chromeBinary);
	}

	private static void setIEDriver() {
		String os = System.getProperty("os.name").toLowerCase().substring(0, 3);
		String ieBinary = "src/main/resources/drivers/ie/IEDriverServer"
				+ (os.equals("win") ? ".exe" : "");
		System.setProperty("webdriver.ie.driver", ieBinary);
	}

}
