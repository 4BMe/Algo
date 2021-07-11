package a;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2169 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n, m;
	static int[][] map;
	static int[][][] dp;
	static int INF = -100000005;
	static int[] dy = { 0, 0, 1 };
	static int[] dx = { 1, -1, 0 };
	static int dirr[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static boolean[][] visited;

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		dp = new int[n][m][3];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j][0] = -100000005;
				dp[i][j][1] = -100000005;
				dp[i][j][2] = -100000005;
			}
		}

		visited = new boolean[n][m];
	}

	static void solve() {
		System.out.println(dfs(0, 0, 0));
	}

	static int dfs(int y, int x, int dir) {
		if (y == n - 1 && x == m - 1)
			return map[y][x];
		if (dp[y][x][dir] != -100000005)
			return dp[y][x][dir];

		visited[y][x] = true;
		int ans = INF;
		for (int i = 0; i < 3; i++) {
			int ny = y + dirr[i][0];
			int nx = x + dirr[i][1];
			if (ny < 0 || ny >= n || nx < 0 || nx >= m || visited[ny][nx])
				continue;
			ans = Math.max(ans, map[y][x] + dfs(ny, nx, i));
		}
		visited[y][x] = false;
		return dp[y][x][dir] = ans;
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
