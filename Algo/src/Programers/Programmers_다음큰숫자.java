package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Programmers_다음큰숫자 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n = 0;

	static int solve(int n) {
		String bi = Integer.toBinaryString(n);
		int cnt = 0;
		for (int i = 0, c = bi.length(); i < c; i++) {
			if (bi.charAt(i) == '1') {
				cnt++;
			}
		}
		int idx = n + 1;
		while (true) {
			bi = Integer.toBinaryString(idx);
			int res = 0;
			for (int i = 0, c = bi.length(); i < c; i++) {
				if (bi.charAt(i) == '1') {
					res++;
				}
			}
			if (cnt == res) {
				return idx;
			}
			idx++;
		}

	}

	public static void main(String[] args) throws Exception {
		System.out.println(solve(n));
	}

}