package a;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2133 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n;
	static int[] dp;

	static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		dp = new int[n + 2];
	}

	static void solve() {
		dp[0] = 1;
		dp[2] = 3;
		for (int i = 4; i <= n; i += 2) {
			dp[i] = dp[i - 2] * 3;
			for (int j = 4; j <= i; j += 2)
				dp[i] += dp[i - j] * 2;
		}
		System.out.println(dp[n]);
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
