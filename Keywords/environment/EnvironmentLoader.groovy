package environment

import com.kms.katalon.core.annotation.Keyword
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.io.FileNotFoundException
import java.io.IOException

public class EnvironmentLoader {

	/**
	 * Attempts to load environment variables from a .env file or falls back to system environment variables.
	 * @param filename Name of the .env file.
	 * @return Map containing the loaded environment variables.
	 * @throws IOException If the .env file cannot be read.
	 */
	@Keyword
	static Map<String, String> loadEnvironmentVariables(String filename = ".env") throws IOException {
		Map<String, String> envVars = new HashMap<>()
		String currentDir = new File(".").getAbsolutePath().substring(0, new File(".").getAbsolutePath().length() - 1)
		Path path = Paths.get(currentDir)
		boolean found = false

		// Try to find and load the .env file
		while (path != null && Files.exists(path) && !found) {
			Path possibleEnvPath = path.resolve(filename)
			if (Files.exists(possibleEnvPath)) {
				found = true
				List<String> lines = Files.readAllLines(possibleEnvPath)
				lines.each { line ->
					// Use Groovy's `each` instead of `forEach`
					if (!line.startsWith("#") && line.contains("=")) {
						def parts = line.split("=")
						if (parts.length == 2) {
							envVars.put(parts[0].trim(), parts[1].trim())
						}
					}
				}
			}
			path = path.getParent()
		}

		// Fallback to system environment variables if .env file not found or as supplement
		System.getenv().each { key, value ->
			// Use Groovy's `each` for consistency
			if (!envVars.containsKey(key)) {
				// Only add if not already defined by .env file
				envVars.put(key, value)
			}
		}

		if (envVars.isEmpty()) {
			throw new IllegalStateException("No environment variables found.")
		}

		return envVars
	}
}
