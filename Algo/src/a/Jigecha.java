package a;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Jigecha {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int y, x;
	static int[][] map = new int[20][20];
	static int[] dy = { 1, 0 };
	static int[] dx = { 0, 1 };
	static int answer = Integer.MAX_VALUE;
	static Stack<int[]> path = new Stack<>();

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		for (int i = 0; i < y; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < x; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	static void solve() {
		dfs(0, 0, 0);
		System.out.println(answer);
	}

	static void dfs(int ny, int nx, int hurt) {
		path.add(new int[] { ny, nx });
		if (ny == y - 1 && nx == x - 1) {
			answer = Math.min(answer, hurt);
			return;
		}
		if (hurt > answer) {
			path.pop();
			return;
		}

		int nny, nnx;
		for (int i = 0; i < 2; i++) {
			nny = ny + dy[i];
			nnx = nx + dx[i];
			if (nny < 0 || nny >= y || nnx < 0 || nnx >= x)
				continue;
			dfs(nny, nnx, hurt + map[nny][nnx]);
		}

	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
