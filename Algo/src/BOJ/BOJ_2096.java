package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2096 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n;
	static int[][] num;
	static int[][][] dp;

	static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		num = new int[n][3];
		dp = new int[2][n][3];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			num[i][0] = Integer.parseInt(st.nextToken());
			num[i][1] = Integer.parseInt(st.nextToken());
			num[i][2] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < 3; i++) {
			dp[0][0][i] = num[0][i];
			dp[1][0][i] = num[0][i];
		}
	}

	static void solve() {
		for (int i = 1; i < n; i++) {
			// max
			dp[0][i][0] = Math.max(dp[0][i - 1][0], dp[0][i - 1][1]) + num[i][0];
			dp[0][i][1] = Math.max(dp[0][i - 1][0], Math.max(dp[0][i - 1][1], dp[0][i - 1][2])) + num[i][1];
			dp[0][i][2] = Math.max(dp[0][i - 1][1], dp[0][i - 1][2]) + num[i][2];

			// min
			dp[1][i][0] = Math.min(dp[1][i - 1][0], dp[1][i - 1][1]) + num[i][0];
			dp[1][i][1] = Math.min(dp[1][i - 1][0], Math.min(dp[1][i - 1][1], dp[1][i - 1][2])) + num[i][1];
			dp[1][i][2] = Math.min(dp[1][i - 1][1], dp[1][i - 1][2]) + num[i][2];
		}

		System.out.println(Math.max(dp[0][n - 1][0], Math.max(dp[0][n - 1][1], dp[0][n - 1][2])) + " "
				+ Math.min(dp[1][n - 1][0], Math.min(dp[1][n - 1][1], dp[1][n - 1][2])));
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
