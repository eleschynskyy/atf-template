package com.covidan.core;

import static com.covidan.core.Configuration.setGlobalEnvironment;
import static com.covidan.core.DriverMaster.getDriver;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public abstract class BaseTest {

	protected static WebDriver driver;
	
	@BeforeSuite(alwaysRun = true)
	@Parameters({ "browser", "environment" })
	public void setUp(@Optional("chrome") String browser,
			@Optional("local") String environment) {
		driver = getDriver(browser);
		setGlobalEnvironment(environment);
	}

	@AfterSuite(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

}
