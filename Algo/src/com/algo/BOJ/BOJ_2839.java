package com.algo.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2839 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;
	static int[] dp;

	static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		dp = new int[n + 3];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[3] = 1;
		dp[5] = 1;

		for (int i = 6; i <= n; i++) {
			dp[i] = Math.min(dp[i - 3], dp[i - 5]);
			if (dp[i] == Integer.MAX_VALUE)
				continue;
			else
				dp[i]++;
		}
		if (dp[n] == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(dp[n]);
	}

	public static void main(String[] args) throws Exception {

		init();

	}

}
