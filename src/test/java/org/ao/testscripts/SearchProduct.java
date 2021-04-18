package org.ao.testscripts;

import java.util.List;

import org.ao.page.SearchProductPage;
import org.ao.startup.BaseTest;
import org.testng.annotations.Test;

public class SearchProduct extends BaseTest {
	@Test
	public void SearchProduct() throws Exception {
		
	//Search bar page
		SearchProductPage searchProductPage = new SearchProductPage();
			
			//Typing into search bar
			searchProductPage.searchProduct();
			
			//Select Brand
			searchProductPage.selectBrand();
			
			//Filter Product
			searchProductPage.filterProduct();
			
			//Verify filtered products
			searchProductPage.verifyFilteredProducts();			
	}
			 

}
