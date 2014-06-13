package com.covidan.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import com.covidan.core.BaseTest;
import com.covidan.core.CsvDataProvider;
import com.covidan.core.web.pages.LoginPage;
import com.covidan.data.objects.ErrorMessage;
import com.covidan.data.objects.User;
//import org.testng.annotations.AfterMethod;

public class LoginTest extends BaseTest {
	
	@Test(dataProvider = "CsvDataProviderAsObject", dataProviderClass = CsvDataProvider.class)
	public void attemptToLoginWithWrongCredentialsFails(User user, ErrorMessage msg) {
		LoginPage loginPage = new LoginPage(driver)
			.loadAndWaitUntilAvailable()
			.loginWithWrongCredentialsAs(user);
		assertThat("Page Error Message should be as expected",
				loginPage.getPageErrorMessage(),equalTo(msg.getMessage()));
//		try {
//			Thread.sleep(500);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
	}
	
}
