
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import java.lang.String


 /**
	 * Attempts to load environment variables from a .env file or falls back to system environment variables.
	 * @param filename Name of the .env file.
	 * @return Map containing the loaded environment variables.
	 * @throws IOException If the .env file cannot be read.
	 */ 
def static "environment.EnvironmentLoader.loadEnvironmentVariables"(
    	String filename	) {
    (new environment.EnvironmentLoader()).loadEnvironmentVariables(
        	filename)
}


def static "environment.EnvironmentLoader.loadEnvironmentVariables"() {
    (new environment.EnvironmentLoader()).loadEnvironmentVariables()
}


def static "webKeywords.ApplicationFunction.enhanced_SetViewportSize"(
    	int width	
     , 	int height	) {
    (new webKeywords.ApplicationFunction()).enhanced_SetViewportSize(
        	width
         , 	height)
}


def static "oauthflowapi.OAuth2.getOAuth2Token"(
    	String clientId	
     , 	String clientSecret	) {
    (new oauthflowapi.OAuth2()).getOAuth2Token(
        	clientId
         , 	clientSecret)
}
