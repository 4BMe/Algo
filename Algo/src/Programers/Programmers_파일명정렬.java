package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Programmers_파일명정렬 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb;
	static String[] files = { "F-15", "img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG" };

	static String[] solve(String[] files) {
		Pattern head = Pattern.compile("\\D+");
		Pattern number = Pattern.compile("[0-9]+");
		Arrays.sort(files, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				o1 = o1.toLowerCase();
				o2 = o2.toLowerCase();

				Matcher hm1 = head.matcher(o1);
				Matcher hm2 = head.matcher(o2);
				hm1.find();
				hm2.find();

				String header1 = hm1.group();
				String header2 = hm2.group();
				if (!header1.equals(header2)) {
					return header1.compareTo(header2);
				}
				Matcher nm1 = number.matcher(o1);
				Matcher nm2 = number.matcher(o2);
				nm1.find();
				nm2.find();
				int number1 = Integer.parseInt(nm1.group());
				int number2 = Integer.parseInt(nm2.group());
				return number1 - number2;
			}
		});
		return files;
	}

	public static void main(String[] args) throws Exception {
		for (String a : solve(files)) {
			System.out.println(a + " ");
		}
	}

}