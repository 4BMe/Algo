package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_21757 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n;
	static long[] psum;
	static long[][] dp;

	static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		psum = new long[n + 1];
		dp = new long[n + 1][4];

		st = new StringTokenizer(br.readLine());
		long sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += Long.parseLong(st.nextToken());
			psum[i] = sum;
		}
	}

	static void solve() {
		if (psum[n] % 4 != 0) {
			System.out.println(0);
			return;
		}
		long mod = psum[n] / 4;

		dp[0][0] = 1;
		for (int i = 1; i <= n; i++) {
			dp[i][0] = 1;
			for (int j = 1; j <= 3; j++) {
				dp[i][j] = dp[i - 1][j];
				if (mod * j == psum[i]) {
					dp[i][j] += dp[i - 1][j - 1];
				}
			}
		}
		System.out.println(dp[n - 1][3]);
	}

	public static void main(String[] args) throws Exception {
		init();
		solve();
	}

}