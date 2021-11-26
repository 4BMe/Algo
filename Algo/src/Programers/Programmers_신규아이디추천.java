package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Programmers_신규아이디추천 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;

	static void solve() {
		String new_id = "abcdefghijklmn.p";
		new_id = new_id.toLowerCase();
		new_id = new_id.replaceAll("[^0-9a-z-_.]+", "");
		new_id = new_id.replaceAll("[.]+", ".");
		new_id = new_id.replaceAll("^[.]+", "");
		new_id = new_id.replaceAll("[.]$", "");

		int len = new_id.length();
		if (len == 0) {
			new_id = "aaa";
		} else if (len > 15) {
			new_id = new_id.substring(0, 15);
			new_id = new_id.replaceAll("[.]$", "");
		} else if (len < 3) {
			char last = new_id.charAt(len - 1);
			for (int i = len; i < 3; i++) {
				new_id += last;
			}
		}
		System.out.println(new_id);

	}

	public static void main(String[] args) throws Exception {
		solve();
	}

}