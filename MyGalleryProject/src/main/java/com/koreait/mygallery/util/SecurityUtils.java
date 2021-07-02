package com.koreait.mygallery.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 암호화, 복호화, 무작위 키 생성 클래스
 * 
 * @author 박세환
 */
public class SecurityUtils {

	/**
	 * sha256 암호화
	 * 
	 * @param pw 비밀번호
	 * @return sha256
	 */
	public static String sha256(String pw) {
		return DigestUtils.sha256Hex(pw.getBytes());
	}

	/**
	 * 무작위 키 생성
	 * 
	 * @param length 키의 길이
	 * @return 키값
	 */
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
