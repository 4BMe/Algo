package SWE;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swe_1953 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int y, x, r, c, l;
	static int[][] map;
	static boolean[][] visited;
	static Queue<int[]> q;
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };
	static int answer;
	static boolean[][] pipe = { { true, true, true, true }, { false, false, true, true }, { true, true, false, false },
			{ true, false, false, true }, { true, false, true, false }, { false, true, true, false },
			{ false, true, false, true } };

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		map = new int[y][x];
		visited = new boolean[y][x];

		for (int i = 0; i < y; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < x; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		answer = 0;

	}

	static void solve() {
		bfs();
		sb.append(answer + "\n");
	}

	static void bfs() {
		q = new LinkedList<int[]>();
		q.offer(new int[] { r, c });
		visited[r][c] = true;

		int[] cur;
		int ny, nx, p, np;
		while (l-- > 0) {
			for (int size = 0, c = q.size(); size < c; size++) {
				cur = q.poll();
				answer++;
				p = map[cur[0]][cur[1]];
				for (int i = 0; i < 4; i++) {
					ny = cur[0] + dy[i];
					nx = cur[1] + dx[i];
					if (ny < 0 || ny >= y || nx < 0 || nx >= x)
						continue;
					if (!pipe[p - 1][i] || map[ny][nx] == 0 || visited[ny][nx])
						continue;
					np = map[ny][nx];
					if (!pipe[np - 1][i % 2 == 0 ? i + 1 : i - 1])
						continue;
					q.offer(new int[] { ny, nx });
					visited[ny][nx] = true;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {

		int t = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		for (int test = 1; test <= t; test++) {
			sb.append("#" + test + " ");
			init();
			solve();
		}
		System.out.println(sb);
	}

}
