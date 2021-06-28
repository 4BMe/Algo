package a;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1915 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n, m;
	static char[][] map;
	static int[][] dp;

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n + 1][m + 1];
		dp = new int[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			String s = br.readLine();
			for (int j = 1; j <= m; j++) {
				map[i][j] = s.charAt(j - 1);
				if (map[i][j] == '1')
					dp[i][j] = 1;
			}
		}
	}

	static void solve() {
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (map[i][j] == '0')
					continue;
				dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
				ans = Math.max(dp[i][j], ans);
			}
		}
		System.out.println(ans * ans);
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
