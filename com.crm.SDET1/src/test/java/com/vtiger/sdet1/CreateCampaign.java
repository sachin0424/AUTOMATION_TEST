package com.vtiger.sdet1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.genaricUtility.Baseclass;
import com.crm.genaricUtility.ExcelUtilityLIbraries;
import com.crm.genaricUtility.FileUtilityLibraries;
import com.crm.genaricUtility.JavaUtilityLibraries;
import com.crm.genaricUtility.WebDriverUtilityLibraries;
import com.vtiger.OjectRepository.CompignInfornationPage;
import com.vtiger.OjectRepository.CreateCompaignLink;
import com.vtiger.OjectRepository.CreatingNewCompigen;
import com.vtiger.OjectRepository.HomePage;
import com.vtiger.OjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaign extends Baseclass {

	@Test
	public void CreateCompaign() throws Throwable{
		/*get the data using genricUyilit */
		ExcelUtilityLIbraries exl=new ExcelUtilityLIbraries();
		JavaUtilityLibraries jll=new JavaUtilityLibraries();
		
		
		 
			 /*fetching data from exceL file*/		
			 String compignName = exl.getDataFromExcel("compaing", 3, 1)+jll.getRanDomNum();
			 
			
			
		    /*move to cursor on more & click campaign*/	
			HomePage homepage=new HomePage(driver);
			homepage.movetoClick(driver);
			/*click on campaign created icon*/
			CreateCompaignLink click=new CreateCompaignLink(driver);
			click.CompignLink();
			/*give the name campaign in Textfield*/
			CreatingNewCompigen givecompignName=new CreatingNewCompigen(driver);
			givecompignName.Addcampaignname(compignName);
			/*save the campaign name page*/
			givecompignName.SaveButton();
			/*Verification */
			CompignInfornationPage compignsucssfullMsg=new CompignInfornationPage(driver);
			String ActualMsg = compignsucssfullMsg.CompignSucssfullMsg();
//			if(ActualMsg.contains(compignName)) {
//				System.out.println("is created succsusfully ==pass");
//			}else {
//				System.out.println("is created ===fail");
//			}
			Assert.assertEquals(ActualMsg.contains(compignName), true);
			
				
	}
}
