package src.com.algo.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2636 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m;
	static int[][] map;
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };
	static boolean[][] visited;
	static Queue<int[]> edge;
	static Queue<int[]> find;
	static int cheese;
	static int ans;

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					cheese++;
			}
		}

		find = new LinkedList<int[]>();
		edge = new LinkedList<int[]>();

	}

	static void solve() {

		int[] cur;
		int y, x;
		int time = 0;
		for (;;) {
			visited = new boolean[n][m];
			for (int i = 0; i < n; i++) {
				find.offer(new int[] { i, 0 });
				find.offer(new int[] { i, m - 1 });
				visited[i][0] = true;
				visited[i][m - 1] = true;
			}
			while (!find.isEmpty()) {
				cur = find.poll();
				for (int i = 0; i < 4; i++) {
					y = cur[0] + dy[i];
					x = cur[1] + dx[i];
					if (y < 0 || y >= n || x < 0 || x >= m)
						continue;
					if (map[y][x] == 0) {
						if (!visited[y][x])
							find.offer(new int[] { y, x });
					} else if (map[y][x] > 0) {
						if (!visited[y][x])
							edge.offer(new int[] { y, x });
					}
					visited[y][x] = true;
				}
			}

			ans = edge.size();
			while (!edge.isEmpty()) {
				cur = edge.poll();
				map[cur[0]][cur[1]] = 0;
			}
			cheese -= ans;
			time++;
			if (cheese == 0) {
				System.out.println(time);
				System.out.println(ans);
				return;
			}

		}

	}

	public static void main(String[] args) throws Exception {

		init();
		solve();

	}

}
