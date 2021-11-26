package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Programmers_내적 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int[] a;
	static int[] b;

	static void solve() {
		int ans = 0;
		for (int i = 0, c = a.length; i < c; i++) {
			ans += a[i] * b[i];
		}
	}

	public static void main(String[] args) throws Exception {
		solve();
	}

}