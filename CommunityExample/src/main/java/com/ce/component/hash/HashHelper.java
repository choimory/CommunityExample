package com.ce.component.hash;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

public class HashHelper {
	private BCryptPasswordEncoder bcrypt;
	private Pbkdf2PasswordEncoder pbkdf;

	public void setBcrypt(BCryptPasswordEncoder bcrypt) {
		this.bcrypt = bcrypt;
	}

	public void setPbkdf(Pbkdf2PasswordEncoder pbkdf) {
		this.pbkdf = pbkdf;
	}
	
	public String hashByBCrypt(String rawPassword) {
		String hashedPassword=null;
		
		hashedPassword=bcrypt.encode(rawPassword);
		
		return hashedPassword;
	}
	public String hashByPbkdf(String rawPassword) {
		String hashedPassword=null;
		
		hashedPassword=pbkdf.encode(rawPassword);
		
		return hashedPassword;
	}
	public boolean matchByBCrypt(String rawPassword, String hashedPassword) {
		boolean result=false;
		
		result=bcrypt.matches(rawPassword, hashedPassword);
		
		return result;
	}
	public boolean matchByPbkdf(String rawPassword, String hashedPassword) {
		boolean result=false;
		
		result=pbkdf.matches(rawPassword, hashedPassword);
		
		return result;
	}
}
