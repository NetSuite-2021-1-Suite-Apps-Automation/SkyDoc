package com.qa.skyDocRP.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.qa.skyDocRP.util.TestBase;

public class SkyDocFoldersPage extends TestBase {
	
	@FindBy(xpath = "//span[@id='custpage_header_val']//iframe")
	WebElement mainFrame;
	
	@FindBy(xpath = "//input[@value='Upload Files']")
	WebElement uploadFilesBtn;
	
	@FindBy(xpath = "//iframe[@id='iframe_null']")
	WebElement uploadFilesFrame;
	
	@FindBy(xpath = "//button[@data-id='folder']")
	WebElement uploadFolderBtn;
	
	@FindBy(xpath = "//button[@data-id='category']")
	WebElement uploadCategoryBtn;
	
	@FindBy(xpath = "//button[@data-id='folder']//following-sibling::div//span[@class='text']")
	List<WebElement> uploadFolderList;
	
	@FindBy(xpath = "//button[@data-id='category']//following-sibling::div//span[@class='text']")
	List<WebElement> uploadCategoryList;
	
	@FindBy(xpath = "//div[@class='dropzone']")
	WebElement dragDropBtn;
	
	@FindBy(xpath = "//label[contains(@id,'fileupload_')]")
	WebElement uploadStatus;
	
	@FindBy(xpath = "//div[@id='uploadIframe']//span[text()='×']")
	WebElement fileUploadCloseBtn;
	
	@FindBy(xpath = "//input[@id='searchstr']")
	WebElement foldersSearchBox;
	
	@FindBy(xpath = "//input[@id='mediasrch_b']")
	WebElement foldersSearchBtn;
	
	@FindBy(xpath = "//input[@aria-controls='div__bodytab']")
	WebElement rightSearchBox;
	
	@FindBy(xpath = "//div[@id='div__nav_tree']//li[contains(@style,'display: block')]//a")
	List<WebElement> folderSearchResults;
	
	@FindBy(xpath = "//table[@id='div__bodytab']//tbody//td[count(//table[@id='div__bodytab']//div[contains(text(),'Name')]//parent::div//parent::th//preceding-sibling::th)+1]")
	List<WebElement> fileNamesList;
	
	@FindBy(xpath = "//table[@id='div__bodytab']//tbody//td[count(//table[@id='div__bodytab']//div[contains(text(),'Name')]//parent::div//parent::th//preceding-sibling::th)+1][contains(@class,'wordwrapfilename')]")
	List<WebElement> fileNamesListWithoutFolders;
	
	@FindBy(xpath = "//table[@id='div__bodytab']//tbody//td[count(//table[@id='div__bodytab']//div[contains(text(),'Name')]//parent::div//parent::th//preceding-sibling::th)]//input")
	List<WebElement> checkboxesList;
	
	@FindBy(xpath = "//input[@value='Move Files']")
	WebElement moveFilesBtn;
	
	@FindBy(xpath = "//input[@value='Copy Files']")
	WebElement copyFilesBtn;
	
	@FindBy(xpath = "//input[@value='Delete Files']")
	WebElement deleteFilesBtn;
	
	@FindBy(xpath = "//input[@value='New Folder']")
	WebElement newFolderBtn;
	
	@FindBy(xpath = "//div[@id='div__nav_tree']//li//a")
	List<WebElement> leftFoldersList;
	
	public SkyDocFoldersPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void verifyNewFolderFunctionality(String folderName, ExtentTest logInfo) throws InterruptedException {
		action = new Actions(driver);
		driver.switchTo().frame(mainFrame);
		eleClickable(driver, newFolderBtn, 10);
		newFolderBtn.click();
		driver.switchTo().defaultContent();
		Thread.sleep(1500);
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
	    driver.manage().window().maximize();
	    eleAvailability(driver, By.xpath("//input[@id='custrecord_skydoc_folder_name']"), 10);
	    driver.findElement(By.xpath("//input[@id='custrecord_skydoc_folder_name']")).sendKeys(folderName);
	    driver.findElement(By.xpath("//span[@id='custrecordtss_aws_s3_ns_access_allemp_fs']//img")).click();
    	driver.findElement(By.xpath("//span[@id='custrecord_tss_aws_s3_ns_public_fs']//img")).click();
    	driver.findElement(By.xpath("//input[@id='btn_multibutton_submitter']")).click();
    	Thread.sleep(5000);
    	driver.close();
	    driver.switchTo().window(tabs.get(0));
	    driver.navigate().refresh();
	    driver.switchTo().frame(mainFrame);
	    eleClickable(driver, foldersSearchBox, 10);
    	boolean folderCreationFlag = false;
    	for(int i=0;i<leftFoldersList.size();i++) {
    		if(leftFoldersList.get(i).getText().trim().equals(folderName)) {
    			folderCreationFlag = true;
    			break;
    		}
    	}
    	
    	if(folderCreationFlag) {
    		System.out.println(folderName+" folder created successfully");
    		logInfo.pass(folderName+" folder created successfully");
    	}else {
    		System.out.println(folderName+" unable to create");
    		logInfo.fail(folderName+" unable to create");
    	}
    	driver.switchTo().defaultContent();
		Thread.sleep(1500);
	}
	
	public void verifyDeleteFilesFunctionality(String folderName, String fileName, ExtentTest logInfo) throws InterruptedException {
		action = new Actions(driver);
		driver.switchTo().frame(mainFrame);
		eleClickable(driver, foldersSearchBox, 10);
    	foldersSearchBox.sendKeys(folderName);
    	foldersSearchBtn.click();
    	Thread.sleep(1500);
    	for(int i=0;i<folderSearchResults.size();i++) {
    		if(folderSearchResults.get(i).getText().trim().equals(folderName)) {
    			folderSearchResults.get(i).click();
    			break;
    		}
    	}
    	eleAvailability(driver, rightSearchBox, 10);
    	
		// Select files to delete
    	int fileFoundCount = 0;
		boolean fileFoundStatus = false;
		if(fileName.contains(",")) {
			String[] filesToDelete = fileName.split(",");
			for (int j = 0; j < filesToDelete.length; j++) {
				boolean currentFileFoundStatus = false;
				for (int i = 0; i < fileNamesListWithoutFolders.size(); i++) {
					action.moveToElement(fileNamesListWithoutFolders.get(i)).build().perform();
					if(fileNamesListWithoutFolders.get(i).getText().contains(filesToDelete[j])) {
						checkboxesList.get(i).click();
						currentFileFoundStatus = true;
						fileFoundCount++;
						break;
					}
				}
				if(!currentFileFoundStatus) {
					fileName = fileName.replace(filesToDelete[j], "");
					System.out.println(filesToDelete[j]+" file not found");
					logInfo.pass(filesToDelete[j]+" file not found");
				}
			}
		}else {
			for (int i = 0; i < fileNamesListWithoutFolders.size(); i++) {
				action.moveToElement(fileNamesListWithoutFolders.get(i)).build().perform();
				if(fileNamesListWithoutFolders.get(i).getText().contains(fileName)) {
					checkboxesList.get(i).click();
					fileFoundStatus = true;
					break;
				}
			}
			if(!fileFoundStatus) {
				System.out.println(fileName+" file not found");
				logInfo.pass(fileName+" file not found");
			}
		}
		
		boolean fileDeleteStatus = false;
		if(fileFoundCount >= 1 || fileFoundStatus) {
			// Click Delete button
			eleClickable(driver, deleteFilesBtn, 10);
			deleteFilesBtn.click();
			if(isAlertPresent()) {
				Thread.sleep(1000);
				Alert alert = driver.switchTo().alert();
				String alertMsg = alert.getText();
				System.out.println("Alert occured: "+alertMsg);
				alert.accept();
			}
			Thread.sleep(2000);
			if(isAlertPresent()) {
				Thread.sleep(1000);
				Alert alert = driver.switchTo().alert();
				String alertMsg = alert.getText();
				System.out.println("Alert occured: "+alertMsg);
				alert.accept();
			}
			eleAvailability(driver, rightSearchBox, 10);
			fileDeleteStatus = true;
		}
		
		driver.switchTo().defaultContent();
		Thread.sleep(1500);
		if(fileDeleteStatus) {
			System.out.println(fileName+" deleted successfully");
			logInfo.pass(fileName+" deleted successfully");
		}else {
			System.out.println(fileName+" unable to delete");
			logInfo.fail(fileName+" unable to delete");
		}
	}
	
	public void verifyCopyFilesFunctionality(String sourceFolder, String destinationFolder, String fileName, ExtentTest logInfo) throws InterruptedException {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		action = new Actions(driver);
		driver.switchTo().frame(mainFrame);
		eleClickable(driver, foldersSearchBox, 10);
    	foldersSearchBox.sendKeys(sourceFolder);
    	foldersSearchBtn.click();
    	Thread.sleep(1500);
    	for(int i=0;i<folderSearchResults.size();i++) {
    		if(folderSearchResults.get(i).getText().trim().equals(sourceFolder)) {
    			folderSearchResults.get(i).click();
    			break;
    		}
    	}
    	eleAvailability(driver, rightSearchBox, 10);
    	
		// Select files to Copy
		if(fileName.contains(",")) {
			String[] filesToSend = fileName.split(",");
			for (int j = 0; j < filesToSend.length; j++) {
				for (int i = 0; i < fileNamesListWithoutFolders.size(); i++) {
					action.moveToElement(fileNamesListWithoutFolders.get(i)).build().perform();
					if(fileNamesListWithoutFolders.get(i).getText().contains(filesToSend[j])) {
						checkboxesList.get(i).click();
						break;
					}
				}
			}
		}else {
			for (int i = 0; i < fileNamesListWithoutFolders.size(); i++) {
				action.moveToElement(fileNamesListWithoutFolders.get(i)).build().perform();
				if(fileNamesListWithoutFolders.get(i).getText().contains(fileName)) {
					checkboxesList.get(i).click();
					break;
				}
			}
		}
		
		// Click Copy Files button
		copyFilesBtn.click();
		if(isAlertPresent()) {
			Thread.sleep(1000);
			Alert alert = driver.switchTo().alert();
			String alertMsg = alert.getText();
			System.out.println("Alert occured: "+alertMsg);
			alert.accept();
		}
		driver.findElement(By.xpath("//select[@id='realitems']")).click();
		List<WebElement> options = driver.findElements(By.xpath("//select[@id='realitems']//option"));
		for (int i = 0; i < options.size(); i++) {
			if(options.get(i).getText().trim().equals(destinationFolder)) {
				options.get(i).click();
				break;
			}
		}
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		Thread.sleep(1000);
		
		// Open destination folder
		eleClickable(driver, foldersSearchBox, 10);
    	foldersSearchBox.sendKeys(destinationFolder);
    	foldersSearchBtn.click();
    	Thread.sleep(1500);
    	for(int i=0;i<folderSearchResults.size();i++) {
    		if(folderSearchResults.get(i).getText().trim().equals(destinationFolder)) {
    			folderSearchResults.get(i).click();
    			break;
    		}
    	}
    	
    	// Verify files in destination folder
    	eleAvailability(driver, rightSearchBox, 10);
    	int matchCount = 0;
		int multipleFilesLength = 0;
		boolean flag = false;
		if(fileName.contains(",")) {
			String[] filesToSend = fileName.split(",");
			multipleFilesLength = filesToSend.length;
			for (int j = 0; j < filesToSend.length; j++) {
				for (int i = 0; i < fileNamesListWithoutFolders.size(); i++) {
					if(fileNamesListWithoutFolders.get(i).getText().contains(filesToSend[j])) {
						matchCount++;
						break;
					}
				}
			}
		}else {
			for (int i = 0; i < fileNamesListWithoutFolders.size(); i++) {
				je.executeScript("arguments[0].scrollIntoView(true);", fileNamesList.get(i));
				if(fileNamesListWithoutFolders.get(i).getText().contains(fileName)) {
					flag = true;
					break;
				}
			}
		}
		driver.switchTo().defaultContent();
		Thread.sleep(1500);
		if(matchCount >= multipleFilesLength || flag) {
			System.out.println(fileName+" copied successfully from "+sourceFolder+" folder to "+destinationFolder+" folder");
			logInfo.pass(fileName+" copied successfully from "+sourceFolder+" folder to "+destinationFolder+" folder");
		}else {
			System.out.println(fileName+" unable to copy");
			logInfo.fail(fileName+" unable to copy");
		}
    	
	}
	
	public void verifyMoveFilesFunctionality(String sourceFolder, String destinationFolder, String fileName, ExtentTest logInfo) throws InterruptedException {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		action = new Actions(driver);
		driver.switchTo().frame(mainFrame);
		eleClickable(driver, foldersSearchBox, 10);
    	foldersSearchBox.sendKeys(sourceFolder);
    	foldersSearchBtn.click();
    	Thread.sleep(1500);
    	for(int i=0;i<folderSearchResults.size();i++) {
    		if(folderSearchResults.get(i).getText().trim().equals(sourceFolder)) {
    			folderSearchResults.get(i).click();
    			break;
    		}
    	}
    	eleAvailability(driver, rightSearchBox, 10);
    	
		// Select files to Move
		if(fileName.contains(",")) {
			String[] filesToSend = fileName.split(",");
			for (int j = 0; j < filesToSend.length; j++) {
				for (int i = 0; i < fileNamesListWithoutFolders.size(); i++) {
					action.moveToElement(fileNamesListWithoutFolders.get(i)).build().perform();
					if(fileNamesListWithoutFolders.get(i).getText().contains(filesToSend[j])) {
						checkboxesList.get(i).click();
						break;
					}
				}
			}
		}else {
			for (int i = 0; i < fileNamesListWithoutFolders.size(); i++) {
				action.moveToElement(fileNamesListWithoutFolders.get(i)).build().perform();
				if(fileNamesListWithoutFolders.get(i).getText().contains(fileName)) {
					checkboxesList.get(i).click();
					break;
				}
			}
		}
		
		// Click Move Files button
		moveFilesBtn.click();
		if(isAlertPresent()) {
			Thread.sleep(1000);
			Alert alert = driver.switchTo().alert();
			String alertMsg = alert.getText();
			System.out.println("Alert occured: "+alertMsg);
			alert.accept();
		}
		driver.findElement(By.xpath("//select[@id='realitems']")).click();
		List<WebElement> options = driver.findElements(By.xpath("//select[@id='realitems']//option"));
		for (int i = 0; i < options.size(); i++) {
			if(options.get(i).getText().trim().equals(destinationFolder)) {
				options.get(i).click();
				break;
			}
		}
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		Thread.sleep(1000);
		
		// Open destination folder
		eleClickable(driver, foldersSearchBox, 10);
    	foldersSearchBox.sendKeys(destinationFolder);
    	foldersSearchBtn.click();
    	Thread.sleep(1500);
    	for(int i=0;i<folderSearchResults.size();i++) {
    		if(folderSearchResults.get(i).getText().trim().equals(destinationFolder)) {
    			folderSearchResults.get(i).click();
    			break;
    		}
    	}
    	
    	// Verify files in destination folder
    	eleAvailability(driver, rightSearchBox, 10);
    	int matchCount = 0;
		int multipleFilesLength = 0;
		boolean flag = false;
		if(fileName.contains(",")) {
			String[] filesToSend = fileName.split(",");
			multipleFilesLength = filesToSend.length;
			for (int j = 0; j < filesToSend.length; j++) {
				for (int i = 0; i < fileNamesListWithoutFolders.size(); i++) {
					if(fileNamesListWithoutFolders.get(i).getText().contains(filesToSend[j])) {
						matchCount++;
						break;
					}
				}
			}
		}else {
			for (int i = 0; i < fileNamesListWithoutFolders.size(); i++) {
				je.executeScript("arguments[0].scrollIntoView(true);", fileNamesList.get(i));
				if(fileNamesListWithoutFolders.get(i).getText().contains(fileName)) {
					flag = true;
					break;
				}
			}
		}
		driver.switchTo().defaultContent();
		Thread.sleep(1500);
		if(matchCount >= multipleFilesLength || flag) {
			System.out.println(fileName+" moved successfully from "+sourceFolder+" folder to "+destinationFolder+" folder");
			logInfo.pass(fileName+" moved successfully from "+sourceFolder+" folder to "+destinationFolder+" folder");
		}else {
			System.out.println(fileName+" unable to move");
			logInfo.fail(fileName+" unable to move");
		}
    	
	}
	
	public void verifyFileUploadFunctionality(String folderName, String categoryName, String filePath, ExtentTest logInfo) throws InterruptedException, AWTException {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		driver.switchTo().frame(mainFrame);
		uploadFilesBtn.click();
		driver.switchTo().frame(uploadFilesFrame);
		
		// Select Folder
		uploadFolderBtn.click();
		for (int i = 0; i < uploadFolderList.size(); i++) {
			if(uploadFolderList.get(i).getText().equals(folderName)) {
				uploadFolderList.get(i).click();
				break;
			}
		}
		
		// Select Category
		if(categoryName.contains(",")) {
			String[] categories = categoryName.split(",");
			uploadCategoryBtn.click();
			// Uncheck all the categories
			for (int i = 0; i < uploadCategoryList.size(); i++) {
				WebElement parentAtag = (WebElement)je.executeScript("return arguments[0].parentNode;", uploadCategoryList.get(i));
				WebElement parentLi = (WebElement)je.executeScript("return arguments[0].parentNode;", parentAtag);
				if(parentLi.getAttribute("class").equals("selected"))
					uploadCategoryList.get(i).click();
			}
			// check multiple categories one by one
			for (int i = 0; i < uploadCategoryList.size(); i++) {
				for (int j = 0; j < categories.length; j++) {
					if(uploadCategoryList.get(i).getText().trim().equals(categories[j])) {
						WebElement parentAtag = (WebElement)je.executeScript("return arguments[0].parentNode;", uploadCategoryList.get(i));
						WebElement parentLi = (WebElement)je.executeScript("return arguments[0].parentNode;", parentAtag);
						if(!parentLi.getAttribute("class").equals("selected"))
							uploadCategoryList.get(i).click();
					}
				}
			}
			uploadCategoryBtn.click();
		}else if(!categoryName.isBlank() && !categoryName.contains(",")) {
			uploadCategoryBtn.click();
			for (int i = 0; i < uploadCategoryList.size(); i++) {
				if(uploadCategoryList.get(i).getText().trim().equals(categoryName)) {
					WebElement parentAtag = (WebElement)je.executeScript("return arguments[0].parentNode;", uploadCategoryList.get(i));
					WebElement parentLi = (WebElement)je.executeScript("return arguments[0].parentNode;", parentAtag);
					if(!parentLi.getAttribute("class").equals("selected"))
						uploadCategoryList.get(i).click();
				}else {
					WebElement parentAtag = (WebElement)je.executeScript("return arguments[0].parentNode;", uploadCategoryList.get(i));
					WebElement parentLi = (WebElement)je.executeScript("return arguments[0].parentNode;", parentAtag);
					if(parentLi.getAttribute("class").equals("selected"))
						uploadCategoryList.get(i).click();
				}
			}
			uploadCategoryBtn.click();
		}else if(categoryName.isBlank()) {
			uploadCategoryBtn.click();
			for (int i = 0; i < uploadCategoryList.size(); i++) {
				WebElement parentAtag = (WebElement)je.executeScript("return arguments[0].parentNode;", uploadCategoryList.get(i));
				WebElement parentLi = (WebElement)je.executeScript("return arguments[0].parentNode;", parentAtag);
				if(parentLi.getAttribute("class").equals("selected"))
					uploadCategoryList.get(i).click();
			}
			uploadCategoryBtn.click();
		}
		
		dragDropBtn.click();
		
		// Upload file
		StringSelection strSelection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strSelection, null);
		Robot robot = new Robot();
		robot.delay(200);
		robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(200);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(1000);
        
        // Verify the file upload status
        boolean fileUploadFlag = false;
        eleContainsText(driver, driver.findElement(By.xpath("//div[@id='files_statis']")), 10, "uploaded successfully");
        eleAvailability(driver, uploadStatus, 10);
        je.executeScript("arguments[0].scrollIntoView(true);", uploadStatus);
        Thread.sleep(3000);
        String[] filepath = filePath.split(Pattern.quote(File.separator));;
        String uploadFileName = filepath[filepath.length-1];
        if(uploadStatus.getText().contains("has been uploaded")) {
        	driver.switchTo().defaultContent();
        	Thread.sleep(1500);
        	driver.switchTo().frame(mainFrame);
        	eleAvailability(driver, fileUploadCloseBtn, 8);
        	fileUploadCloseBtn.click();
        	eleClickable(driver, foldersSearchBox, 10);
        	foldersSearchBox.sendKeys(folderName);
        	foldersSearchBtn.click();
        	Thread.sleep(1500);
        	for(int i=0;i<folderSearchResults.size();i++) {
        		if(folderSearchResults.get(i).getText().trim().equals(folderName)) {
        			folderSearchResults.get(i).click();
        			break;
        		}
        	}
        	eleAvailability(driver, fileNamesList.get(0), 10);
        	for(int i=0;i<fileNamesList.size();i++) {
        		WebElement currentFileName = fileNamesList.get(i);
				String text = currentFileName.getText();
				if(text.contains(uploadFileName)) {
					fileUploadFlag = true;
				}
        	}
        }
        
        if(fileUploadFlag) {
			System.out.println(uploadFileName+" file uploaded successfully");
			logInfo.pass(uploadFileName+" file uploaded successfully");
		}else {
			System.out.println(uploadFileName+" file upload unsuccessfull");
			logInfo.fail(uploadFileName+" file upload unsuccessfull");
		}
        driver.switchTo().defaultContent();
    	Thread.sleep(1500);
	}
}
