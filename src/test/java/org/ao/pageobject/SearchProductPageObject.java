package org.ao.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchProductPageObject {
	
//Search Bar
	@FindBy(xpath="//*[@id=\"siteSearch-input\"]")
	public WebElement searchBar;
	
//Search Button
	@FindBy(xpath="//*[@aria-label=\"Submit search\"]")
	public WebElement searchButton;
	
//Search Brand
	@FindBy(xpath="//*[@id=\"brands\"]//li[1]")
	public WebElement searchByBrand;
	
//Hide Out of Stock
	@FindBy(xpath="//*[@id=\"style-1\"]/div[1]/div[2]/fieldset/div/a/label/span/span[1]")
	public WebElement hideOutofstock;
	
//Choosing Colour
	@FindBy(xpath="//*[@id=\"style-1\"]/div[5]/div[2]/fieldset/div/div/div[1]/a/label/div[1]")
	public WebElement filterColour;	
	
//Choosing Fit Type
	@FindBy(xpath="//*[@id=\"style-1\"]/div[2]/div[2]/fieldset/div[1]/a/label/span/span[1]")
	public WebElement fitType;
	
//Assertion Page Objects
	//Select Brand assertion
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div/div/div[1]/div/span[3]")
	public WebElement selectedBrand;
	
	//Out of Stock assertion
	@FindBy(xpath="//*[contains(text(),\"Out of stock\")]")
	public WebElement outOfStock;
	
	//Freestanding Number of products
	@FindBy(xpath="//*[@id=\"style-1\"]/div[2]/div[2]/fieldset/div[1]/a/label/span/span[2]/span[2]")
	public WebElement freeStandingNoOfProducts;
	
	//Number of products
	@FindBy(xpath="//*[@id=\"app\"]/footer/div[1]/div[1]/span[1]")
	public WebElement numberOfProducts;
}
