package oauthflowapi

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.RestRequestObjectBuilder
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import groovy.json.JsonSlurper

class OAuth2 {
	@Keyword
	def getOAuth2Token(String clientId, String clientSecret) {
		// Define the request URL
		String url = "https://bsure-digitalbv-dev-ed.develop.my.salesforce.com/services/oauth2/token"

		// Define the request body with actual clientId and clientSecret
		String body = "grant_type=client_credentials&client_id=${clientId}&client_secret=${clientSecret}"

		// Define the request headers
		List<TestObjectProperty> headers = Arrays.asList(
				new TestObjectProperty("Content-Type", ConditionType.EQUALS, "application/x-www-form-urlencoded")
				)

		// Create the request object using RestRequestObjectBuilder
		RequestObject requestObject = new RestRequestObjectBuilder()
				.withRestUrl(url)
				.withRestRequestMethod("POST")
				.withHttpHeaders(headers) // Use the list of TestObjectProperty
				.withTextBodyContent(body)
				.build()

		// Send the request and receive the response
		def response = WS.sendRequest(requestObject)

		// Check if the request was successful
		if (response.getStatusCode() == 200) {
			// Parse the JSON response to extract the access token
			def jsonResponse = new JsonSlurper().parseText(response.getResponseText())
			return jsonResponse.access_token
		} else {
			println("Failed to retrieve OAuth2 token: HTTP Status = ${response.getStatusCode()}")
			return null
		}
	}
}