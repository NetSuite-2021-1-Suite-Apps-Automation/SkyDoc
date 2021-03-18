package com.qa.skyDocRP.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.qa.skyDocRP.util.TestBase;

public class SkyDocSetupPage extends TestBase{
	
	@FindBy(xpath = "//span[@id='custpage_dlink_fs']//img")
	WebElement enableDownloadCheckbox;
	
	@FindBy(xpath = "//span[@id='custpage_enafolder_fs']//img")
	WebElement foldersOnListCheckbox;
	
	@FindBy(xpath = "//span[@id='custpage_enacategory_fs']//img")
	WebElement enableCategoryCheckbox;
	
	@FindBy(xpath = "//span[@id='custpage_addnote_fs']//img")
	WebElement addNoteCheckbox;
	
	@FindBy(xpath = "//span[@id='custpageenable_move_copy_fs']//img")
	WebElement enableMoveCopyCheckbox;
	
	@FindBy(xpath = "//span[@id='custpage_extaccess_fs']//img")
	WebElement externalAccessCheckbox;
	
	@FindBy(xpath = "//span[@id='custpage_enb_drag_drop_fs']//img")
	WebElement enableDragDropCheckbox;
	
	@FindBy(xpath = "//span[@id='custpage_folderpageaccess_fs']//img")
	WebElement folderPageAccessCheckbox;
	
	@FindBy(xpath = "//span[@id='custpage_tss_skydoc_gallery_fs']//img")
	WebElement enableSkydocGalleryCheckbox;
	
	@FindBy(xpath = "//span[@id='custpage_tss_enable_view_in_list_fs']//img")
	WebElement enableViewInListCheckbox;
	
	@FindBy(xpath = "//span[@id='custpage_tss_enable_folder_fs']//img")
	WebElement enablFolderOnRecordCheckbox;
	
	@FindBy(xpath = "//span[@id='custpage_tss_disp_app_status_fs']//img")
	WebElement enableApprovalWorkflowCheckbox;
	
	@FindBy(xpath = "//span[@id='custpage_tss_rel_tran_files_msg_fs']//img")
	WebElement enableTransactionFilesCheckbox;
	
	@FindBy(xpath = "//span[@id='custpage_tss_disp_category_inline_fs']//img")
	WebElement enableInlineCategoryCheckbox;
	
	@FindBy(xpath = "//span[@id='custpage_tss_portal_files_restrict_fs']//img")
	WebElement portalFilesRestrictionCheckbox;
	
	@FindBy(xpath = "//span[@id='custpage_skydoc_folder_hierarchy_name_fs']//img")
	WebElement folderHierarchyCheckbox;
	
	@FindBy(xpath = "//span[@id='custpage_skydoc_portal_folder_create_fs']//img")
	WebElement newFolderInPortalCheckbox;
	
	@FindBy(xpath = "//span[@id='custpage_tss_enable_doc_checkout_fs']//img")
	WebElement enableDocCheckoutCheckbox;
	
	@FindBy(xpath = "//span[@id='custpage_tss_enable_related_records_fs']//img")
	WebElement enableRelatedRecordsCheckbox;
	
	@FindBy(xpath = "//span[@id='custpage_tss_enable_multi_category_fs']//img")
	WebElement enableMultipleCategoryCheckbox;
	
	@FindBy(xpath = "//span[@id='custpage_tss_enable_del_expenselinelevel_fs']//img")
	WebElement enableDelExpenseLineLevelCheckbox;
	
	@FindBy(xpath = "//span[@id='custpage_tss_st_app_pro_fs']//img")
	WebElement skyDocPortalApprovalCheckbox;
	
	@FindBy(xpath = "//span[@id='custpage_tss_st_upload_fs']//img")
	WebElement skyDocPortalUploadCheckbox;
	
	@FindBy(xpath = "//label[text()='Filter By']")
	WebElement label;
	
	@FindBy(xpath = "//input[@id='submitter']")
	WebElement submitBtn;
	
	@FindBy(xpath = "//span[text()='Lists']")
	WebElement listLink;
	
	@FindBy(xpath = "//span[text()='Relationships']")
	WebElement relationshipsLink;
	
	@FindBy(xpath = "//span[text()='Vendors']")
	WebElement vendorsLink;
	
	@FindBy(xpath = "//span[text()='Customers']")
	WebElement customersLink;
	
	@FindBy(xpath = "//span[text()='New']")
	WebElement newLink;
	
	@FindBy(xpath = "//span[text()='Transactions']")
	WebElement transactionsLink;
	
	@FindBy(xpath = "//span[text()='Enter Expense Reports']")
	WebElement expenseReportLink;
	
	@FindBy(xpath = "//span[text()='List']")
	WebElement expenseListLink;
	
	@FindBy(xpath = "//input[@name='inpt_quicksort']")
	WebElement quickSortDropdown;
	
	@FindBy(xpath = "//form//tr[contains(@id,'row')]//td[count(//form//table[@id='div__labtab']//div[contains(text(),'Name')]//parent::td//preceding-sibling::td)+1]//a")
	List<WebElement> customerList;
	
	@FindBy(xpath = "//tr[contains(@id,'row')]//td[5]")
	List<WebElement> listOfExpenseReports;
	
	@FindBy(xpath = "//a[text()='Sky' or text()='yDoc']")
	WebElement skyDocSubtabLink;
	
	@FindBy(xpath = "//iframe[@id='frame']")
	WebElement rightFrame;
	
	@FindBy(xpath = "//tr[@role='row'][not(@class='trheader')]//td[count(//tr[@class='trheader']//td[text()='ACTION']//preceding-sibling::td)+1]//div[2]")
	List<WebElement> downloadLinks;
	
	@FindBy(xpath = "//div[@class='folderfilter']//div[contains(@class,'optionfoldertest')]//button")
	WebElement folderFilterDropdown;
	
	@FindBy(xpath = "//div[@class='folderfilter']//div[contains(@class,'optionfoldertest')]//button//following-sibling::div//span[@class='text']")
	List<WebElement> folderFilterDropdownOptions;
	
	@FindBy(xpath = "//div[@class='folderfilter']//div[contains(@class,'optioncategorytest')]//button")
	WebElement categoryFilterDropdown;
	
	@FindBy(xpath = "//button[@id='add_note_button']")
	WebElement addNoteBtn;
	
	@FindBy(xpath = "//tr[@role='row'][not(@class='trheader')]//td[count(//tr[@class='trheader']//td[text()='ACTION']//preceding-sibling::td)+1]//div[1]")
	List<WebElement> viewLinks;
	
	@FindBy(xpath = "//img[@title='View SkyDoc Gallery']")
	WebElement skyDocGalleryBtn;
	
	@FindBy(xpath = "//tr[@class='trheader']//td[text()='Folder' or text()='FOLDER']")
	WebElement folderColumn;
	
	@FindBy(xpath = "//tr[@role='row'][not(@class='trheader')]//td[count(//tr[@class='trheader']//td[text()='Category' or text()='DEF' or text()='CATEGORY']//preceding-sibling::td)+1]//img")
	List<WebElement> inlineCategoryIcons;
	
	@FindBy(xpath = "//tr[@role='row'][not(@class='trheader')]//td[count(//tr[@class='trheader']//td[text()='CHECKED OUT BY']//preceding-sibling::td)+1]")
	List<WebElement> checkedOutColumn;
	
	@FindBy(xpath = "//button[text()='Transaction Files']")
	WebElement transactionFilesBtn;
	
	@FindBy(xpath = "//button[@id='copy_move_button']")
	WebElement moveCopyBtn;
	
	@FindBy(xpath = "//button[@id='new_folder_button']")
	WebElement newFolderBtn;
	
	@FindBy(xpath = "//button[@data-id='filecatogery']//following-sibling::div//span[@class='text']")
	List<WebElement> filterCategoryOptions;
	
	@FindBy(xpath = "//div[text()='Drag and Drop']")
	List<WebElement> dragDropBtnForAllExpenseLines;
	
	@FindBy(xpath = "//input[@id='edit']")
	WebElement editBtnInExpenseReport;
	
	@FindBy(xpath = "//tr[@id='expense_row_1']//td[count(//tr[@id='expense_headerrow']//td[@data-label='Attach File']//preceding-sibling::td)+1]")
	WebElement firstAttachFileLineItemDiv;
	
	@FindBy(xpath = "//span[@id='parent_actionbuttons_expense_expmediaitem_fs']//a[2]")
	WebElement attachFileArrow;
	
	@FindBy(xpath = "//a[@id='expmediaitem_popup_list']")
	WebElement attachFileListBtn;
	
	@FindBy(xpath = "//div[@id='inner_popup_div']//table//tr//td//following-sibling::td//a")
	List<WebElement> searchResults;
	
	@FindBy(xpath = "//table[@id='expense_splits']//tr[2]//td[count(//div[text()='SkyDoc File']//parent::td//preceding-sibling::td)+1]//iframe")
	WebElement skyDocFileFrameInExpenseReport;
	
	@FindBy(xpath = "//a[@id='file_name']")
	WebElement skyDocFileLinkInExpenseReportView;
	
	@FindBy(xpath = "//table[@id='expense_splits']//tr[2]//td[count(//div[text()='Attach File']//parent::td//preceding-sibling::td)+1]")
	WebElement attachFileInExpenseReportView;
	
	@FindBy(xpath = "//tr[@id='expense_row_1']//td[count(//tr[@id='expense_headerrow']//td[@data-label='SkyDoc File']//preceding-sibling::td)+1]//div")
	WebElement firstSkyDocFileLineItemDiv;
	
	@FindBy(xpath = "//li[contains(@class,'ns-header') and @data-title='Setup']//span[text()='Setup']")
	WebElement setupLink;
	
	@FindBy(xpath = "//a[contains(@class,'ns-scroll-button-bottom')]")
	WebElement scrollBtn;
	
	@FindBy(xpath = "//span[text()='SkyDoc']")
	WebElement skyDocLink;
	
	@FindBy(xpath = "//span[text()='SkyDoc Setup']")
	WebElement skyDocSetupLink;
	
	@FindBy(xpath = "//span[text()='SkyDoc Portal Link']")
	WebElement skyDocPortalLink;
	
	@FindBy(xpath = "//span[text()='Documents']")
	WebElement documentsLink;
	
	@FindBy(xpath = "//li[@class='ns-menuitem ns-submenu']//span[text()='SkyDoc Folders']")
	WebElement skyDocFoldersLink1;
	
	@FindBy(xpath = "//li[@class='ns-menuitem ']/a/span[text()='SkyDoc Folders']")
	WebElement skyDocFoldersLink2;
	
	@FindBy(xpath = "//span[text()='SkyDoc Folder List']")
	WebElement skyDocFoldersListLink;
	
	@FindBy(xpath = "//span[text()='Employees']")
	WebElement employeesLink1;
	
	@FindBy(xpath = "//li[@class='ns-menuitem ns-submenu']//span[text()='Employees']")
	WebElement employeesLink2;
	
	@FindBy(xpath = "//input[@id='custpage_page_length']")
	WebElement pageLengthBox;
	
	@FindBy(xpath = "//select[@name='fileList_length']")
	WebElement listLength;
	
	@FindBy(xpath = "//table[@id='fileList']//tbody//tr[1]//img[@class='editImg']")
	WebElement multipleCategoryEditBtn;
	
	@FindBy(xpath = "//button[@data-id='editcategory']")
	WebElement multipleCategoryDropdown;
	
	@FindBy(xpath = "//button[@data-id='editcategory']//following-sibling::div[@role='combobox']//li//span[1]")
	List<WebElement> multipleCategoryDropdownList;
	
	@FindBy(xpath = "//table[@id='fileList']//tbody//tr[1]//td[count(//tr[@class='trheader']//td[text()='Category' or text()='DEF' or text()='CATEGORY']//preceding-sibling::td)+1]")
	WebElement selectedMultipleCategory;
	
	@FindBy(xpath = "//table[@id='fileList']//tbody//td[count(//tr[@class='trheader']//td[text()='FILE NAME']//preceding-sibling::td)+1]")
	List<WebElement> fileNamesList;
	
	@FindBy(xpath = "//table[@id='fileList']//tbody//td[count(//tr[@class='trheader']//td[text()='FILE NAME']//preceding-sibling::td)+1]//span[@class='description wordwrapclass wrapok']")
	List<WebElement> noteList;
	
	@FindBy(xpath = "//table[@id='fileList']//tbody//tr//td[count(//tr[@class='trheader']//td[text()='SIZE']//preceding-sibling::td)]")
	List<WebElement> categoryList;
	
	@FindBy(xpath = "//input[@name='inpt_custpage_attachedfolder']")
	WebElement attachToFolderDropdown;
	
	@FindBy(xpath = "//div[@id='popup_outerdiv']//input[@id='st']")
	WebElement searchBox;
	
	@FindBy(xpath = "//div[@id='popup_outerdiv']//input[@id='Search']")
	WebElement searchBtn;
	
	@FindBy(xpath = "//div[@id='popup_outerdiv']//div[@id='inner_popup_div']//table//tr//td//following-sibling::td//a")
	List<WebElement> searchList;
	
	@FindBy(xpath = "//button[text()='Attach Files']")
	WebElement attachFileBtnInCustomerPage;
	
	@FindBy(xpath = "//input[@name='inpt_custpage_defaultfolder']")
	WebElement skyDocUploadFolderDropdown;
	
	@FindBy(xpath = "//button[@data-id='folder']")
	WebElement skyDocUploadFolderInCustomerPage;
	
	@FindBy(xpath = "//button[@data-id='category']")
	WebElement skyDocUploadCategoryBtn;
	
	@FindBy(xpath = "//button[@data-id='folder']//following-sibling::div//span[@class='text']")
	List<WebElement> uploadFolderList;
	
	@FindBy(xpath = "//button[@data-id='category']//following-sibling::div//span[@class='text']")
	List<WebElement> uploadCategoryList;
	
	@FindBy(xpath = "//iframe[@id='first_frame']")
	WebElement leftFrame;
	
	@FindBy(xpath = "//div[@class='dropzone']")
	WebElement dragDropBtn;
	
	@FindBy(xpath = "//input[@id='loginid']")
	WebElement portalUsername;
	
	@FindBy(xpath = "//input[@id='loginpassword']")
	WebElement portalPassword;
	
	@FindBy(xpath = "//button[@id='login']")
	WebElement portalLoginBtn;
	
	@FindBy(xpath = "//label[contains(@id,'fileupload_0')]")
	WebElement uploadStatus;
	
	@FindBy(xpath = "//button[@id='add_refresh_btn']")
	WebElement refreshBtn;
	
	@FindBy(xpath = "//button[@data-id='select_folder']")
	WebElement noteFolder;
	
	@FindBy(xpath = "//button[@data-id='select_folder']//following-sibling::div//span[@class='text']")
	List<WebElement> noteFolderList;
	
	@FindBy(xpath = "//button[@data-id='select_category']")
	WebElement noteCategory;
	
	@FindBy(xpath = "//button[@data-id='select_category']//following-sibling::div//span[@class='text']")
	List<WebElement> noteCategoryList;
	
	@FindBy(xpath = "//input[@id='notetitle']")
	WebElement noteTitle;
	
	@FindBy(xpath = "//textarea[@id='file_note_comments']")
	WebElement noteText;
	
	@FindBy(xpath = "//button[text()='Attach Note']")
	WebElement attachNoteBtn;
	
	@FindBy(xpath = "//input[@id='inpt_custpage_recordtype1']")
	WebElement recordType;
	
	@FindBy(xpath = "//input[@id='custpage_search']")
	WebElement searchBtnInPopup;
	
	@FindBy(xpath = "//a[text()='Copy']//parent::span//parent::span//preceding-sibling::span//input")
	WebElement copyRadioBtn;
	
	@FindBy(xpath = "//a[text()='Move']//parent::span//parent::span//preceding-sibling::span//input")
	WebElement moveRadioBtn;
	
	@FindBy(xpath = "//span[@id='parent_actionbuttons_custpage_recordid_fs']//a[2]")
	WebElement targetRecordArrowBtn;
	
	@FindBy(xpath = "//a[@id='custpage_recordid_popup_list']")
	WebElement targetRecordListBtn;
	
	@FindBy(xpath = "//div[@id='popup_outerdiv']//div[@id='inner_popup_div']//table//tr//td//following-sibling::td//a")
	List<WebElement> targetRecordDropdownList;
	
	@FindBy(xpath = "//input[@id='submitter']")
	WebElement saveBtnInPopup;
	
	@FindBy(xpath = "//button[@data-id='filefolder']")
	WebElement attachFileSourceFolder;
	
	@FindBy(xpath = "//button[@data-id='filefolder']//following-sibling::div//span[@class='text']")
	List<WebElement> attachFileSourceFolderList;
	
	@FindBy(xpath = "//button[@data-id='filecatogery']")
	WebElement attachFileDestinationFolder;
	
	@FindBy(xpath = "//button[@data-id='filecatogery']//following-sibling::div//span[@class='text']")
	List<WebElement> attachFileDestinationFolderList;
	
	@FindBy(xpath = "//button[text()='Search']")
	WebElement attachFileSearchBtn;
	
	@FindBy(xpath = "//button[text()='Attach Files']")
	WebElement attachFileBtnInPopup;
	
	@FindBy(xpath = "//table[@id='fileList']//tbody//td[count(//tr[@class='headerStyling']//th[text()='FILE NAME']//preceding-sibling::th)+1]")
	List<WebElement> attachFileFileNamesList;
	
	@FindBy(xpath = "//table[@id='fileList']//tbody//td[count(//tr[@class='trheader']//td[text()='FILE NAME']//preceding-sibling::td)+1]//a")
	List<WebElement> fileNamesListWithoutNotes;
	
	@FindBy(xpath = "//div[@class='lightboxgallery-gallery']//a")
	List<WebElement> skyDocGalleryDisplayList;
	
	@FindBy(xpath = "//img[@class='listbutton']")
	WebElement displayListBtn;
	
	@FindBy(xpath = "//img[@id='loading']")
	WebElement loadingImage;
	
	@FindBy(xpath = "//input[@value='Delete']")
	WebElement deleteBtn;
	
	@FindBy(xpath = "//input[@type='search']")
	WebElement searchBoxInSkyDocList;
	
	@FindBy(xpath = "//iframe[@id='Preview']")
	WebElement filePreviewFrame;
	
	@FindBy(xpath = "//div[@class='modal fade in']//button[text()='x']")
	WebElement closeBtn;
	
	@FindBy(xpath = "//a[contains(text(),'1.jpg')]//parent::td//following-sibling::td//div[text()='View']")
	WebElement viewLinkForImg;
	
	@FindBy(xpath = "//a[contains(text(),'1.jpg')]//parent::td//following-sibling::td//div[text()='Download']")
	WebElement downloadLinkForImg;
	
	@FindBy(xpath = "//img[@title='SkyDoc List Files']")
	WebElement displayListBtnInTransactionFiles;
	
	@FindBy(xpath = "//table[@id='fileList']//tbody//td[count(//tr[@class='trheader']//td[text()='RECORD TYPE']//preceding-sibling::td)+1]//a")
	List<WebElement> recordTypeList;
	
	@FindBy(xpath = "//span//a[contains(@id,'qsTarget')]")
	WebElement customerInTransaction;
	
	@FindBy(xpath = "//button[@id='doc_check_out']")
	WebElement checkoutBtn;
	
	@FindBy(xpath = "//div[@id='download_popup']//span[@class='close']")
	WebElement closeBtnInCheckout;
	
	@FindBy(xpath = "//tr[@role='row'][not(@class='trheader')]//td[count(//tr[@class='trheader']//td[text()='FILE TYPE']//preceding-sibling::td)+2]")
	List<WebElement> folderList;
	
	@FindBy(xpath = "//a[text()='ommunication']")
	WebElement communicationSubtab;
	
	@FindBy(xpath = "//input[@id='newmessage']")
	WebElement emailBtn;
	
	@FindBy(xpath = "//a[@id='messagestxt']")
	WebElement messagesTab;
	
	@FindBy(xpath = "//input[@id='subject']")
	WebElement subjectBox;
	
	@FindBy(xpath = "//a[@id='custpagetabtxt']")
	WebElement skyDocTab;
	
	@FindBy(xpath = "//input[@name='inpt_custpage_filename']")
	WebElement skyDocFileDropdown;
	
	@FindBy(xpath = "//input[@id='submitter']")
	WebElement mergeSendBtn;
	
	@FindBy(xpath = "//tr[@id='messagesrow0']//a[text()='View']")
	WebElement viewEmailLink;
	
	@FindBy(xpath = "//input[@id='edit']")
	WebElement editBtnInEmp;
	
	@FindBy(xpath = "//input[@id='custentity_tss_skydoc_external_pass']")
	WebElement skyDocPwdInEmp;
	
	@FindBy(xpath = "//span[@id='custentity_tss_skydoc_external_access_fs']//img")
	WebElement skyDocExternalAccessCheckbox;
	
	@FindBy(xpath = "//span[@id='custentity_tss_skydoc_aces_notification_fs']//img")
	WebElement skyDocExternalAccessNotificationCheckbox;
	
	@FindBy(xpath = "//input[@id='btn_multibutton_submitter']")
	WebElement saveBtnInEmp;
	
	@FindBy(xpath = "//button[@id='send_for_approval_button']")
	WebElement sendForApprovalBtn;
	
	@FindBy(xpath = "//span[@id='supervisor_fs_lbl_uir_label']//following-sibling::span//a")
	WebElement supervisorLinkInEmp;
	
	@FindBy(xpath = "//table[@id='example']//tbody//tr")
	List<WebElement> fileRowListInPortal;
	
	@FindBy(xpath = "//table[@id='example']//tbody//a")
	List<WebElement> fileNamesListInPortal;
	
	@FindBy(xpath = "//table[@id='example']//tbody//td[4]")
	List<WebElement> attachedToListInPortal;
	
	@FindBy(xpath = "//textarea[@id='comments']")
	WebElement approverCommentsInPortal;
	
	@FindBy(xpath = "//input[@id='approval']")
	WebElement approvalBtnInPortal;
	
	@FindBy(xpath = "//input[@id='rejection']")
	WebElement rejectBtnInPortal;
	
	@FindBy(xpath = "//select[@id='recordType']")
	WebElement selectActionDropdownInPortal;
	
	@FindBy(xpath = "//tr[contains(@id,'row')]//td[3]")
	List<WebElement> foldersListInFoldersPage;
	
	@FindBy(xpath = "//span[@id='custrecord_tss_skydoc_external_entity_fs_lbl_uir_label']//following-sibling::span//a//span")
	List<WebElement> externalEntityListForFolder;
	
	@FindBy(xpath = "//a[text()='kyDoc Portal Access']")
	WebElement skyDocPortalAccessSubtabInFolderPage;
	
	@FindBy(xpath = "//a[@id='custrecord_tss_skydoc_external_entity_popup_list']")
	WebElement externalEntityArrowBtn;
	
	@FindBy(xpath = "//div[@id='popup_outerdiv']//input[@id='st']")
	WebElement externalEntitySearchBox;
	
	@FindBy(xpath = "//div[@id='popup_outerdiv']//input[@id='Search']")
	WebElement externalEntitySearchBtn;
	
	@FindBy(xpath = "//div[@id='div__nav_tree']//a")
	List<WebElement> uploadFilesLeftFolderListInPortal;
	
	@FindBy(xpath = "//input[@id='custpage_view']")
	WebElement viewBtnInAWS;
	
	@FindBy(xpath = "//input[@id='custpage_download']")
	WebElement downloadBtnInAWS;
	
	@FindBy(xpath = "//input[@id='custpage_move_copy']")
	WebElement moveCopyBtnInAWS;
	
	@FindBy(xpath = "//span[@id='custrecord_tss_aws_s3_ns_file_view_fs_lbl_uir_label']//following-sibling::span")
	WebElement fileViewFieldValue;
	
	@FindBy(xpath = "//span[@id='custrecord_tss_aws_s3_ns_file_download_fs_lbl_uir_label']//following-sibling::span")
	WebElement fileDownloadFieldValue;
	
	@FindBy(xpath = "//span[@id='custrecord_tss_aws_s3_ns_ispublic_fs']//img")
	WebElement isPublicCheckboxInAWS;
	
	@FindBy(xpath = "//input[@id='custpage_genpulicurl']")
	WebElement publicUrlInAWS;
	
	@FindBy(xpath = "//input[@id='custpage_genprivateurl']")
	WebElement privateUrlInAWS;
	
	@FindBy(xpath = "//a[@id='custpage_versionfileslisttxt']")
	WebElement fileVersionSubtabInAWS;
	
	@FindBy(xpath = "//tr[contains(@id,'custpage_versionlistrow')]//td[count(//tr[@id='custpage_versionlistheader']//div[contains(text(),'Version')]//parent::td//preceding-sibling::td)+1]")
	List<WebElement> fileVersionsListInAWS;
	
	@FindBy(xpath = "//input[@id='custpage_emailfile']")
	WebElement emailFileBtnInAWS;
	
	@FindBy(xpath = "//input[@id='custpage_subject']")
	WebElement subjectInAWS;
	
	@FindBy(xpath = "//textarea[@id='custpage_recipient']")
	WebElement recipientEmailInAWS;
	
	@FindBy(xpath = "//span[@id='custpage_temp_enb_fs']//img")
	WebElement emailTemplateCheckBoxInAWS;
	
	@FindBy(xpath = "//input[@id='inpt_custpage_mes_temp1']")
	WebElement emailTemplateDropdownInAWS;
	
	@FindBy(xpath = "//input[@id='submitter']")
	WebElement sendEmailBtnInAWS;
	
	@FindBy(xpath = "//a[@id='mergetxt']")
	WebElement mailMergeSubtabInAWS;
	
	@FindBy(xpath = "//input[@id='refreshmessages']")
	WebElement refreshBtnInAWS;
	
	@FindBy(xpath = "//div[@id='messages_layer']//table[@id='messages__tab']//tbody//td[count(//div[@id='messages_layer']//thead//div[contains(text(),'Primary Recipient')]//parent::td//preceding-sibling::td)+1]")
	List<WebElement> recipientEmailListInAWS;
	
	@FindBy(xpath = "//div[@id='messages_layer']//table[@id='messages__tab']//tbody//td[count(//div[@id='messages_layer']//thead//div[contains(text(),'Subject')]//parent::td//preceding-sibling::td)+1]")
	List<WebElement> emailSubjectList;
	
	@FindBy(xpath = "//td[contains(@id,'row_custpage_skydoc_adm_role')]//a")
	List<WebElement> skyDocAdminRolesMultiSelectList;
	
	@FindBy(xpath = "//div[@aria-labelledby='custpage_onlyroles_fs_lbl']//td[contains(@id,'row_custpage_onlyroles')]//a")
	List<WebElement> uploadRolesMultiSelectList;
	
	@FindBy(xpath = "//div[@aria-labelledby='custpage_onlyroles1_fs_lbl']//td[contains(@id,'row_custpage_onlyroles')]//a")
	List<WebElement> viewRolesMultiSelectList;
	
	@FindBy(xpath = "//td[contains(@id,'row_custpage_onlydeleteroles')]//a")
	List<WebElement> deleteRolesMultiSelectList;
	
	@FindBy(xpath = "//td[contains(@id,'row_custpage_onlyattachroles')]//a")
	List<WebElement> attachFilesRolesMultiSelectList;
	
	@FindBy(xpath = "//td[contains(@id,'row_custpage_onlymovecopyroles')]//a")
	List<WebElement> moveCopyRolesMultiSelectList;
	
	@FindBy(xpath = "//td[contains(@id,'row_custpage_onlyfolderroles')]//a")
	List<WebElement> folderRolesMultiSelectList;
	
	@FindBy(xpath = "//td[contains(@id,'row_custpage_onlyexprecroles')]//a")
	List<WebElement> expenseReceiptRolesMultiSelectList;
	
	@FindBy(xpath = "//input[@id='custpage_dis_cat_in_sd_fs_inp']//following-sibling::img")
	WebElement displayCategoryCheckbox;
	
	@FindBy(xpath = "//div[@class='descr']")
	WebElement confirmationMsg;
	
	@FindBy(xpath = "//span[@class='uir-pagination-label']")
	WebElement paginationLabel;
	
	@FindBy(xpath = "//span[@class='uir-pagination-label']//following-sibling::ul//li")
	List<WebElement> paginationList;
	
	@FindBy(xpath = "//iframe[@id='myFrame']")
	WebElement outerFrameInPortal;
	
	@FindBy(xpath = "//iframe[@id='frame']")
	WebElement innerFrameInPortal;
	
	@FindBy(xpath = "//td[@id='tdbody_newfolder']//input")
	WebElement newFolderBtnInSkyDocPortal;
	
	@FindBy(xpath = "//div[@id='div__nav_tree']//li//a")
	List<WebElement> leftFoldersList;
	
	@FindBy(xpath = "//div[@class='dropdownDiv']//div")
	List<WebElement> dropdownList;
	
	@FindBy(xpath = "//input[@aria-controls='div__bodytab']")
	WebElement rightSearchBox;
	
	@FindBy(xpath = "//table[@id='div__bodytab']//tbody//td[count(//table[@id='div__bodytab']//div[contains(text(),'User')]//parent::div//parent::th//preceding-sibling::th)+1]")
	List<WebElement> usersListInPortal;
	
	@FindBy(xpath = "//div[@class='uir-record-name']")
	WebElement recordName;
	
	@FindBy(xpath = "//input[@id='name' or @id='custrecord_skydoc_folder_name']")
	WebElement folderField;
	
	@FindBy(xpath = "//span[@id='custrecord_tss_awstons_subfolderof_paren_fs_lbl_uir_label']//following-sibling::span//a")
	WebElement subFolderField;
	
	@FindBy(xpath = "//input[@id='inpt_custrecord_tss_awstons_subfolderof_paren1']")
	WebElement subFolderDropdown;
	
	@FindBy(xpath = "//span[@id='custrecord_tss_aws_s3_ns_access_to_folde_fs_lbl_uir_label']//following-sibling::span")
	WebElement accessToFolderField;
	
	@FindBy(xpath = "//textarea[@name='custrecord_tss_aws_s3_ns_access_to_folde_display']")
	WebElement accessToFolderTextArea;
	
	@FindBy(xpath = "//span[@id='custrecord_copy_parent_folder_permission_fs']//img")
	WebElement copyParentFolderPermissionCheckbox;
	
	@FindBy(xpath = "//input[@name='inpt_custrecord_default_folder_for_record']")
	WebElement defaultFolderDropdown;
	
	@FindBy(xpath = "//span[@id='custpage_auto_fold_cre_for_entites_fs']//img")
	WebElement automaticFolderCreationCheckbox;
	
	@FindBy(xpath = "//input[@id='companyname']")
	WebElement companyBox;
	
	@FindBy(xpath = "//div[@id='isperson_F']//input")
	WebElement companyRadioBtn;
	
	public SkyDocSetupPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void verifyAutomaticFolderCreationFeature(String companyName, ExtentTest logInfo) throws InterruptedException {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		action = new Actions(driver);
		
		// Enable Automatic Folder Creation feature
		clickOnSkyDocSetupLink();
		enableCheckbox(automaticFolderCreationCheckbox);
		je.executeScript("window.scrollTo(0,0)");
		submitBtn.click();
		Thread.sleep(2000);
		
		// Create Customer
		Thread.sleep(1500);
		eleAvailability(driver, By.xpath("//span[text()='Lists']"), 10);
		action.moveToElement(listLink).build().perform();
		eleAvailability(driver, By.xpath("//span[text()='Relationships']"), 10); // Explicit Wait
		action.moveToElement(relationshipsLink).build().perform();
		eleAvailability(driver, customersLink, 10);
		action.moveToElement(customersLink).build().perform();
		eleAvailability(driver, newLink, 10);
		newLink.click();
		Thread.sleep(1500);
		eleSelectionStateToBe(driver, companyRadioBtn, 10, true);
		companyBox.sendKeys(companyName);
		driver.findElement(By.xpath("//h1")).click();
		Thread.sleep(1500);
		saveBtnInEmp.click();
		Thread.sleep(1500);
		boolean customerCreationFlag = false;
		try {
			eleAvailability(driver, confirmationMsg, 10);
			String confirmationMessage = confirmationMsg.getText().trim();
			if (confirmationMessage.equals("Customer successfully Saved")) {
				customerCreationFlag = true;
				System.out.println("Customer '" + companyName + "' created successfully");
				logInfo.pass("Customer '" + companyName + "' created successfully");
			} else {
				System.out.println("Customer '" + companyName + "' unable to create");
				logInfo.fail("Customer '" + companyName + "' unable to create");
			}
		} catch (NoSuchElementException | TimeoutException e) {
			String notice = driver.findElement(By.xpath("//td[@class='text']//img//parent::td"))
					.getText();
			if (notice.contains("A customer record with this ID already exists")) {
				System.out.println("Customer '" + companyName + "' already exists");
				logInfo.fail("Customer '"+companyName+"' already exists");
			}
			driver.findElement(By.xpath("//input[@id='goback']")).click();
			eleSelectionStateToBe(driver, companyRadioBtn, 10, true);
		}
		
		// Verify SkyDoc Upload Folder
		if(customerCreationFlag) {
			skyDocSubtabLink.click();
			je.executeScript("window.scrollBy(-1000,0)");
			je.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	        driver.switchTo().frame(leftFrame);
	        String folderName = skyDocUploadFolderInCustomerPage.getAttribute("title").trim();
			if(skyDocUploadFolderInCustomerPage.getAttribute("title").contains(companyName)) {
				System.out.println("Folder: '"+folderName+"' is created after saving the Customer: "+companyName);
				logInfo.pass("Folder: '"+folderName+"' is created after saving the Customer: "+companyName);
			}else {
				System.out.println("Folder: '"+folderName+"' is not created after saving the Customer: "+companyName);
				logInfo.fail("Folder: '"+folderName+"' is not created after saving the Customer: "+companyName);
			}
			driver.switchTo().defaultContent();
			Thread.sleep(1500);
		}
		
		// Disable the Automatic Folder Creation feature
		clickOnSkyDocSetupLink();
		disableCheckbox(automaticFolderCreationCheckbox);
		je.executeScript("window.scrollTo(0,0)");
		submitBtn.click();
		Thread.sleep(2000);
	}

	public void clickOnSkyDocSetupLink() throws InterruptedException {
		action = new Actions(driver);
		Thread.sleep(1500);
		eleAvailability(driver, setupLink, 10);
		action.moveToElement(setupLink).build().perform();
		eleAvailability(driver, scrollBtn, 10);
		action.moveToElement(scrollBtn).build().perform();
		Thread.sleep(1500);
		eleAvailability(driver, skyDocLink, 10); // Explicit Wait
		action.moveToElement(skyDocLink).build().perform();
		eleAvailability(driver, skyDocSetupLink, 10); // Explicit Wait
		skyDocSetupLink.click();
	}
	
	public void verifyDefaultFolderForRecordFeature(String folderName, String netsuiteRecord, String vendorName, ExtentTest logInfo) throws InterruptedException {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		action = new Actions(driver);
		
		clickOnSkyDocFoldersListLink();		
		openFolderInExistingTab(folderName);
		editBtnInExpenseReport.click();
		Thread.sleep(1500);
		eleFocussed(folderField);
		defaultFolderDropdown.click();
		for (int i = 0; i < dropdownList.size(); i++) {
			if (dropdownList.get(i).getText().trim().equals(netsuiteRecord)) {
				action.moveToElement(dropdownList.get(i)).click(dropdownList.get(i)).build().perform();
				break;
			}
		}
        saveBtnInEmp.click();
        if(isAlertPresent())
        	driver.switchTo().alert().accept();
        Thread.sleep(1500);
        
        clickOnVendorsListLink();
        openFolderInExistingTab(vendorName);
        skyDocSubtabLink.click();
		je.executeScript("window.scrollBy(-1000,0)");
		je.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        driver.switchTo().frame(leftFrame);
		if(skyDocUploadFolderInCustomerPage.getAttribute("title").equals(folderName)) {
			System.out.println("Folder: '"+folderName+"' is selected as the default SkyDoc Upload folder for the Vendor: '"+vendorName+"'");
			logInfo.pass("Folder: '"+folderName+"' is selected as the default SkyDoc Upload folder for the Vendor: '"+vendorName+"'");
		}else {
			System.out.println("Folder: '"+folderName+"' is not selected as the default SkyDoc Upload folder for the Vendor: '"+vendorName+"'");
			logInfo.fail("Folder: '"+folderName+"' is not selected as the default SkyDoc Upload folder for the Vendor: '"+vendorName+"'");
		}
		driver.switchTo().defaultContent();
		clickOnSkyDocFoldersListLink();		
		openFolderInExistingTab(folderName);
		editBtnInExpenseReport.click();
		Thread.sleep(1500);
		eleFocussed(folderField);
		defaultFolderDropdown.click();
		for (int i = 0; i < dropdownList.size(); i++) {
			if (dropdownList.get(i).getText().trim().isBlank()) {
				action.moveToElement(dropdownList.get(i)).click(dropdownList.get(i)).build().perform();
				break;
			}
		}
        saveBtnInEmp.click();
        if(isAlertPresent())
        	driver.switchTo().alert().accept();
        Thread.sleep(1500);
	}

	public void verifyCopyParentFolderPermissionsFeature(String parentFolder, String childFolder, ExtentTest logInfo) throws InterruptedException {
		action = new Actions(driver);
		
		// Navigate to SkyDoc Folders List
		clickOnSkyDocFoldersListLink();
		
		// Open Parent Folder & get Access to Folder field value
		openFolderInNewTab(parentFolder);
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		String parentFolderAccessData = accessToFolderField.getText().trim();
		System.out.println(parentFolderAccessData);
		driver.close();
		driver.switchTo().window(tabs.get(0));
		
		// Open Child Folder, copy access permissions & verify the field
        openFolderInNewTab(childFolder);
        ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs1.get(1));
		editBtnInExpenseReport.click();
		Thread.sleep(1500);
		eleFocussed(folderField);
        if(!subFolderDropdown.getAttribute("value").trim().contains(parentFolder)) {
        	subFolderDropdown.sendKeys(parentFolder);
        }
        action.click(accessToFolderTextArea).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).build().perform();
        recordName.click();
        enableCheckbox(copyParentFolderPermissionCheckbox);
        saveBtnInEmp.click();
		String childFolderAccessData = accessToFolderField.getText().trim();
		if(parentFolderAccessData.equals(childFolderAccessData)) {
			System.out.println("All the access permissions in the Parent Folder: '"+parentFolder+"' are copied to Folder: '"+
					childFolder+"' when 'Copy Parent Folder Permissions' checkbox is checked");
			logInfo.pass("All the access permissions in the Parent Folder: '"+parentFolder+"' are copied to Folder: '"+
					childFolder+"' when 'Copy Parent Folder Permissions' checkbox is checked");
		}else {
			System.out.println("All the access permissions in the Parent Folder: '"+parentFolder+"' are not copied to Folder: '"+
					childFolder+"' even if 'Copy Parent Folder Permissions' checkbox is checked");
			logInfo.fail("All the access permissions in the Parent Folder: '"+parentFolder+"' are not copied to Folder: '"+
					childFolder+"' even if 'Copy Parent Folder Permissions' checkbox is checked");
		}
		Thread.sleep(1500);
		
		// Verify Child folder when Copy parent folder permissions checkbox is unchecked
		editBtnInExpenseReport.click();
		Thread.sleep(1500);
		eleFocussed(folderField);
        if(!subFolderDropdown.getAttribute("value").trim().contains(parentFolder)) {
        	subFolderDropdown.sendKeys(parentFolder);
        }
        action.click(accessToFolderTextArea).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).build().perform();
        recordName.click();
        disableCheckbox(copyParentFolderPermissionCheckbox);
        saveBtnInEmp.click();
		String childFolderAccessData2 = accessToFolderField.getText().trim();
		driver.close();
		driver.switchTo().window(tabs1.get(0));
		if(childFolderAccessData2.isBlank()) {
			System.out.println("All the access permissions in the Parent Folder: '"+parentFolder+"' are not copied to Folder: '"+
				childFolder+"' when 'Copy Parent Folder Permissions' checkbox is unchecked");
			logInfo.pass("All the access permissions in the Parent Folder: '"+parentFolder+"' are not copied to Folder: '"+
				childFolder+"' when 'Copy Parent Folder Permissions' checkbox is unchecked");
		}else {
			if(parentFolderAccessData.equals(childFolderAccessData2)){
				System.out.println("All the access permissions in the Parent Folder: '"+parentFolder+"' are copied to Folder: '"+
					childFolder+"' even if 'Copy Parent Folder Permissions' checkbox is unchecked");
				logInfo.pass("All the access permissions in the Parent Folder: '"+parentFolder+"' are copied to Folder: '"+
					childFolder+"' even if 'Copy Parent Folder Permissions' checkbox is unchecked");
			}
		}
		Thread.sleep(1500);
	}

	public void openFolderInNewTab(String folder) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		action = new Actions(driver);
		
		List<WebElement> foldersList = driver.findElements(By.xpath("//tr[contains(@id,'row')]//td[count(//table[@id='div__labtab']//div[text()='Name']//parent::td//preceding-sibling::td)+1]"));
        for (int i = 0; i < foldersList.size(); i++) {
        	action.moveToElement(foldersList.get(i)).build().perform();
			if(foldersList.get(i).getText().trim().contains(folder)) {
				WebElement parentTr = (WebElement)je.executeScript("return arguments[0].parentNode;", foldersList.get(i));
				String rowId = parentTr.getAttribute("id");
				action.keyDown(Keys.CONTROL).build().perform();
				driver.findElement(By.xpath("//tr[@id='"+rowId+"']//a[text()='View']")).click();
				action.keyUp(Keys.CONTROL).build().perform();
				break;
			}
		}
	}
	
	public void openFolderInExistingTab(String folder) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		action = new Actions(driver);
		
		List<WebElement> foldersList = driver.findElements(By.xpath("//tr[contains(@id,'row')]//td[count(//table[@id='div__labtab']//div[contains(text(),'Name')]//parent::td//preceding-sibling::td)+1]"));
        for (int i = 0; i < foldersList.size(); i++) {
        	action.moveToElement(foldersList.get(i)).build().perform();
			if(foldersList.get(i).getText().trim().contains(folder)) {
				WebElement parentTr = (WebElement)je.executeScript("return arguments[0].parentNode;", foldersList.get(i));
				String rowId = parentTr.getAttribute("id");
				driver.findElement(By.xpath("//tr[@id='"+rowId+"']//a[text()='View']")).click();
				break;
			}
		}
	}
	
	public void verifyFolderHierarchyFeature(String folderName, ExtentTest logInfo) throws InterruptedException {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		action = new Actions(driver);
		
		// Navigate to SkyDoc Folders List
		clickOnSkyDocFoldersListLink();
		
		List<WebElement> foldersList = driver.findElements(By.xpath("//tr[contains(@id,'row')]//td[count(//table[@id='div__labtab']//div[text()='Name']//parent::td//preceding-sibling::td)+1]"));
        for (int i = 0; i < foldersList.size(); i++) {
        	action.moveToElement(foldersList.get(i)).build().perform();
			if(foldersList.get(i).getText().trim().contains(folderName)) {
				WebElement parentTr = (WebElement)je.executeScript("return arguments[0].parentNode;", foldersList.get(i));
				String rowId = parentTr.getAttribute("id");
				driver.findElement(By.xpath("//tr[@id='"+rowId+"']//a[text()='View']")).click();
				break;
			}
		}
        String recordNameText = recordName.getText().trim();
        Thread.sleep(1500);
        if(recordNameText.contains(":")) {
        	verifyFolderHierarchyIfDisabled(folderName, logInfo);
        	verifyFolderHierarchyIfEnabled(folderName, logInfo);
        }else {
        	verifyFolderHierarchyIfEnabled(folderName, logInfo);
        	verifyFolderHierarchyIfDisabled(folderName, logInfo);
        }
	}
	
	public void verifyFolderHierarchyIfEnabled(String folderName, ExtentTest logInfo)
			throws InterruptedException {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		action = new Actions(driver);
		
		// Navigate to Setup Page
		Thread.sleep(1500);
		eleAvailability(driver, setupLink, 10);
		action.moveToElement(setupLink).build().perform();
		eleAvailability(driver, scrollBtn, 10);
		action.moveToElement(scrollBtn).build().perform();
		Thread.sleep(1500);
		eleAvailability(driver, skyDocLink, 10); // Explicit Wait
		action.moveToElement(skyDocLink).build().perform();
		eleAvailability(driver, skyDocSetupLink, 10); // Explicit Wait
		action.keyDown(Keys.CONTROL).click(skyDocSetupLink).keyUp(Keys.CONTROL).build().perform();
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		enableCheckbox(folderHierarchyCheckbox);
		je.executeScript("window.scrollTo(0,0)");
		submitBtn.click();
		Thread.sleep(2000);
		driver.close();
		driver.switchTo().window(tabs.get(0));
		
		editBtnInExpenseReport.click();
		Thread.sleep(1500);
		eleFocussed(folderField);
		eleClickable(driver, folderField, 10);
		folderField.clear();
		folderField.sendKeys(folderName);
		saveBtnInEmp.click();
		String subFolderFieldValue = subFolderField.getText().trim();
		String expectedFolderName = subFolderFieldValue+" "+":"+" "+folderName;
		if(recordName.getText().trim().equals(expectedFolderName)) {
			System.out.println("Folder Name is displayed with hierarchy when 'Enable Folder Hierarchy In Folder Name' checkbox is checked");
			logInfo.pass("Folder Name is displayed with hierarchy when 'Enable Folder Hierarchy In Folder Name' checkbox is checked");
		} else {
			System.out.println("Folder Name is not displayed with hierarchy even if 'Enable Folder Hierarchy In Folder Name' checkbox is checked");
			logInfo.fail("Folder Name is not displayed with hierarchy even if 'Enable Folder Hierarchy In Folder Name' checkbox is checked");
		}
	}

	public void verifyFolderHierarchyIfDisabled(String folderName, ExtentTest logInfo)
			throws InterruptedException {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		action = new Actions(driver);
		
		// Navigate to Setup Page
		Thread.sleep(1500);
		eleAvailability(driver, By.xpath("//span[text()='Setup']"), 10);
		action.moveToElement(setupLink).build().perform();
		eleAvailability(driver, scrollBtn, 10);
		action.moveToElement(scrollBtn).build().perform();
		Thread.sleep(1500);
		eleAvailability(driver, skyDocLink, 10); // Explicit Wait
		action.moveToElement(skyDocLink).build().perform();
		eleAvailability(driver, skyDocSetupLink, 10); // Explicit Wait
		action.keyDown(Keys.CONTROL).click(skyDocSetupLink).keyUp(Keys.CONTROL).build().perform();
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		disableCheckbox(folderHierarchyCheckbox);
		je.executeScript("window.scrollTo(0,0)");
		submitBtn.click();
		Thread.sleep(2000);
		driver.close();
		driver.switchTo().window(tabs.get(0));
		
		editBtnInExpenseReport.click();
		Thread.sleep(1500);
		eleFocussed(folderField);
		eleClickable(driver, folderField, 10);
		folderField.clear();
		folderField.sendKeys(folderName);
		saveBtnInEmp.click();
		if(recordName.getText().trim().equals(folderName)) {
			System.out.println("Folder Name is displayed without hierarchy when 'Enable Folder Hierarchy In Folder Name' checkbox is unchecked");
			logInfo.pass("Folder Name is displayed without hierarchy when 'Enable Folder Hierarchy In Folder Name' checkbox is unchecked");
		} else {
			System.out.println("Folder Name is not displayed without hierarchy even if 'Enable Folder Hierarchy In Folder Name' checkbox is unchecked");
			logInfo.fail("Folder Name is not displayed without hierarchy even if 'Enable Folder Hierarchy In Folder Name' checkbox is unchecked");
		}
	}
	
	public void verifyEmailFileFunctionalityInAWS(String customer, String fileName, String subject, String emailTemplate, String recipientEmail, ExtentTest logInfo) throws InterruptedException {
		openAWSRecord(customer, fileName);
		emailFileBtnInAWS.click();
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(2));
	    driver.manage().window().maximize();
	    System.out.println("A pop up occured to enter message content along with recipient's email and subject or recipient's email should display along with email template");
	    logInfo.pass("A pop up occured to enter message content along with recipient's email and subject or recipient's email should display along with email template");
	    recipientEmailInAWS.sendKeys(recipientEmail);
	    if(emailTemplate.trim().isBlank()) {
	    	subjectInAWS.sendKeys(subject);
	    }else {
	    	emailTemplateCheckBoxInAWS.click();
	    	emailTemplateDropdownInAWS.sendKeys(emailTemplate);
	    }
	    
	    sendEmailBtnInAWS.click();
	    boolean emailAlertFlag = false;
	    if(isAlertPresent()) {
			Thread.sleep(1000);
			Alert alert = driver.switchTo().alert();
			String alertMsg = alert.getText();
			if(alertMsg.contains("Email sent successfully"))
				emailAlertFlag = true;
			System.out.println("Alert occured: "+alertMsg);
			alert.accept();
		}
	    
	    if (emailAlertFlag) {
			System.out.println("Email sent successfully to "+recipientEmail);
			logInfo.pass("Email sent successfully to "+recipientEmail);
		}else {
			System.out.println("Email unable to send to the EmailId: "+recipientEmail);
			logInfo.fail("Email unable to send to the EmailId: "+recipientEmail);
		}
	    
	    driver.switchTo().window(tabs.get(1));
	    mailMergeSubtabInAWS.click();
	    refreshBtnInAWS.click();
	    Thread.sleep(1500);
	    
	    boolean emailFlag = false;
	    for (int i = 0; i < recipientEmailListInAWS.size(); i++) {
			if(recipientEmailListInAWS.get(i).getText().trim().equals(recipientEmail))
				emailFlag = true;
		}
	    
	    driver.close();
	    driver.switchTo().window(tabs.get(0));
		driver.switchTo().frame(rightFrame);
		try {
			closeBtn.click();
		}catch(NoSuchElementException e) {
			System.out.println("File not previewed");
		}
		driver.switchTo().defaultContent();
		Thread.sleep(1500);
	    
	    if (emailFlag) {
			System.out.println("Mail merge tab displayed the email sent to recipient: "+recipientEmail);
			logInfo.pass("Mail merge tab displayed the email sent to recipient: "+recipientEmail);
		}else {
			System.out.println("Mail merge tab is not displaying the email sent to recipient: "+recipientEmail);
			logInfo.fail("Mail merge tab is not displaying the email sent to recipient: "+recipientEmail);
		}
	}
	
	public void verifyFileVersionsInAWS(String customer, String fileName, ExtentTest logInfo) throws InterruptedException {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		action = new Actions(driver);
		openCustomer(customer);
		int version = getVersionForFile(fileName);
		List<Integer> versionListInAWS = new ArrayList<>();
		if(version>1) {
			driver.switchTo().frame(rightFrame);
			for (int i = 0; i < fileNamesListWithoutNotes.size(); i++) {
				if(fileNamesListWithoutNotes.get(i).getText().trim().contains(fileName)) {
					fileNamesListWithoutNotes.get(i).click();
					break;
				}
			}
			driver.switchTo().defaultContent();
			Thread.sleep(1500);
			
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		    driver.switchTo().window(tabs.get(1));
		    fileVersionSubtabInAWS.click();
			je.executeScript("window.scrollBy(-1000,0)");
			je.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			for (int i = 0; i < fileVersionsListInAWS.size(); i++)
				versionListInAWS.add(Integer.parseInt(fileVersionsListInAWS.get(i).getText().trim()));
			driver.close();
			driver.switchTo().window(tabs.get(0));
			driver.switchTo().frame(rightFrame);
			try {
				closeBtn.click();
			}catch(NoSuchElementException e) {
				System.out.println("File not previewed");
			}
			driver.switchTo().defaultContent();
			Thread.sleep(1500);
			
			boolean versionFlag = true;
			for (int i = version-1; i > 0; i--) {
				System.out.println("test "+i);
				if(!versionListInAWS.contains(i))
					versionFlag = false;
			}
			
			if(versionFlag) {
				System.out.println("All the versions for the file "+fileName+" other than V"+version+" version displayed in the File versions subtab");
				logInfo.pass("All the versions for the file "+fileName+" other than V"+version+" version displayed in the File versions subtab");
			}else {
				System.out.println("Some versions for the file "+fileName+" not displayed in the File versions subtab");
				logInfo.fail("Some versions for the file "+fileName+" not displayed in the File versions subtab");
			}
			
		}else {
			System.out.println(fileName+" does'nt have version greater than 1");
			logInfo.pass(fileName+" does'nt have version greater than 1");
		}
	}
	
	public void verifyPublicAndPrivateURLFuncationality(String customer, String fileName, ExtentTest logInfo) throws InterruptedException {
		openAWSRecord(customer, fileName);
		boolean isPublicFlag = true;
		if(isPublicCheckboxInAWS.getAttribute("alt").equals("Unchecked"))
			isPublicFlag = false;
		
		if(isPublicFlag) {
			privateUrlInAWS.click();
			if(isAlertPresent()) {
				Thread.sleep(1000);
				Alert alert = driver.switchTo().alert();
				String alertMsg = alert.getText();
				System.out.println("Alert occured: "+alertMsg);
				logInfo.pass("Alert occured: "+alertMsg);
				alert.accept();
			}
			if(isPublicCheckboxInAWS.getAttribute("alt").equals("Unchecked")) {
				System.out.println("Is Public checkbox is unchecked & file is private");
				logInfo.pass("Is Public checkbox is unchecked & file is private");
			}else {
				System.out.println("Is Public checkbox unable to uncheck");
				logInfo.fail("Is Public checkbox unable to uncheck");
			}
			
			publicUrlInAWS.click();
			if(isAlertPresent()) {
				Thread.sleep(1000);
				Alert alert = driver.switchTo().alert();
				String alertMsg = alert.getText();
				System.out.println("Alert occured: "+alertMsg);
				logInfo.pass("Alert occured: "+alertMsg);
				alert.accept();
			}
			if(isPublicCheckboxInAWS.getAttribute("alt").equals("Checked")) {
				System.out.println("Is Public checkbox is checked & file can be accessed by everyone");
				logInfo.pass("Is Public checkbox is checked & file can be accessed by everyone");
			}else {
				System.out.println("Is Public checkbox is not checked");
				logInfo.fail("Is Public checkbox is not checked");
			}
		}else {
			publicUrlInAWS.click();
			if(isAlertPresent()) {
				Thread.sleep(1000);
				Alert alert = driver.switchTo().alert();
				String alertMsg = alert.getText();
				System.out.println("Alert occured: "+alertMsg);
				logInfo.pass("Alert occured: "+alertMsg);
				alert.accept();
			}
			if(isPublicCheckboxInAWS.getAttribute("alt").equals("Checked")) {
				System.out.println("Is Public checkbox is checked & file can be accessed by everyone");
				logInfo.pass("Is Public checkbox is checked & file can be accessed by everyone");
			}else {
				System.out.println("Is Public checkbox is not checked");
				logInfo.fail("Is Public checkbox is not checked");
			}
			
			privateUrlInAWS.click();
			if(isAlertPresent()) {
				Thread.sleep(1000);
				Alert alert = driver.switchTo().alert();
				String alertMsg = alert.getText();
				System.out.println("Alert occured: "+alertMsg);
				logInfo.pass("Alert occured: "+alertMsg);
				alert.accept();
			}
			if(isPublicCheckboxInAWS.getAttribute("alt").equals("Unchecked")) {
				System.out.println("Is Public checkbox is unchecked & file is private");
				logInfo.pass("Is Public checkbox is unchecked & file is private");
			}else {
				System.out.println("Is Public checkbox unable to uncheck");
				logInfo.fail("Is Public checkbox unable to uncheck");
			}
		}
		
		driver.close();
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(0));
	}
	
	public void verifyMoveCopyFunctionalityInAWS(String moveCopyFlag, String sourceCustomer, String destinationCustomer, String fileName, ExtentTest logInfo) throws InterruptedException {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		openAWSRecord(sourceCustomer, fileName);
		moveCopyBtnInAWS.click();
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(2));
	    recordType.sendKeys("Customer");
	    searchBtnInPopup.click();
	    eleAvailability(driver, copyRadioBtn, 10);
	    if(moveCopyFlag.equals("C"))
	    	copyRadioBtn.click();
	    else if(moveCopyFlag.equals("M"))
	    	moveRadioBtn.click();
	    targetRecordArrowBtn.click();
		targetRecordListBtn.click();
		eleAvailability(driver, searchBox, 10);
		searchBox.sendKeys(destinationCustomer);
		searchBtn.click();
		Thread.sleep(3000);
		for (int i = 0; i < targetRecordDropdownList.size(); i++) {
			if(targetRecordDropdownList.get(i).getText().trim().equals(destinationCustomer)) {
				searchResults.get(i).click();
				break;
			}
		}
		saveBtnInPopup.click();
		if(isAlertPresent()) {
			Thread.sleep(1000);
			Alert alert = driver.switchTo().alert();
			String alertMsg = alert.getText();
			System.out.println("Alert occured: "+alertMsg);
			alert.accept();
		}
		driver.switchTo().window(tabs.get(1));
	    driver.close();
	    driver.switchTo().window(tabs.get(0));
		Thread.sleep(5000);
		driver.switchTo().frame(rightFrame);
		eleAvailability(driver, moveCopyBtn, 10);
		try {
			closeBtn.click();
		}catch(NoSuchElementException e) {
			System.out.println("File not previewed");
		}
		driver.switchTo().defaultContent();
		Thread.sleep(1500);
		
		// Open destination customer
		openCustomer(destinationCustomer);
		boolean flag = false;
		driver.switchTo().frame(rightFrame);
		for (int i = 0; i < fileNamesList.size(); i++) {
			je.executeScript("arguments[0].scrollIntoView(true);", fileNamesList.get(i));
			if(fileNamesList.get(i).getText().contains(fileName)) {
				flag = true;
				break;
			}
		}
		driver.switchTo().defaultContent();
		Thread.sleep(1500);
		if(flag) {
			if(moveCopyFlag.equals("C")) {
				System.out.println(fileName+" copied successfully from "+sourceCustomer+" to "+destinationCustomer);
				logInfo.pass(fileName+" copied successfully from "+sourceCustomer+" to "+destinationCustomer);
			}else if(moveCopyFlag.equals("M")) {
				System.out.println(fileName+" moved successfully from "+sourceCustomer+" to "+destinationCustomer);
				logInfo.pass(fileName+" moved successfully from "+sourceCustomer+" to "+destinationCustomer);
			}
		}else {
			if(moveCopyFlag.equals("C")) {
				System.out.println(fileName+" unable to copy");
				logInfo.fail(fileName+" unable to copy");
			}else if(moveCopyFlag.equals("M")) {
				System.out.println(fileName+" unable to move");
				logInfo.fail(fileName+" unable to move");
			}
		}
	}
	
	public void verifyDownloadFunctionalityInAWS(String customer, String fileName, ExtentTest logInfo) throws InterruptedException {
		openAWSRecord(customer, fileName);
		int downloadFileCount = Integer.parseInt(fileDownloadFieldValue.getText().trim());
		downloadBtnInAWS.click();
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(2));
	    Thread.sleep(6000);
		if(isFileDownloaded("C:\\Users\\Sravan Kumar\\Downloads", "1.jpg")) {
			System.out.println("File downloaded successfully");
			logInfo.pass("File downloaded successfully");
		}else {
			System.out.println("File unable to download");
			logInfo.fail("File unable to download");
		}
		driver.close();
	    driver.switchTo().window(tabs.get(1));
	    
	    // Verify Download File Count is increased or not
	    driver.navigate().refresh();
	    eleAvailability(driver, fileDownloadFieldValue, 10);
	    int downloadFileCount2 = Integer.parseInt(fileDownloadFieldValue.getText().trim());
	    if(downloadFileCount+1 == downloadFileCount2) {
	    	System.out.println("File download field value is displayed correctly. Value incremented from "+downloadFileCount+" to "+downloadFileCount2);
	    	logInfo.pass("File download field value is displayed correctly. Value incremented from "+downloadFileCount+" to "+downloadFileCount2);
	    }else {
	    	System.out.println("File download field value is not displayed correctly");
	    	logInfo.fail("File download field value is not displayed correctly");
	    }
	    
	    driver.close();
	    driver.switchTo().window(tabs.get(0));
	    driver.switchTo().frame(rightFrame);
		try {
			closeBtn.click();
		}catch(NoSuchElementException e) {
			System.out.println("File not previewed");
		}
		driver.switchTo().defaultContent();
		Thread.sleep(1500);
	}
	
	public void verifyViewFunctionalityInAWS(String customer, String fileName, ExtentTest logInfo) throws InterruptedException {
		openAWSRecord(customer, fileName);
		int viewFileCount = Integer.parseInt(fileViewFieldValue.getText().trim());
		viewBtnInAWS.click();
	    ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs1.get(2));
	    boolean viewFlag = false;
	    try {
			eleAvailability(driver, By.xpath("//img[@id='fileview']"), 10);
			if(driver.findElement(By.xpath("//img[@id='fileview']")).isDisplayed()) {
				viewFlag = true;
				Thread.sleep(1500);
			}
		} catch (Exception e) {
			System.out.println("File '"+fileName+"' unable to view");
			logInfo.fail("File '"+fileName+"' unable to view");
		}
	    driver.close();
	    driver.switchTo().window(tabs1.get(1));
	    if (viewFlag) {
			System.out.println("File '"+fileName+"' is viewed");
			logInfo.pass("File '"+fileName+"' is viewed");
		}
	    
	    // Verify View File Count is increased or not
	    driver.navigate().refresh();
		eleClickable(driver, fileViewFieldValue, 10);
	    int viewFileCount2 = Integer.parseInt(fileViewFieldValue.getText().trim());
	    if(viewFileCount+1 == viewFileCount2) {
	    	System.out.println("File view field value is displayed correctly. Value incremented from "+viewFileCount+" to "+viewFileCount2);
	    	logInfo.pass("File view field value is displayed correctly. Value incremented from "+viewFileCount+" to "+viewFileCount2);
	    }else {
	    	System.out.println("File view field value is not displayed correctly");
	    	logInfo.fail("File view field value is not displayed correctly");
	    }
	    
	    driver.close();
	    driver.switchTo().window(tabs1.get(0));
	    driver.switchTo().frame(rightFrame);
		try {
			closeBtn.click();
		}catch(NoSuchElementException e) {
			System.out.println("File not previewed");
		}
		driver.switchTo().defaultContent();
		Thread.sleep(1500);
	}
	
	public void openAWSRecord(String customer, String fileName) throws InterruptedException {
		openCustomer(customer);
		driver.switchTo().frame(rightFrame);
		for (int i = 0; i < fileNamesListWithoutNotes.size(); i++) {
			if(fileNamesListWithoutNotes.get(i).getText().trim().contains(fileName)) {
				fileNamesListWithoutNotes.get(i).click();
				break;
			}
		}
		driver.switchTo().defaultContent();
		Thread.sleep(1500);
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
	}
	
	public void verifySkyDocFilesInEmailRecord(String customer, ExtentTest logInfo) throws InterruptedException {
		action = new Actions(driver);
		
		List<String> fileNamesUploaded = new ArrayList<>();
		List<String> fileNamesInEmailRecord = new ArrayList<>();
		
		// Add files names uploaded in the current record
		driver.switchTo().frame(rightFrame);
		for (int i = 0; i < fileNamesList.size(); i++) {
			String fileName = fileNamesList.get(i).getText().trim().split("\\[V")[0].trim();
			fileNamesUploaded.add(fileName);
		}
		
		// Add file names uploaded in the related transactions record
		transactionFilesBtn.click();
		eleAvailability(driver, displayListBtnInTransactionFiles, 10);
		for (int i = 0; i < fileNamesList.size(); i++) {
			String fileName = fileNamesList.get(i).getText().trim().split("\\[V")[0].trim();
			fileNamesUploaded.add(fileName);
		}
		driver.switchTo().defaultContent();
		Thread.sleep(1500);
		
		// Go to SkyDoc Files tab in Email record & store all the file names
		communicationSubtab.click();
		emailBtn.click();
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
	    driver.manage().window().maximize();
	    skyDocTab.click();
	    skyDocFileDropdown.click();
	    List<WebElement> fileList = driver.findElements(By.xpath("//div[@class='dropdownDiv']//div"));
	    for (int i = 0; i < fileList.size(); i++) {
			if(!fileList.get(i).getText().trim().isBlank()) {
				System.out.println(fileList.get(i).getText().trim());
				fileNamesInEmailRecord.add(fileList.get(i).getText().trim());
			}
		}
	    driver.close();
	    driver.switchTo().window(tabs.get(0));
	    
	    Collections.sort(fileNamesInEmailRecord);
	    Collections.sort(fileNamesUploaded);
	    
	    if(fileNamesUploaded.equals(fileNamesInEmailRecord)) {
	    	System.out.println("All the files uploaded in the current record & related transactions records are displayed in the Files list of the Email record");
	    	logInfo.pass("All the files uploaded in the current record & related transactions records are displayed in the Files list of the Email record");
	    }else {
	    	System.out.println("All the files uploaded in the current record & related transactions records are not displayed correctly in the Files list of the Email record");
	    	logInfo.fail("All the files uploaded in the current record & related transactions records are not displayed correctly in the Files list of the Email record");
	    }
	    
	}
	
	public void verifyEmailFunctionalityWithSkyDocFiles(String subject, String fileName, ExtentTest logInfo) throws InterruptedException {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		communicationSubtab.click();
		Thread.sleep(2500);
		emailBtn.click();
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
	    driver.manage().window().maximize();
	    messagesTab.click();
	    subjectBox.sendKeys(subject);
	    skyDocTab.click();
	    skyDocFileDropdown.sendKeys(fileName);
	    mergeSendBtn.click();
	    if(isAlertPresent()) {
	    	Thread.sleep(1000);
			Alert alert = driver.switchTo().alert();
			String alertMsg = alert.getText();
			System.out.println("Alert occured: "+alertMsg);
			alert.accept();
	    }
	    Thread.sleep(4000);
	    driver.switchTo().window(tabs.get(0));
	    eleAvailability(driver, By.xpath("//input[@id='refreshmessages']"), 10);
	    driver.findElement(By.xpath("//input[@id='refreshmessages']")).click();
	    Thread.sleep(4000);
	    try {
		    WebElement subjectElement = driver.findElement(By.xpath("//div[@id='messages_layer']//td[text()='Test Image Email']"));
		    eleAvailability(driver, subjectElement, 10);
		    WebElement parentTr = (WebElement)je.executeScript("return arguments[0].parentNode;", subjectElement);
		    String rowId = parentTr.getAttribute("id");
		    driver.findElement(By.xpath("//div[@id='messages_layer']//tr[@id='"+rowId+"']//a[text()='View']")).click();
		    
		    ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		    driver.switchTo().window(tabs2.get(1));
		    WebElement skyDocFile = driver.findElement(By.xpath("//td[text()='"+fileName+"']"));
		    if(skyDocFile.isDisplayed()) {
		    	System.out.println("Email sent successfully with file '"+fileName+"' attached");
		    	logInfo.pass("Email sent successfully with file '"+fileName+"' attached");
		    }
		    driver.close();
		    driver.switchTo().window(tabs2.get(0));
	    }catch(NoSuchElementException e) {
	    	System.out.println("Email not sent");
	    	logInfo.fail("Email not sent");
	    }
	    
	}
	
	public void verifyFolderAccessInPortal(String folderName, String employeeName, ExtentTest logInfo) throws InterruptedException {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		action = new Actions(driver);
		
		// Verify if the employee has the Portal access
		Thread.sleep(1500);
		eleAvailability(driver, listLink, 10);
		action.moveToElement(listLink).build().perform();
		eleAvailability(driver, employeesLink1, 10); // Explicit Wait
		action.moveToElement(employeesLink1).build().perform();
		eleAvailability(driver, employeesLink2, 10); // Explicit Wait
		employeesLink2.click();
		
		for(int i=0;i<customerList.size();i++) {
			WebElement currentEmp = customerList.get(i);
			String text = currentEmp.getText();
			if(text.equals(employeeName)) {
				action.moveToElement(currentEmp).build().perform();
				WebElement parentTd = (WebElement)je.executeScript("return arguments[0].parentNode;", currentEmp);
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
		boolean supervisorFlag = true;
		String supervisorEmail = driver.findElement(By.xpath("//span[@id='email_fs_lbl_uir_label']//following-sibling::span//a")).getText().trim();
		String supervisorPwd = driver.findElement(By.xpath("//span[@id='custentity_tss_skydoc_external_pass_fs_lbl_uir_label']//following-sibling::span")).getText().trim();
		if(skyDocExternalAccessCheckbox.getAttribute("alt").equals("Unchecked"))
			supervisorFlag = false;
		
		if(supervisorFlag) {
			// Navigate to SkyDoc Folders List
			eleAvailability(driver, documentsLink, 10);
			action.moveToElement(documentsLink).build().perform();
			eleAvailability(driver, skyDocFoldersLink1, 10);
			action.moveToElement(skyDocFoldersLink1).build().perform();
			eleAvailability(driver, skyDocFoldersListLink, 10);
			skyDocFoldersListLink.click();
			
			List<WebElement> foldersList = driver.findElements(By.xpath("//tr[contains(@id,'row')]//td[count(//table[@id='div__labtab']//div[text()='Name']//parent::td//preceding-sibling::td)+1]"));
	        for (int i = 0; i < foldersList.size(); i++) {
	        	action.moveToElement(foldersList.get(i)).build().perform();
				if(foldersList.get(i).getText().trim().equals(folderName)) {
					WebElement parentTr = (WebElement)je.executeScript("return arguments[0].parentNode;", foldersList.get(i));
					String rowId = parentTr.getAttribute("id");
					driver.findElement(By.xpath("//tr[@id='"+rowId+"']//a[text()='View']")).click();
					break;
				}
			}
	        skyDocPortalAccessSubtabInFolderPage.click();
	        boolean accessFlag = false;
	        for (int i = 0; i < externalEntityListForFolder.size(); i++) {
				if(externalEntityListForFolder.get(i).getText().trim().equals(employeeName)) {
					accessFlag = true;
					break;
				}
			}
	        
	        if(!accessFlag) {
	        	editBtnInExpenseReport.click();
	        	Thread.sleep(2000);
	        	skyDocPortalAccessSubtabInFolderPage.click();
	        	action.moveToElement(externalEntityArrowBtn).build().perform();
	        	externalEntityArrowBtn.click();
	        	eleClickable(driver, externalEntitySearchBox, 10);
	        	externalEntitySearchBox.sendKeys(employeeName);
	        	externalEntitySearchBtn.click();
	        	Thread.sleep(3000);
	        	List<WebElement> searchResults = driver.findElements(By.xpath("//div[@id='popup_outerdiv']//div[@id='inner_popup_div']//a[@class='smalltextnolink']"));
	        	for (int i = 0; i < searchResults.size(); i++) {
	        		System.out.println(searchResults.get(i).getText().trim()+" "+employeeName);
					if(searchResults.get(i).getText().trim().equals(employeeName)) {
						searchResults.get(i).click();
						break;
					}
				}
	        	Thread.sleep(500);
	        	driver.findElement(By.xpath("//div[@id='popup_outerdiv']//input[@id='update']")).click();
	        	
	        	driver.findElement(By.xpath("//input[@id='btn_multibutton_submitter']")).click();
	        }
	        
	        // Login to SkyDoc portal
 			je.executeScript("window.open('about:blank','_blank');");
 			ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
 		    driver.switchTo().window(tabs1.get(1));
 			driver.get(prop.getProperty("skyDocPortalUrl"));
 			eleAvailability(driver, portalUsername, 10);
 		    portalUsername.sendKeys(supervisorEmail);
 		    portalPassword.sendKeys(supervisorPwd);
 		    portalLoginBtn.click();
 		    
 		    // Verify folder in the Upload files page
 		    driver.switchTo().frame("myFrame");
 		    driver.findElement(By.xpath("//b[text()='Upload Files']")).click();
 		    driver.switchTo().frame("frame");
 		    boolean folderFoundFlag = false;
 		    eleAvailability(driver, By.xpath("//input[@id='searchstr']"), 10);
 		    Thread.sleep(2000);
 		    for (int i = 0; i < uploadFilesLeftFolderListInPortal.size(); i++) {
 		    	System.out.println(uploadFilesLeftFolderListInPortal.get(i).getText().trim()+" "+folderName);
				if(uploadFilesLeftFolderListInPortal.get(i).getText().trim().equals(folderName)) {
					folderFoundFlag = true;
					break;
				}
			}
 		    driver.switchTo().defaultContent();
 		    Thread.sleep(1500);
 		    driver.close();
 		    driver.switchTo().window(tabs1.get(0));
 		    
 		    if(folderFoundFlag) {
 		    	System.out.println("User: "+employeeName+" got access for the folder: "+folderName+" in the SkyDoc portal");
 		    	logInfo.pass("User: "+employeeName+" got access for the folder: "+folderName+" in the SkyDoc portal");
 		    }else {
 		    	System.out.println("User: "+employeeName+" unable to get access for the folder: "+folderName+" in the SkyDoc portal");
 		    	logInfo.fail("User: "+employeeName+" unable to get access for the folder: "+folderName+" in the SkyDoc portal");
 		    }
		}else {
			System.out.println("User: "+employeeName+" does'nt have access to the SkyDoc Portal");
			logInfo.fail("User: "+employeeName+" does'nt have access to the SkyDoc Portal");
		}
		
	}
	
	public void verifyFileUploadInPublicFolder(String customer, String folder, String category, String filePath, ExtentTest logInfo) throws InterruptedException, AWTException {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		action = new Actions(driver);
		String[] filepath = filePath.split(Pattern.quote(File.separator));;
        String fileName = filepath[filepath.length-1];
		
		// Make the folder as public
        WebElement viewLink = driver.findElement(By.xpath("//tr[contains(@id,'row')]//td[count(//thead//div[text()='Name']//parent::td//preceding-sibling::td)+1][text()='"+folder+"']//preceding-sibling::td//a[contains(@class,'view')]"));
        action.moveToElement(viewLink).click(viewLink).build().perform();
		String publicCheckboxClass = driver.findElement(By.xpath("//span[@id='custrecord_tss_aws_s3_ns_public_fs']")).getAttribute("class").trim();
		if(publicCheckboxClass.equals("checkbox_read_unck")) {
			editBtnInExpenseReport.click();
			driver.findElement(By.xpath("//span[@id='custrecord_tss_aws_s3_ns_public_fs']//img")).click();
			driver.findElement(By.xpath("//input[@id='btn_multibutton_submitter']")).click();
		}
		
		// Open Customer & upload file
		openCustomer(customer);
		verifyFileUpload(folder, category, filePath, logInfo);
		
		// View file in new tab
		driver.switchTo().frame(rightFrame);
		String fileLink = driver.findElement(By.xpath("//a[text()='"+fileName+"']")).getAttribute("href");
    	je.executeScript("window.open('"+fileLink+"')");
    	driver.switchTo().defaultContent();
    	Thread.sleep(1500);
    	ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
	    String isPublicCheckboxClass = driver.findElement(By.xpath("//span[@id='custrecord_tss_aws_s3_ns_ispublic_fs']")).getAttribute("class").trim();
	    if(isPublicCheckboxClass.equals("checkbox_read_ck")) {
	    	System.out.println(fileName+" File uploaded to the Public folder: "+folder+" is selected as public");
	    	logInfo.pass(fileName+" File uploaded to the Public folder: "+folder+" is selected as public");
	    }else {
	    	System.out.println(fileName+" File uploaded to the Public folder: "+folder+" is not selected as public");
	    	logInfo.fail(fileName+" File uploaded to the Public folder: "+folder+" is not selected as public");
	    }
	    driver.close();
	    driver.switchTo().window(tabs.get(0));
		
	}
	
	public void verifySendForApprovalFunctionality(String entityName, String folderName, String categoryName, String filePath, String comments, String approvalFlag, ExtentTest logInfo) throws AWTException, InterruptedException {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		action = new Actions(driver);
		String[] filepath = filePath.split(Pattern.quote(File.separator));;
        String fileName = filepath[filepath.length-1];
		
		// Open the employee record
		eleAvailability(driver, listLink, 10);
		action.moveToElement(listLink).build().perform();
		eleAvailability(driver, employeesLink1, 10); // Explicit Wait
		action.moveToElement(employeesLink1).build().perform();
		eleAvailability(driver, employeesLink2, 10); // Explicit Wait
		employeesLink2.click();
		
		for(int i=0;i<customerList.size();i++) {
			WebElement currentEmp = customerList.get(i);
			String text = currentEmp.getText();
			if(text.equals(entityName)) {
				action.moveToElement(currentEmp).build().perform();
				WebElement parentTd = (WebElement)je.executeScript("return arguments[0].parentNode;", currentEmp);
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
		
		// Get username, pwd when supervisor have access
		String supervisorEmail = null, supervisorPwd = null;
		boolean supervisorFlag = true;
		try {
			action.keyDown(Keys.CONTROL).click(supervisorLinkInEmp).keyUp(Keys.CONTROL).build().perform();
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			supervisorEmail = driver.findElement(By.xpath("//span[@id='email_fs_lbl_uir_label']//following-sibling::span//a")).getText().trim();
			supervisorPwd = driver.findElement(By.xpath("//span[@id='custentity_tss_skydoc_external_pass_fs_lbl_uir_label']//following-sibling::span")).getText().trim();
			if(skyDocExternalAccessCheckbox.getAttribute("alt").equals("Unchecked"))
				supervisorFlag = false;
			driver.close();
			driver.switchTo().window(tabs.get(0));
		} catch (NoSuchElementException e1) {
			supervisorFlag = false;
			System.out.println("Something not right with supervisor details");
			logInfo.fail("Something not right with supervisor details");
		}
		
		if(supervisorFlag) i: {
			// Upload file
			skyDocSubtabLink.click();
			je.executeScript("window.scrollBy(-1000,0)");
			je.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			verifyFileUpload(folderName, categoryName, filePath, logInfo);
			// Send File for approval
			driver.switchTo().frame(rightFrame);
			for (int i = 0; i < fileNamesList.size(); i++) {
				action.moveToElement(fileNamesList.get(i));
				if (fileNamesList.get(i).getText().contains(fileName)) {
					WebElement checkBoxInput = (WebElement) je.executeScript("return arguments[0].previousSibling.lastChild;", fileNamesList.get(i));
					checkBoxInput.click();
					break;
				}
			}
			sendForApprovalBtn.click();
			if (isAlertPresent()) {
				Thread.sleep(1000);
				Alert alert = driver.switchTo().alert();
				String alertMsg = alert.getText();
				System.out.println("Alert occured: " + alertMsg);
				alert.accept();
			}
			try {
				WebElement statusImg = driver.findElement(By.xpath("//a[text()='" +fileName+ "']//parent::td//following-sibling::td//img[@title='Pending Approval']"));
				if (statusImg.isDisplayed()) {
					System.out.println(fileName + " sent for approval");
					logInfo.pass(fileName + " sent for approval");
				}
			} catch (NoSuchElementException e) {
				System.out.println(fileName + " unable to send for approval");
				logInfo.fail(fileName + " unable to send for approval");
				break i;
			}
			driver.switchTo().defaultContent();
			Thread.sleep(1500);
			
			// Login to SkyDoc portal & approve/reject files
			je.executeScript("window.open('about:blank','_blank');");
			ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
		    driver.switchTo().window(tabs1.get(1));
			driver.get(prop.getProperty("skyDocPortalUrl"));
			eleAvailability(driver, portalUsername, 10);
		    portalUsername.sendKeys(supervisorEmail);
		    portalPassword.sendKeys(supervisorPwd);
		    portalLoginBtn.click();
		    driver.switchTo().frame("myFrame");
		    boolean fileApprovalFlag = false;
		    for (int i = 0; i < fileRowListInPortal.size(); i++) {
				if(fileNamesListInPortal.get(i).getText().trim().equals(fileName) && attachedToListInPortal.get(i).getText().trim().equals(entityName)) {
					fileRowListInPortal.get(i).click();
					approverCommentsInPortal.sendKeys(comments);
					if(approvalFlag.equals("Approve")) {
						approvalBtnInPortal.click();
						Thread.sleep(8000);
						selectActionDropdownInPortal.sendKeys("Approved Records");
						Thread.sleep(3500);
						for (int j = 0; j < fileRowListInPortal.size(); j++) {
							if(fileNamesListInPortal.get(j).getText().trim().equals(fileName) && attachedToListInPortal.get(j).getText().trim().equals(entityName)) {
								fileApprovalFlag = true;
								break;
							}
						}
					}else if(approvalFlag.equals("Reject")) {
						rejectBtnInPortal.click();
						Thread.sleep(8000);
						selectActionDropdownInPortal.sendKeys("Rejected Records");
						Thread.sleep(3500);
						for (int j = 0; j < fileRowListInPortal.size(); j++) {
							if(fileNamesListInPortal.get(j).getText().trim().equals(fileName) && attachedToListInPortal.get(j).getText().trim().equals(entityName)) {
								fileApprovalFlag = true;
								break;
							}
						}
					}
					break;
				}
			}
		    driver.switchTo().defaultContent();
		    Thread.sleep(1500);
		    driver.close();
		    driver.switchTo().window(tabs1.get(0));
		    driver.switchTo().frame(rightFrame);
		    refreshBtn.click();
		    
	    	if(approvalFlag.equals("Approve")) {
	    		try {
					WebElement statusImg = driver.findElement(By.xpath("//a[text()='" +fileName+ "']//parent::td//following-sibling::td//img[@title='Approved']"));
					if (statusImg.isDisplayed()) {
						System.out.println(fileName+" file approved successfully by the supervisor of "+entityName);
						logInfo.pass(fileName+" file approved successfully by the supervisor of "+entityName);
					}
				} catch (NoSuchElementException e) {
					System.out.println(fileName + " unable to approve");
					logInfo.fail(fileName + " unable to approve");
				}
	    		if(fileApprovalFlag) {
	    			System.out.println(fileName+" file displayed in the Approved records list in SkyDoc Portal");
		    		logInfo.pass(fileName+" file displayed in the Approved records list in SkyDoc Portal");
	    		}else {
	    			System.out.println(fileName+" file not displayed in the Approved records list in SkyDoc Portal");
		    		logInfo.fail(fileName+" file not displayed in the Approved records list in SkyDoc Portal");
	    		}
	    	}else if(approvalFlag.equals("Reject")) {
	    		try {
					WebElement statusImg = driver.findElement(By.xpath("//a[text()='" +fileName+ "']//parent::td//following-sibling::td//img[@title='Rejected']"));
					if (statusImg.isDisplayed()) {
						System.out.println(fileName+" file rejected successfully by the supervisor of "+entityName);
						logInfo.pass(fileName+" file rejected successfully by the supervisor of "+entityName);
					}
				} catch (NoSuchElementException e) {
					System.out.println(fileName + " unable to reject");
					logInfo.fail(fileName + " unable to reject");
				}
	    		if(fileApprovalFlag) {
	    			System.out.println(fileName+" file displayed in the Rejected records list in SkyDoc Portal");
		    		logInfo.pass(fileName+" file displayed in the Rejected records list in SkyDoc Portal");
	    		}else {
	    			System.out.println(fileName+" file not displayed in the Rejected records list in SkyDoc Portal");
	    			logInfo.pass(fileName+" file not displayed in the Rejected records list in SkyDoc Portal");
	    		}
	    	}
	    	
	    	// Open file in new tab & verify comments in AWS record
	    	String fileLink = driver.findElement(By.xpath("//a[text()='"+fileName+"']")).getAttribute("href");
	    	je.executeScript("window.open('"+fileLink+"')");
	    	driver.switchTo().defaultContent();
	    	Thread.sleep(1500);
	    	ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		    driver.switchTo().window(tabs2.get(1));
		    try {
				String commentsText = driver.findElement(By.xpath("//span[@id='custrecord_tss_external_comments_fs_lbl_uir_label']//following-sibling::span")).getText();
				if(commentsText.contains(comments)) {
					System.out.println("Approver comments are displayed in the AWS record");
		    	logInfo.pass("Approver comments are displayed in the AWS record");
				}else {
					System.out.println("Approver comments are not displaying correctly in the AWS record");
		    	logInfo.fail("Approver comments are not displaying correctly in the AWS record");
				}
			} catch (NoSuchElementException e) {
				System.out.println("Approver Comments does'nt exist in the AWS record");
				logInfo.fail("Approver Comments does'nt exist in the AWS record");
				System.out.println(e.getMessage());
			}
		    
		    driver.close();
		    driver.switchTo().window(tabs2.get(0));
		}else {
			System.out.println("Supervisor for the entity "+entityName+" does'nt have SkyDoc portal access");
			logInfo.fail("Supervisor for the entity "+entityName+" does'nt have SkyDoc portal access");
		}
		
	}
	
	public void enableAndVerifySkyDocPortalAccess(String employeeName, String password, ExtentTest logInfo) throws InterruptedException {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		action = new Actions(driver);
		
		// Open the employee record
		Thread.sleep(1000);
		eleAvailability(driver, listLink, 10);
		action.moveToElement(listLink).build().perform();
		eleAvailability(driver, employeesLink1, 10); // Explicit Wait
		action.moveToElement(employeesLink1).build().perform();
		eleAvailability(driver, employeesLink2, 10); // Explicit Wait
		employeesLink2.click();
		
		for(int i=0;i<customerList.size();i++) {
			WebElement currentEmp = customerList.get(i);
			String text = currentEmp.getText();
			if(text.equals(employeeName)) {
				action.moveToElement(currentEmp).build().perform();
				WebElement parentTd = (WebElement)je.executeScript("return arguments[0].parentNode;", currentEmp);
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
		
		// Enter all the data required for SkyDoc External access
		editBtnInEmp.click();
		skyDocPwdInEmp.clear();
		skyDocPwdInEmp.sendKeys(password);
		enableCheckbox(skyDocExternalAccessCheckbox);
		enableCheckbox(skyDocExternalAccessNotificationCheckbox);
		String email = driver.findElement(By.xpath("//input[@id='email']")).getAttribute("value").trim();
		je.executeScript("window.scrollTo(0,0)");
		saveBtnInEmp.click();
		
		// Verify login access in the SkyDoc Portal
		eleClickable(driver, editBtnInEmp, 15);
		je.executeScript("window.open('about:blank','_blank');");
		ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs1.get(1));
		driver.get(prop.getProperty("skyDocPortalUrl"));
		eleAvailability(driver, portalUsername, 10);
	    portalUsername.sendKeys(email);
	    portalPassword.sendKeys(password);
	    portalLoginBtn.click();
	    
	    try {
	    	driver.switchTo().frame("myFrame");
		    eleAvailability(driver, By.xpath("//h3//font"), 10);
		    String approvePageHeading = driver.findElement(By.xpath("//h3//font")).getText();
		    if(approvePageHeading.contains("Approve")) {
		    	System.out.println("SkyDoc Portal access enabled for the entity "+employeeName);
		    	logInfo.pass("SkyDoc Portal access enabled for the entity "+employeeName);
		    }
	    }catch(NoSuchElementException e) {
	    	System.out.println("SkyDoc Portal access denied for the entity "+employeeName);
	    	logInfo.fail("SkyDoc Portal access denied for the entity "+employeeName);
	    }
	    driver.close();
	    driver.switchTo().window(tabs1.get(0));
	    
	    // Verify Email
	    boolean emailFlag = false;
	    for (int i = 0; i < recipientEmailListInAWS.size(); i++) {
	    	action.moveToElement(recipientEmailListInAWS.get(i)).build().perform();
			if(recipientEmailListInAWS.get(i).getText().trim().equals(email) && emailSubjectList.get(i).getText().equals("Access to SkyDoc Portal")) {
				emailFlag = true;
				break;
			}
		}
	    
	    if (emailFlag) {
			System.out.println("SkyDoc Portal Access Notification sent to the User: "+employeeName);
			logInfo.pass("SkyDoc Portal Access Notification sent to the User: "+employeeName);
		}else {
			System.out.println("SkyDoc Portal Access Notification unable to sent to the User: "+employeeName);
			logInfo.fail("SkyDoc Portal Access Notification unable to sent to the User: "+employeeName);
		}
	}
	
	public void verifyDeletingFileWithMultipleVersions(String customer, String folderName, String categoryName, String filePath, ExtentTest logInfo) throws InterruptedException {
		openCustomer(customer);
		String[] filepath = filePath.split(Pattern.quote(File.separator));;
        String fileName = filepath[filepath.length-1];
		int version = getVersionForFile(fileName, folderName, categoryName);
		if(version>1) {
			verifyDeleteFunctionality(fileName, logInfo);
			int version2 = getVersionForFile(fileName, folderName, categoryName);
			if(version - 1 == version2) {
				System.out.println(fileName+" file is updating the versions correctly from version 'V"+version+"' to version 'V"+version2+"'");
				logInfo.pass(fileName+" file is updating the versions correctly from version 'V"+version+"' to version 'V"+version2+"'");
			}else {
				System.out.println(fileName+" file is not deleting the latest version");
				logInfo.fail(fileName+" file is not deleting the latest version");
			}
		}else {
			System.out.println(fileName+" is not having multiple versions");
			logInfo.fail(fileName+" is not having multiple versions");
		}
	}
	
	public void verifyVersionsForMultipleFileUploads(String fileName, int version1, int version2, ExtentTest logInfo) {
		if(version1 + 1 == version2) {
			System.out.println(fileName+" file is updating the versions correctly from version 'V"+version1+"' to version 'V"+version2+"'");
			logInfo.pass(fileName+" file is updating the versions correctly from version 'V"+version1+"' to version 'V"+version2+"'");
		}else {
			System.out.println(fileName+" file is not updating the versions correctly");
			logInfo.fail(fileName+" file is not updating the versions correctly");
		}
	}
	
	public int getVersionForFile(String fileName, String folder, String category) throws InterruptedException {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		driver.switchTo().frame(rightFrame);
		int version = 0;
		for (int i = 0; i < fileNamesList.size(); i++) {
			if(fileNamesList.get(i).getText().contains(fileName) && folderList.get(i).getText().equals(folder) && categoryList.get(i).getText().equals(category)) {
				WebElement versionSpan = (WebElement)je.executeScript("return arguments[0].lastChild.previousSibling.previousSibling;", fileNamesList.get(i));
				String versionText = versionSpan.getText().replaceAll("\\[V", "").replaceAll("\\]", "");
				version = Integer.parseInt(versionText);
				break;
			}
		}
		driver.switchTo().defaultContent();
		Thread.sleep(1500);
		return version;
	}
	
	public void verifyFolderFilter(String folderName, ExtentTest logInfo) throws InterruptedException {
		driver.switchTo().frame(rightFrame);
		
		// Get all the files with the folder selected
		int folderMatchCount = 0;
		int filesCount = 0;
		for (int i = 0; i < folderList.size(); i++) {
			if(folderList.get(i).getText().contains(folderName))
				folderMatchCount++;
		}
		
		// Select folder Category & get files count after filter
		folderFilterDropdown.click();
		for (int i = 0; i < folderFilterDropdownOptions.size(); i++) {
			if(folderFilterDropdownOptions.get(i).getText().contains(folderName)) {
				folderFilterDropdownOptions.get(i).click();
				break;
			}
		}
		refreshBtn.click();
		Thread.sleep(2000);
		eleAvailability(driver, refreshBtn, 10);
		for (int i = 0; i < folderList.size(); i++)
			filesCount++;
				
		// Compare both the count & print result
		if(folderMatchCount == filesCount) {
			System.out.println("The files attached to the selected folder:"+folderName+" are displayed correctly");
			logInfo.pass("The files attached to the selected folder:"+folderName+" are displayed correctly");
		}else {
			System.out.println("The files attached to the selected folder:"+folderName+" are not displayed correctly");
			logInfo.fail("The files attached to the selected folder:"+folderName+" are not displayed correctly");
		}
		
		driver.switchTo().defaultContent();
		Thread.sleep(1500);
	}
	
	public void addNoteForFile(String note, String fileName, ExtentTest logInfo) throws InterruptedException {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		action = new Actions(driver);
		driver.switchTo().frame(rightFrame);
		boolean fileFoundStatus = false;
		for (int i = 0; i < fileNamesListWithoutNotes.size(); i++) {
			if(fileNamesListWithoutNotes.get(i).getText().contains(fileName)) {
				fileFoundStatus = true;
				WebElement plusSymbol = (WebElement)je.executeScript("return arguments[0].parentNode.lastChild.lastChild;", fileNamesListWithoutNotes.get(i));
				action.moveToElement(plusSymbol).build().perform();
				plusSymbol.click();
				eleAvailability(driver, By.xpath("//textarea[@id='description_comments']"), 5);
				driver.findElement(By.xpath("//textarea[@id='description_comments']")).sendKeys(note);
				driver.findElement(By.xpath("//div[@class='note-content']//button[text()='Submit']")).click();
				Thread.sleep(7000);
				eleAvailability(driver, By.xpath("//a[text()='"+fileName.trim()+"']//following-sibling::span//img"), 10);
				driver.findElement(By.xpath("//a[text()='"+fileName.trim()+"']//following-sibling::span//img")).click();
				if(driver.findElement(By.xpath("//p[@id='demo']")).getText().contains(note)) {
					System.out.println("Note added successfully for file "+fileName);
					logInfo.pass("Note added successfully for file "+fileName);
				}else {
					System.out.println("Note unable to add for file "+fileName);
					logInfo.fail("Note unable to add for file "+fileName);
				}
				break;
			}
		}
		if(!fileFoundStatus) {
			System.out.println(fileName+" file not found to add note");
			logInfo.fail(fileName+" file not found to add note");
		}
		driver.switchTo().defaultContent();
		Thread.sleep(1500);
	}
	
	public void verifyNewFolderFunctionality(ExtentTest logInfo) throws InterruptedException {
		String recordName = driver.findElement(By.xpath("//div[@class='uir-record-name']")).getText().trim();
		driver.switchTo().frame(rightFrame);
		newFolderBtn.click();
		driver.switchTo().defaultContent();
		Thread.sleep(1500);
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
	    driver.manage().window().maximize();
	    eleAvailability(driver, By.xpath("//input[@id='custrecord_skydoc_folder_name']"), 10);
	    // Enter Folder name, Click Access to all employees, public checbox
	    driver.findElement(By.xpath("//input[@id='custrecord_skydoc_folder_name']")).sendKeys(recordName+" Folder");
    	driver.findElement(By.xpath("//span[@id='custrecordtss_aws_s3_ns_access_allemp_fs']//img")).click();
    	driver.findElement(By.xpath("//span[@id='custrecord_tss_aws_s3_ns_public_fs']//img")).click();
    	driver.findElement(By.xpath("//input[@id='btn_multibutton_submitter']")).click();
    	Thread.sleep(5000);
	    driver.close();
	    driver.switchTo().window(tabs.get(0));
	    Thread.sleep(5000);
	    driver.switchTo().frame(leftFrame);
	    eleAvailability(driver, skyDocUploadFolderInCustomerPage, 10);
	    String folderName = recordName+" Folder";
	    if(skyDocUploadFolderInCustomerPage.getText().replaceAll(" ", "").contains(folderName.replaceAll(" ", ""))) {
	    	System.out.println(folderName+" folder is created & also selected as the default folder for the record");
	    	logInfo.pass(folderName+" folder is created & also selected as the default folder for the record");
	    }else {
	    	System.out.println(folderName+" folder unable to create");
	    	logInfo.fail(folderName+" folder unable to create");
	    }
	    driver.switchTo().defaultContent();
	    Thread.sleep(1500);
	}
	
	public void verifyCheckOutSymbol(String fileName, ExtentTest logInfo) throws InterruptedException {
		driver.switchTo().frame(rightFrame);
		Thread.sleep(3000);
		boolean checkOutFlag = false;
		try {
			action.moveToElement(driver.findElement(By.xpath("//a[text()='"+fileName.trim()+"']//following-sibling::img"))).build().perform();
			if(driver.findElement(By.xpath("//a[text()='"+fileName.trim()+"']//following-sibling::img")).isDisplayed())
				checkOutFlag = true;

		}catch(NoSuchElementException e) {
			System.out.println("Check out symbol is removed for the file "+fileName);
			logInfo.pass("Check out symbol is removed for the file "+fileName);
		}
		if(checkOutFlag) {
			System.out.println("Check out symbol is still displayed for the file "+fileName);
			logInfo.fail("Check out symbol is still displayed for the file "+fileName);
		}
		driver.switchTo().defaultContent();
		Thread.sleep(1500);
	}
	
	public void verifyCheckOutFunctionality(String fileName, ExtentTest logInfo) throws InterruptedException {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		action = new Actions(driver);
		driver.switchTo().frame(rightFrame);
		
		// Select file to Check out
		boolean fileFoundStatus = false;
		for (int i = 0; i < fileNamesList.size(); i++) {
			action.moveToElement(fileNamesList.get(i));
			if(fileNamesList.get(i).getText().contains(fileName)) {
				WebElement previousTd = (WebElement)je.executeScript("return arguments[0].previousSibling;", fileNamesList.get(i));
				WebElement checkBoxInput = (WebElement)je.executeScript("return arguments[0].lastChild;", previousTd);
				checkBoxInput.click();
				fileFoundStatus = true;
				break;
			}
		}
		
		if(fileFoundStatus) i: {
			// Click Check out button
			action.moveToElement(checkoutBtn).build().perform();
			Thread.sleep(1500);
			je.executeScript("arguments[0].click();", checkoutBtn);
			if(isAlertPresent()) {
				Thread.sleep(1000);
				Alert alert = driver.switchTo().alert();
				String alertMsg = alert.getText();
				System.out.println("Alert occured: "+alertMsg);
				alert.accept();
				if(alertMsg.contains("has been checked out by same user")) {
					logInfo.pass("Alert occured: "+alertMsg);
					break i;
				}
			}
			
			// Verify file is downloaded or not
			boolean checkOutFlag = false;
			Thread.sleep(11000);
			if(isFileDownloaded("C:\\Users\\Sravan Kumar\\Downloads", fileName)) {
				eleAvailability(driver, closeBtnInCheckout, 10);
				eleClickable(driver, closeBtnInCheckout, 10);
				je.executeScript("arguments[0].click();", closeBtnInCheckout);
				eleAvailability(driver, checkoutBtn, 10);
				action.moveToElement(driver.findElement(By.xpath("//a[text()='"+fileName.trim()+"']//following-sibling::img"))).build().perform();
				if(driver.findElement(By.xpath("//a[text()='"+fileName.trim()+"']//following-sibling::img")).isDisplayed()) {
					checkOutFlag = true;
				}
			}
			
			if(checkOutFlag) {
				System.out.println(fileName+" checked out successfully");
				logInfo.pass(fileName+" checked out successfully");
			}else {
				System.out.println(fileName+" unable to check out");
				logInfo.fail(fileName+" unable to check out");
			}
		}else {
			System.out.println(fileName+" file not found");
			logInfo.pass(fileName+" file not found");
		}
		
		driver.switchTo().defaultContent();
		Thread.sleep(1500);
	}
	
	public void verifyFileCheckOutWithoutSelectingFile(ExtentTest logInfo) throws InterruptedException {
		driver.switchTo().frame(rightFrame);
		checkoutBtn.click();
		if(isAlertPresent()) {
			Thread.sleep(1000);
			Alert alert = driver.switchTo().alert();
			String alertMsg = alert.getText();
			System.out.println("Alert occured when we click check out button without selecting the file: "+alertMsg);
			logInfo.pass("Alert occured when we click check out button without selecting the file: "+alertMsg);
			alert.accept();
		}else {
			System.out.println("No alert message occured when we click check out button without selecting the file");
			logInfo.fail("No alert message occured when we click check out button without selecting the file");
		}
		driver.switchTo().defaultContent();
		Thread.sleep(1500);
	}
	
	public void verifyDeleteFunctionality(String fileName, ExtentTest logInfo) throws InterruptedException {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		action = new Actions(driver);
		driver.switchTo().frame(rightFrame);
		
		int fileFoundCount = 0;
		boolean fileFoundStatus = false;
		// Select files to Delete
		if(fileName.contains(",")) {
			String[] filesToDelete = fileName.split(",");
			for (int j = 0; j < filesToDelete.length; j++) {
				boolean currentFileFoundStatus = false;
				for (int i = 0; i < fileNamesList.size(); i++) {
					action.moveToElement(fileNamesList.get(i));
					if(fileNamesList.get(i).getText().contains(filesToDelete[j])) {
						WebElement previousTd = (WebElement)je.executeScript("return arguments[0].previousSibling;", fileNamesList.get(i));
						WebElement checkBoxInput = (WebElement)je.executeScript("return arguments[0].lastChild;", previousTd);
						checkBoxInput.click();
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
			for (int i = 0; i < fileNamesList.size(); i++) {
				action.moveToElement(fileNamesList.get(i));
				if(fileNamesList.get(i).getText().contains(fileName)) {
					WebElement previousTd = (WebElement)je.executeScript("return arguments[0].previousSibling;", fileNamesList.get(i));
					WebElement checkBoxInput = (WebElement)je.executeScript("return arguments[0].lastChild;", previousTd);
					checkBoxInput.click();
					fileFoundStatus = true;
					break;
				}
			}
			if(!fileFoundStatus) {
				System.out.println(fileName+" file not found");
				logInfo.pass(fileName+" file not found");
			}
		}
		
		if(fileFoundCount >= 1 || fileFoundStatus) {
			// Click Delete button
			eleClickable(driver, deleteBtn, 10);
			je.executeScript("arguments[0].scrollIntoView(true);", deleteBtn);
			Thread.sleep(1500);
			je.executeScript("arguments[0].click();", deleteBtn);
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
			eleAvailability(driver, addNoteBtn, 8);
			boolean deleteFlag = true;
			driver.switchTo().defaultContent();
			Thread.sleep(1500);
			int version = getVersionForFile(fileName);
			System.out.println(version);
			driver.switchTo().frame(rightFrame);
			for (int i = 0; i < fileNamesList.size(); i++) {
				if(fileNamesList.get(i).getText().contains(fileName) && !(version>=1))
					deleteFlag = false;
			}
			if(deleteFlag) {
				System.out.println(fileName+" deleted successfully");
				logInfo.pass(fileName+" deleted successfully");
			}else {
				System.out.println(fileName+" unable to delete");
				logInfo.fail(fileName+" unable to delete");
			}
		}
		driver.switchTo().defaultContent();
		Thread.sleep(1500);
	}

	
	private int getVersionForFile(String fileName) throws InterruptedException {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		driver.switchTo().frame(rightFrame);
		int version = 0;
		for (int i = 0; i < fileNamesList.size(); i++) {
			if(fileNamesList.get(i).getText().contains(fileName)) {
				WebElement versionSpan = (WebElement)je.executeScript("return arguments[0].lastChild.previousSibling.previousSibling;", fileNamesList.get(i));
				String versionText = versionSpan.getText().replaceAll("\\[V", "").replaceAll("\\]", "");
				version = Integer.parseInt(versionText);
				break;
			}
		}
		driver.switchTo().defaultContent();
		Thread.sleep(1500);
		return version;
	}

	public void verifyTransactionFilesFunctionality(ExtentTest logInfo) throws InterruptedException {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		driver.switchTo().frame(rightFrame);
		transactionFilesBtn.click();
		eleAvailability(driver, displayListBtnInTransactionFiles, 10);
		boolean transactionFilesFlag = true;
		for (int i = 0; i < recordTypeList.size(); i++) {
			String currentFileName = fileNamesList.get(i).getText();
			recordTypeList.get(i).click();
			driver.switchTo().defaultContent();
			Thread.sleep(1500);
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		    driver.switchTo().window(tabs.get(1));
		    String currentTransactionCustomerName = customerInTransaction.getText();
		    skyDocSubtabLink.click();
			je.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			driver.switchTo().frame(rightFrame);
			boolean fileMatchFlag = false;
			boolean customerMatchFlag = false;
			for (int j = 0; j < fileNamesList.size(); j++) {
				if(fileNamesList.get(j).getText().contains(currentFileName)) {
					fileMatchFlag = true;
					break;
				}
			}
			if(currentTransactionCustomerName.contains("ABC"))
				customerMatchFlag = true;
			driver.switchTo().defaultContent();
			Thread.sleep(1500);
			driver.close();
			driver.switchTo().window(tabs.get(0));
			driver.switchTo().frame(rightFrame);
			
			if(!customerMatchFlag || !fileMatchFlag)
				transactionFilesFlag = false;
		}
		driver.switchTo().defaultContent();
		Thread.sleep(1500);
		
		if(transactionFilesFlag) {
			System.out.println("Files uploaded in transactions related to the record are displayed");
			logInfo.pass("Files uploaded in transactions related to the record are displayed");
		}else {
			System.out.println("Files uploaded in transactions related to the record are not displayed");
			logInfo.fail("Files uploaded in transactions related to the record are not displayed");
		}
		
	}
	
	public void verifyViewFunctionality(ExtentTest logInfo) throws InterruptedException {
		driver.switchTo().frame(rightFrame);
		viewLinkForImg.click();
		driver.switchTo().defaultContent();
		Thread.sleep(1500);
		
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
	    
	    Thread.sleep(7000);
	    driver.close();
	    driver.switchTo().window(tabs.get(0));
	    
	    System.out.println("File is viewed");
	    logInfo.pass("File is viewed");
	}
	
	public void verifyDownloadFunctionality(ExtentTest logInfo) throws InterruptedException {
		action = new Actions(driver);
		driver.switchTo().frame(rightFrame);
		downloadLinkForImg.click();
		Thread.sleep(6000);
		if(isFileDownloaded("C:\\Users\\Sravan Kumar\\Downloads", "1.jpg")) {
			System.out.println("File downloaded successfully");
			logInfo.pass("File downloaded successfully");
		}else {
			System.out.println("File unable to download");
			logInfo.fail("File unable to download");
		}
		
		driver.findElement(By.xpath("//a[text()='1.jpg']")).click();
		
		driver.switchTo().defaultContent();
		Thread.sleep(1500);
		
		ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs1.get(1));
		try {
			WebElement downloadEntity = driver.findElement(By.xpath("//span[@id='custrecord_entity_download_fs_lbl_uir_label']//following-sibling::span//span[text()='Sravan K']"));
			if(downloadEntity.isDisplayed()) {
				System.out.println("Entity Download field is displaying Entity name who downloaded the file");
				logInfo.pass("Entity Download field is displaying Entity name who downloaded the file");
			}
		} catch (NoSuchElementException e) {
			System.out.println("Entity Download field is not displaying Entity name who downloaded the file");
			logInfo.fail("Entity Download field is not displaying Entity name who downloaded the file");
		}
		
		driver.close();
		driver.switchTo().window(tabs1.get(0));
	}
	
	public boolean isFileDownloaded(String downloadPath, String fileName) {
		boolean flag = false;
	    File dir = new File(downloadPath);
	    File[] dir_contents = dir.listFiles();
	    for (int i = 0; i < dir_contents.length; i++) {
	        if (dir_contents[i].getName().contains(fileName))
	            return flag=true;
	    }

	    return flag;
	}
	
	public void verifyFilePreviewFunctionality(ExtentTest logInfo) throws InterruptedException {
		action = new Actions(driver);
		driver.switchTo().frame(rightFrame);
		boolean fileFoundFlag = false;
		for (int i = 0; i < fileNamesListWithoutNotes.size(); i++) {
			if(fileNamesListWithoutNotes.get(i).getText().contains("1.jpg")) {
				fileFoundFlag = true;
				action.moveToElement(fileNamesListWithoutNotes.get(i)).build().perform();
				break;
			}
		}
		if(fileFoundFlag) {
			eleAvailability(driver, closeBtn, 10);
			eleAvailability(driver, filePreviewFrame, 15);
			driver.switchTo().frame(filePreviewFrame);
			eleAvailability(driver, By.xpath("//img[@style='-webkit-user-select: none;']"), 20);
			WebElement image = driver.findElement(By.xpath("//img[@style='-webkit-user-select: none;']"));
			if(image.isDisplayed()) {
				Thread.sleep(1500);
				System.out.println("File is previewed");
				logInfo.pass("File is previewed");
			}else {
				System.out.println("Unable to preview the file");
				logInfo.fail("Unable to preview the file");
			}
		}else {
			System.out.println("File not found, unable to preview");
			logInfo.fail("File not found, unable to preview");
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame(rightFrame);
		closeBtn.click();
		driver.switchTo().defaultContent();
		Thread.sleep(1500);
	}
	
	public void verifyVideoPreview(ExtentTest logInfo) throws InterruptedException {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		action = new Actions(driver);
		driver.switchTo().frame(rightFrame);
		boolean fileFoundFlag = false;
		for (int i = 0; i < fileNamesListWithoutNotes.size(); i++) {
			if(fileNamesListWithoutNotes.get(i).getText().contains("sample video.mp4")) {
				fileFoundFlag = true;
				action.moveToElement(fileNamesListWithoutNotes.get(i)).build().perform();
				break;
			}
		}
		if (fileFoundFlag) {
			eleAvailability(driver, closeBtn, 10);
			eleAvailability(driver, filePreviewFrame, 15);
			driver.switchTo().frame(filePreviewFrame);
			eleAvailability(driver, By.xpath("//video"), 20);
			WebElement video = driver.findElement(By.xpath("//video"));
			if (video.isDisplayed()) {
				Thread.sleep(1500);
				je.executeScript("return arguments[0].autoplay = true;", video);
				je.executeScript("return arguments[0].muted = true;", video);
				Thread.sleep(1500);
				je.executeScript("return arguments[0].muted = false;", video);
				Thread.sleep(1500);
//				je.executeScript("return arguments[0].play();", video);
				System.out.println("File is previewed");
				logInfo.pass("File is previewed");
			}else {
				System.out.println("Unable to preview the file");
				logInfo.fail("Unable to preview the file");
			}
		}else {
			System.out.println("File not found, unable to preview");
			logInfo.fail("File not found, unable to preview");
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame(rightFrame);
		closeBtn.click();
		driver.switchTo().defaultContent();
		Thread.sleep(1500);
	}
	
	public void verifySearchFunctionality(ExtentTest logInfo) throws InterruptedException {
		action = new Actions(driver);
		driver.switchTo().frame(rightFrame);
		searchBoxInSkyDocList.sendKeys("note");
		Thread.sleep(1500);
		boolean searchFlag = true;
		for (int i = 0; i <fileNamesList.size(); i++) {
			if(!fileNamesList.get(i).getText().contains("note"))
				searchFlag = false;
		}
		action.click(searchBoxInSkyDocList).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).build().perform();
		Thread.sleep(1000);
		
		if(searchFlag) {
			System.out.println("The file names that matches the search criteria are displayed");
			logInfo.pass("The file names that matches the search criteria are displayed");
		}else {
			System.out.println("Some of the file names does'nt match with the search criteria");
			logInfo.fail("Some of the file names does'nt match with the search criteria");
		}
		driver.switchTo().defaultContent();
		Thread.sleep(1500);
	}
	
	
	public void verifySkyDocGalleryFunctionality(ExtentTest logInfo) throws InterruptedException {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		driver.switchTo().frame(rightFrame);
		int filesCount = fileNamesListWithoutNotes.size();
		int skyDocGalleryCount = 0;
		eleClickable(driver, By.xpath("//img[@title='View SkyDoc Gallery']"), 5);
		skyDocGalleryBtn.click();
		Thread.sleep(10000);
		eleToBeInvisible(driver, loadingImage, 30);
		Thread.sleep(3000);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='skydocgalleryiframe']")));
		for (int i = 0; i < skyDocGalleryDisplayList.size(); i++) {
			je.executeScript("arguments[0].scrollIntoView(true);", skyDocGalleryDisplayList.get(i));
			if(skyDocGalleryDisplayList.get(i).isDisplayed())
				skyDocGalleryCount++;
		}
		driver.switchTo().defaultContent();
		Thread.sleep(1500);
		driver.switchTo().frame(rightFrame);
		displayListBtn.click();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		Thread.sleep(1500);
		
		if(skyDocGalleryCount == filesCount) {
			System.out.println("SkyDoc Gallery displayed all the images within the record");
			logInfo.pass("SkyDoc Gallery displayed all the images within the record");
		}else {
			System.out.println("SkyDoc Gallery is not displayed correctly");
			logInfo.fail("SkyDoc Gallery is not displayed correctly");
		}
	}
	
	public void verifyAttachFileFunctionality(String sourceFolder, String destinationFolder, String fileName, ExtentTest logInfo) throws InterruptedException {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		action = new Actions(driver);
		driver.switchTo().frame(rightFrame);
		attachFileBtnInCustomerPage.click();
		driver.switchTo().defaultContent();
		Thread.sleep(1500);
		
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
	    driver.manage().window().maximize();
	    
	    // Select Source folder
	    attachFileSourceFolder.click();
	    for (int i = 0; i < attachFileSourceFolderList.size(); i++) {
			if(attachFileSourceFolderList.get(i).getText().trim().equals(sourceFolder)) {
				attachFileSourceFolderList.get(i).click();
				break;
			}
		}
	    attachFileSearchBtn.click();
	    
	    // Select Files to be attached
	    for (int i = 0; i < attachFileFileNamesList.size(); i++) {
			action.moveToElement(attachFileFileNamesList.get(i));
			if(attachFileFileNamesList.get(i).getText().contains(fileName)) {
				WebElement previousTd = (WebElement)je.executeScript("return arguments[0].previousSibling;", attachFileFileNamesList.get(i));
				WebElement checkBoxInput = (WebElement)je.executeScript("return arguments[0].lastChild;", previousTd);
				checkBoxInput.click();
			}
		}
	    
	    // Select destination folder
	    if(!destinationFolder.isBlank()) {
	    	attachFileDestinationFolder.click();
		    for (int i = 0; i < attachFileDestinationFolderList.size(); i++) {
				if(attachFileDestinationFolderList.get(i).getText().trim().equals(destinationFolder)) {
					attachFileDestinationFolderList.get(i).click();
					break;
				}
			}
	    }
	    
	    attachFileBtnInPopup.click();
	    if(isAlertPresent()) {
			Thread.sleep(1000);
			Alert alert = driver.switchTo().alert();
			String alertMsg = alert.getText();
			System.out.println("Alert occured: "+alertMsg);
			alert.accept();
		}
	    
	    if(isAlertPresent()) {
			Thread.sleep(1000);
			Alert alert = driver.switchTo().alert();
			String alertMsg = alert.getText();
			System.out.println("Alert occured: "+alertMsg);
			alert.accept();
		}
	    
	    driver.switchTo().window(tabs.get(0));
	    driver.switchTo().frame(rightFrame);
	    refreshBtn.click();
	    Thread.sleep(4000);
	    eleAvailability(driver, fileNamesList.get(0), 10);
	    
	    // Verify file is attached or not
	    boolean attachFileFlag = false;
	    for (int i = 0; i < fileNamesList.size(); i++) {
			if(fileNamesList.get(i).getText().contains(fileName))
				attachFileFlag = true;
		}
	    driver.switchTo().defaultContent();
	    Thread.sleep(1500);
	    if(attachFileFlag) {
	    	System.out.println(fileName+" attached successfully");
	    	logInfo.pass(fileName+" attached successfully");
	    }else {
	    	System.out.println(fileName+" unable to attach");
	    	logInfo.fail(fileName+" unable to attach");
	    }
	}
	
	public void verifyMoveCopyFunctionality(String moveCopyFlag, String sourceCustomer, String destinationCustomer, String fileName, ExtentTest logInfo) throws InterruptedException {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		action = new Actions(driver);
		driver.switchTo().frame(rightFrame);
		
		// Select files to Copy/Move
		if(fileName.contains(",")) {
			String[] filesToSend = fileName.split(",");
			for (int i = 0; i < fileNamesList.size(); i++) {
				for (int j = 0; j < filesToSend.length; j++) {
					action.moveToElement(fileNamesList.get(i));
//					je.executeScript("arguments[0].scrollIntoView(true);", fileNamesList.get(i));
					if(fileNamesList.get(i).getText().contains(filesToSend[j])) {
						WebElement previousTd = (WebElement)je.executeScript("return arguments[0].previousSibling;", fileNamesList.get(i));
						WebElement checkBoxInput = (WebElement)je.executeScript("return arguments[0].lastChild;", previousTd);
						checkBoxInput.click();
					}
				}
			}
		}else {
			for (int i = 0; i < fileNamesList.size(); i++) {
				action.moveToElement(fileNamesList.get(i));
//				je.executeScript("arguments[0].scrollIntoView(true);", fileNamesList.get(i));
				if(fileNamesList.get(i).getText().contains(fileName)) {
					WebElement previousTd = (WebElement)je.executeScript("return arguments[0].previousSibling;", fileNamesList.get(i));
					WebElement checkBoxInput = (WebElement)je.executeScript("return arguments[0].lastChild;", previousTd);
					checkBoxInput.click();
				}
			}
		}
		
		// Click Move/Copy button
		moveCopyBtn.click();
		if(isAlertPresent()) {
			Thread.sleep(1000);
			Alert alert = driver.switchTo().alert();
			String alertMsg = alert.getText();
			System.out.println("Alert occured: "+alertMsg);
			alert.accept();
		}
		driver.switchTo().defaultContent();
		Thread.sleep(1500);
		
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
	    recordType.sendKeys("Customer");
	    searchBtnInPopup.click();
	    eleAvailability(driver, copyRadioBtn, 10);
	    if(moveCopyFlag.equals("C"))
	    	copyRadioBtn.click();
	    else if(moveCopyFlag.equals("M"))
	    	moveRadioBtn.click();
	    targetRecordArrowBtn.click();
		targetRecordListBtn.click();
		eleAvailability(driver, searchBox, 10);
		searchBox.sendKeys(destinationCustomer);
		searchBtn.click();
		Thread.sleep(3000);
		for (int i = 0; i < targetRecordDropdownList.size(); i++) {
			if(targetRecordDropdownList.get(i).getText().trim().equals(destinationCustomer)) {
				searchResults.get(i).click();
				break;
			}
		}
		saveBtnInPopup.click();
		if(isAlertPresent()) {
			Thread.sleep(1000);
			Alert alert = driver.switchTo().alert();
			String alertMsg = alert.getText();
			System.out.println("Alert occured: "+alertMsg);
			alert.accept();
		}
		driver.switchTo().window(tabs.get(0));
		Thread.sleep(5000);
		driver.switchTo().frame(rightFrame);
		eleAvailability(driver, moveCopyBtn, 10);
		driver.switchTo().defaultContent();
		Thread.sleep(1500);
		
		// Open destination customer
		openCustomer(destinationCustomer);
		driver.switchTo().frame(rightFrame);
		
		// Verify files in destination customer
		int matchCount = 0;
		int multipleFilesLength = 0;
		boolean flag = false;
		if(fileName.contains(",")) {
			String[] filesToSend = fileName.split(",");
			multipleFilesLength = filesToSend.length;
			for (int j = 0; j < filesToSend.length; j++) {
				for (int i = 0; i < fileNamesList.size(); i++) {
					if(fileNamesList.get(i).getText().contains(filesToSend[j])) {
						matchCount++;
					}
				}
			}
		}else {
			for (int i = 0; i < fileNamesList.size(); i++) {
				je.executeScript("arguments[0].scrollIntoView(true);", fileNamesList.get(i));
				if(fileNamesList.get(i).getText().contains(fileName)) {
					flag = true;
				}
			}
		}
		driver.switchTo().defaultContent();
		Thread.sleep(1500);
		if(matchCount == multipleFilesLength || flag) {
			if(moveCopyFlag.equals("C")) {
				System.out.println(fileName+" copied successfully from "+sourceCustomer+" to "+destinationCustomer);
				logInfo.pass(fileName+" copied successfully from "+sourceCustomer+" to "+destinationCustomer);
			}else if(moveCopyFlag.equals("M")) {
				System.out.println(fileName+" moved successfully from "+sourceCustomer+" to "+destinationCustomer);
				logInfo.pass(fileName+" moved successfully from "+sourceCustomer+" to "+destinationCustomer);
			}
		}else {
			if(moveCopyFlag.equals("C")) {
				System.out.println(fileName+" unable to copy");
				logInfo.fail(fileName+" unable to copy");
			}else if(moveCopyFlag.equals("M")) {
				System.out.println(fileName+" unable to move");
				logInfo.fail(fileName+" unable to move");
			}
		}
	}
	
	public void verifyAddNoteFunctionality(ExtentTest logInfo) throws InterruptedException {
		driver.switchTo().frame(rightFrame);
		addNoteBtn.click();
		
		// Select folder
		noteFolder.click();
		for (int i = 0; i < noteFolderList.size(); i++) {
			if(noteFolderList.get(i).getText().equals("Customer")) {
				noteFolderList.get(i).click();
				break;
			}
		}
		
		// Select category
		noteCategory.click();
		for (int i = 0; i < noteCategoryList.size(); i++) {
			if(noteCategoryList.get(i).getText().equals("Images")) {
				noteCategoryList.get(i).click();
				break;
			}
		}
		noteCategory.click();
		
		// Enter title, comments & click Attach note button
		noteTitle.sendKeys("Test note");
		noteText.sendKeys("Test");
		attachNoteBtn.click();
		Thread.sleep(7000);
		
		// Verify Note attached in the SkyDoc display list
		boolean addNoteFlag = false;
		for(int i=0;i<noteList.size();i++) {
    		WebElement currentFileName = noteList.get(i);
			String text = currentFileName.getText();
			if(text.contains("Test note")) {
				addNoteFlag = true;
			}
    	}
		if(addNoteFlag) {
			System.out.println("A file of type note is added successfully");
			logInfo.pass("A file of type note is added successfully");
		}else {
			System.out.println("Note unable to add");
			logInfo.fail("Note unable to add");
		}
		driver.switchTo().defaultContent();
		Thread.sleep(1500);
	}
	
	public void verifyFileUploadWithoutFolder(ExtentTest logInfo) throws InterruptedException, AWTException {
		driver.switchTo().frame(leftFrame);
		skyDocUploadFolderInCustomerPage.click();
		for (int i = 0; i < uploadFolderList.size(); i++) {
			if(uploadFolderList.get(i).getText().isBlank()) {
				uploadFolderList.get(i).click();
				break;
			}
		}
		dragDropBtn.click();
		Thread.sleep(1000);
		
		// Select file to upload
		StringSelection strSelection = new StringSelection(prop.getProperty("filePath"));
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
        
        // Verify the alert
		if(isAlertPresent()) {
			Thread.sleep(1000);
			Alert alert = driver.switchTo().alert();
			String alertMsg = alert.getText();
			System.out.println("Alert occured when we upload a file without selecting the folder: "+alertMsg);
			logInfo.pass("Alert occured when we upload a file without selecting the folder: "+alertMsg);
			alert.accept();
		}else {
			System.out.println("No alert message occured when we upload a file without selecting the folder");
			logInfo.fail("No alert message occured when we upload a file without selecting the folder");
		}
		driver.switchTo().defaultContent();
		Thread.sleep(1500);
	}
	
	public void verifyFileUpload(String folderName, String categoryName, String filePath, ExtentTest logInfo) throws AWTException, InterruptedException {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		action = new Actions(driver);
		driver.switchTo().frame(leftFrame);
		
		// Select Folder
		action.moveToElement(skyDocUploadFolderInCustomerPage).build().perform();
		skyDocUploadFolderInCustomerPage.click();
		for (int i = 0; i < uploadFolderList.size(); i++) {
			if(uploadFolderList.get(i).getText().equals(folderName)) {
				uploadFolderList.get(i).click();
				break;
			}
		}
		
		// Select Category
		if(categoryName.contains(",")) {
			String[] categories = categoryName.split(",");
			skyDocUploadCategoryBtn.click();
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
			skyDocUploadCategoryBtn.click();
		}else if(!categoryName.isBlank() && !categoryName.contains(",")) {
			skyDocUploadCategoryBtn.click();
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
			skyDocUploadCategoryBtn.click();
		}else if(categoryName.isBlank()) {
			skyDocUploadCategoryBtn.click();
			for (int i = 0; i < uploadCategoryList.size(); i++) {
				WebElement parentAtag = (WebElement)je.executeScript("return arguments[0].parentNode;", uploadCategoryList.get(i));
				WebElement parentLi = (WebElement)je.executeScript("return arguments[0].parentNode;", parentAtag);
				if(parentLi.getAttribute("class").equals("selected"))
					uploadCategoryList.get(i).click();
			}
			skyDocUploadCategoryBtn.click();
		}
		
		dragDropBtn.click();
		Thread.sleep(1000);
		
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
        	Thread.sleep(3000);
        	driver.switchTo().frame(rightFrame);
        	eleAvailability(driver, refreshBtn, 8);
        	refreshBtn.click();
        	eleAvailability(driver, fileNamesList.get(0), 15);
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
		
		// Sort customer list by recently created
		if(!quickSortDropdown.getAttribute("value").equals("Recently Created"))
			quickSortDropdown.sendKeys("Recently Created");
		
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
	
	public void verifyEnabledFeatures(ExtentTest logInfo) throws InterruptedException {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		action = new Actions(driver);
		
		// Navigate to SkyDoc Portal link
		String portalUrl = prop.getProperty("skyDocPortalUrl");
		je.executeScript("window.open('"+portalUrl+"')");
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
	    
	    // Login to Portal
	    eleAvailability(driver, portalUsername, 10);
	    portalUsername.sendKeys(prop.getProperty("username"));
	    portalPassword.sendKeys(prop.getProperty("skyDocPortalPassword"));
	    portalLoginBtn.click();
	    
	    // Verify Approve page
	    driver.switchTo().frame("myFrame");
	    eleAvailability(driver, By.xpath("//h3//font"), 10);
	    String approvePageHeading = driver.findElement(By.xpath("//h3//font")).getText();
	    if(approvePageHeading.contains("Approve")) {
	    	System.out.println("SkyDoc Approve page is displayed when 'SkyDoc Portal Approval Process' checkbox is checked");
	    	logInfo.pass("SkyDoc Approve page is displayed when 'SkyDoc Portal Approval Process' checkbox is checked");
	    }else {
	    	System.out.println("SkyDoc Approve page is not displayed when 'SkyDoc Portal Approval Process' checkbox is checked");
	    	logInfo.fail("SkyDoc Approve page is not displayed when 'SkyDoc Portal Approval Process' checkbox is checked");
	    }
	    
	    // Verify Upload page
	    driver.findElement(By.xpath("//b[text()='Upload Files']")).click();
	    Thread.sleep(3000);
	    eleAvailability(driver, By.xpath("//h3//font"), 10);
	    String uploadPageHeading = driver.findElement(By.xpath("//h3//font")).getText();
	    System.out.println(uploadPageHeading);
	    if(uploadPageHeading.contains("Upload")) {
	    	System.out.println("SkyDoc Upload page is displayed when 'SkyDoc Upload Portal' checkbox is checked");
	    	logInfo.pass("SkyDoc Upload page is displayed when 'SkyDoc Upload Portal' checkbox is checked");
	    }else {
	    	System.out.println("SkyDoc Upload page is not displayed when 'SkyDoc Upload Portal' checkbox is checked");
	    	logInfo.fail("SkyDoc Upload page is not displayed when 'SkyDoc Upload Portal' checkbox is checked");
	    }
	    
	    // Verify New Folder functionality 
	    driver.switchTo().frame(innerFrameInPortal);
    	newFolderBtnInSkyDocPortal.click();
    	driver.switchTo().defaultContent();
    	ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(2));
	    driver.findElement(By.xpath("//input[@id='custpage_skydoc_folder_name']")).sendKeys("Folder B");
	    driver.findElement(By.xpath("//input[@id='submitter']")).click();
	    driver.switchTo().window(tabs2.get(1));
	    driver.switchTo().frame(outerFrameInPortal);
	    driver.switchTo().frame(innerFrameInPortal);
	    eleAvailability(driver, rightSearchBox, 10);
    	boolean folderCreationFlag = false;
    	for(int i=0;i<leftFoldersList.size();i++) {
    		if(leftFoldersList.get(i).getText().trim().equals("Folder B")) {
    			folderCreationFlag = true;
    			break;
    		}
    	}
    	if(folderCreationFlag) {
    		System.out.println("'Folder B' folder created successfully in Portal when 'New Folder from SkyDoc Portal' checkbox is checked");
    		logInfo.pass("'Folder B' folder created successfully in Portal when 'New Folder from SkyDoc Portal' checkbox is checked");
    	}else {
    		System.out.println("'Folder B' unable to create in Portal even if 'New Folder from SkyDoc Portal' checkbox is checked");
    		logInfo.fail("'Folder B' unable to create in Portal even if 'New Folder from SkyDoc Portal' checkbox is checked");
    	}
	    
	    // Verify Files restriction in SkyDoc portal
    	driver.findElement(By.xpath("//a[contains(text(),'1216 RLN Test Company')]")).click();
    	eleAvailability(driver, rightSearchBox, 10);
    	Thread.sleep(1500);
    	boolean fileRestrictionFlag = true;
    	for (int i = 0; i < usersListInPortal.size(); i++) {
			if(!usersListInPortal.get(i).getText().equals("Sravan K"))
				fileRestrictionFlag = false;
		}
    	if (fileRestrictionFlag) {
			System.out.println("SkyDoc Portal displayed only the files uploaded by the current user when 'Skydoc Portal Files Restriction' checkbox is checked");
			logInfo.pass("SkyDoc Portal displayed only the files uploaded by the current user when 'Skydoc Portal Files Restriction' checkbox is checked");
		}else {
			System.out.println("SkyDoc Portal is displaying some files which are not uploaded by the current user even if 'Skydoc Portal Files Restriction' checkbox is checked");
			logInfo.fail("SkyDoc Portal is displaying some files which are not uploaded by the current user even if 'Skydoc Portal Files Restriction' checkbox is checked");
		}
    	driver.switchTo().defaultContent();
	    driver.close();
	    driver.switchTo().window(tabs2.get(0));
		
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
				try {
				// Verify download links
				boolean downloadFlag = true;
				for (int i = 0; i < downloadLinks.size(); i++) {
					if(!downloadLinks.get(i).isDisplayed())
						downloadFlag = false;
				}
				if(downloadFlag) {
					System.out.println("Download link is displayed in SkyDoc display list when 'Enable Download link' checkbox is checked");
					logInfo.pass("Download link appeared in SkyDoc display list when 'Enable Download link' checkbox is checked");
				}else {
					System.out.println("Download link is not displayed in SkyDoc display list when 'Enable Download link' checkbox is checked");
					logInfo.fail("Download link is not appeared in SkyDoc display list when 'Enable Download link' checkbox is checked");
				}
				
				// Verify Folder filter
				if(folderColumn.isDisplayed()) {
					System.out.println("Folder Column is displayed in SkyDoc display list when 'Display folder on list' checkbox is checked");
					logInfo.pass("Folder Column is displayed in SkyDoc display list when 'Display folder on list' checkbox is checked");
				}else {
					System.out.println("Folder Column is not displayed in SkyDoc display list when 'Display folder on list' checkbox is checked");
					logInfo.fail("Folder Column is not displayed in SkyDoc display list when 'Display folder on list' checkbox is checked");
				}
				
				// Verify Category filter
				if(categoryFilterDropdown.isDisplayed()) {
					System.out.println("Category filter is displayed in SkyDoc display list when 'Enable Category' checkbox is checked");
					logInfo.pass("Category filter is appeared in SkyDoc display list when 'Enable Category' checkbox is checked");
				}else {
					System.out.println("Category filter is not displayed in SkyDoc display list when 'Enable Category' checkbox is checked");
					logInfo.fail("Category filter is not appeared in SkyDoc display list when 'Enable Category' checkbox is checked");
				}
				
				// Verify Add note button
				if(addNoteBtn.isDisplayed()) {
					System.out.println("Add note button is displayed in SkyDoc display list when 'Add note on list' checkbox is checked");
					logInfo.pass("Add note button is appeared in SkyDoc display list when 'Add note on list' checkbox is checked");
				}else {
					System.out.println("Add note button is not displayed in SkyDoc display list when 'Add note on list' checkbox is checked");
					logInfo.fail("Add note button is not appeared in SkyDoc display list when 'Add note on list' checkbox is checked");
				}
				
				// Verify Move/Copy button
				if(moveCopyBtn.isDisplayed()) {
					System.out.println("Move/Copy button is displayed in SkyDoc display list when 'Add move/copy on list' checkbox is checked");
					logInfo.pass("Move/Copy button is appeared in SkyDoc display list when 'Add move/copy on list' checkbox is checked");
				}else {
					System.out.println("Move/Copy button is not displayed in SkyDoc display list when 'Add move/copy on list' checkbox is checked");
					logInfo.fail("Move/Copy button is not appeared in SkyDoc display list when 'Add move/copy on list' checkbox is checked");
				}
				
				// Verify View links
				boolean viewFlag = true;
				for (int i = 0; i < viewLinks.size(); i++) {
					if(!viewLinks.get(i).isDisplayed())
						viewFlag = false;
				}
				if(viewFlag) {
					System.out.println("View link displayed in SkyDoc display list when 'Enable View in SkyDoc list' checkbox is checked");
					logInfo.pass("View link appeared in SkyDoc display list when 'Enable View in SkyDoc list' checkbox is checked");
				}else {
					System.out.println("View link is not displayed in SkyDoc display list when 'Enable View in SkyDoc list' checkbox is checked");
					logInfo.fail("View link is not appeared in SkyDoc display list when 'Enable View in SkyDoc list' checkbox is checked");
				}
				
				// Verify "View SkyDoc Gallery" button
				if(skyDocGalleryBtn.isDisplayed()) {
					System.out.println("View SkyDoc Gallery button is displayed in SkyDoc display list when 'Enable SkyDoc Gallery' checkbox is checked");
					logInfo.pass("View SkyDoc Gallery button is appeared in SkyDoc display list when 'Enable SkyDoc Gallery' checkbox is checked");
				}else {
					System.out.println("View SkyDoc Gallery button is not displayed in SkyDoc display list when 'Enable SkyDoc Gallery' checkbox is checked");
					logInfo.fail("View SkyDoc Gallery button is not appeared in SkyDoc display list when 'Enable SkyDoc Gallery' checkbox is checked");
				}
				
				// Verify New Folder button in SkyDoc list
				if(newFolderBtn.isDisplayed()) {
					System.out.println("New Folder button is displayed in SkyDoc display list when 'Enable folder on record' checkbox is checked");
					logInfo.pass("New Folder button is appeared in SkyDoc display list when 'Enable folder on record' checkbox is checked");
				}else {
					System.out.println("New Folder button is not displayed in SkyDoc display list when 'Enable folder on record' checkbox is checked");
					logInfo.fail("New Folder button is not appeared in SkyDoc display list when 'Enable folder on record' checkbox is checked");
				}
				
				// Verify Inline category icons in the SkyDoc display list
				boolean inlineCategoryFlag = true;
				for (int i = 0; i < inlineCategoryIcons.size(); i++) {
					if(!inlineCategoryIcons.get(i).isDisplayed())
						inlineCategoryFlag = false;
				}
				if(inlineCategoryFlag) {
					System.out.println("Inline category icon is displayed in SkyDoc display list when 'Enable Inline category' checkbox is checked");
					logInfo.pass("Inline category icon is appeared in SkyDoc display list when 'Enable Inline category' checkbox is checked");
				}else {
					System.out.println("Inline category icon is not displayed in SkyDoc display list when 'Enable Inline category' checkbox is checked");
					logInfo.fail("Inline category icon is not appeared in SkyDoc display list when 'Enable Inline category' checkbox is checked");
				}
				
				// Verify "Checked out by" column in SkyDoc display list
				boolean checkedOutByColumnFlag = true;
				for (int i = 0; i < checkedOutColumn.size(); i++) {
					if(!checkedOutColumn.get(i).isDisplayed())
						checkedOutByColumnFlag = false;
				}
				if(checkedOutByColumnFlag) {
					System.out.println("Checked out by column is displayed in SkyDoc display list when 'Enable document check out' checkbox is checked");
					logInfo.pass("Checked out by column is appeared in SkyDoc display list when 'Enable document check out' checkbox is checked");
				}else {
					System.out.println("Checked out by column is not displayed in SkyDoc display list when 'Enable document check out' checkbox is checked");
					logInfo.fail("Checked out by column is not appeared in SkyDoc display list when 'Enable document check out' checkbox is checked");
				}
				
				// Verify "Transaction Files" button
				if(transactionFilesBtn.isDisplayed()) {
					System.out.println("Transaction Files button is displayed in SkyDoc display list when 'Enable related transaction skydoc files' checkbox is checked");
					logInfo.pass("Transaction Files button is appeared in SkyDoc display list when 'Enable related transaction skydoc files' checkbox is checked");
				}else {
					System.out.println("Transaction Files button is not displayed in SkyDoc display list when 'Enable related transaction skydoc files' checkbox is checked");
					logInfo.fail("Transaction Files button is not appeared in SkyDoc display list when 'Enable related transaction skydoc files' checkbox is checked");
				}
				
				// Verify Multiple category can be selected or not
				multipleCategoryEditBtn.click();
				multipleCategoryDropdown.click();
				for(int i=0;i<multipleCategoryDropdownList.size();i++) {
					if(multipleCategoryDropdownList.get(i).getText().equals("Images") || multipleCategoryDropdownList.get(i).getText().equals("Project Files")) {
						WebElement parentLi = (WebElement)je.executeScript("return arguments[0].parentNode.parentNode;", multipleCategoryDropdownList.get(i));
						if(!parentLi.getAttribute("class").equals("selected"))
							multipleCategoryDropdownList.get(i).click();
					}else {
						WebElement parentLi = (WebElement)je.executeScript("return arguments[0].parentNode.parentNode;", multipleCategoryDropdownList.get(i));
						if(parentLi.getAttribute("class").equals("selected"))
							multipleCategoryDropdownList.get(i).click();
					}
				}
				driver.findElement(By.xpath("//p[@id='existingcategory']//following-sibling::label")).click();
				driver.findElement(By.xpath("//div[@class='editcategory-content']//button[@class='btn btn-primary']")).click();
				Thread.sleep(6000);
				String selectedFilterCategory = selectedMultipleCategory.getText();
				if(selectedFilterCategory.contains("Images") && selectedFilterCategory.contains("Project Files")) {
					System.out.println("Multiple categories can be selected when 'Enable multiple category' checkbox is checked");
					logInfo.pass("Multiple categories can be selected when 'Enable multiple category' checkbox is checked");
				}else {
					System.out.println("Multiple categories can't be selected when 'Enable multiple category' checkbox is checked");
					logInfo.fail("Multiple categories can't be selected when 'Enable multiple category' checkbox is checked");
				}
				
				// Verify page length
				Select list = new Select(listLength);
				if(list.getFirstSelectedOption().getText().equals("10")) {
					System.out.println("Page length is selected correctly");
					logInfo.pass("Page length is selected correctly");
				}else {
					System.out.println("Page length is not selected correctly");
					logInfo.fail("Page length is not selected correctly");
				}
				
				// Verify source folder after clicking Attach files button
				attachFileBtnInCustomerPage.click();
				String customerWindowHandle = driver.getWindowHandle();
				Set<String> allWindows1 = driver.getWindowHandles();
				for(String window: allWindows1) {
					if(!(setupPageWindow.equals(window) || customerWindowHandle.equals(window))) {
						driver.switchTo().window(window);
						eleAvailability(driver, By.xpath("//button[@data-id='filefolder']"), 6);
						String folderName = driver.findElement(By.xpath("//button[@data-id='filefolder']")).getAttribute("title");
						if(folderName.equals("Documents")) {
							System.out.println("Attach to Folder selected in the Setup page is selected as the Source folder in the Attach files page");
							logInfo.pass("Attach to Folder selected in the Setup page is selected as the Source folder in the Attach files page");
						}else {
							System.out.println("Attach to Folder selected in the Setup page is not selected in the Source folder in the Attach files page");
							logInfo.fail("Attach to Folder selected in the Setup page is not selected in the Source folder in the Attach files page");
						}
					}
				}
				driver.close();
				driver.switchTo().window(child);
				Thread.sleep(3000);
				
				// Open "abctest" customer
				openCustomer("abctest");
				
				// Verify SkyDoc upload folder in Customer record
				driver.switchTo().frame(leftFrame);
				if(skyDocUploadFolderInCustomerPage.getAttribute("title").equals("QA")) {
					System.out.println("The folder selected in the SkyDoc Upload folder is selected as the default folder while uploading files in SkyDoc tab");
					logInfo.pass("The folder selected in the SkyDoc Upload folder is selected as the default folder while uploading files in SkyDoc tab");
				}else {
					System.out.println("The folder selected in the SkyDoc Upload folder is not selected as the default folder while uploading files in SkyDoc tab");
					logInfo.fail("The folder selected in the SkyDoc Upload folder is not selected as the default folder while uploading files in SkyDoc tab");
				}
				
				}catch(NoSuchElementException e) {
					System.out.println("Element not found "+e.getMessage());
				}
			}
		}
		
		driver.close();
		driver.switchTo().window(setupPageWindow);
		action.sendKeys(Keys.ESCAPE).build().perform();
		
		// Navigate to any Expense report
		je.executeScript("window.open('about:blank','_blank');");
		ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs1.get(1));
		driver.get("https://tstdrv939179-rp.app.netsuite.com/app/accounting/transactions/exprept.nl?id=11368&whence=");
				
		// Verify Drag & Drop button on all the expense line items
		boolean dragDropFlag = true;
		for (int i = 0; i < dragDropBtnForAllExpenseLines.size(); i++) {
			System.out.println(dragDropBtnForAllExpenseLines.get(i).isDisplayed());
			if(!dragDropBtnForAllExpenseLines.get(i).isDisplayed())
				dragDropFlag = false;
		}
		if(dragDropFlag) {
			System.out.println("Drag & drop button is displayed for all the expense line items when 'Enable Drag & drop in line level' checkbox is checked");
			logInfo.pass("Drag & drop button is appeared for all the expense line items when 'Enable Drag & drop in line level' checkbox is checked");
		}else {
			System.out.println("Drag & drop button is not displayed for all the expense line items when 'Enable Drag & drop in line level' checkbox is checked");
			logInfo.fail("Drag & drop button is not appeared for all the expense line items when 'Enable Drag & drop in line level' checkbox is checked");
		}
		
		// Verify whether attached file is populated in the SkyDoc file column
		editBtnInExpenseReport.click();
		je.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		firstAttachFileLineItemDiv.click();
		attachFileArrow.click();
		attachFileListBtn.click();
		eleAvailability(driver, searchBox, 10);
		String selectedFile = null;
		for (int i = 0; i < searchResults.size(); i++) {
			if(searchResults.get(i).getText().trim().contains(".pdf") || searchResults.get(i).getText().trim().contains(".jpg") || searchResults.get(i).getText().trim().contains(".png")) {
				selectedFile = searchResults.get(i).getText().trim();
				searchResults.get(i).click();
				break;
			}
		}
		Thread.sleep(1500);
		driver.findElement(By.xpath("//input[@id='btn_secondarymultibutton_submitter']")).click();
		Thread.sleep(1500);
		driver.switchTo().frame(skyDocFileFrameInExpenseReport);
		eleAvailability(driver, skyDocFileLinkInExpenseReportView, 10);
		je.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		String fileName = skyDocFileLinkInExpenseReportView.getText().trim();
		driver.switchTo().defaultContent();
		String attachFileText = attachFileInExpenseReportView.getText().trim();
		System.out.println(selectedFile+" "+fileName+" "+attachFileText);
		if(selectedFile.contains(fileName) && attachFileText.isBlank()) {
			System.out.println("File uploaded is deleted from Attach file field & displayed in SkyDoc file column when 'Delete expense report line level file' checkbox is checked");
			logInfo.pass("File uploaded is deleted from Attach file field & displayed in SkyDoc file column when 'Delete expense report line level file' checkbox is checked");
		} else {
			System.out.println("File uploaded is not deleted from Attach file field when 'Delete expense report line level file' checkbox is checked");
			logInfo.fail("File uploaded is not deleted from Attach file field when 'Delete expense report line level file' checkbox is checked");
		}
		driver.close();
		driver.switchTo().window(tabs1.get(0));
		
		// Verify skydoc external access when checkbox is enabled
		verifySkyDocExternalAccess(setupPageWindow, logInfo);
		
		// Verify skydoc folder page access when checkbox is enabled
		verifySkyDocFolderPageAccess(setupPageWindow, logInfo);
	}
	
	public void verifyDisabledFeatures(ExtentTest logInfo) throws InterruptedException {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		action = new Actions(driver);
		
		// Navigate to SkyDoc Portal link
		String portalUrl = prop.getProperty("skyDocPortalUrl");
		je.executeScript("window.open('"+portalUrl+"')");
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
	    
	    // Login to Portal
	    eleAvailability(driver, portalUsername, 10);
	    portalUsername.sendKeys(prop.getProperty("username"));
	    portalPassword.sendKeys(prop.getProperty("skyDocPortalPassword"));
	    portalLoginBtn.click();
	    
	    // Verify Upload page
	    try {
	    	if(driver.findElement(By.xpath("//input[@value='Upload Files']")).isDisplayed()) {
	    		System.out.println("SkyDoc Upload page is displayed even if 'SkyDoc Portal Upload' checkbox is unchecked");
	    		logInfo.fail("SkyDoc Upload page is displayed even if 'SkyDoc Portal Upload' checkbox is unchecked");
	    	}
	    }catch(NoSuchElementException e) {
	    	System.out.println("SkyDoc Upload page is not displayed when 'SkyDoc Upload Portal' checkbox is unchecked");
	    	logInfo.pass("SkyDoc Upload page is not displayed when 'SkyDoc Upload Portal' checkbox is unchecked");
	    }
	    
	    // Verify Approve page
	    try {
		    driver.findElement(By.xpath("//b[text()='Approve Records']")).click();
		    eleAvailability(driver, By.xpath("//h3//font"), 10);
		    String approvePageHeading = driver.findElement(By.xpath("//h3//font")).getText();
		    if(approvePageHeading.contains("Approve")) {
		    	System.out.println("SkyDoc Approve page is displayed even if 'SkyDoc Portal Approval Process' checkbox is unchecked");
		    	logInfo.fail("SkyDoc Approve page is displayed even if 'SkyDoc Portal Approval Process' checkbox is unchecked");
		    }
	    }catch(NoSuchElementException e) {
	    	System.out.println("SkyDoc Approve page is not displayed when 'SkyDoc Portal Approval Process' checkbox is unchecked");
	    	logInfo.pass("SkyDoc Approve page is not displayed when 'SkyDoc Portal Approval Process' checkbox is unchecked");
	    }
	    
	    driver.close();
	    driver.switchTo().window(tabs.get(0));
	    
	    // Verify New Folder button on Portal
	    enableCheckbox(skyDocPortalApprovalCheckbox);
		enableCheckbox(skyDocPortalUploadCheckbox);
		je.executeScript("window.scrollTo(0,0)");
		submitBtn.click();
		Thread.sleep(2000);
		je.executeScript("window.open('"+portalUrl+"')");
		ArrayList<String> tabs4 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs4.get(1));
	    eleAvailability(driver, portalUsername, 10);
	    portalUsername.sendKeys(prop.getProperty("username"));
	    portalPassword.sendKeys(prop.getProperty("skyDocPortalPassword"));
	    portalLoginBtn.click();
	    driver.switchTo().frame(outerFrameInPortal);
	    driver.findElement(By.xpath("//b[text()='Upload Files']")).click();
	    Thread.sleep(3000);
	    driver.switchTo().frame(innerFrameInPortal);
	    eleAvailability(driver, rightSearchBox, 10);
	    try {
	    	if(newFolderBtnInSkyDocPortal.isDisplayed()) {
	    		System.out.println("New Folder button is displayed even if 'New Folder from SkyDoc Portal' checkbox is unchecked");
	    		logInfo.fail("New Folder button is displayed even if 'New Folder from SkyDoc Portal' checkbox is unchecked");
	    	}
	    }catch(NoSuchElementException e) {
	    	System.out.println("New Folder button is not displayed when 'New Folder from SkyDoc Portal' checkbox is unchecked");
	    	logInfo.pass("New Folder button is not displayed when 'New Folder from SkyDoc Portal' checkbox is unchecked");
	    }
	    
	    // Verify Files restriction in SkyDoc portal
    	driver.findElement(By.xpath("//a[contains(text(),'1216 RLN Test Company')]")).click();
    	eleAvailability(driver, rightSearchBox, 10);
    	Thread.sleep(1500);
    	boolean fileRestrictionFlag = true;
    	for (int i = 0; i < usersListInPortal.size(); i++) {
			if(!usersListInPortal.get(i).getText().equals("Sravan K"))
				fileRestrictionFlag = false;
		}
    	if (!fileRestrictionFlag) {
			System.out.println("SkyDoc Portal displayed all files along with the files uploaded by the current user when 'Skydoc Portal Files Restriction' checkbox is unchecked");
			logInfo.pass("SkyDoc Portal displayed all files along with the files uploaded by the current user when 'Skydoc Portal Files Restriction' checkbox is unchecked");
		}else {
			System.out.println("SkyDoc Portal displayed only the files uploaded by the current user even if 'Skydoc Portal Files Restriction' checkbox is unchecked");
			logInfo.fail("SkyDoc Portal displayed only the files uploaded by the current user even if 'Skydoc Portal Files Restriction' checkbox is unchecked");
		}
    	driver.switchTo().defaultContent();
	    driver.close();
	    driver.switchTo().window(tabs4.get(0));
	    
	    // Open "ABC" customer link
	    eleAvailability(driver, By.xpath("//span[text()='Lists']"), 10);
		action.moveToElement(listLink).build().perform();
		eleAvailability(driver, By.xpath("//span[text()='Relationships']"), 10);
		action.moveToElement(relationshipsLink).build().perform();
		eleAvailability(driver, By.xpath("//span[text()='Customers']"), 10);
		action.keyDown(Keys.CONTROL).click(customersLink).keyUp(Keys.CONTROL).build().perform();
		ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs1.get(1));
		openCustomer("ABC");
		driver.switchTo().frame(rightFrame);
		
		// Verify download links
		try {
			if(driver.findElement(By.xpath("//div[text()='Download']")).isDisplayed() || driver.findElement(By.xpath("//td[text()='Download']")).isDisplayed()) {
				System.out.println("Download link is displayed in SkyDoc display list even if 'Enable Download link' checkbox is unchecked");
				logInfo.fail("Download link is displayed in SkyDoc display list even if 'Enable Download link' checkbox is unchecked");
			}
		}catch(NoSuchElementException e) {
	    	System.out.println("Download link is not displayed in SkyDoc display list when 'Enable Download link' checkbox is unchecked");
	    	logInfo.pass("Download link is not displayed in SkyDoc display list when 'Enable Download link' checkbox is unchecked");
	    }
		
		// Verify Folder filter
		try {
			if(folderColumn.isDisplayed()) {
				System.out.println("Folder Column is displayed in SkyDoc display list even if 'Display folder on list' checkbox is unchecked");
				logInfo.fail("Folder Column is displayed in SkyDoc display list even if 'Display folder on list' checkbox is unchecked");
			}
		} catch (NoSuchElementException e) {
	    	System.out.println("Folder Column is not displayed in SkyDoc display list when 'Display folder on list' checkbox is unchecked");
	    	logInfo.pass("Folder Column is not displayed in SkyDoc display list when 'Display folder on list' checkbox is unchecked");
	    }
		
		// Verify Category filter
		try {
			if(categoryFilterDropdown.isDisplayed()) {
				System.out.println("Category filter is displayed in SkyDoc display list even if 'Enable Category' checkbox is unchecked");
				logInfo.fail("Category filter is displayed in SkyDoc display list even if 'Enable Category' checkbox is unchecked");
			}
		} catch (NoSuchElementException e) {
	    	System.out.println("Category filter is not displayed in SkyDoc display list when 'Enable Category' checkbox is unchecked");
	    	logInfo.pass("Category filter is not displayed in SkyDoc display list when 'Enable Category' checkbox is unchecked");
	    }
		
		// Verify Add note button
		try {
			if(addNoteBtn.isDisplayed()) {
				System.out.println("Add note button is displayed in SkyDoc display list even if 'Add note on list' checkbox is unchecked");
				logInfo.fail("Add note button is displayed in SkyDoc display list even if 'Add note on list' checkbox is unchecked");
			}
		} catch (NoSuchElementException e) {
	    	System.out.println("Add note button is not displayed in SkyDoc display list when 'Add note on list' checkbox is unchecked");
	    	logInfo.pass("Add note button is not displayed in SkyDoc display list when 'Add note on list' checkbox is unchecked");
	    }
		
		// Verify Move/Copy button
		try {
			if(moveCopyBtn.isDisplayed()) {
				System.out.println("Move/Copy button is displayed in SkyDoc display list even if 'Add move/copy on list' checkbox is unchecked");
				logInfo.fail("Move/Copy button is displayed in SkyDoc display list even if 'Add move/copy on list' checkbox is unchecked");
			}
		} catch (NoSuchElementException e) {
	    	System.out.println("Move/Copy button is not displayed in SkyDoc display list when 'Add move/copy on list' checkbox is unchecked");
	    	logInfo.pass("Move/Copy button is not displayed in SkyDoc display list when 'Add move/copy on list' checkbox is unchecked");
	    }
		
		// Verify View links
		try {
			if(driver.findElement(By.xpath("//div[text()='View']")).isDisplayed()) {
				System.out.println("View link is displayed in SkyDoc display list even if 'Enable View in SkyDoc list' checkbox is unchecked");
				logInfo.fail("View link is displayed in SkyDoc display list even if 'Enable View in SkyDoc list' checkbox is unchecked");
			}
		} catch (NoSuchElementException e) {
	    	System.out.println("View link is not displayed in SkyDoc display list when 'Enable View in SkyDoc list' checkbox is unchecked");
	    	logInfo.pass("View link is not displayed in SkyDoc display list when 'Enable View in SkyDoc list' checkbox is unchecked");
	    }
		
		// Verify "View SkyDoc Gallery" button
		try {
			if(skyDocGalleryBtn.isDisplayed()) {
				System.out.println("View SkyDoc Gallery button is displayed in SkyDoc display list even if 'Enable SkyDoc Gallery' checkbox is unchecked");
				logInfo.fail("View SkyDoc Gallery button is displayed in SkyDoc display list even if 'Enable SkyDoc Gallery' checkbox is unchecked");
			}
		} catch (NoSuchElementException e) {
	    	System.out.println("View SkyDoc Gallery button is not displayed in SkyDoc display list when 'Enable SkyDoc Gallery' checkbox is unchecked");
	    	logInfo.pass("View SkyDoc Gallery button is not displayed in SkyDoc display list when 'Enable SkyDoc Gallery' checkbox is unchecked");
	    }
		
		// Verify New Folder button in SkyDoc list
		try {
			if(newFolderBtn.isDisplayed()) {
				System.out.println("New Folder button is displayed in SkyDoc display list even if 'Enable folder on record' checkbox is unchecked");
				logInfo.fail("New Folder button is displayed in SkyDoc display list even if 'Enable folder on record' checkbox is unchecked");
			}
		} catch (NoSuchElementException e) {
	    	System.out.println("New Folder button is not displayed in SkyDoc display list when 'Enable folder on record' checkbox is unchecked");
	    	logInfo.pass("New Folder button is not displayed in SkyDoc display list when 'Enable folder on record' checkbox is unchecked");
	    }
		
		// Verify Inline category icons in the SkyDoc display list
		try {
			if(driver.findElement(By.xpath("//img[@class='editImg']")).isDisplayed()) {
				System.out.println("Inline category icon is displayed in SkyDoc display list even if 'Enable Inline category' checkbox is unchecked");
				logInfo.fail("Inline category icon is displayed in SkyDoc display list even if 'Enable Inline category' checkbox is unchecked");
			}
		} catch (NoSuchElementException e) {
	    	System.out.println("Inline category icon is not displayed in SkyDoc display list when 'Enable Inline category' checkbox is unchecked");
	    	logInfo.pass("Inline category icon is not displayed in SkyDoc display list when 'Enable Inline category' checkbox is unchecked");
	    }
		
		// Verify "Checked out by" column in SkyDoc display list
		try {
			if(driver.findElement(By.xpath("//td[text()='CHECKED OUT BY']")).isDisplayed()) {
				System.out.println("Checked out by column is displayed in SkyDoc display list even if 'Enable document check out' checkbox is unchecked");
				logInfo.fail("Checked out by column is displayed in SkyDoc display list even if 'Enable document check out' checkbox is unchecked");
			}
		} catch (NoSuchElementException e) {
	    	System.out.println("Checked out by column is not displayed in SkyDoc display list when 'Enable document check out' checkbox is unchecked");
	    	logInfo.pass("Checked out by column is not displayed in SkyDoc display list when 'Enable document check out' checkbox is unchecked");
	    }
		
		// Verify "Transaction Files" button
		try {
			if(transactionFilesBtn.isDisplayed()) {
				System.out.println("Transaction Files button is displayed in SkyDoc display list even if 'Enable related transaction skydoc files' checkbox is unchecked");
				logInfo.fail("Transaction Files button is displayed in SkyDoc display list even if 'Enable related transaction skydoc files' checkbox is unchecked");
			}
		} catch (NoSuchElementException e) {
	    	System.out.println("Transaction Files button is not displayed in SkyDoc display list when 'Enable related transaction skydoc files' checkbox is unchecked");
	    	logInfo.pass("Transaction Files button is not displayed in SkyDoc display list when 'Enable related transaction skydoc files' checkbox is unchecked");
	    }
		
		// Verify Multiple category can be selected or not
		driver.switchTo().defaultContent();
		driver.switchTo().window(tabs1.get(0));
		enableCheckbox(enableCategoryCheckbox);
		enableCheckbox(enableInlineCategoryCheckbox);
		je.executeScript("window.scrollTo(0,0)");
		submitBtn.click();
		Thread.sleep(2000);
		driver.switchTo().window(tabs1.get(1));
		driver.navigate().refresh();
		skyDocSubtabLink.click();
		je.executeScript("window.scrollBy(-1000,0)");
		je.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		driver.switchTo().frame(rightFrame);
		multipleCategoryEditBtn.click();
		multipleCategoryDropdown.click();
		je.executeScript("window.scrollTo(0,0)");
		for(int i=0;i<multipleCategoryDropdownList.size();i++) {
			if(!multipleCategoryDropdown.getAttribute("aria-expanded").equals("true"))
				multipleCategoryDropdown.click();
			if(multipleCategoryDropdownList.get(i).getText().equals("Images") || multipleCategoryDropdownList.get(i).getText().equals("Project Files")) {
				WebElement parentLi = (WebElement)je.executeScript("return arguments[0].parentNode.parentNode;", multipleCategoryDropdownList.get(i));
				if(!parentLi.getAttribute("class").equals("selected"))
					multipleCategoryDropdownList.get(i).click();
			}
			if(!multipleCategoryDropdown.getAttribute("aria-expanded").equals("true"))
				multipleCategoryDropdown.click();
		}
		driver.findElement(By.xpath("//p[@id='existingcategory']//following-sibling::label")).click();
		driver.findElement(By.xpath("//div[@class='editcategory-content']//button[@class='btn btn-primary']")).click();
		Thread.sleep(6000);
		String selectedFilterCategory = selectedMultipleCategory.getText();
		if(selectedFilterCategory.contains("Images") && selectedFilterCategory.contains("Project Files")) {
			System.out.println("Multiple categories can be selected even if 'Enable multiple category' checkbox is unchecked");
			logInfo.fail("Multiple categories can be selected even if 'Enable multiple category' checkbox is unchecked");
		}else {
			System.out.println("Multiple categories can't be selected when 'Enable multiple category' checkbox is unchecked");
			logInfo.pass("Multiple categories can't be selected when 'Enable multiple category' checkbox is unchecked");
		}
		
		driver.close();
		driver.switchTo().window(tabs1.get(0));
		
		// Navigate to any Expense report
		je.executeScript("window.open('about:blank','_blank');");
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
		driver.get("https://tstdrv939179-rp.app.netsuite.com/app/accounting/transactions/exprept.nl?id=11368&whence=");
				
		// Verify Drag & Drop button on all the expense line items
		try {
			if(driver.findElement(By.xpath("//div[text()='Drag and Drop']")).isDisplayed()) {
				System.out.println("Drag & drop button is displayed for all the expense line items even if 'Enable Drag & drop in line level' checkbox is unchecked");
				logInfo.fail("Drag & drop button is displayed for all the expense line items even if 'Enable Drag & drop in line level' checkbox is unchecked");
			}
		} catch (NoSuchElementException e) {
	    	System.out.println("Drag & drop button is not displayed when 'Enable Drag & drop in line level' checkbox is unchecked");
	    	logInfo.pass("Drag & drop button is not displayed when 'Enable Drag & drop in line level' checkbox is unchecked");
	    }
		
		// Enable Drag & drop in line level checkbox
		ArrayList<String> tabs3 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs3.get(0));
		enableCheckbox(enableDragDropCheckbox);
		je.executeScript("window.scrollTo(0,0)");
		submitBtn.click();
		Thread.sleep(2000);
		driver.switchTo().window(tabs3.get(1));
		
		// Verify whether attached file is populated in the SkyDoc file column
		editBtnInExpenseReport.click();
		je.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		firstAttachFileLineItemDiv.click();
		attachFileArrow.click();
		attachFileListBtn.click();
		eleAvailability(driver, searchBox, 10);
		String selectedFile = null;
		Thread.sleep(3000);
		for (int i = 0; i < searchResults.size(); i++) {
			if(searchResults.get(i).getText().trim().contains(".pdf") || searchResults.get(i).getText().trim().contains(".jpg") || searchResults.get(i).getText().trim().contains(".png")) {
				selectedFile = searchResults.get(i).getText().trim();
				searchResults.get(i).click();
				break;
			}
		}
		Thread.sleep(1500);
		driver.findElement(By.xpath("//input[@id='btn_secondarymultibutton_submitter']")).click();
		Thread.sleep(1500);
		driver.switchTo().frame(skyDocFileFrameInExpenseReport);
		eleAvailability(driver, skyDocFileLinkInExpenseReportView, 10);
		je.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		String fileName = skyDocFileLinkInExpenseReportView.getText().trim();
		driver.switchTo().defaultContent();
		String attachFileText = attachFileInExpenseReportView.getText().trim();
		System.out.println(selectedFile+" "+fileName+" "+attachFileText);
		if(selectedFile.contains(fileName) && selectedFile.contains(attachFileText)) {
			System.out.println("File attached is displayed in both SkyDoc file & Attach File columns when 'Delete expense report line level file' checkbox is unchecked");
			logInfo.pass("File attached is displayed in both SkyDoc file & Attach File columns when 'Delete expense report line level file' checkbox is unchecked");
		} else {
			System.out.println("File attached is not displayed in both SkyDoc file & Attach File columns when 'Delete expense report line level file' checkbox is unchecked");
			logInfo.fail("File attached is not displayed in both SkyDoc file & Attach File columns when 'Delete expense report line level file' checkbox is unchecked");
		}
		driver.close();
		driver.switchTo().window(tabs2.get(0));
		String setupPageWindow = driver.getWindowHandle();
		
		// Verify SkyDoc Portal link
		eleAvailability(driver, setupLink, 10);
		action.moveToElement(setupLink).build().perform();
		eleAvailability(driver, scrollBtn, 10);
		action.moveToElement(scrollBtn).build().perform();
		Thread.sleep(1500);
		eleAvailability(driver, skyDocLink, 10);
		action.moveToElement(skyDocLink).build().perform();
		eleAvailability(driver, skyDocPortalLink, 10);
		action.keyDown(Keys.CONTROL).click(skyDocPortalLink).keyUp(Keys.CONTROL).build().perform();
		
		Set<String> allWindows2 = driver.getWindowHandles();
		for(String child: allWindows2) {
			if(!setupPageWindow.equals(child)) {
				driver.switchTo().window(child);
				
				if(driver.getTitle().contains("Skydoc External Access Link")) {
					System.out.println("SkyDoc external access link is displayed in the SkyDoc Portal page");
					logInfo.fail("SkyDoc external access link is displayed in the SkyDoc Portal page");
				}else {
					System.out.println("An error message '"+driver.findElement(By.xpath("//b")).getText()+"' is displayed");
					logInfo.pass("An error message '"+driver.findElement(By.xpath("//b")).getText()+"' is displayed");
				}
			}
		}
		
		driver.close();
		driver.switchTo().window(setupPageWindow);
		action.sendKeys(Keys.ESCAPE).build().perform();
		
		// Verify SkyDoc Folder Page
		eleAvailability(driver, documentsLink, 10);
		action.moveToElement(documentsLink).build().perform();
		eleAvailability(driver, skyDocFoldersLink1, 10); // Explicit Wait
		action.moveToElement(skyDocFoldersLink1).build().perform();
		eleAvailability(driver, skyDocFoldersLink2, 10); // Explicit Wait
		action.keyDown(Keys.CONTROL).click(skyDocFoldersLink2).keyUp(Keys.CONTROL).build().perform();
		
		Set<String> allWindows3 = driver.getWindowHandles();
		for(String child: allWindows3) {
			if(!setupPageWindow.equals(child)) {
				driver.switchTo().window(child);
				
				if(driver.getTitle().contains("SkyDoc Folders")) {
					System.out.println("SkyDoc Folders page is displayed");
					logInfo.fail("SkyDoc Folders page is displayed");
				}else {
					System.out.println("An error message '"+driver.findElement(By.xpath("//b")).getText()+"' occured");
					logInfo.pass("An error message '"+driver.findElement(By.xpath("//b")).getText()+"' is displayed");
				}
			}
		}
		driver.close();
		driver.switchTo().window(setupPageWindow);
		action.sendKeys(Keys.ESCAPE).build().perform();
	}

	public void verifySkyDocFolderPageAccess(String setupPageWindow, ExtentTest logInfo) {
		// Verify SkyDoc Folder Page access
		eleAvailability(driver, documentsLink, 10);
		action.moveToElement(documentsLink).build().perform();
		eleAvailability(driver, skyDocFoldersLink1, 10);
		action.moveToElement(skyDocFoldersLink1).build().perform();
		eleAvailability(driver, skyDocFoldersLink2, 10);
		action.keyDown(Keys.CONTROL).click(skyDocFoldersLink2).keyUp(Keys.CONTROL).build().perform();
		
		Set<String> allWindows3 = driver.getWindowHandles();
		for(String child: allWindows3) {
			if(!setupPageWindow.equals(child)) {
				driver.switchTo().window(child);
				
				if(driver.getTitle().contains("SkyDoc Folders")) {
					System.out.println("SkyDoc Folders page is displayed");
					logInfo.pass("SkyDoc Folders page is displayed");
				}else {
					System.out.println("An error message '"+driver.findElement(By.xpath("//b")).getText()+"' occured");
					logInfo.fail("An error message '"+driver.findElement(By.xpath("//b")).getText()+"' is displayed");
				}
			}
		}
		driver.close();
		driver.switchTo().window(setupPageWindow);
		action.sendKeys(Keys.ESCAPE).build().perform();
	}

	public void verifySkyDocExternalAccess(String setupPageWindow, ExtentTest logInfo) throws InterruptedException {
		// Verify SkyDoc External access
		eleAvailability(driver, setupLink, 10);
		action.moveToElement(setupLink).build().perform();
		eleAvailability(driver, scrollBtn, 10);
		action.moveToElement(scrollBtn).build().perform();
		Thread.sleep(1500);
		eleAvailability(driver, skyDocLink, 10); // Explicit Wait
		action.moveToElement(skyDocLink).build().perform();
		eleAvailability(driver, skyDocPortalLink, 10); // Explicit Wait
		action.keyDown(Keys.CONTROL).click(skyDocPortalLink).keyUp(Keys.CONTROL).build().perform();
		
		Set<String> allWindows2 = driver.getWindowHandles();
		for(String child: allWindows2) {
			if(!setupPageWindow.equals(child)) {
				driver.switchTo().window(child);
				
				if(driver.getTitle().contains("Skydoc External Access Link")) {
					System.out.println("SkyDoc external access link is displayed in the SkyDoc Portal page");
					logInfo.pass("SkyDoc external access link is displayed in the SkyDoc Portal page");
				}else {
					System.out.println("An error message '"+driver.findElement(By.xpath("//b")).getText()+"' is displayed");
					logInfo.fail("An error message '"+driver.findElement(By.xpath("//b")).getText()+"' is displayed");
				}
			}
		}
		
		driver.close();
		driver.switchTo().window(setupPageWindow);
		action.sendKeys(Keys.ESCAPE).build().perform();
	}
	
	public void enableAllSkyDocFeatures() throws InterruptedException {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		// Enable "Enable Download Link" checkbox
		enableCheckbox(enableDownloadCheckbox);
		
		// Enable "DISPLAY FOLDER ON LIST" checkbox
		enableCheckbox(foldersOnListCheckbox);
		
		// Enable "ENABLE CATEGORY" checkbox
		enableCheckbox(enableCategoryCheckbox);
		
		// Enable "ADD NOTE ON LIST" checkbox
		enableCheckbox(addNoteCheckbox);
		
		// Enable "ADD MOVE/COPY ON LIST" checkbox
		enableCheckbox(enableMoveCopyCheckbox);
		
		// Enable "SKYDOC EXTERNAL ACCESS" checkbox
		enableCheckbox(externalAccessCheckbox);
		
		// Enable "ENABLE DRAG AND DROP IN LINE LEVEL" checkbox
		enableCheckbox(enableDragDropCheckbox);
		
		// Enable "ACCESS TO FOLDERS PAGE" checkbox
		enableCheckbox(folderPageAccessCheckbox);
		
		// Enable "ENABLE SKYDOC GALLERY" checkbox
		enableCheckbox(enableSkydocGalleryCheckbox);
		
		// Enable "ENABLE VIEW IN SKYDOC LIST" checkbox
		enableCheckbox(enableViewInListCheckbox);
		
		// Enable "ENABLE FOLDER ON RECORD" checkbox
		enableCheckbox(enablFolderOnRecordCheckbox);
		
		// Enable "APPROVAL WORKFLOW" checkbox
		enableCheckbox(enableApprovalWorkflowCheckbox);
		
		// Disable "AUTOMATIC FOLDER CREATION FOR ENTITIES" checkbox
		disableCheckbox(automaticFolderCreationCheckbox);
		
		// Enable "ENABLE RELATED TRANSACTION FILES ON MESSAGE" checkbox
		enableCheckbox(enableTransactionFilesCheckbox);
		
		// Enable "INLINE CATEGORY" checkbox
		enableCheckbox(enableInlineCategoryCheckbox);
		
		// Enable "SKYDOC PORTAL FILES RESTRICTION" checkbox
		enableCheckbox(portalFilesRestrictionCheckbox);
		
		// Enable "ENABLE FOLDER HIERARCHY IN FOLDER NAME" checkbox
		enableCheckbox(folderHierarchyCheckbox);
		
		// Enable "NEW FOLDER FROM SKYDOC PORTAL" checkbox
		enableCheckbox(newFolderInPortalCheckbox);
		
		// Enable "DOCUMENT CHECKOUT" checkbox
		enableCheckbox(enableDocCheckoutCheckbox);
		
		// Enable "ENABLE RELATED TRANSACTION SKYDOC FILES" checkbox
		enableCheckbox(enableRelatedRecordsCheckbox);
		
		// Enable "MULTIPLE CATEGORY" checkbox
		enableCheckbox(enableMultipleCategoryCheckbox);
		
		// Enable "DELETE EXPENSE REPORT LINE LEVEL FILE" checkbox
		enableCheckbox(enableDelExpenseLineLevelCheckbox);
		
		// Enable "SKYDOC PORTAL APPROVAL PROCESS" checkbox
		enableCheckbox(skyDocPortalApprovalCheckbox);
		
		// Enable "SKYDOC PORTAL UPLOAD" checkbox
		enableCheckbox(skyDocPortalUploadCheckbox);
		
		// Select a folder in Attach to Folder dropdown
		je.executeScript("arguments[0].scrollIntoView(true);", attachToFolderDropdown);
		if(!attachToFolderDropdown.getAttribute("value").equals("Documents")) {
			attachToFolderDropdown.click();
			for (int i = 0; i < dropdownList.size(); i++) {
				if(dropdownList.get(i).getText().trim().equals("Documents")) {
					dropdownList.get(i).click();
					break;
				}
			}
//			for (int i = 0; i < targetRecordDropdownList.size(); i++) {
//				if(targetRecordDropdownList.get(i).getText().trim().equals("Documents")) {
//					targetRecordDropdownList.get(i).click();
//					break;
//				}
//			}
		}
		
		// Select a folder in Skydoc Upload Folder dropdown
		je.executeScript("arguments[0].scrollIntoView(true);", skyDocUploadFolderDropdown);
		if(!skyDocUploadFolderDropdown.getAttribute("value").equals("QA")) {
			skyDocUploadFolderDropdown.click();
			for (int i = 0; i < dropdownList.size(); i++) {
				if(dropdownList.get(i).getText().trim().equals("QA")) {
					dropdownList.get(i).click();
					break;
				}
			}
//			for (int i = 0; i < targetRecordDropdownList.size(); i++) {
//				if(targetRecordDropdownList.get(i).getText().trim().equals("QA")) {
//					targetRecordDropdownList.get(i).click();
//					break;
//				}
//			}
		}
		
		// Set page length
		je.executeScript("arguments[0].scrollIntoView(true);", pageLengthBox);
		action.click(pageLengthBox).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys(pageLengthBox, "10").build().perform();
		
		// Click on submit button
		je.executeScript("window.scrollTo(0,0)");
		submitBtn.click();
		Thread.sleep(2000);
	}
	
	public void disableAllSkyDocFeatures() throws InterruptedException {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		// Disable "Enable Download Link" checkbox
		disableCheckbox(enableDownloadCheckbox);
		
		// Disable "DISPLAY FOLDER ON LIST" checkbox
		disableCheckbox(foldersOnListCheckbox);
		
		// Disable "ENABLE CATEGORY" checkbox
		disableCheckbox(enableCategoryCheckbox);
		
		// Disable "ADD NOTE ON LIST" checkbox
		disableCheckbox(addNoteCheckbox);
		
		// Disable "ADD MOVE/COPY ON LIST" checkbox
		disableCheckbox(enableMoveCopyCheckbox);
		
		// Disable "SKYDOC EXTERNAL ACCESS" checkbox
		disableCheckbox(externalAccessCheckbox);
		
		// Disable "ENABLE DRAG AND DROP IN LINE LEVEL" checkbox
		disableCheckbox(enableDragDropCheckbox);
		
		// Disable "ACCESS TO FOLDERS PAGE" checkbox
		disableCheckbox(folderPageAccessCheckbox);
		
		// Disable "ENABLE SKYDOC GALLERY" checkbox
		disableCheckbox(enableSkydocGalleryCheckbox);
		
		// Disable "ENABLE VIEW IN SKYDOC LIST" checkbox
		disableCheckbox(enableViewInListCheckbox);
		
		// Disable "ENABLE FOLDER ON RECORD" checkbox
		disableCheckbox(enablFolderOnRecordCheckbox);
		
		// Disable "APPROVAL WORKFLOW" checkbox
		disableCheckbox(enableApprovalWorkflowCheckbox);
		
		// Disable "ENABLE RELATED TRANSACTION FILES ON MESSAGE" checkbox
		disableCheckbox(enableTransactionFilesCheckbox);
		
		// Disable "INLINE CATEGORY" checkbox
		disableCheckbox(enableInlineCategoryCheckbox);
		
		// Disable "SKYDOC PORTAL FILES RESTRICTION" checkbox
		disableCheckbox(portalFilesRestrictionCheckbox);
		
		// Disable "ENABLE FOLDER HIERARCHY IN FOLDER NAME" checkbox
		disableCheckbox(folderHierarchyCheckbox);
		
		// Disable "NEW FOLDER FROM SKYDOC PORTAL" checkbox
		disableCheckbox(newFolderInPortalCheckbox);
		
		// Disable "DOCUMENT CHECKOUT" checkbox
		disableCheckbox(enableDocCheckoutCheckbox);
		
		// Disable "ENABLE RELATED TRANSACTION SKYDOC FILES" checkbox
		disableCheckbox(enableRelatedRecordsCheckbox);
		
		// Disable "MULTIPLE CATEGORY" checkbox
		disableCheckbox(enableMultipleCategoryCheckbox);
		
		// Disable "DELETE EXPENSE REPORT LINE LEVEL FILE" checkbox
		disableCheckbox(enableDelExpenseLineLevelCheckbox);
		
		// Disable "SKYDOC PORTAL APPROVAL PROCESS" checkbox
		disableCheckbox(skyDocPortalApprovalCheckbox);
		
		// Disable "SKYDOC PORTAL UPLOAD" checkbox
		disableCheckbox(skyDocPortalUploadCheckbox);
		
		// Click on submit button
		je.executeScript("window.scrollTo(0,0)");
		submitBtn.click();
		Thread.sleep(2000);
	}
	
	public void enableCheckbox(WebElement element) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		action = new Actions(driver);
		action.moveToElement(element).build().perform();
		WebElement parentSpan = (WebElement)je.executeScript("return arguments[0].parentNode;", element);
		if(parentSpan.getAttribute("class").equals("checkbox_unck"))
			element.click();
	}

	public void disableCheckbox(WebElement element) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		action = new Actions(driver);
		action.moveToElement(element).build().perform();
		WebElement parentSpan = (WebElement)je.executeScript("return arguments[0].parentNode;", element);
		if(!parentSpan.getAttribute("class").equals("checkbox_unck"))
			element.click();
	}

	public SkyDocFoldersPage clickOnSkyDocFoldersLink() {
		action = new Actions(driver);
		eleAvailability(driver, documentsLink, 10);
		action.moveToElement(documentsLink).build().perform();
		eleAvailability(driver, skyDocFoldersLink1, 10); // Explicit Wait
		action.moveToElement(skyDocFoldersLink1).build().perform();
		eleAvailability(driver, skyDocFoldersLink2, 10); // Explicit Wait
		skyDocFoldersLink2.click();
		
		return new SkyDocFoldersPage();
	}

	public void clickOnSkyDocFoldersListLink() throws InterruptedException {
		action = new Actions(driver);
		Thread.sleep(2000);
		eleAvailability(driver, documentsLink, 10);
		action.moveToElement(documentsLink).build().perform();
		eleAvailability(driver, skyDocFoldersLink1, 10); // Explicit Wait
		action.moveToElement(skyDocFoldersLink1).build().perform();
		eleAvailability(driver, skyDocFoldersListLink, 10); // Explicit Wait
		skyDocFoldersListLink.click();
	}
	
	public void clickOnVendorsListLink() throws InterruptedException {
		action = new Actions(driver);
		Thread.sleep(2000);
		eleAvailability(driver, listLink, 10);
		action.moveToElement(listLink).build().perform();
		eleAvailability(driver, relationshipsLink, 10);
		action.moveToElement(relationshipsLink).build().perform();
		eleAvailability(driver, vendorsLink, 10);
		vendorsLink.click();
	}

	public void enableAllSkyDocFeaturesInRolesPage() throws InterruptedException {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		action = new Actions(driver);
		
		// Enable SkyDoc Admin feature for "Administrator" role
		enableFeatureForRole(skyDocAdminRolesMultiSelectList, "Administrator");

		// Enable Upload feature for "Administrator" role
		enableFeatureForRole(uploadRolesMultiSelectList, "Administrator");

		// Enable View feature for "Administrator" role
		enableFeatureForRole(viewRolesMultiSelectList, "Administrator");

		// Enable Delete feature for "Administrator" role
		enableFeatureForRole(deleteRolesMultiSelectList, "Administrator");

		// Enable Attach file feature for "Administrator" role
		enableFeatureForRole(attachFilesRolesMultiSelectList, "Administrator");

		// Enable Move/Copy feature for "Administrator" role
		enableFeatureForRole(moveCopyRolesMultiSelectList, "Administrator");

		// Enable Folder feature for "Administrator" role
		enableFeatureForRole(folderRolesMultiSelectList, "Administrator");
		
		// Check Category checkbox
		WebElement parentSpan = (WebElement)je.executeScript("return arguments[0].parentNode;", displayCategoryCheckbox);
		if(parentSpan.getAttribute("class").equals("checkbox_unck"))
			action.moveToElement(displayCategoryCheckbox).click(displayCategoryCheckbox).build().perform();
		
		je.executeScript("window.scrollTo(0,0)");
		submitBtn.click();
		eleAvailability(driver, confirmationMsg, 10);
		if(confirmationMsg.isDisplayed())
			System.out.println("Roles Page saved");
		Thread.sleep(1500);
	}
	public void enableFeatureForRole(List<WebElement> skyDocFeature, String role) {
		action = new Actions(driver);
		JavascriptExecutor je = (JavascriptExecutor) driver;
		for(int i=0;i<skyDocFeature.size();i++) {
			WebElement currentRole = skyDocFeature.get(i);
			if(currentRole.getText().equals("Administrator")) {
				action.moveToElement(currentRole).build().perform();
				WebElement parentTd = (WebElement)je.executeScript("return arguments[0].parentNode;", currentRole);
				String str = parentTd.getAttribute("class");
				if(!str.equals("dropdownSelected"))
					action.keyDown(Keys.CONTROL).click(currentRole).keyUp(Keys.CONTROL).build().perform();
				break;
			}
		}
	}
}
