package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Programmers_숫자문자열과영단어 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static String s;

	static void solve() {
		String num = "";
		for (int i = 0, c = s.length(); i < c; i++) {
			char now = s.charAt(i);
			if (now == 'z') {
				num += '0';
				i += 3;
			} else if (now == 'o') {
				num += '1';
				i += 2;
			} else if (now == 't') {
				if (s.charAt(i + 1) == 'w') {
					num += '2';
					i += 2;
				} else {
					num += '3';
					i += 4;
				}
			} else if (now == 'f') {
				if (s.charAt(i + 1) == 'o') {
					num += '4';
					i += 3;
				} else {
					num += '5';
					i += 3;
				}
			} else if (now == 's') {
				if (s.charAt(i + 1) == 'i') {
					num += '6';
					i += 2;
				} else {
					num += '7';
					i += 4;
				}
			} else if (now == 'e') {
				num += '8';
				i += 4;
			} else if (now == 'n') {
				num += '9';
				i += 3;
			} else {
				num += now;
			}
		}
		int answer = Integer.parseInt(num);
		System.out.println(answer);
	}

	public static void main(String[] args) throws Exception {
		solve();
	}

}