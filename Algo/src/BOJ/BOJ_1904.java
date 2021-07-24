package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1904 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n;
	static int[] dp;

	static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		dp = new int[n + 1];
	}

	static void solve() {
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			dp[i] = (dp[i - 1] % 15746 + dp[i - 2] % 15746) % 15746;
		}
		System.out.println(dp[n] % 15746);
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
