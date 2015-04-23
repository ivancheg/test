package core;

import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.auth.oauth2.GoogleOAuthConstants;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.repackaged.org.apache.commons.codec.binary.Base64;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.ListMessagesResponse;
import com.google.api.services.gmail.model.Message;


public class GmailAPIUtils {
	

	
	/**
	 * 
	 * @return
	 * @throws IOException
	 */
	public static Gmail autorizeGmail(WebDriver driver, String mail, String pass, String clientSicretPass, String appName) throws IOException{
		Gmail service;
		HttpTransport httpTransport = new NetHttpTransport();
		JsonFactory jsonFactory = new JacksonFactory();

		GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(jsonFactory,  new FileReader(clientSicretPass));

		// Allow user to authorize via url.
		GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
				httpTransport, jsonFactory, clientSecrets, Arrays.asList("https://www.googleapis.com/auth/gmail.readonly"))
		.setAccessType("online")
		.setApprovalPrompt("auto").build();

		String url = flow.newAuthorizationUrl().setRedirectUri(GoogleOAuthConstants.OOB_REDIRECT_URI)
				.build();
		driver.get(url);
		driver.findElement(By.id("Email")).sendKeys(mail);
		driver.findElement(By.id("Passwd")).sendKeys(pass);
		driver.findElement(By.id("signIn")).click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("submit_approve_access")));
		driver.findElement(By.id("submit_approve_access")).click();



		String code = driver.findElement(By.id("code")).getAttribute("value");
		driver.quit();
		System.out.println(code);
		System.out.println("Please open the following URL in your browser then type"
				+ " the authorization code:\n" + url);

		// Read code entered by user.
		//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//    String code = br.readLine();

		// Generate Credential using retrieved code.
		GoogleTokenResponse response = flow.newTokenRequest(code)
				.setRedirectUri(GoogleOAuthConstants.OOB_REDIRECT_URI).execute();
		GoogleCredential credential = new GoogleCredential()
		.setFromTokenResponse(response);

		// Create a new authorized Gmail API client
		Gmail tempservice = new Gmail.Builder(httpTransport, jsonFactory, credential)
		.setApplicationName(appName).build();
		service = tempservice;
		return service;

	}
	/**
	 * 
	 * @param service
	 * @param userId
	 * @param query
	 * @return
	 * @throws IOException
	 */
	public static List<Message> listMessagesMatchingQuery(Gmail service, String userId,	String query) throws IOException {
		ListMessagesResponse response = service.users().messages().list(userId).setQ(query).execute();

		List<Message> messages = new ArrayList<Message>();
		while (response.getMessages() != null) {
			messages.addAll(response.getMessages());
			if (response.getNextPageToken() != null) {
				String pageToken = response.getNextPageToken();
				response = service.users().messages().list(userId).setQ(query)
						.setPageToken(pageToken).execute();
			} else {
				break;
			}
		}

		for (Message message : messages) {
			// System.out.println(message.toPrettyString());
		}

		return messages;
	}
	
	/**
	 * 
	 * @param service
	 * @param userId
	 * @param messageId
	 * @return
	 * @throws IOException
	 */
	public static Message getMessage(Gmail service, String userId, String messageId)
			throws IOException {
		Message message = service.users().messages().get(userId, messageId).execute();

		// System.out.println("Message snippet: " + message.getSnippet());

		return message;
	}	
	
	
}

