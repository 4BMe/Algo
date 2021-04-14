package com.algo.swe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swe_3307 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int t, n;
	static int[] num;
	static int ans;
	static int[] dp;

	static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		num = new int[n];
		dp = new int[n];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++)
			num[i] = Integer.parseInt(st.nextToken());

		ans = 0;
	}

	static void solve() {
		for (int i = 0; i < n; i++) {
			dp[i] = 1;
			for (int j = i - 1; j >= 0; j--) {
				if (num[j] < num[i])
					dp[i] = Math.max(dp[i], dp[j] + 1);
			}
			ans = Math.max(ans, dp[i]);
		}
	}

	public static void main(String[] args) throws Exception {

		t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			init();
			solve();

			System.out.println("#" + i + " " + ans);
		}

	}

}
