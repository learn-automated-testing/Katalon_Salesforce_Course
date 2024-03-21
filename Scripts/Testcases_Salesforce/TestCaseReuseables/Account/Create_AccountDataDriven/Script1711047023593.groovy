import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

// Load your test data
TestData accountData = findTestData('AccountTestData')

// Get the row count of your test data
int rowCount = accountData.getRowNumbers()

// Loop through each row of your test data
for (int i = 1; i <= rowCount; i++) {
    // Use data from your test data file
    String accountName = accountData.getValue('AccountName', i)

    String site = accountData.getValue('Site', i)

    String annualRevenue = accountData.getValue('AnnualRevenue', i)

    String phone = accountData.getValue('Phone', i)

    String fax = accountData.getValue('Fax', i)

    String typeOfAccount = accountData.getValue('TypeOfAccount', i)

    // Your test steps here, using the variables above
    WebUI.enhancedClick(findTestObject('Object Repository/Salesforce/Account/Accounts_List_Salesforce/span_Accounts'))

    WebUI.click(findTestObject('Object Repository/Salesforce/Account/Accounts_List_Salesforce/New'))

    WebUI.setText(findTestObject('Salesforce/Account/Accounts_fields_Salesforce/Account_name'), accountName)

    WebUI.delay(1 // Example delay, adjust as necessary
        )

    WebUI.setText(findTestObject('Salesforce/Account/Accounts_fields_Salesforce/account_site'), site)

    WebUI.setText(findTestObject('Salesforce/Account/Accounts_fields_Salesforce/Annual_revenue'), annualRevenue)

    WebUI.setText(findTestObject('Salesforce/Account/Accounts_fields_Salesforce/Phone'), phone)

    WebUI.setText(findTestObject('Salesforce/Account/Accounts_fields_Salesforce/fax'), fax)

    WebUI.scrollToElement(findTestObject('Salesforce/Account/Accounts_fields_Salesforce/fax'), 2)

    WebUI.click(findTestObject('Object Repository/Salesforce/Account/Accounts_fields_Salesforce/type'))

    WebUI.waitForElementClickable(findTestObject('Salesforce/Account/Accounts_fields_Salesforce/typeofaccount'), 20)

    WebUI.click(findTestObject('Salesforce/Account/Accounts_fields_Salesforce/typeofaccount', [('combobox') : typeOfAccount]))

    // Continue for the rest of your fields...
    // After setting all fields, save the account
    WebUI.click(findTestObject('Object Repository/Salesforce/Account/Accounts_fields_Salesforce/Save'))

    // Example of verifying account creation, adjust the verification step as needed
    String accountCreated = WebUI.getText(findTestObject('Object Repository/Salesforce/Account/Accounts_List_Salesforce/span_toastMessage slds-text-heading--small _f3870d'))

    println('Account Created: ' + accountCreated) // Add your verification logic here
}

