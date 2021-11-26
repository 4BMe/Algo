package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Programmers_음양더하기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int[] absolutes;
	static boolean[] signs;

	static void solve() {
		int ans = 0;
		for (int i = 0, c = signs.length; i < c; i++) {
			if (signs[i]) {
				ans += absolutes[i];
			} else {
				ans -= absolutes[i];
			}
		}
	}

	public static void main(String[] args) throws Exception {
		solve();
	}

}