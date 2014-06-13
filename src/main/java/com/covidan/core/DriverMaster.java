package com.covidan.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.covidan.utils.ConfigProperties;

public class DriverMaster {

	private static String chromeDriverProperty = ConfigProperties
			.getSystemProperties("chromeDriverProperty");
	private static String chromeDriverLocation = ConfigProperties
			.getSystemProperties("chromeDriverLocation");
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
			System.setProperty(chromeDriverProperty, chromeDriverLocation);
			ChromeOptions option = new ChromeOptions();
			option.addArguments(chromeDriverMode);
			driver = new ChromeDriver(option);
			break;
		default:
			driver = new FirefoxDriver();
			break;
		}
		return driver;
	}

}
