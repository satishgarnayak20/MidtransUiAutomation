package com.midtrans.web.automation.utilities;

import java.util.Base64;
/**
 * @author Satish Garnayak
 *  This class is used for encoding/decoding the sensitive test data
 */
public class TestUtility {

	public static String encodeString(String string) {
		String encodedString = Base64.getEncoder().encodeToString(string.getBytes());
		return encodedString;
	}

	public static String decodedString(String string) {
		byte[] decodedBytes = Base64.getDecoder().decode(string);
		String decodedString = new String(decodedBytes);
		return decodedString;

	}
}
