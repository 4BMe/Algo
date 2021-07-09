package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2098 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;
	static int[][] map;
	static int[][] dp;
	static int INF = 987654321;

	static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];

		dp = new int[n][(1 << n) - 1];
		for (int i = 0; i < n; i++)
			Arrays.fill(dp[i], INF);

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	static void solve() {
		System.out.println(dfs(0, 1) + "\n");
	}

	static int dfs(int node, int visit) {
		// 모든 지점을 방문한 경우
		if (visit == (1 << n) - 1) {
			if (map[node][0] == 0)
				return INF;
			return map[node][0];
		}

		// 이미 계산 했던 경우
		if (dp[node][visit] != INF)
			return dp[node][visit];

		for (int i = 0; i < n; i++) {
			int next = visit | (1 << i);
			// i번 노드에 대해서 길이 없거나 방문한 경우
			if (map[node][i] == 0 || (visit & (1 << i)) != 0)
				continue;

			dp[node][visit] = Math.min(dp[node][visit], dfs(i, next) + map[node][i]);
		}

		return dp[node][visit];
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
