package com.algo.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11054 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;
	static int[] num;
	static int[] indp;
	static int[] dedp;

	static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		num = new int[n];
		indp = new int[n];
		dedp = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			num[i] = Integer.parseInt(st.nextToken());
	}

	static void solve() {
		for (int i = 0; i < n; i++) {
			indp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (num[i] > num[j])
					indp[i] = Math.max(indp[i], indp[j] + 1);
			}
		}
		
		for (int i = n - 1; i >= 0; i--) {
			dedp[i] = 1;
			for (int j = n - 1; j > i; j--) {
				if (num[i] > num[j])
					dedp[i] = Math.max(dedp[i], dedp[j] + 1);
			}
		}

		int answer = 0;
		for (int i = 0; i < n; i++) {
			answer = Math.max(answer, indp[i] + dedp[i] - 1);
		}
		System.out.println(answer);
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
