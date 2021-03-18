package com.qa.skyDocRP.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.skyDocRP.util.TestBase;

public class HomePage extends TestBase {
	@FindBy(xpath = "//li[contains(@id,'ns-header-menu-userrole-item')]/a/span[@class='ns-role-menuitem-text']")
	List<WebElement> rolesList;
	
	@FindBy(xpath = "//span[text()='Setup']")
	WebElement setupLink;
	
	@FindBy(xpath = "//li[@data-title='Setup Manager']//following-sibling::li/a/span")
	List<WebElement> setupDropdownList;
	
	@FindBy(xpath = "//a[contains(@class,'ns-scroll-button-bottom')]")
	WebElement scrollBtn;
	
	@FindBy(xpath = "//span[text()='SkyDoc']")
	WebElement skyDocLink;
	
	@FindBy(xpath = "//span[text()='SkyDoc Setup']")
	WebElement skyDocSetupLink;
	
	@FindBy(xpath = "//span[text()='SkyDoc Roles']")
	WebElement skyDocRolesLink;
	
	@FindBy(xpath = "//div[@class='ns-role']/span[2]")
	WebElement role;
	
	@FindBy(xpath = "//div[@id='devpgloadtime']//following-sibling::div[@class='ns-logo']//img")
	List<WebElement> images;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public SkyDocSetupPage clickOnSkyDocSetupPageLink() throws InterruptedException{
		action = new Actions(driver);
		Thread.sleep(1500);
		eleAvailability(driver, By.xpath("//span[text()='Setup']"), 10);
		action.moveToElement(setupLink).build().perform();
		eleAvailability(driver, scrollBtn, 10);
		action.moveToElement(scrollBtn).build().perform();
		Thread.sleep(1500);
		eleAvailability(driver, skyDocLink, 10); // Explicit Wait
		action.moveToElement(skyDocLink).build().perform();
		eleAvailability(driver, skyDocSetupLink, 10); // Explicit Wait
		skyDocSetupLink.click();
		
//		if(isAlertPresent()) {
//			driver.switchTo().alert().accept();
//		}
		
		return new SkyDocSetupPage();
	}
	
	public void changeRole(String company, String roleData, String roleType, String selectedRole) throws InterruptedException {
		action = new Actions(driver);
		String currentRole = role.getText().trim();
		if(currentRole.equals(selectedRole)) {
			System.out.println("Role already selected");
		} else {
			action.moveToElement(driver.findElement(By.xpath("//div[@id='spn_cRR_d1']/a"))).build().perform();
			for(int i=0;i<rolesList.size();i++) {
				WebElement roleElement = rolesList.get(i);
				String roleValue = roleElement.getText().trim();
				if(roleValue.contains(company) && roleValue.contains(roleData) && roleValue.contains(roleType)) {
					roleElement.click();
					break;
				}
			}
		}
		
	}

	public SkyDocRolesPage clickOnSkyDocRolesPageLink() throws InterruptedException {
		action = new Actions(driver);
		Thread.sleep(1500);
		eleAvailability(driver, By.xpath("//span[text()='Setup']"), 10);
		action.moveToElement(setupLink).build().perform();
		eleAvailability(driver, scrollBtn, 10);
		action.moveToElement(scrollBtn).build().perform();
		Thread.sleep(1500);
		eleAvailability(driver, skyDocLink, 10);
		action.moveToElement(skyDocLink).build().perform();
		eleAvailability(driver, skyDocRolesLink, 10);
		skyDocRolesLink.click();
		
		return new SkyDocRolesPage();
	}
}
