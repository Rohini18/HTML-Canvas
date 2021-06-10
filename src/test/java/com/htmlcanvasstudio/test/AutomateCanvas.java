package com.htmlcanvasstudio.test;

import java.sql.Driver;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.htmlcanvasstudio.pages.CanvasStudio;

public class AutomateCanvas extends CanvasStudio {

	@BeforeSuite
	public void openURL() {
		try {
			openURL("http://www.htmlcanvasstudio.com");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();;
		}
		
	}

	@Test
	public void testCanvas() {
		try {
			drawCross();
			drawRectangle();
			earseLine();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	@AfterSuite
	public void close() {
		 ldriver.close();
	}
}
