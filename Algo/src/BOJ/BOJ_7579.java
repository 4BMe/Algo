package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_7579 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n, m;
	static int[] mem, cost;
	static int ans;
	static int[][] dp;
	static int max = 0;

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		mem = new int[n + 1];
		cost = new int[n + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++)
			mem[i] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
			max += cost[i];
		}

		dp = new int[n + 1][max + 1];
		ans = 987654321;
	}

	static void solve() {
		for (int i = 1; i <= n; i++) {
			int m = mem[i];
			int c = cost[i];
			for (int j = 0; j <= max; j++) {
				if (j - c >= 0)
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - c] + m);
				dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
			}
		}

		for (int i = 0; i <= max; i++)
			if (dp[n][i] >= m) {
				System.out.println(i);
				return;
			}
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
