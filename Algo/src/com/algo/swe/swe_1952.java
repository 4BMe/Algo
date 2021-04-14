package com.algo.swe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swe_1952 {
	static int T;
	static int[] charge = new int[4];
	static int[] Month = new int[12];
	static int[] dp;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(in.readLine());

		for (int test = 1; test <= T; test++) {
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < 4; i++) {
				charge[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < 12; i++) {
				Month[i] = Integer.parseInt(st.nextToken());
			}
			dp = new int[12];
			answer = 987654321;

			dp[0] = Math.min(Month[0] * charge[0], charge[1]);
			for (int i = 1; i < 12; i++) {
				if (Month[i] <= 0) {
					dp[i] = dp[i - 1];
					continue;
				}
				dp[i] = dp[i - 1] + Math.min(Month[i] * charge[0], charge[1]);
//				System.out.println(Month[i] * charge[0]+" "+charge[1]);
				if (i == 2)
					dp[i] = Math.min(dp[i], charge[2]);
				else if (i > 2) {
					dp[i] = Math.min(dp[i], dp[i - 3] + charge[2]);
//					System.out.println(dp[i - 3] + charge[2]);
				}
//				System.out.println(i+" "+dp[i]);
			}
			dp[11] = Math.min(dp[11], charge[3]);
			System.out.println("#" + test + " " + dp[11]);
		}
	}

}
