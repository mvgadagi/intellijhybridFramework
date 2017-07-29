package com.hybridFramework.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TestBase {

	public WebDriver driver;
	public Properties OR;
	public File f1;
	public FileInputStream file;

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

	public void getScreenshot(String imageName) throws IOException {

		if (imageName.equals("")) {
			imageName = "blank";
		}
		File image = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String imageLocation = System.getProperty("user.dir") + "\\src\\main\\java\\com\\hybridFramework\\screenshot\\";
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String actualImageName = imageLocation + "_" + formater.format(calendar.getTime()) + ".png";
		File destFile = new File(actualImageName);
		FileUtils.copyFile(image, destFile);

	}

	public void loadPropertiesFile() throws IOException {

		OR = new Properties();
		f1 = new File(
				System.getProperty("user.dir") + "\\src\\main\\java\\com\\hybridFramework\\config\\config.properties");
		file = new FileInputStream(f1);
		OR.load(file);

		f1 = new File(
				System.getProperty("user.dir") + "\\src\\main\\java\\com\\hybridFramework\\config\\or.properties");
		file = new FileInputStream(f1);
		OR.load(file);
	}

	public static void main(String[] args) throws IOException {

		TestBase test = new TestBase();
		test.getBrowser("firefox");
		test.loadPropertiesFile();
		System.out.println(test.OR.getProperty("Name"));
	}

}
