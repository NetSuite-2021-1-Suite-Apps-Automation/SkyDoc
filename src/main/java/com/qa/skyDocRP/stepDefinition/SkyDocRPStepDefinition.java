package com.qa.skyDocRP.stepDefinition;

import java.awt.AWTException;
import java.io.File;
import java.util.Map;
import java.util.regex.Pattern;

import com.aventstack.extentreports.ExtentTest;
import com.qa.skyDocRP.pages.AuthenticationPage;
import com.qa.skyDocRP.pages.HomePage;
import com.qa.skyDocRP.pages.LoginPage;
import com.qa.skyDocRP.pages.SkyDocFoldersPage;
import com.qa.skyDocRP.pages.SkyDocRolesPage;
import com.qa.skyDocRP.pages.SkyDocSetupPage;
import com.qa.skyDocRP.util.ExcelDataToDataTable;
import com.qa.skyDocRP.util.TestBase;

import cucumber.api.DataTable;
import cucumber.api.Transform;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class SkyDocRPStepDefinition extends TestBase{
	
	LoginPage loginPage;
	AuthenticationPage authPage;
	HomePage homePage;
	SkyDocSetupPage skyDocSetupPage;
	SkyDocRolesPage skyDocRolesPage;
	SkyDocFoldersPage skyDocFoldersPage;
	
	@After
	public void closeBrowser() {
		driver.quit();
	}
	
	@Given("^Enable all the SkyDoc features$")
	public void enable_skydoc_features() throws InterruptedException {
		ExtentTest loginfo = null;
		try {
			test = extent.createTest("Verification of all the SkyDoc features while enabling features");
			// User login to Netsuite with Tvarana Dev Test role
			TestBase.init();
			loginPage = new LoginPage();
			authPage = loginPage.login();
			homePage = authPage.Authentication();
			homePage.changeRole(prop.getProperty("companyName"), prop.getProperty("role"), prop.getProperty("roleType"), prop.getProperty("selectedRole"));
		} catch (Exception e) {
			testStepHandle("FAIL", driver, loginfo, e, "Verification of all the SkyDoc features while enabling features");
		}
		
		ExtentTest loginfo2 = null;
		try {
			loginfo2 = test.createNode("Enable all the SkyDoc features");
			skyDocSetupPage = new SkyDocSetupPage();
			homePage.clickOnSkyDocRolesPageLink();
			skyDocSetupPage.enableAllSkyDocFeaturesInRolesPage();
			homePage.clickOnSkyDocSetupPageLink();
			skyDocSetupPage.enableAllSkyDocFeatures();
			loginfo2.pass("Enabled all the SkyDoc features");
		} catch (Exception e) {
			testStepHandle("FAIL", driver, loginfo2, e, "Enable all the SkyDoc features");
		}
	}

	@Then("^Verify features enabled in the skydoc subtab$")
	public void verify_features_in_the_skydoc_subtab() throws InterruptedException {
		ExtentTest loginfo = null;
		try {
			loginfo = test.createNode("Verification of all the SkyDoc features");
			skyDocSetupPage.verifyEnabledFeatures(loginfo);
		} catch (Exception e) {
			testStepHandle("FAIL", driver, loginfo, e, "Verification of all the SkyDoc features");
		}
	}
	
	@Then("^Disable all the Skydoc features$")
	public void disable_all_the_Skydoc_features() throws InterruptedException {
		ExtentTest loginfo = null;
		try {
			test = extent.createTest("Verification of all the SkyDoc features while disabling features");
			loginfo = test.createNode("Disable all the SkyDoc features");
			skyDocSetupPage = homePage.clickOnSkyDocSetupPageLink();
			skyDocSetupPage.disableAllSkyDocFeatures();
			loginfo.pass("Disabled all the SkyDoc features");
		} catch (Exception e) {
			testStepHandle("FAIL", driver, loginfo, e, "Disable all the SkyDoc features");
		}
	}

	@Then("^Verify features disabled in the skydoc subtab$")
	public void verify_features_disabled_in_the_skydoc_subtab() throws InterruptedException {
		ExtentTest loginfo = null;
		try {
			loginfo = test.createNode("Verification of all the SkyDoc features");
			skyDocSetupPage.verifyDisabledFeatures(loginfo);
		} catch (Exception e) {
			testStepHandle("FAIL", driver, loginfo, e, "Verification of all the SkyDoc features");
		}
	}
	
	@Then("^Verify Folder Hierarchy feature in SkyDoc$")
	public void verify_folder_hierarchy_feature_in_skydoc() throws InterruptedException {
		ExtentTest loginfo = null;
		try {
			test = extent.createTest("Verification of Folder Hierarchy feature in SkyDoc");
			loginfo = test.createNode("Verification of Folder Hierarchy feature in SkyDoc");
			homePage.clickOnSkyDocSetupPageLink();
			skyDocSetupPage.enableAllSkyDocFeatures();
			skyDocSetupPage.verifyFolderHierarchyFeature("Test Hierarchy", loginfo);
		} catch (Exception e) {
			testStepHandle("FAIL", driver, loginfo, e, "Verification of Folder Hierarchy feature in SkyDoc");
		}
	}
	
	@Then("^Verify Copy Parent Folder Permissions feature in SkyDoc$")
	public void verify_copy_parent_folder_permissions_feature_in_skydoc() throws InterruptedException {
		ExtentTest loginfo = null;
		try {
			test = extent.createTest("Verification of Copy Parent Folder Permissions feature in SkyDoc");
			loginfo = test.createNode("Verification of Copy Parent Folder Permissions feature in SkyDoc");
			skyDocSetupPage.verifyCopyParentFolderPermissionsFeature("ABC", "test folder099", loginfo);
		} catch (Exception e) {
			testStepHandle("FAIL", driver, loginfo, e, "Verification of Folder Hierarchy feature in SkyDoc");
		}
	}
	
	@Then("^Verify Default Folder for Record feature in SkyDoc$")
	public void verify_default_folder_for_Record_feature_in_skydoc() throws InterruptedException {
		ExtentTest loginfo = null;
		try {
			test = extent.createTest("Verification of Default Folder for Record feature in SkyDoc");
			loginfo = test.createNode("Verify the SkyDoc Upload folder in Vendor: 'Bob Ford, CPA' record when Folder: 'Design Documents' is selected as Default folder for Vendor records");
			skyDocSetupPage.verifyDefaultFolderForRecordFeature("Design Documents", "Vendor", "Bob Ford, CPA", loginfo);
		} catch (Exception e) {
			testStepHandle("FAIL", driver, loginfo, e, "Verification of Folder Hierarchy feature in SkyDoc");
		}
	}
	
	@Then("^Verify Automatic Folder Creation for entities feature in SkyDoc$")
	public void verify_automatic_folder_creation_feature_in_skydoc() throws InterruptedException {
		ExtentTest loginfo = null;
		try {
			test = extent.createTest("Verification of Automatic Folder Creation for entities feature in SkyDoc");
			loginfo = test.createNode("Verify Folder Creation when Customer: 'Test Customer Folder' is created");
			skyDocSetupPage.verifyAutomaticFolderCreationFeature("Test Folder creation", loginfo);
		} catch (Exception e) {
			testStepHandle("FAIL", driver, loginfo, e, "Verification of Folder Hierarchy feature in SkyDoc");
		}
	}
	
	@Given("^User is on SkyDoc Roles page$")
	public void user_is_on_SkyDoc_Roles_page() throws Throwable {
		ExtentTest loginfo = null;
		try {
			test = extent.createTest("Verification of all the SkyDoc features after enabling or disabling features in Roles Page");
			loginfo = test.createNode("login");
			// User login to Netsuite with Tvarana Dev Test role
			TestBase.init();
			loginPage = new LoginPage();
			authPage = loginPage.login();
			homePage = authPage.Authentication();
			homePage.changeRole(prop.getProperty("companyName"), prop.getProperty("role"), prop.getProperty("roleType"), prop.getProperty("selectedRole"));
			loginfo.pass("Login Successful in Netsuite");
		} catch (Exception e) {
			testStepHandle("FAIL", driver, loginfo, e, "login");
		}
		
		ExtentTest loginfo2 = null;
		try {
			skyDocRolesPage = homePage.clickOnSkyDocRolesPageLink();
		} catch (Exception e) {
			testStepHandle("FAIL", driver, loginfo2, e, "Verification of all the SkyDoc features after enabling or disabling features in Roles Page");
		}
	}

	@Then("^Remove Delete functionality for Administrator role, Enter Folder label & Category label, enable category checkbox$")
	public void disable_Delete_functionality_for_Administrator_role() {
		ExtentTest loginfo = null;
		try {
			loginfo = test.createNode("Enable or Disable features in SkyDoc Roles Pages");
			skyDocRolesPage.disableDeleteFeature(loginfo);
		} catch (Exception e) {
			testStepHandle("FAIL", driver, loginfo, e, "Enable or Disable features in SkyDoc Roles Pages");
		}
	}

	@Then("^Verify all the functionalities in Customer record$")
	public void verify_the_Delecte_functionality_in_Customer_record() throws InterruptedException {
		ExtentTest loginfo = null;
		try {
			loginfo = test.createNode("Verification of all the SkyDoc features");
			skyDocRolesPage.verifyDeleteBtnInCustomerPage(loginfo);
		} catch (Exception e) {
			testStepHandle("FAIL", driver, loginfo, e, "Verification of all the SkyDoc features");
		}
	}
	
	@Then("^Upload file & verify the file in the SkyDoc list using excel data at \"([^\"]*)\"$")
	public void verify_file_upload(@Transform(ExcelDataToDataTable.class) DataTable skyDocData) throws AWTException, InterruptedException {
		ExtentTest loginfo = null;
		try {
			test = extent.createTest("Verification of File Upload feature in SkyDoc");
			// User login to Netsuite with Tvarana Dev Test role
			TestBase.init();
			loginPage = new LoginPage();
			authPage = loginPage.login();
			homePage = authPage.Authentication();
			homePage.changeRole(prop.getProperty("companyName"), prop.getProperty("role"), prop.getProperty("roleType"), prop.getProperty("selectedRole"));
		} catch (Exception e) {
			testStepHandle("FAIL", driver, loginfo, e, "Login");
		}
		
		ExtentTest loginfo2 = null;
		try {
			loginfo2 = test.createNode("Enable all the SkyDoc features");
			skyDocSetupPage = homePage.clickOnSkyDocSetupPageLink();
			skyDocSetupPage.enableAllSkyDocFeatures();
			homePage.clickOnSkyDocRolesPageLink();
			skyDocSetupPage.enableAllSkyDocFeaturesInRolesPage();
			loginfo2.pass("Enabled all the SkyDoc features");
		} catch (Exception e) {
			testStepHandle("FAIL", driver, loginfo2, e, "Enable all the SkyDoc features");
		}
		ExtentTest loginfo3 = null;
		try {
			skyDocSetupPage.openCustomer("ABC");
			for(Map<String,String> data: skyDocData.asMaps(String.class, String.class)) {
				String folderName = data.get("Folder");
				String categoryName = data.get("Category");
				String filePath = data.get("File path");
				String[] filepath = filePath.split(Pattern.quote(File.separator));
		        String uploadFileName = filepath[filepath.length-1];
				loginfo3 = test.createNode("Verify uploading a File: '"+uploadFileName+"' in the Customer: 'ABC' record");
				skyDocSetupPage.verifyFileUpload(folderName, categoryName, filePath, loginfo3);
			}
		} catch (Exception e) {
			testStepHandle("FAIL", driver, loginfo3, e, "Verification of File uploaded in SkyDoc display list");
		}
	}
	
	@Then("^Verify File upload without selecting folder$")
	public void verify_file_upload_without_folder() throws AWTException, InterruptedException {
		ExtentTest loginfo = null;
		try {
			test = extent.createTest("Verification of File Upload without selecting folder");
			loginfo = test.createNode("Verification of alert when uploading a file '1.jpg' without selecting folder");
			skyDocSetupPage.openCustomer("ABC");
			skyDocSetupPage.verifyFileUploadWithoutFolder(loginfo);
		} catch (Exception e) {
			testStepHandle("FAIL", driver, loginfo, e, "Verification of File Upload without selecting folder");
		}
	}
	
	@Then("^Verify Add Note functionality in SkyDoc display list$")
	public void verify_Add_Note_functionality_in_SkyDoc_display_list() throws InterruptedException {
		ExtentTest loginfo = null;
		try {
			test = extent.createTest("Verification of Add Note functionality in SkyDoc");
			loginfo = test.createNode("Verification of note file in SkyDoc display list");
			skyDocSetupPage.openCustomer("ABC");
			skyDocSetupPage.verifyAddNoteFunctionality(loginfo);
		} catch (Exception e) {
			testStepHandle("FAIL", driver, loginfo, e, "Verification of Add Note functionality in SkyDoc");
		}
	}

	@Then("^Verify Move/Copy functionality in SkyDoc display list using excel data at \"([^\"]*)\"$")
	public void verify_Move_Copy_functionality_in_SkyDoc_display_list(@Transform(ExcelDataToDataTable.class) DataTable skyDocData) throws InterruptedException {
		ExtentTest loginfo = null;
		try {
			test = extent.createTest("Verification of Move/Copy functionality in SkyDoc");
			for(Map<String,String> data: skyDocData.asMaps(String.class, String.class)) {
				String moveCopyFlag = data.get("Move Copy Flag");
				String sourceCustomer = data.get("Source Customer");
				String destinationCustomer = data.get("Destination Customer");
				String fileName = data.get("File name");
				if(moveCopyFlag.equals("C")) {
					loginfo = test.createNode("Verify copying file(s) '"+fileName+"' from Customer: "+sourceCustomer+" to Customer: "+destinationCustomer);
				}else if(moveCopyFlag.equals("M")) {
					loginfo = test.createNode("Verify moving file(s) '"+fileName+"' from Customer: "+sourceCustomer+" to Customer: "+destinationCustomer);
				}
				skyDocSetupPage.openCustomer(sourceCustomer);
				skyDocSetupPage.verifyMoveCopyFunctionality(moveCopyFlag, sourceCustomer, destinationCustomer, fileName, loginfo);
			}
		} catch (Exception e) {
			testStepHandle("FAIL", driver, loginfo, e, "Verification of Move/Copy functionality in SkyDoc");
		}
	}

	@Then("^Verify Attach Files functionality in SkyDoc display list using excel data at \"([^\"]*)\"$")
	public void verify_Attach_Files_functionality_in_SkyDoc_display_list(@Transform(ExcelDataToDataTable.class) DataTable skyDocData) throws InterruptedException {
		ExtentTest loginfo = null;
		try {
			test = extent.createTest("Verification of Attach Files functionality in SkyDoc");
			for(Map<String,String> data: skyDocData.asMaps(String.class, String.class)) {
				String customer = data.get("Customer");
				String sourceFolder = data.get("Source Folder");
				String destinationFolder = data.get("Destination Folder");
				String fileName = data.get("File Name");
				loginfo = test.createNode("Verify attaching a file '"+fileName+"' from Folder: "+sourceFolder);
				skyDocSetupPage.openCustomer(customer);
				skyDocSetupPage.verifyAttachFileFunctionality(sourceFolder, destinationFolder, fileName, loginfo);
			}
		} catch (Exception e) {
			testStepHandle("FAIL", driver, loginfo, e, "Verification of Attach Files functionality in SkyDoc");
		}
	}

	@Then("^Verify SkyDoc Gallery in SkyDoc display list$")
	public void verify_SkyDoc_Gallery_in_SkyDoc_display_list() throws InterruptedException {
		ExtentTest loginfo = null;
		try {
			test = extent.createTest("Verification of SkyDoc Gallery functionality in SkyDoc");
			loginfo = test.createNode("Verification of SkyDoc Gallery functionality in SkyDoc display list");
			skyDocSetupPage.openCustomer("ABC");
			skyDocSetupPage.verifySkyDocGalleryFunctionality(loginfo);
		} catch (Exception e) {
			testStepHandle("FAIL", driver, loginfo, e, "Verification of SkyDoc Gallery functionality in SkyDoc");
		}
	}

	@Then("^Verify Delete functionality in SkyDoc display list using excel data at \"([^\"]*)\"$")
	public void verify_Delete_functionality_in_SkyDoc_display_list(@Transform(ExcelDataToDataTable.class) DataTable skyDocData) throws InterruptedException {
		ExtentTest loginfo = null;
		try {
			test = extent.createTest("Verification of Delete functionality in SkyDoc");
			for(Map<String,String> data: skyDocData.asMaps(String.class, String.class)) {
				String customer = data.get("Customer");
				String fileName = data.get("File Name");
				loginfo = test.createNode("Verify deleting file(s) '"+fileName+"' in the Customer: "+customer+" record");
				skyDocSetupPage.openCustomer(customer);
				skyDocSetupPage.verifyDeleteFunctionality(fileName, loginfo);
			}
		} catch (Exception e) {
			testStepHandle("FAIL", driver, loginfo, e, "Verification of Delete functionality in SkyDoc");
		}
	}

//	@Then("^Verify Search functionality in SkyDoc display list$")
//	public void verify_Search_functionality_in_SkyDoc_display_list() throws InterruptedException {
//		ExtentTest loginfo = null;
//		try {
//			test = extent.createTest("Verification of Search functionality in SkyDoc");
//			loginfo = test.createNode("Verification of Search functionality for the Search criteria 'note' in SkyDoc display list");
//			skyDocSetupPage.openCustomer("ABC");
//			skyDocSetupPage.verifySearchFunctionality(loginfo);
//		} catch (Exception e) {
//			testStepHandle("FAIL", driver, loginfo, e, "Verification of Search functionality in SkyDoc");
//		}
//	}

	@Then("^Verify File preview functionality in SkyDoc display list$")
	public void verify_File_preview_functionality_in_SkyDoc_display_list() throws InterruptedException {
		ExtentTest loginfo = null;
//		try {
			test = extent.createTest("Verification of File preview functionality in SkyDoc");
			loginfo = test.createNode("Verify preview for the file '1.jpg' in the Customer: ABC record");
			skyDocSetupPage.openCustomer("ABC");
			skyDocSetupPage.verifyFilePreviewFunctionality(loginfo);
//		} catch (Exception e) {
//			testStepHandle("FAIL", driver, loginfo, e, "Verification of File preview functionality in SkyDoc");
//		}
	}
	
	@Then("^Verify File preview for mp4 file in SkyDoc display list$")
	public void verify_File_preview_for_mp4_file_in_SkyDoc_display_list() throws InterruptedException {
		ExtentTest loginfo = null;
		try {
			test = extent.createTest("Verification of File preview functionality for .mp4 file in SkyDoc");
			loginfo = test.createNode("Verify preview for the file 'sample video.mp4' in the Customer: abctest record");
			skyDocSetupPage.openCustomer("abctest");
			skyDocSetupPage.verifyVideoPreview(loginfo);
		} catch (Exception e) {
			testStepHandle("FAIL", driver, loginfo, e, "Verification of File preview functionality in SkyDoc");
		}
	}

	@Then("^Verify Download functionality in SkyDoc display list$")
	public void verify_Download_functionality_in_SkyDoc_display_list() throws InterruptedException {
		ExtentTest loginfo = null;
		try {
			test = extent.createTest("Verification of Download functionality & Entity download field in SkyDoc");
			loginfo = test.createNode("Verify downloading a file '1.jpg' in the Customer: ABC record & verify Entity download field value in AWS S3 record");
			skyDocSetupPage.openCustomer("ABC");
			skyDocSetupPage.verifyDownloadFunctionality(loginfo);
		} catch (Exception e) {
			testStepHandle("FAIL", driver, loginfo, e, "Verification of Download functionality & Entity download field in SkyDoc");
		}
	}

	@Then("^Verify View functionality in SkyDoc display list$")
	public void verify_View_functionality_in_SkyDoc_display_list() throws InterruptedException {
		ExtentTest loginfo = null;
		try {
			test = extent.createTest("Verification of View functionality in SkyDoc");
			loginfo = test.createNode("Verify viewing a file '1.jpg' in the Customer: ABC record");
			skyDocSetupPage.openCustomer("ABC");
			skyDocSetupPage.verifyViewFunctionality(loginfo);
		} catch (Exception e) {
			testStepHandle("FAIL", driver, loginfo, e, "Verification of View functionality in SkyDoc");
		}
	}
	
	@Then("^Verify files related to transactions after clicking Transaction Files button$")
	public void verify_Transaction_Files_functionality() throws InterruptedException {
		ExtentTest loginfo = null;
		try {
			test = extent.createTest("Verification of Transaction Files functionality in SkyDoc");
			loginfo = test.createNode("Verify files related to transactions after clicking Transaction Files button in the Customer: ABC record");
			skyDocSetupPage.openCustomer("ABC");
			skyDocSetupPage.verifyTransactionFilesFunctionality(loginfo);
		} catch (Exception e) {
			testStepHandle("FAIL", driver, loginfo, e, "Verification of Transaction Files functionality in SkyDoc");
		}
	}
	
	@Then("^Verify File check out without selecting any file$")
	public void verify_File_check_out_without_selecting_any_file() throws InterruptedException {
		ExtentTest loginfo = null;
		try {
			test = extent.createTest("Verification of File check out without selecting any file in SkyDoc");
			loginfo = test.createNode("Verify the alert occured on clicking check out button without selecting a file");
			skyDocSetupPage.openCustomer("ABC");
			skyDocSetupPage.verifyFileCheckOutWithoutSelectingFile(loginfo);
		} catch (Exception e) {
			testStepHandle("FAIL", driver, loginfo, e, "Verification of File check out without selecting any file in SkyDoc");
		}
	}

	@Then("^Verify File check out functionality using excel data at \"([^\"]*)\"$")
	public void verify_File_check_out_functionality_using_excel_data_at(@Transform(ExcelDataToDataTable.class) DataTable skyDocData) throws InterruptedException {
		ExtentTest loginfo = null;
		try {
			test = extent.createTest("Verification of File check out functionality in SkyDoc");
			for(Map<String,String> data: skyDocData.asMaps(String.class, String.class)) {
				String customer = data.get("Customer");
				String fileName = data.get("File Name");
				loginfo = test.createNode("Verify checking out a file '"+fileName+"' in the Customer: "+customer+" record");
				skyDocSetupPage.openCustomer(customer);
				skyDocSetupPage.verifyCheckOutFunctionality(fileName, loginfo);
			}
		} catch (Exception e) {
			testStepHandle("FAIL", driver, loginfo, e, "Verification of File check out functionality in SkyDoc");
		}
	}
	
	@Then("^Verify Uploading a file after check out of same file with file data \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
	public void verify_Uploading_a_file_after_check_out_of_same_file_with_file_data(String folderName, String categoryName, String filePath) throws AWTException, InterruptedException {
		ExtentTest loginfo = null;
		try {
			test = extent.createTest("Verify Uploading a file after check out of same file");
			skyDocSetupPage.openCustomer("Tvarana Customer");
			String[] filepath = filePath.split(Pattern.quote(File.separator));
	        String fileName = filepath[filepath.length-1];
	        loginfo = test.createNode("Verify uploading a file '"+fileName+"' after check out of same file in the Customer: Tvarana Customer record");
			skyDocSetupPage.verifyFileUpload(folderName, categoryName, filePath, loginfo);
			skyDocSetupPage.verifyCheckOutFunctionality(fileName, loginfo);
			skyDocSetupPage.verifyFileUpload(folderName, categoryName, filePath, loginfo);
			skyDocSetupPage.verifyCheckOutSymbol(fileName, loginfo);
		} catch (Exception e) {
			testStepHandle("FAIL", driver, loginfo, e, "Verify Uploading a file after check out of same file");
		}
	}
	
	@Then("^Verify New Folder Functionality$")
	public void verify_new_folder_functionality() throws InterruptedException {
		ExtentTest loginfo = null;
		try {
			test = extent.createTest("Verification of New Folder functionality in SkyDoc");
			loginfo = test.createNode("Verify creating a new folder for the Customer: Customer Test");
			skyDocSetupPage.openCustomer("Tvarana Customer");
			skyDocSetupPage.verifyNewFolderFunctionality(loginfo);
		} catch (Exception e) {
			testStepHandle("FAIL", driver, loginfo, e, "Verification of New Folder functionality in SkyDoc");
		}
	}
	
	@Then("^Verify note \"([^\"]*)\" added to the file \"([^\"]*)\" for the customer \"([^\"]*)\"$")
	public void verify_note_added_to_the_file_for_the_customer(String note, String fileName, String customer) throws InterruptedException {
		ExtentTest loginfo = null;
		try {
			test = extent.createTest("Verification of adding note to a file in SkyDoc");
			loginfo = test.createNode("Verify adding Note: "+note+" to a file '"+fileName+" for the Customer: "+customer);
			skyDocSetupPage.openCustomer(customer);
			skyDocSetupPage.addNoteForFile(note, fileName, loginfo);
		} catch (Exception e) {
			testStepHandle("FAIL", driver, loginfo, e, "Verification of adding note to a file in SkyDoc");
		}
	}
	
	@Then("^Verify folder filter \"([^\"]*)\" for the Customer \"([^\"]*)\" in SkyDoc display list$")
	public void verify_folder_filter_for_the_Customer_in_SkyDoc_display_list(String folderName, String customer) throws InterruptedException {
		ExtentTest loginfo = null;
		try {
			test = extent.createTest("Verification of SkyDoc display list based on the Folder filter applied");
			loginfo = test.createNode("Verify SkyDoc display list for the Folder '"+folderName+"' selected in the Customer: "+customer+" record");
			skyDocSetupPage.openCustomer(customer);
			skyDocSetupPage.verifyFolderFilter(folderName, loginfo);
		} catch (Exception e) {
			testStepHandle("FAIL", driver, loginfo, e, "Verification of SkyDoc display list based on the Folder filter applied");
		}
	}
	
	@Then("^Verify file version when a file \"([^\"]*)\" is uploaded more than once in a customer record \"([^\"]*)\" with folder \"([^\"]*)\" & category \"([^\"]*)\"$")
	public void verify_file_version_when_a_file_is_uploaded_more_than_once_in_a_customer_record_with_folder_category(String filePath, String customer, String folder, String category) throws InterruptedException, AWTException {
		ExtentTest loginfo = null;
		try {
			test = extent.createTest("Verification of file version when a file is uploaded more than once");
			skyDocSetupPage.openCustomer(customer);
			String[] filepath = filePath.split(Pattern.quote(File.separator));;
	        String fileName = filepath[filepath.length-1];
	        loginfo = test.createNode("Verify the file version when a file '"+fileName+"' is uploaded more than once");
			skyDocSetupPage.verifyFileUpload(folder, category, filePath, loginfo);
			int version1 = skyDocSetupPage.getVersionForFile(fileName,folder,category);
			skyDocSetupPage.verifyFileUpload(folder, category, filePath, loginfo);
			int version2 = skyDocSetupPage.getVersionForFile(fileName,folder,category);
			skyDocSetupPage.verifyVersionsForMultipleFileUploads(fileName, version1, version2, loginfo);
		} catch (Exception e) {
			testStepHandle("FAIL", driver, loginfo, e, "Verification of file version when a file is uploaded more than once");
		}
	}
	
	@Then("^Verify deleting a file having multiple versions for the customer \"([^\"]*)\" with file data \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
	public void verify_deleting_a_file_having_multiple_versions_for_the_customer_with_file_data(String customer, String folderName, String categoryName, String filePath) throws InterruptedException {
		ExtentTest loginfo = null;
		try {
			String[] filepath = filePath.split(Pattern.quote(File.separator));;
	        String fileName = filepath[filepath.length-1];
			test = extent.createTest("Verification of file version when a file with multiple versions is deleted");
			loginfo = test.createNode("Verify the version of the file '"+fileName+"' when the file is deleted");
			skyDocSetupPage.verifyDeletingFileWithMultipleVersions(customer, folderName, categoryName, filePath, loginfo);
		} catch (Exception e) {
			testStepHandle("FAIL", driver, loginfo, e, "Verification of file version when a file with multiple versions is deleted");
		}
	}
	
	@Then("^Verify email functionality with attaching SkyDoc files using email data \"([^\"]*)\", \"([^\"]*)\" & \"([^\"]*)\"$")
	public void verify_email_functionality_with_attaching_SkyDoc_files_using_email_data(String customer, String subject, String fileName) throws InterruptedException {
		ExtentTest loginfo = null;
		try {
			test = extent.createTest("Verification of email functionality with SkyDoc files attached");
			loginfo = test.createNode("Verify sending an email with the file '"+fileName+"' attached");
			skyDocSetupPage.openCustomer(customer);
			skyDocSetupPage.verifyEmailFunctionalityWithSkyDocFiles(subject, fileName, loginfo);
		} catch (Exception e) {
			testStepHandle("FAIL", driver, loginfo, e, "Verification of email functionality with SkyDoc files attached");
		}
	}
	
	@Then("^Verify Skydoc files in the Email record are displaying correctly for the customer \"([^\"]*)\"$")
	public void verify_Skydoc_files_in_the_Email_record_are_displaying_correctly_for_the_customer(String customer) throws InterruptedException {
		ExtentTest loginfo = null;
		try {
			test = extent.createTest("Verification of files list in the SkyDoc Files subtab on clicking the Email");
			loginfo = test.createNode("Verify the files list in the SkyDoc Files subtab in the Email record for the Customer: "+customer);
			skyDocSetupPage.openCustomer(customer);
			skyDocSetupPage.verifySkyDocFilesInEmailRecord(customer, loginfo);
		} catch (Exception e) {
			testStepHandle("FAIL", driver, loginfo, e, "Verification of files list in the SkyDoc Files subtab on clicking the Email");
		}
	}
	
	@Then("^Verify File upload functionality in SkyDoc Folders Page using excel data at \"([^\"]*)\"$")
	public void verify_File_upload_functionality_in_SkyDoc_Folders_Page_using_excel_data_at(@Transform(ExcelDataToDataTable.class) DataTable skyDocData) throws InterruptedException, AWTException {
		ExtentTest loginfo = null;
		try {
			test = extent.createTest("Verification of File upload functionality in SkyDoc Folders Page");
			skyDocFoldersPage = skyDocSetupPage.clickOnSkyDocFoldersLink();
			for(Map<String,String> data: skyDocData.asMaps(String.class, String.class)) {
				String folderName = data.get("Folder");
				String categoryName = data.get("Category");
				String filePath = data.get("File path");
				String[] filepath = filePath.split(Pattern.quote(File.separator));;
		        String fileName = filepath[filepath.length-1];
				loginfo = test.createNode("Verify uploading a file '"+fileName+"' in the Folder '"+folderName+"' in SkyDoc Folders Page");
				skyDocFoldersPage.verifyFileUploadFunctionality(folderName, categoryName, filePath, loginfo);
			}
		} catch (Exception e) {
			testStepHandle("FAIL", driver, loginfo, e, "Verification of File upload functionality in SkyDoc Folders Page");
		}
	}
	
	@Then("^Verify Move Files functionality in SkyDoc Folders Page using excel data at \"([^\"]*)\"$")
	public void verify_Move_Files_functionality_in_SkyDoc_Folders_Page_using_excel_data_at(@Transform(ExcelDataToDataTable.class) DataTable skyDocData) throws InterruptedException {
		ExtentTest loginfo = null;
		try {
			test = extent.createTest("Verification of Move Files functionality in SkyDoc Folders Page");
			skyDocFoldersPage = skyDocSetupPage.clickOnSkyDocFoldersLink();
			for(Map<String,String> data: skyDocData.asMaps(String.class, String.class)) {
				String sourceFolder = data.get("Source Folder");
				String destinationFolder = data.get("Destination Folder");
				String fileName = data.get("File name");
				loginfo = test.createNode("Verify moving a file '"+fileName+"' from '"+sourceFolder+"' folder to '"+destinationFolder+"' in SkyDoc Folders Page");
				skyDocFoldersPage.verifyMoveFilesFunctionality(sourceFolder, destinationFolder, fileName, loginfo);
			}
		} catch (Exception e) {
			testStepHandle("FAIL", driver, loginfo, e, "Verification of Move Files functionality in SkyDoc Folders Page");
		}
	}

	@Then("^Verify Copy Files functionality in SkyDoc Folders Page using excel data at \"([^\"]*)\"$")
	public void verify_Copy_Files_functionality_in_SkyDoc_Folders_Page_using_excel_data_at(@Transform(ExcelDataToDataTable.class) DataTable skyDocData) throws InterruptedException {
		ExtentTest loginfo = null;
		try {
			test = extent.createTest("Verification of Copy Files functionality in SkyDoc Folders Page");
			skyDocFoldersPage = skyDocSetupPage.clickOnSkyDocFoldersLink();
			for(Map<String,String> data: skyDocData.asMaps(String.class, String.class)) {
				String sourceFolder = data.get("Source Folder");
				String destinationFolder = data.get("Destination Folder");
				String fileName = data.get("File name");
				loginfo = test.createNode("Verify copying a file '"+fileName+"' from '"+sourceFolder+"' folder to '"+destinationFolder+"' in SkyDoc Folders Page");
				skyDocFoldersPage.verifyCopyFilesFunctionality(sourceFolder, destinationFolder, fileName, loginfo);
			}
		} catch (Exception e) {
			testStepHandle("FAIL", driver, loginfo, e, "Verification of Copy Files functionality in SkyDoc Folders Page");
		}
	}
	
	@Then("^Verify Delete Files functionality in SkyDoc Folders Page using excel data at \"([^\"]*)\"$")
	public void verify_Delete_Files_functionality_in_SkyDoc_Folders_Page_using_excel_data_at(@Transform(ExcelDataToDataTable.class) DataTable skyDocData) throws InterruptedException {
		ExtentTest loginfo = null;
		try {
			test = extent.createTest("Verification of Delete Files functionality in SkyDoc Folders Page");
			skyDocFoldersPage = skyDocSetupPage.clickOnSkyDocFoldersLink();
			for(Map<String,String> data: skyDocData.asMaps(String.class, String.class)) {
				String folderName = data.get("Folder Name");
				String fileName = data.get("File name");
				loginfo = test.createNode("Verify deleting a file '"+fileName+"' from the folder '"+folderName+"' in SkyDoc Folders Page");
				skyDocFoldersPage.verifyDeleteFilesFunctionality(folderName, fileName, loginfo);
			}
		} catch (Exception e) {
			testStepHandle("FAIL", driver, loginfo, e, "Verification of Delete Files functionality in SkyDoc Folders Page");
		}
	}
	
	@Then("^Verify New Folder functionality in SkyDoc Folders Page with folder name \"([^\"]*)\"$")
	public void verify_New_Folder_functionality_in_SkyDoc_Folders_Page_with_folder_name(String folderName) throws Throwable {
		ExtentTest loginfo = null;
		try {
			test = extent.createTest("Verification of New Folder functionality in SkyDoc Folders Page");
			loginfo = test.createNode("Verify creating a new folder '"+folderName+"' in SkyDoc Folders Page");
			skyDocFoldersPage = skyDocSetupPage.clickOnSkyDocFoldersLink();
			skyDocFoldersPage.verifyNewFolderFunctionality(folderName, loginfo);
		} catch (Exception e) {
			testStepHandle("FAIL", driver, loginfo, e, "Verification of New Folder functionality in SkyDoc Folders Page");
		}
	}
	
	@Then("^Verify if files uploaded to a public folder are public by default for the Customer \"([^\"]*)\" & file upload data \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
	public void verify_if_files_uploaded_to_a_public_folder_are_public_by_default_for_the_Customer_file_upload_data(String customer, String folder, String category, String filePath) throws InterruptedException, AWTException {
		ExtentTest loginfo = null;
		try {
			String[] filepath = filePath.split(Pattern.quote(File.separator));;
	        String fileName = filepath[filepath.length-1];
			test = extent.createTest("Verification of file uploaded to a public folder is public by default");
			loginfo = test.createNode("Verify uploading a file '"+fileName+"' to a public folder '"+folder+"' is public or not");
			skyDocSetupPage.clickOnSkyDocFoldersListLink();
			skyDocSetupPage.verifyFileUploadInPublicFolder(customer, folder, category, filePath, loginfo);
		} catch (Exception e) {
			testStepHandle("FAIL", driver, loginfo, e, "Verification of file uploaded to a public folder is public by default");
		}
	}
	
	@Then("^Verify folder access in the SkyDoc portal after giving folder access to external user with excel data at \"([^\"]*)\"$")
	public void verify_folder_access_in_the_SkyDoc_portal_after_giving_folder_access_to_external_user_with_excel_data_at(@Transform(ExcelDataToDataTable.class) DataTable skyDocData) throws InterruptedException {
		ExtentTest loginfo = null;
		try {
			test = extent.createTest("Verification of folder access in the SkyDoc portal after giving folder access to external user");
			for(Map<String,String> data: skyDocData.asMaps(String.class, String.class)) {
				String folderName = data.get("Folder");
				String employeeName = data.get("Employee Name");
				loginfo = test.createNode("Verify access to the folder '"+folderName+"' in the SkyDoc portal for the User: "+employeeName);
				skyDocSetupPage.verifyFolderAccessInPortal(folderName, employeeName, loginfo);
			}
		} catch (Exception e) {
			testStepHandle("FAIL", driver, loginfo, e, "Verification of folder access in the SkyDoc portal after giving folder access to external user");
		}
	}
	
	
	@Then("^Verify Send for Approval functionality using excel data at \"([^\"]*)\"$")
	public void verify_Send_for_Approval_functionality_using_excel_data_at(@Transform(ExcelDataToDataTable.class) DataTable skyDocData) throws AWTException, InterruptedException {
		ExtentTest loginfo = null;
		try {
			test = extent.createTest("Verification of File approval process using 'Send for Approval' functionality in SkyDoc");
			for(Map<String,String> data: skyDocData.asMaps(String.class, String.class)) {
				String entityName = data.get("Entity");
				String folderName = data.get("Folder");
				String categoryName = data.get("Category");
				String filePath = data.get("File Path");
				String comments = data.get("Comments");
				String approvalFlag = data.get("Approval Flag");
				String[] filepath = filePath.split(Pattern.quote(File.separator));;
		        String fileName = filepath[filepath.length-1];
				loginfo = test.createNode("Verify File approval process for the file '"+fileName+"' by the User: "+entityName+" in SkyDoc");
				skyDocSetupPage.verifySendForApprovalFunctionality(entityName, folderName, categoryName, filePath, comments, approvalFlag, loginfo);
			}
		} catch (Exception e) {
			testStepHandle("FAIL", driver, loginfo, e, "Verification of File approval process using 'Send for Approval' functionality in SkyDoc");
		}
	}
	
	@Then("^Enable SkyDoc Portal access, SkyDoc Portal Access Notification, enter password \"([^\"]*)\" for the employee \"([^\"]*)\" and verify login access in the SkyDoc Portal$")
	public void enable_SkyDoc_Portal_access_SkyDoc_Portal_Access_Notification_enter_password_for_the_employee_and_verify_login_access_in_the_SkyDoc_Portal(String password, String employeeName) throws Throwable {
		ExtentTest loginfo = null;
		try {
			test = extent.createTest("Verification of SkyDoc Portal access in SkyDoc");
			// User login to Netsuite with Tvarana Dev Test role
			TestBase.init();
			loginPage = new LoginPage();
			authPage = loginPage.login();
			homePage = authPage.Authentication();
			homePage.changeRole(prop.getProperty("companyName"), prop.getProperty("role"), prop.getProperty("roleType"), prop.getProperty("selectedRole"));
		} catch (Exception e) {
			testStepHandle("FAIL", driver, loginfo, e, "Login");
		}
		
		ExtentTest loginfo2 = null;
		try {
			loginfo2 = test.createNode("Enable all the SkyDoc features");
			skyDocSetupPage = homePage.clickOnSkyDocSetupPageLink();
			skyDocSetupPage.enableAllSkyDocFeatures();
			homePage.clickOnSkyDocRolesPageLink();
			skyDocSetupPage.enableAllSkyDocFeaturesInRolesPage();
			loginfo2.pass("Enabled all the SkyDoc features");
		} catch (Exception e) {
			testStepHandle("FAIL", driver, loginfo2, e, "Enable all the SkyDoc features");
		}
		
		ExtentTest loginfo3 = null;
		try {
			loginfo3 = test.createNode("Verify SkyDoc Portal access for the User: "+employeeName);
			skyDocSetupPage.enableAndVerifySkyDocPortalAccess(employeeName, password, loginfo3);
		} catch (Exception e) {
			testStepHandle("FAIL", driver, loginfo3, e, "Verification of SkyDoc Portal access in SKyDoc");
		}
	}
	
	@Then("^Verify View functionality in AWS record$")
	public void verify_View_functionality_in_AWS_record() throws InterruptedException {
		ExtentTest loginfo = null;
		try {
			test = extent.createTest("Verification of View functionality & File view field value in AWS record");
			// User login to Netsuite with Tvarana Dev Test role
			TestBase.init();
			loginPage = new LoginPage();
			authPage = loginPage.login();
			homePage = authPage.Authentication();
			homePage.changeRole(prop.getProperty("companyName"), prop.getProperty("role"), prop.getProperty("roleType"), prop.getProperty("selectedRole"));
		} catch (Exception e) {
			testStepHandle("FAIL", driver, loginfo, e, "Login");
		}
		
		ExtentTest loginfo2 = null;
		try {
			loginfo2 = test.createNode("Enable all the SkyDoc features");
			skyDocSetupPage = homePage.clickOnSkyDocSetupPageLink();
			skyDocSetupPage.enableAllSkyDocFeatures();
			homePage.clickOnSkyDocRolesPageLink();
			skyDocSetupPage.enableAllSkyDocFeaturesInRolesPage();
			loginfo2.pass("Enabled all the SkyDoc features");
		} catch (Exception e) {
			testStepHandle("FAIL", driver, loginfo2, e, "Enable all the SkyDoc features");
		}
		ExtentTest loginfo3 = null;
		try {
			loginfo3 = test.createNode("Verify viewing a file '1.jpg' & file count field value in AWS record");
			skyDocSetupPage.verifyViewFunctionalityInAWS("ABC","1.jpg", loginfo3);
		} catch (Exception e) {
			testStepHandle("FAIL", driver, loginfo3, e, "Verification of View functionality & File view field value in AWS record");
		}
	}

	@Then("^Verify Download functionality in AWS record$")
	public void verify_Download_functionality_in_AWS_record() throws InterruptedException {
		ExtentTest loginfo = null;
		try {
			test = extent.createTest("Verification of Download functionality & File Download field value in AWS record");
			loginfo = test.createNode("Verify downloading a file '1.jpg' & verify file download field value in AWS record");
			skyDocSetupPage.verifyDownloadFunctionalityInAWS("ABC","1.jpg",loginfo);
		} catch (Exception e) {
			testStepHandle("FAIL", driver, loginfo, e, "Verification of Download functionality & File Download field value in AWS record");
		}
	}

	@Then("^Verify Move/Copy functionality in AWS record using excel data at \"([^\"]*)\"$")
	public void verify_Move_Copy_functionality_in_AWS_record_using_excel_data_at(@Transform(ExcelDataToDataTable.class) DataTable skyDocData) throws InterruptedException {
		ExtentTest loginfo = null;
		try {
			test = extent.createTest("Verification of Move/Copy functionality in AWS record");
			for(Map<String,String> data: skyDocData.asMaps(String.class, String.class)) {
				String moveCopyFlag = data.get("Move Copy Flag");
				String sourceCustomer = data.get("Source Customer");
				String destinationCustomer = data.get("Destination Customer");
				String fileName = data.get("File name");
				if(moveCopyFlag.equals("C")) {
					loginfo = test.createNode("Verify copying a file '"+fileName+"' from Customer: "+sourceCustomer+" to Customer: "+destinationCustomer+" in the AWS record");
				}else if(moveCopyFlag.equals("M")) {
					loginfo = test.createNode("Verify moving a file '"+fileName+"' from Customer: "+sourceCustomer+" to Customer: "+destinationCustomer+" in the AWS record");
				}
				skyDocSetupPage.verifyMoveCopyFunctionalityInAWS(moveCopyFlag, sourceCustomer, destinationCustomer, fileName, loginfo);
			}
		} catch (Exception e) {
			testStepHandle("FAIL", driver, loginfo, e, "Verification of Move/Copy functionality in AWS record");
		}
	}

	@Then("^Verify Public URL and Private URL functionalities in AWS record$")
	public void verify_Public_URL_functionality_in_AWS_record() throws InterruptedException {
		ExtentTest loginfo = null;
		try {
			test = extent.createTest("Verification of Public URL and Private URL functionality in AWS record");
			loginfo = test.createNode("Verify clicking on Public URL & Private URL button in AWS record");
			skyDocSetupPage.verifyPublicAndPrivateURLFuncationality("ABC", "1.jpg", loginfo);
		} catch (Exception e) {
			testStepHandle("FAIL", driver, loginfo, e, "Verification of Public URL and Private URL functionality in AWS record");
		}
	}

	@Then("^Verify File versions in AWS record$")
	public void verify_File_versions_in_AWS_record() throws InterruptedException {
		ExtentTest loginfo = null;
		try {
			test = extent.createTest("Verification of File versions in AWS record");
			loginfo = test.createNode("Verification of File versions in AWS record");
			skyDocSetupPage.verifyFileVersionsInAWS("Tvarana T Customer", "2.jpg", loginfo);
		} catch (Exception e) {
			testStepHandle("FAIL", driver, loginfo, e, "Verification of File versions in AWS record");
		}
	}

	@Then("^Verify Email file functionality in AWS record using excel data at \"([^\"]*)\"$")
	public void verify_Email_file_functionality_in_AWS_record_using_excel_data_at(@Transform(ExcelDataToDataTable.class) DataTable skyDocData) throws InterruptedException {
		ExtentTest loginfo = null;
		try {
			test = extent.createTest("Verification of Email file functionality & verify mail merge tab in AWS record");
			for(Map<String,String> data: skyDocData.asMaps(String.class, String.class)) {
				String customer = data.get("Customer");
				String fileName = data.get("File name");
				String subject = data.get("Subject");
				String emailTemplate = data.get("Email Template");
				String recipientEmail = data.get("Recipient");
				loginfo = test.createNode("Verify sending email to "+recipientEmail+" with file '"+fileName+"' attached & verify mail merge tab in AWS record");
				skyDocSetupPage.verifyEmailFileFunctionalityInAWS(customer, fileName, subject, emailTemplate, recipientEmail, loginfo);
			}
		} catch (Exception e) {
			testStepHandle("FAIL", driver, loginfo, e, "Verification of Email file functionality & verify mail merge tab in AWS record");
		}
	}
	
}
