package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10971 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n;
	static int[][] city;
	static boolean[] visited;
	static int[] dp;
	static int ans;

	static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		city = new int[n][n];
		visited = new boolean[n];
		dp = new int[n + 1];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Arrays.fill(dp, Integer.MAX_VALUE);
		ans = Integer.MAX_VALUE;
	}

	static void solve() {
		visited[0] = true;
		dfs(0, 1, 0);
		System.out.println(dp[n]);
	}

	static void dfs(int idx, int cnt, int sum) {
		if (cnt == n) {
			if (city[idx][0] == 0)
				return;
			dp[cnt] = Math.min(dp[cnt], sum + city[idx][0]);
			return;
		}
		dp[cnt] = Math.min(dp[cnt], sum);

		for (int i = 0; i < n; i++) {
			if (visited[i] || city[idx][i] == 0)
				continue;
			visited[i] = true;
			dfs(i, cnt + 1, sum + city[idx][i]);
			visited[i] = false;
		}

	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
