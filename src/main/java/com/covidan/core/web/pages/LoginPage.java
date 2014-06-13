package com.covidan.core.web.pages;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.covidan.core.web.WebPage;
import com.covidan.core.web.elements.Button;
import com.covidan.core.web.elements.TextInput;
import com.covidan.data.objects.User;
import com.covidan.core.web.elements.Text;

public class LoginPage extends WebPage<LoginPage> {
	
	Logger log = Logger.getLogger("LoginPage");

	private static final String PAGE_URL = BASE_URL + "/bidapp/service/view/login";

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public LoginPage load() {
		driver.get(PAGE_URL);
		return this;
	}

	@Override
	public boolean isAvailable() {
		return getUsernameInput().isAvailable() &&
				getPasswordInput().isAvailable() &&
				getLoginButton().isAvailable() &&
				getRegisterNewUserButton().isAvailable();
	}
	
	public AdminHomePage loginAs(User user) {
		fillFormAndClick(user);
		return new AdminHomePage(driver).waitUntilAvailable();
	}

	public LoginPage loginWithWrongCredentialsAs(User user) {
		fillFormAndClick(user);
		return this.waitUntilAvailable();
	}
	
	public String getPageErrorMessage() {
		return new Text(driver, By.xpath("//span[@class='noty_text']"))
			.waitUntilAvailable()
			.getText();
	}
	
	private void fillFormAndClick(User user) {
		getUsernameInput().inputText(user.getUsername());
		getPasswordInput().inputText(user.getPassword());
		getLoginButton().click();
	}
	
	private TextInput getUsernameInput() {
		return new TextInput(driver, By.id("email"));
	}
	
	private TextInput getPasswordInput() {
		return new TextInput(driver, By.id("password"));
	}
	
	private Button getLoginButton() {
		return new Button(driver, By.id("loginBtn"));
	}
	
	private Button getRegisterNewUserButton() {
		return new Button(driver, By.xpath("//a[@class='btn user']"));
	}

	public NewUserRegistrationPage openNewUserRegistrationPage() {
		getRegisterNewUserButton().click();
		NewUserRegistrationPage newUserRegistrationPage = new NewUserRegistrationPage(driver).loadAndWaitUntilAvailable();
		return newUserRegistrationPage;
	}

}
