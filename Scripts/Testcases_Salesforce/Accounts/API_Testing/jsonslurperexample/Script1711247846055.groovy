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

import groovy.json.JsonSlurper



// Sample JSON string (you would replace this with the actual response body from your API call)
// Assuming jsonResponse is a String containing your JSON response
String jsonResponse = '''
{
  "dates": [
    {"date": "2023-01-01"},
    {"date": "2023-01-02"},
    {"date": "2023-01-03"}
  ]
}
'''
// Parse the JSON response

try {
	JsonSlurper slurper = new JsonSlurper()
	def response = slurper.parseText(jsonResponse)

	// Now 'response' is a Groovy map containing your JSON data
	// Assuming 'response' contains the parsed JSON
	response.dates.each { dateObj ->
		// 'dateObj' is now each individual date object in the list
		println "Date found: ${dateObj.date}"
			}
	}
	
 catch (Exception e) {
	println "Error parsing JSON: ${e.message}"
}


	
	// Add your verification logic here
