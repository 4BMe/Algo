package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Programmers_JadenCase문자열만들기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static String s = "aaaaaaa  aa";

	static String solve(String s) {
		StringBuilder sb = new StringBuilder();
		sb.append(s.substring(0, 1).toUpperCase());
		char before = s.charAt(0);
		for (int i = 1, c = s.length(); i < c; i++) {
			if (before == ' ') {
				sb.append(s.substring(i, i + 1).toUpperCase());
			} else {
				sb.append(s.substring(i, i + 1).toLowerCase());
			}
			before = s.charAt(i);
		}

		return sb.toString();
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solve(s));
	}

}