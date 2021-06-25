package com.koreait.member.command;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

public class SecurityUtils {

	public static String xxs(String str) {
		str = str.replaceAll("&", "&amp;");
		str = str.replace("<", "&lt;");
		str = str.replace(">", "&gt;");
		return str;
	}
	
	
	public static String sha256(String pw) {
		/*
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
			md.update(pw.getBytes());
			StringBuilder sb = new StringBuilder();
			for(byte b : md.digest()) {
				sb.append(String.format("%02x", b)); // 16진수 표기법 변환
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "";
		*/
		return DigestUtils.sha256Hex(pw.getBytes());
	}
	
	public static String encodeBase64(String string) {
		return new String(Base64.encodeBase64(string.getBytes()));
	}
	
	public static String decodeBase64(String base64String) {
		return new String(Base64.decodeBase64(base64String.getBytes()));
	}
	
	public static String createKey(int length) {
		StringBuilder key = new StringBuilder();
		for (int i = 0; i < length; i++) {
			if(Math.random() > 0.4) {
				key.append((char)(Math.random() * ('Z' - 'A') + 'A'));
			} else {
				key.append((char)(Math.random() * ('9' - '0') + '0'));
			}
		}
		return key.toString();
	}
	
}
