package com.covidan.core.web.pages;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.covidan.core.web.WebPage;
import com.covidan.core.web.elements.Button;
import com.covidan.core.web.elements.CheckboxInput;
import com.covidan.core.web.elements.TextInput;
import com.covidan.data.objects.User;

public class NewUserRegistrationPage extends WebPage<NewUserRegistrationPage> {
	
	Logger log = Logger.getLogger("NewUserRegistrationPage");

	private static final String PAGE_URL = BASE_URL + "/bidapp/service/view/signup";

	public NewUserRegistrationPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public NewUserRegistrationPage load() {
		driver.get(PAGE_URL);
		return this;
	}

	@Override
	public boolean isAvailable() {
		return getCompanyNameInput().isAvailable() &&
				getFirstNameInput().isAvailable() &&
				getLastNameInput().isAvailable() &&
				getCompanyRoleInput().isAvailable() &&
				getPhoneInput().isAvailable() &&
				getEmailInput().isAvailable() &&
				getPasswordInput().isAvailable() &&
				getConfirmPasswordInput().isAvailable() &&
				getAcceptTermsCheckboxInput().isAvailable() &&
				getLoginButton().isAvailable();
	}
	
	private void fillFormAndClick(User user) {
		getCompanyNameInput().inputText(user.getUsername());
		getPasswordInput().inputText(user.getPassword());
		getLoginButton().click();
	}
	
	private TextInput getCompanyNameInput() {
		return new TextInput(driver, By.id("companyName"));
	}
	
	private TextInput getFirstNameInput() {
		return new TextInput(driver, By.id("firstName"));
	}
	
	private TextInput getLastNameInput() {
		return new TextInput(driver, By.id("lastName"));
	}
	
	private TextInput getCompanyRoleInput() {
		return new TextInput(driver, By.id("title"));
	}
	
	private TextInput getPhoneInput() {
		return new TextInput(driver, By.id("phone"));
	}
	
	private TextInput getEmailInput() {
		return new TextInput(driver, By.id("email"));
	}
	
	private TextInput getPasswordInput() {
		return new TextInput(driver, By.id("password"));
	}
	
	private TextInput getConfirmPasswordInput() {
		return new TextInput(driver, By.id("confirmPassword"));
	}
	
	private CheckboxInput getAcceptTermsCheckboxInput() {
		return new CheckboxInput(driver, By.xpath("//p[contains(., 'accept the terms of use')][@class='center']/input[@type='checkbox']"));
	}
	
	private Button getLoginButton() {
		return new Button(driver, By.id("regBtn"));
	}

}
