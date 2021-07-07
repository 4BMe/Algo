package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11049 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n;
	static int[][] arr;
	static int[][] dp;

	static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		arr = new int[n][2];
		dp = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}

	}

	static void solve() {
		System.out.println(dfs(0, n - 1));
	}

	static int dfs(int from, int to) {
		if (from == to)
			return 0;
		if (dp[from][to] != Integer.MAX_VALUE)
			return dp[from][to];

		for (int i = from; i < to; i++) {
			int temp = dfs(from, i) + dfs(i + 1, to) + arr[from][0] * arr[i][1] * arr[to][1];
			dp[from][to] = Math.min(dp[from][to], temp);
		}
		return dp[from][to];
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
