package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Programmers_팰린드롬 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static String s = "aa";

	static int solution(String s) {
		int ans = 1;
		for (int i = 0, c = s.length(); i < c; i++) {
			int idx = 1;
			for (int j = 1; j < s.length(); j++) {
				if (i + j == c || i - j == -1 || s.charAt(i + j) != s.charAt(i - j)) {
					break;
				}
				idx += 2;
			}
			ans = Math.max(ans, idx);
			if (i >= 1) {
				if (s.charAt(i) == s.charAt(i - 1)) {
					idx = 2;
					for (int j = 1; j < s.length(); j++) {
						if (i + j == c || i - 1 - j == -1 || s.charAt(i + j) != s.charAt(i - 1 - j)) {
							break;
						}
						idx += 2;
					}
					ans = Math.max(ans, idx);
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solution(s));
	}

}