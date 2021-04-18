package org.ao.page;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static org.testng.Assert.assertEquals;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.ao.generic.ExtentTestManager;
import org.ao.generic.GenericFunctions;
import org.ao.pageobject.SearchProductPageObject;
import org.ao.startup.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

public class SearchProductPage extends BaseTest {
	
	//WebDriverWait wait = new WebDriverWait(driver,10); //maximum wait time
	SearchProductPageObject SearchProductPageObj=PageFactory.initElements(driver, SearchProductPageObject.class);

		//Search Product
		 public void searchProduct() throws Exception {
			try {
				ExtentTestManager.getTest().log(LogStatus.INFO, "User keys in to search bar");
				GenericFunctions.waitForElementToAppear(SearchProductPageObj.searchBar);
				SearchProductPageObj.searchBar.sendKeys("Washing Machines");
				GenericFunctions.waitWebDriver(3000);

				//Search Bar Assertion
				String expectedText = "Washing Machines";
				String actualText = SearchProductPageObj.searchBar.getAttribute("value");
				Assert.assertEquals(actualText,expectedText);
				Assert.assertTrue(true, "User is able to key in to search bar successfully");
				ExtentTestManager.getTest().log(LogStatus.PASS, "User is able to key in to search bar successfully");
									
				SearchProductPageObj.searchButton.click();
				GenericFunctions.waitWebDriver(3000);
				
			} catch (Exception e) {
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to key in to search bar");
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: "+e.getLocalizedMessage());
				Assert.fail("Failed to key in to search bar");
			}
			
		 }
	 
	    //Select Brand
		 public void selectBrand() throws Exception {
			try {
				ExtentTestManager.getTest().log(LogStatus.INFO, "User selects a brand");
				GenericFunctions.waitForElementToAppear(SearchProductPageObj.searchByBrand);
				SearchProductPageObj.searchByBrand.click();
				GenericFunctions.waitWebDriver(3000);
				
				//Select Brand Assertion
				String expectedText = "Bosch";
				String actualText = SearchProductPageObj.selectedBrand.getText();
				Assert.assertEquals(actualText,expectedText);
				Assert.assertTrue(true, "User is able to select brand successfully");
				ExtentTestManager.getTest().log(LogStatus.PASS, "User is able to select brand successfully");
				
			} catch (Exception e) {
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to select a brand");
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: "+e.getLocalizedMessage());
				Assert.fail("Failed to select a brand");
			}
			
		 }
		 
		//Filter Products as per the Fit Type
		 public void filterProduct() throws Exception {
			try {
							
				//Choose Fit Type filter
				ExtentTestManager.getTest().log(LogStatus.INFO, "User selects filter Fit Type");
				GenericFunctions.waitForElementToAppear(SearchProductPageObj.fitType);
				SearchProductPageObj.fitType.click();
				GenericFunctions.waitWebDriver(2000);
				
			} catch (Exception e) {
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to filter product");
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: "+e.getLocalizedMessage());
				//Assert.fail("Failed to filter product");
			}
			
		 }
		 
		 //Verify the filtered Products
		 public void verifyFilteredProducts() throws Exception {
			 try {
				 
				//Assertion for fit Type
				 String freestandingNoOfProducts = SearchProductPageObj.freeStandingNoOfProducts.getText();
				 Pattern p = Pattern.compile("\\d+");
			        Matcher m = p.matcher(freestandingNoOfProducts);
    	             String expectedNoOfProducts="";
			        while(m.find()) {
			            expectedNoOfProducts+=m.group();
			        }
				 String actualNoOfProducts = SearchProductPageObj.numberOfProducts.getText();
				 Assert.assertEquals(actualNoOfProducts,expectedNoOfProducts);
				 Assert.assertTrue(true, "Products filtered successfully");
				 ExtentTestManager.getTest().log(LogStatus.PASS, "Products filtered successfully");
				
			} catch (Exception e) {
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify products");
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: "+e.getLocalizedMessage());
			}
		 }

}
