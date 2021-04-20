package com.htmlcanvasstudio.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CanvasStudio {
	protected WebDriver ldriver = null;
	protected static Actions builder=null;

	public CanvasStudio() {
		// Initialize driver
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		ldriver = new ChromeDriver();

	}

	// Page Objects
	protected By lineButton = By.xpath("//input[@title='Draw a line']");
	protected By rectangleButton = By.xpath("//input[@title='Draw a rectangle']");
	protected By eraserButton = By.xpath("//input[@title='Use eraser']");
	protected By canvas = By.xpath("//canvas[@id='imageView']");

	// Page Actions
	protected WebElement identify(By locator) throws Exception {
		WebElement element = null;
		try {
			element = ldriver.findElement(locator);
		} catch (Exception e) {
			throw new Exception("Failed To Identify The Element:" + locator);
		}
		return element;
	}

	protected void clickOn(By locator) throws Exception {
		try {

			identify(locator).click();
			Thread.sleep(1000);
		} catch (Exception e) {
			throw new Exception("Failed To Click On:" + locator);
		}
	}

	protected void openURL(String url) throws Exception {
		try {

			ldriver.get("http://www.htmlcanvasstudio.com");
			ldriver.manage().window().maximize();
		} catch (Exception e) {
			throw new Exception("Failed to open URL");
		}
	}

	protected void drawCross() throws Exception {
		try {

			clickOn(lineButton);
			builder = new Actions(ldriver);
			// Draw two lines

			builder.click(identify(canvas)).moveByOffset(100, 0).click().perform();

			builder.moveByOffset(-50, -50).click().moveByOffset(0, 100).click().perform();

		} catch (Exception e) {
			throw new Exception("Unable to draw cross" + e.getLocalizedMessage());
		}
	}

	protected void drawRectangle() throws Exception {
		try {

			// Draw a rectangle
			clickOn(rectangleButton);
			builder.moveByOffset(0, 0).moveByOffset(-50, 10).click().moveByOffset(100, 50).click().perform();

		} catch (Exception e) {
			throw new Exception("Unable to draw rectangle" + e.getLocalizedMessage());
		}
	}

	protected void earseLine() throws Exception {
		try {

			// Erase horizontal line
			clickOn(eraserButton);
			builder.clickAndHold(identify(canvas)).moveByOffset(100, 0).perform();

		} catch (Exception e) {
			throw new Exception("Unable to erase" + e.getLocalizedMessage());
		}
	}

}
