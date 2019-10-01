package com.ss.daythree.two;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AppendTextToFile {

	public static void main(String[] args) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter("./files/append.txt", true));
		writer.append("another one");
		writer.close();
	}
}
