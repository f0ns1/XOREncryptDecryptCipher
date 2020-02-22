package com.encryptor.xor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

import com.encryptor.cipher.XORCipher;

public class Main {
	private static final String PRIVATE_KEY = "";
	private static final String FILE_IN = "";
	private static final String FILE_OUT = FILE_IN + ".decrypted";

	public static void main(String[] args) {
		String dataToEncryot = getDataFromFile(FILE_IN);
		String encryptedString = dataToEncryot;
		XORCipher xor = new XORCipher(PRIVATE_KEY);
		// System.out.println("Initial data to encrypt: "+dataToEncryot);
		// String encryptedString = xor.encrypt(dataToEncryot);
		System.out.println("Data encrypted with XOR cipher : " + encryptedString);
		String decrypted = xor.decrypt(encryptedString);
		System.out.println("Data decrypted with XOR cipher : " + decrypted);
		setDataDecryptedOnOutputFile(decrypted, FILE_OUT);

	}

	private static void setDataDecryptedOnOutputFile(String decrypted, String fileOut) {

		try {
			File fileDir = new File(fileOut);
			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileDir), "UTF8"));
			out.append(decrypted);
			out.flush();
			out.close();

		} catch (UnsupportedEncodingException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private static String getDataFromFile(String file2) {
		StringBuilder sb = new StringBuilder();
		try (FileReader reader = new FileReader(file2); BufferedReader br = new BufferedReader(reader)) {
			// read line by line
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				sb.append(line);
			}
		} catch (IOException e) {
			System.err.format("IOException: %s%n", e);
		}
		return sb.toString();
	}

}
