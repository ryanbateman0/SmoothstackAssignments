package com.ss.daythree.one;

import java.io.File;

public class GetAllFilesInDirectory {
	
	public static void main(String[] args) {
		String filePath = ".";
		if (args.length > 0) {
			filePath = args[0];
		}
		File curFile = new File(filePath);
		File[] files = curFile.listFiles();
		for (File file: files) {
			System.out.println(file.getPath());
		}
	}
}
