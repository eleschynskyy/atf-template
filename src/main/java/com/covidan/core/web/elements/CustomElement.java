package com.covidan.core.web.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.covidan.core.web.WebComponent;

public class CustomElement extends WebComponent<CustomElement> {

	public CustomElement(WebDriver driver, By findByMethod) {
		super(driver, findByMethod);
	}
	
}
