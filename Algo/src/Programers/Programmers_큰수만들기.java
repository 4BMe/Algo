package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Programmers_큰수만들기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static String number = "1924";
	static int k = 2;

	static String solve() {
		int len = number.length();

		StringBuilder ans = new StringBuilder();

		int idx = 0;
		int max = 0;
		for (int i = 0; i < len - k; i++) {
			max = 0;
			for (int j = idx; j <= i + k; j++) {
				if (max < number.charAt(j) - '0') {
					max = number.charAt(j) - '0';
					idx = j + 1;
				}
			}
			ans.append(max);
		}
		return ans.toString();
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solve());
	}

}