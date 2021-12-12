package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Programmers_HIndex {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int[] citations = { 10000, 1, 2, 3, 3 };

	static int solve() {
		Arrays.sort(citations);
		int ans = 0;
		int idx = 0;
		for (int i = 1; i < 1000; i++) {
			for (int j = idx, c = citations.length; j < c; j++) {
				if (citations[j] >= i) {
					if (c - j >= i) {
						ans = i;
					}
					idx = j;
					break;
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solve());
	}

}