package src.com.algo.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17070_dp {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;
	static int[][] map;
	static long[][][] dp;
	static int[] dy = { 0, 1, 1 };
	static int[] dx = { 1, 1, 0 };
	static int ans;

	static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		dp = new long[n][n][3];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	static void solve() {

		dp[0][1][0] = 1;

		for (int i = 0; i < n; i++) {
			for (int j = 2; j < n; j++) {
				if (map[i][j] == 1)
					continue;
				dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][1];
				if (i == 0)
					continue;
				dp[i][j][2] = dp[i - 1][j][1] + dp[i - 1][j][2];
				if (map[i - 1][j] == 1 || map[i][j - 1] == 1)
					continue;
				dp[i][j][1] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
			}
		}

		System.out.println(dp[n - 1][n - 1][0] + dp[n - 1][n - 1][1] + dp[n - 1][n - 1][2]);

	}

	public static void main(String[] args) throws Exception {

		init();
		solve();

	}

}