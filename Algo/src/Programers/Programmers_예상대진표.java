package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Programmers_예상대진표 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;

	static int solve() {
		int n = 0;
		int a = 7;
		int b = 8;
		int ans = 0;
		while (a != b) {
			ans++;
			a = (a + 1) / 2;
			b = (b + 1) / 2;
		}
		return ans;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solve());
	}

}