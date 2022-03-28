package com.vtiger.sdet1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.Opportunity.ObjectRepository.Homepage;
import com.Opportunity.ObjectRepository.Loginpage;
import com.crm.genaricUtility.Baseclass;
import com.crm.genaricUtility.ExcelUtilityLIbraries;
import com.crm.genaricUtility.FileUtilityLibraries;
import com.crm.genaricUtility.JavaUtilityLibraries;
import com.crm.genaricUtility.WebDriverUtilityLibraries;
import com.vtiger.OjectRepository.ContactInfo;
import com.vtiger.OjectRepository.CreateNewProduct;
import com.vtiger.OjectRepository.HomePage;
import com.vtiger.OjectRepository.ProductInformation;
import com.vtiger.OjectRepository.ProductsPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProduct1 extends Baseclass{
     @Test
	public void CreateProduct() throws Throwable {
	
		/*get the data using genricUyilit */ 
		ExcelUtilityLIbraries exl=new ExcelUtilityLIbraries();
		JavaUtilityLibraries jll=new JavaUtilityLibraries();
		
		
		 /*fetching data from excel file*/		
		 String productname = exl.getDataFromExcel("product", 1, 1)+jll.getRanDomNum();
		 
		
		
        /*navigate to product */
       HomePage prdlink=new HomePage(driver);
       prdlink.ClickProductsLink();
       /*click on create new product icon*/
       CreateNewProduct ClickIconimg=new CreateNewProduct(driver);
       ClickIconimg.ClickProcductIconimg();
       /*give name as product textfield*/
       ProductsPage Prdpage=new ProductsPage(driver);
       Prdpage.CreateProductname(productname);
       /*save the product name page*/
       Prdpage.SaveBtn();
       /*verification*/
       ProductInformation productcreatedsucssfulMsg=new ProductInformation(driver);
       String ActualMsg = productcreatedsucssfulMsg.ProductSuccssufullymsg();
       if(ActualMsg.contains(productname)) {
    	   System.out.println("is creted sucssfuly ===pass");
       }else {
    	   System.out.println("is creted ===fail");
       }
      
       
       
		
	}
}
