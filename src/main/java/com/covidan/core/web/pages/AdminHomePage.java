package com.covidan.core.web.pages;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.covidan.core.web.WebPage;
import com.covidan.core.web.elements.Link;

public class AdminHomePage extends WebPage<AdminHomePage> {
	
	Logger log = Logger.getLogger("AdminHomePage");

	private static final String PAGE_URL = BASE_URL + "/bidapp/service/view/landing";

	public AdminHomePage(WebDriver driver) {
		super(driver);
	}

	@Override
	public AdminHomePage load() {
		driver.get(PAGE_URL);
		return this;
	}

	@Override
	public boolean isAvailable() {
//		return getManageUsersLink().isAvailable()
//				&& getLogoutLink().isAvailable();
		return true;
	}

	private Link getManageUsersLink() {
		return new Link(driver,
				By.xpath("//a[contains(@href, '/admin_users')]"));
	}

	private Link getLogoutLink() {
		return new Link(driver,
				By.xpath("//a[contains(@href, '/access/logout')]"));
	}

}
