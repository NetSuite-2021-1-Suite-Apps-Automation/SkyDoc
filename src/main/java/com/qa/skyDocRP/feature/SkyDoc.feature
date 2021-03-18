Feature: Automation Testing on SkyDoc Suite App

Scenario: Verification of SkyDoc features while enabling or disabling features
Then Enable all the SkyDoc features
Then Verify features enabled in the skydoc subtab
Then Disable all the Skydoc features
Then Verify features disabled in the skydoc subtab
Then Verify Folder Hierarchy feature in SkyDoc
Then Verify Copy Parent Folder Permissions feature in SkyDoc
Then Verify Default Folder for Record feature in SkyDoc
Then Verify Automatic Folder Creation for entities feature in SkyDoc

Scenario: Verification of enabling or disabling the features for a particular roles in SkyDoc roles page
Given User is on SkyDoc Roles page
Then Remove Delete functionality for Administrator role, Enter Folder label & Category label, enable category checkbox
Then Verify all the functionalities in Customer record

Scenario: Verification of all the SkyDoc features
Then Upload file & verify the file in the SkyDoc list using excel data at "C:\Users\Sravan Kumar\Desktop\2021.1 SuiteApp Automation Data\SkyDoc Data_DevProdRP.xlsx,File Upload"
Then Verify File upload without selecting folder
Then Verify Add Note functionality in SkyDoc display list
Then Verify Move/Copy functionality in SkyDoc display list using excel data at "C:\Users\Sravan Kumar\Desktop\2021.1 SuiteApp Automation Data\SkyDoc Data_DevProdRP.xlsx,Move Copy"
Then Verify Attach Files functionality in SkyDoc display list using excel data at "C:\Users\Sravan Kumar\Desktop\2021.1 SuiteApp Automation Data\SkyDoc Data_DevProdRP.xlsx,Attach File"
Then Verify SkyDoc Gallery in SkyDoc display list
Then Verify Delete functionality in SkyDoc display list using excel data at "C:\Users\Sravan Kumar\Desktop\2021.1 SuiteApp Automation Data\SkyDoc Data_DevProdRP.xlsx,Delete Files"
Then Verify File preview functionality in SkyDoc display list
Then Verify File preview for mp4 file in SkyDoc display list
Then Verify Download functionality in SkyDoc display list
Then Verify View functionality in SkyDoc display list
Then Verify files related to transactions after clicking Transaction Files button
Then Verify File check out without selecting any file
Then Verify File check out functionality using excel data at "C:\Users\Sravan Kumar\Desktop\2021.1 SuiteApp Automation Data\SkyDoc Data_DevProdRP.xlsx,File Checkout"
Then Verify Uploading a file after check out of same file with file data "Documents", "", "C:\Users\Sravan Kumar\Documents\2.jpg"
Then Verify New Folder Functionality
Then Verify note "Test note" added to the file "1.jpg" for the customer "ABC"
Then Verify folder filter "Customer" for the Customer "ABC" in SkyDoc display list
Then Verify file version when a file "C:\Users\Sravan Kumar\Documents\2.jpg" is uploaded more than once in a customer record "Tvarana T Customer" with folder "Customer" & category "Project Files"
Then Verify deleting a file having multiple versions for the customer "Tvarana T Customer" with file data "Customer", "Project Files", "C:\Users\Sravan Kumar\Documents\2.jpg"
Then Verify email functionality with attaching SkyDoc files using email data "ABC", "Test Image Email" & "1.jpg"
Then Verify Skydoc files in the Email record are displaying correctly for the customer "ABC"
Then Verify File upload functionality in SkyDoc Folders Page using excel data at "C:\Users\Sravan Kumar\Desktop\2021.1 SuiteApp Automation Data\SkyDoc Data_DevProdRP.xlsx,FP File Upload"
Then Verify Move Files functionality in SkyDoc Folders Page using excel data at "C:\Users\Sravan Kumar\Desktop\2021.1 SuiteApp Automation Data\SkyDoc Data_DevProdRP.xlsx,FP Move Files"
Then Verify Copy Files functionality in SkyDoc Folders Page using excel data at "C:\Users\Sravan Kumar\Desktop\2021.1 SuiteApp Automation Data\SkyDoc Data_DevProdRP.xlsx,FP Copy Files"
Then Verify Delete Files functionality in SkyDoc Folders Page using excel data at "C:\Users\Sravan Kumar\Desktop\2021.1 SuiteApp Automation Data\SkyDoc Data_DevProdRP.xlsx,FP Delete Files"
Then Verify New Folder functionality in SkyDoc Folders Page with folder name "Project Documents"
Then Verify if files uploaded to a public folder are public by default for the Customer "Test Customer Folder" & file upload data "Customer", "", "C:\Users\Sravan Kumar\Documents\2.jpg"
Then Verify folder access in the SkyDoc portal after giving folder access to external user with excel data at "C:\Users\Sravan Kumar\Desktop\2021.1 SuiteApp Automation Data\SkyDoc Data_DevProdRP.xlsx,Folder Access"
Then Verify Send for Approval functionality using excel data at "C:\Users\Sravan Kumar\Desktop\2021.1 SuiteApp Automation Data\SkyDoc Data_DevProdRP.xlsx,Send for Approval"

Scenario: Verification of AWS S3 Record
Then Verify View functionality in AWS record
Then Verify Download functionality in AWS record
Then Verify Move/Copy functionality in AWS record using excel data at "C:\Users\Sravan Kumar\Desktop\2021.1 SuiteApp Automation Data\SkyDoc Data_DevProdRP.xlsx,AWS Move Copy"
Then Verify Public URL and Private URL functionalities in AWS record
Then Verify File versions in AWS record
Then Verify Email file functionality in AWS record using excel data at "C:\Users\Sravan Kumar\Desktop\2021.1 SuiteApp Automation Data\SkyDoc Data_DevProdRP.xlsx,AWS Email File"

Scenario: Verification of SkyDoc Portal Access in SkyDoc Portal
Then Enable SkyDoc Portal access, SkyDoc Portal Access Notification, enter password "test123" for the employee "Sravan K" and verify login access in the SkyDoc Portal