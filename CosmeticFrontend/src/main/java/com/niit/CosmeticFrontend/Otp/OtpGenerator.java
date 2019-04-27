package com.niit.CosmeticFrontend.Otp;

public class OtpGenerator {

	public static String Otpga()
	{
		String password="";
		for(int i=0; i<6-2; i++)
		{
			password = password + randomCharacter("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
		}
		
		String randomDigit =  randomCharacter("12312312");
		password = InsertAtrandom(password, randomDigit);
		String randomSymbol = randomCharacter("12312312");
		password = InsertAtrandom(password, randomSymbol);
		return password;
	}
	public static String randomCharacter(String character)
	{
		int n = character.length();
		int r=(int)(n*Math.random());
		return character.substring(r,  r+1);
	}
	
	public static String InsertAtrandom(String str, String toInsert)
	{
		int n = str.length();
		int r = (int)((n+1)* Math.random());
		return str.substring(0, r) + toInsert + str.substring(r);
	}
	
}
