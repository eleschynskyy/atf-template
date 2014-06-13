package com.covidan.core.web;

import static com.covidan.core.Configuration.getConfig;

import org.openqa.selenium.WebDriver;

import com.covidan.core.Configuration;
import com.covidan.core.Environment;

public abstract class WebPage<T extends WebPage<T>> extends Component<T> {

	private static final Configuration CONFIG = getConfig();
	private static final Environment ENVIRONMENT = CONFIG
			.getEnvironmentSettings();
	protected static final String BASE_URL = ENVIRONMENT.scheme + "://"
			+ ENVIRONMENT.host;

	public WebPage(WebDriver driver) {
		super(driver);
	}

	public abstract T load();

	public T loadAndWaitUntilAvailable() {
		load();
		return waitUntilAvailable();
	}

}
