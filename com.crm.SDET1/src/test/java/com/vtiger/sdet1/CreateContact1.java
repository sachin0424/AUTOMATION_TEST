package com.vtiger.sdet1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.genaricUtility.Baseclass;
import com.crm.genaricUtility.ExcelUtilityLIbraries;
import com.crm.genaricUtility.FileUtilityLibraries;
import com.crm.genaricUtility.JavaUtilityLibraries;
import com.crm.genaricUtility.WebDriverUtilityLibraries;
import com.vtiger.OjectRepository.ContactInfo;
import com.vtiger.OjectRepository.ContactsPage;
import com.vtiger.OjectRepository.CreateNewContact;
import com.vtiger.OjectRepository.HomePage;
import com.vtiger.OjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact1 extends Baseclass {
     @Test
	public void CreateContact() throws Throwable {
		/*get the data using genricUyilit */
		ExcelUtilityLIbraries exl=new ExcelUtilityLIbraries();
		JavaUtilityLibraries jll=new JavaUtilityLibraries();
		
		int getrandomnum = jll.getRanDomNum();
	 /*fetching data from exceL file*/		
	 String lastname = exl.getDataFromExcel("org", 2, 3)+jll.getRanDomNum();
	 String orgname = exl.getDataFromExcel("org", 1, 3);
	
		/*Navigate to contact Link*/
		HomePage homepage=new HomePage(driver);
		homepage.ClickOnContect();
		/*click on create contact icon*/
		ContactsPage contactpage=new ContactsPage(driver);
		contactpage.CreateNewContect();
		/*give name to contact name textfield & select organization */
		CreateNewContact newcontact=new CreateNewContact(driver);
		newcontact.CreateContact(driver, lastname, orgname);
		/*verificatation*/
		ContactInfo contactinfopage=new ContactInfo(driver);
		String actualmsg = contactinfopage.ContactText();
		if(actualmsg.contains(lastname)) {
			System.out.println("contact is created successfully");
		}else {
			System.out.println("contact is failed created ");
		}
		
		
		
	}
}
