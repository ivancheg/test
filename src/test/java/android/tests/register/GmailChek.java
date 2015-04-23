package android.tests.register;



import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.codec.binary.Base64;

import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.Message;

import core.GmailAPIUtils;



public class GmailChek {

	public static Message getGoogleEmail(String email,  Gmail service) throws IOException, InterruptedException{
		Message mail = null;
		for (int i = 0; i < 20 && mail == null; i++ ){
			Thread.sleep(10000);
			List<Message> messages = GmailAPIUtils.listMessagesMatchingQuery(service, "me", "to:"+email);
			if(messages.size()!=0){
				mail = GmailAPIUtils.getMessage(service, "me", messages.get(0).getId());

			}

		}
		return mail;

	}
	
	
	
	/**
	 * 
	 * @param email
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String getConfirmLinkFromMail(Message mail) throws UnsupportedEncodingException{
		String autologin = null;

		//System.out.println(email.getPayload());
		byte[] decoded = Base64.decodeBase64(mail.getPayload().getParts().get(1).getBody().toString());
		String myMessege = new String(decoded, "UTF-8") + "\n";
		//System.out.println(new String(decoded, "UTF-8") + "\n");
		Pattern urlPattern = Pattern.compile("((https?|ftp|telnet)?://)?([a-zA-Z0-9-]{1,128}\\.)+([a-zA-Z]{2,4})+(:[0-9]{0,5})?(/[a-zA-Z0-9.,_@%&?+=\\~/#-]*)?");
		try{
			Matcher urlMatcher = urlPattern.matcher(myMessege);
			while(urlMatcher.find()){
				String ret = urlMatcher.toMatchResult().toString().substring(167);
				if (ret.indexOf("confirm-email") > 0){

					autologin = ret.split("]")[0];
					break;
				}
			}
		}

		catch (Exception e){

		}

		return autologin;
	}
}