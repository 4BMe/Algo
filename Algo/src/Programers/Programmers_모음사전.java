package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Programmers_모음사전 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static String word = "";

	static int solve(String word) {
		int ans = word.length();

		int[] x = { 781, 156, 31, 6, 1 };
		String s = "AEIOU";
		for (int i = 0, c = word.length(); i < c; i++) {
			int idx = s.indexOf(word.charAt(i));
			ans += x[i] * idx;
		}
		return ans;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solve(word));
	}

}