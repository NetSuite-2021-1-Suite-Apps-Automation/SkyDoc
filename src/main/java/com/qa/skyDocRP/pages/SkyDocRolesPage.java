package com.qa.skyDocRP.pages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.qa.skyDocRP.util.TestBase;

public class SkyDocRolesPage extends TestBase {
	
	@FindBy(xpath = "//td[contains(@id,'row_custpage_onlydeleteroles')]//a")
	List<WebElement> deleteRolesMultiSelectList;
	
	@FindBy(xpath = "//input[@id='submitter']")
	WebElement submitBtn;
	
	@FindBy(xpath = "//div[@class='descr']")
	WebElement confirmationMsg;
	
	@FindBy(xpath = "//span[text()='Lists']")
	WebElement listLink;
	
	@FindBy(xpath = "//span[text()='Relationships']")
	WebElement relationshipsLink;
	
	@FindBy(xpath = "//span[text()='Customers']")
	WebElement customersLink;
	
	@FindBy(xpath = "//form//tr[contains(@id,'row')]//td[count(//form//table[@id='div__labtab']//div[contains(text(),'Name')]//parent::td//preceding-sibling::td)+1]//a")
	List<WebElement> customerList;
	
	@FindBy(xpath = "//a[text()='Sky']")
	WebElement skyDocSubtabLink;
	
	@FindBy(xpath = "//iframe[@id='frame']")
	WebElement rightFrame;
	
	@FindBy(xpath = "//input[@value='Delete']")
	WebElement deleteBtn;
	
	@FindBy(xpath = "//input[@id='custpage_folder_label']")
	WebElement folderLabelBox;
	
	@FindBy(xpath = "//input[@id='custpage_category_label']")
	WebElement categoryLabelBox;
	
	@FindBy(xpath = "//div[@class='folderfilter']//div[contains(@class,'optionfoldertest')]//button")
	WebElement folderFilterDropdown;
	
	@FindBy(xpath = "//div[@class='folderfilter']//div[contains(@class,'optioncategorytest')]//button")
	WebElement categoryFilterDropdown;
	
	@FindBy(xpath = "//input[@id='custpage_dis_cat_in_sd_fs_inp']//following-sibling::img")
	WebElement displayCategoryCheckbox;
	
	@FindBy(xpath = "//iframe[@id='first_frame']")
	WebElement leftFrame;
	
	@FindBy(xpath = "//tr[@role='row'][not(@class='trheader')]//td[count(//tr[@class='trheader']//td[text()='Category' or text()='DEF']//preceding-sibling::td)+1]//img")
	List<WebElement> inlineCategoryIcons;
	
	@FindBy(xpath = "//span[@class='uir-pagination-label']")
	WebElement paginationLabel;
	
	@FindBy(xpath = "//span[@class='uir-pagination-label']//following-sibling::ul//li")
	List<WebElement> paginationList;
	
	public SkyDocRolesPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void verifyDeleteBtnInCustomerPage(ExtentTest logInfo) throws InterruptedException {
		action = new Actions(driver);
		Thread.sleep(3000);
		eleAvailability(driver, By.xpath("//span[text()='Lists']"), 10);
		action.moveToElement(listLink).build().perform();
		eleAvailability(driver, By.xpath("//span[text()='Relationships']"), 10); // Explicit Wait
		action.moveToElement(relationshipsLink).build().perform();
		eleAvailability(driver, By.xpath("//span[text()='Customers']"), 10); // Explicit Wait
		action.keyDown(Keys.CONTROL).click(customersLink).keyUp(Keys.CONTROL).build().perform();
		
		String setupPageWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		for(String child: allWindows) {
			if(!setupPageWindow.equals(child)) {
				driver.switchTo().window(child);
				openCustomer("ABC");
				driver.switchTo().frame(rightFrame);
				
				// Verify Delete button
				try {
					if(deleteBtn.isDisplayed()) {
						System.out.println("Delete button is still displayed even if the functionality is disabled for this role");
						logInfo.fail("Delete button is still displayed even if the functionality is disabled for this role");
					}
				}catch(NoSuchElementException e) {
					System.out.println("Delete button is not displayed when the functionality is disabled for this role");
					logInfo.pass("Delete button is not displayed when the functionality is disabled for this role");
				}
				
				// Verify Folder & Category label
				String folderName = folderFilterDropdown.getAttribute("title").toLowerCase();
				String categoryName = categoryFilterDropdown.getAttribute("title").toLowerCase();
				driver.switchTo().defaultContent();
				Thread.sleep(1500);
				driver.switchTo().frame(leftFrame);
				String leftFolderLabel = driver.findElement(By.xpath("//table[@class='left_table']//tr[2]//label")).getText().toLowerCase();
				String leftCategoryLabel = driver.findElement(By.xpath("//table[@class='left_table']//tr[4]//label")).getText().toLowerCase();
				if (folderName.equals("folder") && leftFolderLabel.equals("folder")) {
					System.out.println("Folder label is displayed correctly as entered in the SkyDoc Roles page");
					logInfo.pass("Folder label is displayed correctly as entered in the SkyDoc Roles page");
				}else {
					System.out.println("Folder label is not displayed correctly as entered in the SkyDoc Roles page");
					logInfo.fail("Folder label is not displayed correctly as entered in the SkyDoc Roles page");
				}
				
				if (categoryName.equals("category") && leftCategoryLabel.equals("category")) {
					System.out.println("Category label is displayed correctly as entered in the SkyDoc Roles page");
					logInfo.pass("Category label is displayed correctly as entered in the SkyDoc Roles page");
				}else {
					System.out.println("Category label is not displayed correctly as entered in the SkyDoc Roles page");
					logInfo.fail("Category label is not displayed correctly as entered in the SkyDoc Roles page");
				}
				
				// Verify Category in the SkyDoc display list
				boolean inlineCategoryFlag = true;
				for (int i = 0; i < inlineCategoryIcons.size(); i++) {
					if(!inlineCategoryIcons.get(i).isDisplayed())
						inlineCategoryFlag = false;
				}
				if(inlineCategoryFlag) {
					System.out.println("Category column is displayed in SkyDoc display list when 'Display category in SkyDoc list' checkbox is checked");
					logInfo.pass("Category column is displayed in SkyDoc display list when 'Display category in SkyDoc list' checkbox is checked");
				}else {
					System.out.println("Category column is not displayed even if 'Display category in SkyDoc list' checkbox is checked");
					logInfo.fail("Category column is not displayed even if 'Display category in SkyDoc list' checkbox is checked");
				}
			}
		}
		driver.close();
		driver.switchTo().window(setupPageWindow);
		action.sendKeys(Keys.ESCAPE).build().perform();
	}
	
	public void openCustomer(String customerName) throws InterruptedException {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		action = new Actions(driver);
		Thread.sleep(1500);
		eleAvailability(driver, By.xpath("//span[text()='Lists']"), 10);
		action.moveToElement(listLink).build().perform();
		eleAvailability(driver, By.xpath("//span[text()='Relationships']"), 10); // Explicit Wait
		action.moveToElement(relationshipsLink).build().perform();
		eleAvailability(driver, By.xpath("//span[text()='Customers']"), 10); // Explicit Wait
		customersLink.click();
		
		boolean customerFlag = false;
		for(int i=0;i<customerList.size();i++) {
			WebElement currentCustomer = customerList.get(i);
			String text = currentCustomer.getText();
			if(text.equals(customerName)) {
				customerFlag = true;
				action.moveToElement(currentCustomer).build().perform();
				WebElement parentTd = (WebElement)je.executeScript("return arguments[0].parentNode;", currentCustomer);
				WebElement parentTr = (WebElement)je.executeScript("return arguments[0].parentNode;", parentTd);
				String rowId = parentTr.getAttribute("id");
				if(rowId.isBlank()) {
					WebElement customerRow = (WebElement)je.executeScript("return arguments[0].parentNode;", parentTr);
					rowId = customerRow.getAttribute("id");
				}
				driver.findElement(By.xpath("//table[@id='div__bodytab']//tr[@id='"+rowId+"']//a[text()='View']")).click();
				break;
			}
		}
		if(!customerFlag) {
			for (int i = 1; i < paginationList.size(); i++) {
				boolean customerFlag2 = false;
				action.moveToElement(paginationLabel).build().perform();
				eleAvailability(driver, paginationList.get(i), 10);
				paginationList.get(i).click();
				Thread.sleep(3000);
				for (int j = 0; j < customerList.size(); j++) {
					if(customerList.get(j).getText().trim().equals(customerName)) {
						customerFlag2 = true;
						customerList.get(j).click();
						break;
					}
				}
				if(customerFlag2)
					break;
			}
		}
		Thread.sleep(1500);
		skyDocSubtabLink.click();
		je.executeScript("window.scrollBy(-1000,0)");
		je.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	public void disableDeleteFeature(ExtentTest logInfo) {
		action = new Actions(driver);
		JavascriptExecutor je = (JavascriptExecutor) driver;
		for(int i=0;i<deleteRolesMultiSelectList.size();i++) {
			WebElement currentRole = deleteRolesMultiSelectList.get(i);
			if(currentRole.getText().equals("Administrator")) {
				action.moveToElement(currentRole).build().perform();
				WebElement parentTd = (WebElement)je.executeScript("return arguments[0].parentNode;", currentRole);
				String str = parentTd.getAttribute("class");
				if(str.equals("dropdownSelected")) {
					action.keyDown(Keys.CONTROL).click(currentRole).keyUp(Keys.CONTROL).build().perform();
					break;
				}
			}
		}
		System.out.println("Delete feature disabled in SkyDoc Roles page");
		logInfo.pass("Delete feature disabled in SkyDoc Roles page");
		
		// Enter Folder label
		je.executeScript("arguments[0].scrollIntoView(true);", folderLabelBox);
		folderLabelBox.clear();
		folderLabelBox.sendKeys("Folder");
		logInfo.pass("Folder label is named as 'Folder'");
		
		// Enter Category Label
		categoryLabelBox.clear();
		categoryLabelBox.sendKeys("Category");
		logInfo.pass("Category label is named as 'Category'");
		
		// Check Category checkbox
		WebElement parentSpan = (WebElement)je.executeScript("return arguments[0].parentNode;", displayCategoryCheckbox);
		if(parentSpan.getAttribute("class").equals("checkbox_unck"))
			displayCategoryCheckbox.click();
		logInfo.pass("Category checkbox enabled in SkyDoc Roles page");
		
		je.executeScript("window.scrollTo(0,0)");
		submitBtn.click();
		eleAvailability(driver, confirmationMsg, 10);
		if(confirmationMsg.isDisplayed())
			System.out.println("Roles Page saved");
	}
}
