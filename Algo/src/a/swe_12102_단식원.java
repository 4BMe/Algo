package a;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swe_12102_단식원 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int t;
	static int y, x;
	static int[][] map = new int[9][9];
	static int[][] temp = new int[9][9];
	static boolean[][] visited;
	static int answer;
	static LinkedList<int[]> q;
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		q = new LinkedList<int[]>();
		
		for (int i = 0; i < y; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < x; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2)
					q.offer(new int[] { i, j });
			}
		}
		answer = 0;
	}

	static void solve() {
		dfs(0, 0);
		sb.append(answer + "\n");
	}

	static void dfs(int stage, int cnt) {
		int ny = stage / x;
		int nx = stage % x;
		if (stage >= y * x)
			return;
		if (cnt == 3) {
			chicken();
			return;
		}
		if (map[ny][nx] == 0) {
			map[ny][nx] = 1;
			dfs(stage + 1, cnt + 1);
			map[ny][nx] = 0;
		}
		dfs(stage + 1, cnt);

	}

	static void chicken() {
		Queue<int[]> nq = new LinkedList<>();
		for (int[] a : q) {
			nq.offer(a);
		}
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				temp[i][j] = map[i][j];
			}
		}

		int[] cur;
		int ny, nx;
		while (!nq.isEmpty()) {
			cur = nq.poll();
			for (int i = 0; i < 4; i++) {
				ny = cur[0] + dy[i];
				nx = cur[1] + dx[i];
				if (ny < 0 || ny >= y || nx < 0 || nx >= x || temp[ny][nx] != 0)
					continue;
				temp[ny][nx] = 2;
				nq.offer(new int[] { ny, nx });
			}
		}

		int ret = 0;
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				if (temp[i][j] == 0)
					ret++;
			}
		}

		answer = Math.max(answer, ret);
	}

	public static void main(String[] args) throws Exception {
		t = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		for (int test = 1; test <= t; test++) {
			sb.append("#" + test + " ");
			init();
			solve();
		}
		System.out.println(sb);
	}

}
