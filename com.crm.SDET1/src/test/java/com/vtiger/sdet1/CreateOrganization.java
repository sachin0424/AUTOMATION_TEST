package com.vtiger.sdet1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.genaricUtility.Baseclass;
import com.crm.genaricUtility.ExcelUtilityLIbraries;
import com.crm.genaricUtility.FileUtilityLibraries;
import com.crm.genaricUtility.JavaUtilityLibraries;
import com.crm.genaricUtility.WebDriverUtilityLibraries;
import com.vtiger.OjectRepository.ContactInfo;
import com.vtiger.OjectRepository.CreateNewContact;
import com.vtiger.OjectRepository.CreateNew_Organization;
import com.vtiger.OjectRepository.HomePage;
import com.vtiger.OjectRepository.LoginPage;
import com.vtiger.OjectRepository.Organizationpage;

import bsh.BshClassManager.Listener;
import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.crm.genaricUtility.ListenersImplementationClass.class)
public class CreateOrganization extends Baseclass {
	@Test
  public void getOrganization() throws Throwable {
	  /*get the data using genricUyilit */
	 
	  ExcelUtilityLIbraries exl=new ExcelUtilityLIbraries();
	  JavaUtilityLibraries jll=new JavaUtilityLibraries();
	 
		 /*fetching data from excel file*/		
		 String orgname = exl.getDataFromExcel("organization", 3, 0)+jll.getRanDomNum();
		  String industryType = exl.getDataFromExcel("organization", 5, 1); 
		 
	
	/*Navigate to contact Link*/
	HomePage homepage=new HomePage(driver);
	homepage.Clickonorganization();
	/*click on create contact icon*/
	CreateNew_Organization clickneworganizatation=new CreateNew_Organization(driver);
	clickneworganizatation.createOrganization();
	/*give name to organization  
 & select organization */
	CreateNewContact newcontact=new CreateNewContact(driver);
	Organizationpage addorganizationName=new Organizationpage(driver);

	addorganizationName.CreateOrganizationname(orgname);
	
	addorganizationName.ClickDropDown();
	/*select industry type from dropdown*/
	addorganizationName.SelectIndustryDropDown(industryType);
	addorganizationName.organizationSaveBtn();
	/*verificatation*/
	ContactInfo actualMsg=new ContactInfo(driver);
	String ActualOrganizationName = actualMsg.organizationText();
	if(ActualOrganizationName.contains(orgname)) {
		System.out.println("is created succsufully");
	}else {
		System.out.println("is not created succsufully");
	}
	
	}
	
  }
  

