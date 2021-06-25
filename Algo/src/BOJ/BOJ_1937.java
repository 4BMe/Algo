package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1937 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n;
	static int[][] map;
	static int[][] dp;
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };

	static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		dp = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				dp[i][j] = -1;
	}

	static void solve() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				dfs(i, j, 1);
			}
		}

		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (dp[i][j] < ans)
					continue;
				ans = Math.max(ans, dp[i][j]);
			}
		}
		System.out.println(ans);
	}

	static int dfs(int y, int x, int day) {
		if (dp[y][x] > -1)
			return dp[y][x];
		else {
			int ny, nx;
			int res = 0;
			for (int i = 0; i < 4; i++) {
				ny = y + dy[i];
				nx = x + dx[i];
				if (ny < 0 || ny >= n || nx < 0 || nx >= n || map[y][x] >= map[ny][nx])
					continue;
				res = Math.max(res, dfs(ny, nx, day + 1));
			}
			return dp[y][x] = res + 1;
		}

	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
