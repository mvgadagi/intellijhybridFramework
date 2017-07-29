package com.hybridFramework.testBase;

import org.openqa.selenium.WebDriver;

public class TestBase {

	WebDriver driver;

	public void getBrowser(String browser) {

		System.out.println(System.getProperty("user.dir"));
		if (System.getProperty("os.name").contains("Window")) {
			if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "/drivers/geckodriver.exe");
			} else if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("usr.dir") + "/drivers/chromedriver.exe");
			}
		}

		else if (System.getProperty("os.name").contains("Mac")) {
			if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.firefox.marionette",
						System.getProperty("user.dir") + "/drivers/geckodriver");
			} else if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("usr.dir") + "/drivers/chromedriver");
			}
		}

	}

	public void loadPropertiesFile() {

	}

	public static void main(String[] args) {

		TestBase test = new TestBase();
		test.getBrowser("firefox");
	}

}
