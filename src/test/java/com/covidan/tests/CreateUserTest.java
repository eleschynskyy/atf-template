package com.covidan.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import com.covidan.core.BaseTest;
import com.covidan.core.CsvDataProvider;
import com.covidan.core.web.pages.LoginPage;
import com.covidan.core.web.pages.NewUserRegistrationPage;
import com.covidan.data.objects.Company;
import com.covidan.data.objects.ErrorMessage;
import com.covidan.data.objects.User;

public class CreateUserTest extends BaseTest {
	
//	@Test(dataProvider = "ProvideCompanyAndUser", dataProviderClass = CsvDataProvider.class)
	public void createNewUserSucceed(User user, Company company) {
		NewUserRegistrationPage  newUserRegistrationPage = new LoginPage(driver)
			.loadAndWaitUntilAvailable()
			.openNewUserRegistrationPage();
//		assertThat("Page Error Message should be as expected",
//				loginPage.getPageErrorMessage(),equalTo(msg.getMessage()));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
