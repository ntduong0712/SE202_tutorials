package Tut01;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TagContentExtractor {
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		while(testCases>0){
			String line = in.nextLine();
            boolean matchFound = false;
            // Group 1: <(.+)> matches HTML start tags
            // Group 2: ([^<]+) matches all contents between 2 tags, not include "<" symbol
            // Group 3: </\\1> matches HTML end tags, "\1" is to match all text in group 1
            Pattern pattern = Pattern.compile("<(.+)>([^<]+)</\\1>");
            Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {
                System.out.println(matcher.group(2));
                matchFound = true;
            }
            if ( ! matchFound) {
                System.out.println("None");
            }
			
			testCases--;
		}
	}
}