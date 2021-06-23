package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1149 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;
	static int[][] rgb;
	static int[][] dp;
	static int ans;

	static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		dp = new int[n][3];
		rgb = new int[n][3];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				rgb[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i < n; i++)
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		for (int i = 0; i < 3; i++)
			dp[0][i] = rgb[0][i];
	}

	static void solve() {
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				dp[i][j] = rgb[i][j] + Math.min(dp[i - 1][(j + 1) % 3], dp[i - 1][(j + 2) % 3]);
			}
		}
		ans = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++)
			ans = Math.min(dp[n - 1][i], ans);
		System.out.println(ans);
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();

	}

}
