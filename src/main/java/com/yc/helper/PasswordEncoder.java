package com.yc.helper;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Component;

@Component
public class PasswordEncoder {

	public String getHash(String str) {

		String md5password = "";
		MessageDigest messageDigest;

		try {
			messageDigest = MessageDigest.getInstance("MD5");

			messageDigest.reset();
			messageDigest.update(str.getBytes());

			byte[] md5 = messageDigest.digest();

			for (int i = 0; i < md5.length; i++) {
				String tmp = (Integer.toHexString(0xFF & md5[i]));
				if (tmp.length() == 1) {
					md5password += "0" + tmp;
				} else {
					md5password += tmp;
				}
			}

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return md5password;

	}
}
