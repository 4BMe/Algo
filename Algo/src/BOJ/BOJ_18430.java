package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18430 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n, m;
	static int[][] map;
	static boolean[][] visited;
	static int[][] dy = { { 0, 0, 1 }, { 0, 0, -1 }, { -1, 0, 0 }, { 1, 0, 0 } };
	static int[][] dx = { { -1, 0, 0 }, { -1, 0, 0 }, { 0, 0, 1 }, { 0, 0, 1 } };
	static int ans;

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = 0;
	}

	static void solve() {
		dfs(0, 0);
		System.out.println(ans);
	}

	static void dfs(int idx, int sum) {
		if (idx == n * m) {
			ans = Math.max(ans, sum);
			return;
		}
		int y = idx / m;
		int x = idx % m;
		if (!visited[y][x]) {
			for (int i = 0; i < 4; i++) {
				int cnt = poss(y, x, i);
				if (cnt == 0)
					continue;
				boomerang(y, x, i, true);
				dfs(idx + 1, sum + cnt);
				boomerang(y, x, i, false);
			}
		}
		dfs(idx + 1, sum);
	}

	static int poss(int y, int x, int dir) {
		int ny, nx, res = map[y][x];
		for (int i = 0; i < 3; i++) {
			ny = y + dy[dir][i];
			nx = x + dx[dir][i];
			if (ny < 0 || ny >= n || nx < 0 || nx >= m || visited[ny][nx])
				return 0;
			res += map[ny][nx];
		}
		return res;
	}

	static void boomerang(int y, int x, int dir, boolean value) {
		int ny, nx, res = 0;
		for (int i = 0; i < 3; i++) {
			ny = y + dy[dir][i];
			nx = x + dx[dir][i];
			visited[ny][nx] = value;
		}
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
