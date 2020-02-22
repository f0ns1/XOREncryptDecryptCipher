package com.encryptor.cipher;

import java.awt.image.BufferStrategy;

public class XORCipher {
	private final String PRIVATE_KEY;
	public XORCipher(String privateKey) {
		PRIVATE_KEY=privateKey;
	}

	public  String encrypt(String inputString) 
    { 
      
        String xorKey = PRIVATE_KEY; 
        StringBuilder outputString = new StringBuilder(); 
        outputString.append(PRIVATE_KEY);
        for (int i = 0; i < inputString.length(); i++)  
        { 
            outputString.append(Character.toString((char) (inputString.charAt(i) ^ xorKey.charAt(i)))); 
        } 
        return outputString.toString(); 
    } 
	
	public  String decrypt(String inputString) 
    { 
        inputString=inputString.replace(PRIVATE_KEY, "");
        String xorKey = PRIVATE_KEY; 
        StringBuilder outputString = new StringBuilder();  
        int j=0;
        for (int i = 0; i < inputString.length(); i++)  
        { 
        	if(j==PRIVATE_KEY.length()) {
        		j=0;
        	}
            outputString.append(Character.toString((char) (inputString.charAt(i) ^ xorKey.charAt(j))));
            j++;
        } 
        return outputString.toString(); 
    } 
	
}
