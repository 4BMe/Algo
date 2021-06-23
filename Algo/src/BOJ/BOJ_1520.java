package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1520 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int m, n;
	static int[][] map;
	static int[][] dp;
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new int[m][n];
		dp = new int[m][n];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
	}

	static void solve() {

		System.out.println(dfs(0, 0));

	}

	static int dfs(int y, int x) {
		if (y == m - 1 && x == n - 1) {
			return 1;
		}

		if (dp[y][x] == -1) {
			dp[y][x] = 0;
			int nextY, nextX;
			for (int i = 0; i < 4; i++) {
				nextY = y + dy[i];
				nextX = x + dx[i];
				if (nextY < 0 || nextY >= m || nextX < 0 || nextX >= n)
					continue;
				if (map[nextY][nextX] >= map[y][x])
					continue;

				dp[y][x] += dfs(nextY, nextX);

			}
		}

		return dp[y][x];
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
