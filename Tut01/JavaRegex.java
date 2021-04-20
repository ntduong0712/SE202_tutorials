package Tut01;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

class JavaRegex {
	public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }

    }
}

class MyRegex {
	/*
	 * ([0-2]([0-4][0-9]|5[0-5])) matches "the maximum length is 3", "the maximum of the range is 255"
	 * (\\d{2})\\.|0\\.) matches "the length is 2" or "the minimum of the range is 0"
	 * {3} matches "the previous condition repeats 3 times"
	 * */
    String pattern = "(([0-2]([0-4][0-9]|5[0-5]))\\.|(\\d{2})\\.|0\\.){3}(([0-2]([0-4][0-9]|5[0-5]))|(\\d{2})|0)";
}