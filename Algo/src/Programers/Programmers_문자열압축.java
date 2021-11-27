package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Programmers_문자열압축 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static String s = "aaaaaaaaaa";

	static int solve() {
		int ans = s.length();

		for (int i = 1, c = s.length(); i <= c / 2; i++) {
			String before = s.substring(0, i);
			int cnt = c;
			int con = 1;
			for (int j = i; j < c - i + 1; j += i) {
				String now = s.substring(j, j + i);
				if (before.equals(now)) {
					con++;
				} else {
					if (con != 1) {
						cnt -= i * (con - 1);
						while (con > 0) {
							cnt++;
							con /= 10;
						}
					}
					before = now;
					con = 1;
				}
			}
			if (con != 1) {
				cnt -= i * (con - 1);
				while (con > 0) {
					cnt++;
					con /= 10;
				}
			}
			ans = Math.min(ans, cnt);
		}

		return ans;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solve());
	}

}