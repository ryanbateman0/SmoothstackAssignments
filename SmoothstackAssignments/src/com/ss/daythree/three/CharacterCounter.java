package com.ss.daythree.three;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class CharacterCounter {

	public static void main(String[] args) throws IOException {
		char characterToCount = 'e';
		if (args.length > 0) {
			characterToCount = Character.toLowerCase(args[0].charAt(0));
		}

		FileInputStream fin = new FileInputStream("./files/sherlock.txt");
		BufferedReader buffReader = new BufferedReader(new InputStreamReader(fin));
		int nextByte;
		char nextChar;
		int counter = 0;
		while ((nextByte = buffReader.read()) != -1) {
			nextChar = (char) nextByte;
			if (characterToCount == Character.toLowerCase(nextChar)) {
				counter++;
			}
		}
		System.out.println(counter);
		buffReader.close();
	}
}
