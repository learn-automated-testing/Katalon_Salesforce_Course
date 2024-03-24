import static environment.EnvironmentLoader.loadEnvironmentVariables
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.configuration.RunConfiguration
import java.util.Properties
import oauthflowapi.OAuth2
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.testobject.TestObject as TestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webservice.verification.WSResponseManager
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import groovy.json.JsonOutput
import groovy.json.JsonSlurper




// Attempt to load environment variables
Map<String, String> envVars = loadEnvironmentVariables()

// Access environment variables
String clientId = envVars.get("CLIENT_ID")
String clientSecret = envVars.get("CLIENT_SECRET")

// Example usage
println("Client ID: $clientId")
println("Client Secret: $clientSecret")

String url = "https://bsure-digitalbv-dev-ed.develop.my.salesforce.com/services/oauth2/token"

if (clientId == null || clientSecret == null) {
	throw new IllegalStateException("Client ID or Client Secret environment variables are not set.")
}


String token = new OAuth2().getOAuth2Token(clientId, clientSecret)

// Optional: Print the token for debugging
println("OAuth2 Token: " + token)

GlobalVariable.token = token


// Assume you have a RequestObject
RequestObject request = findTestObject('Object Repository/Salesforce/APITEST/getAccountsbySalesforceSQL')

// Update the Authorization header to use the global variable TOKEN
request.setHttpHeaderProperties(Arrays.asList(
	new TestObjectProperty("Authorization", ConditionType.EQUALS, "Bearer " + GlobalVariable.token)
))


ResponseObject response = WS.sendRequest(request)

int statusCode = WS.getResponseStatusCode(response)
println("Status Code: " + statusCode)

// Printing the entire response body
println("Response Body: " + response.getResponseText())

def jsonSlurper = new JsonSlurper()
def jsonResponse = jsonSlurper.parseText(response.getResponseText())

println(JsonOutput.prettyPrint(JsonOutput.toJson(jsonResponse)))

if (statusCode == 200) {
	println("Request was successful.")
} else {
	println("Request failed.")
}
