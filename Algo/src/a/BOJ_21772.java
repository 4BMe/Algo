package a;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_21772 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int r, c, t;
	static char[][] map;
	static boolean[][] visited;
	static int dy[] = { 0, 0, -1, 1 };
	static int dx[] = { -1, 1, 0, 0 };
	static int[] now = new int[2];
	static int answer = 0;

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());

		map = new char[r][c];
		visited = new boolean[r][c];

		now[0] = now[1] = -1;
		String a;
		for (int i = 0; i < r; i++) {
			a = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = a.charAt(j);
				if (map[i][j] == 'G') {
					now[0] = i;
					now[1] = j;
				}
			}
		}

	}

	static void solve() {
		visited[now[0]][now[1]] = true;
		dfs(now[0], now[1], 0, 0);
		System.out.println(answer);
	}

	static void dfs(int y, int x, int time, int cnt) {
		if (time > t) {
			answer = Math.max(answer, cnt);
			return;
		}
		int ny, nx;
		for (int i = 0; i < 4; i++) {
			ny = y + dy[i];
			nx = x + dx[i];
			if (ny < 0 || ny >= r || nx < 0 || nx >= c || visited[ny][nx] || map[ny][nx] == '#')
				continue;
			visited[ny][nx] = true;
			if (map[ny][nx] == 'S') {
				map[ny][nx] = '.';
				dfs(ny, nx, time + 1, cnt + 1);
				map[ny][nx] = 'S';
			} else {
				dfs(ny, nx, time + 1, cnt);
			}
			visited[ny][nx] = false;
		}

	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
