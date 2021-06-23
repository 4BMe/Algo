package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7562 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int t, l;
	static int[] start = new int[2], dest = new int[2];
	static boolean[][] visited;
	static int[] dy = { 2, 2, -2, -2, 1, 1, -1, -1 };
	static int[] dx = { 1, -1, 1, -1, 2, -2, 2, -2 };

	static void init() throws Exception {

		t = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		for (int i = 0; i < t; i++) {
			l = Integer.parseInt(br.readLine());
			visited = new boolean[l][l];

			st = new StringTokenizer(br.readLine());
			start[0] = Integer.parseInt(st.nextToken());
			start[1] = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			dest[0] = Integer.parseInt(st.nextToken());
			dest[1] = Integer.parseInt(st.nextToken());
			solve();
		}
		br.close();
		System.out.println(sb);
	}

	static void solve() {
		if (start[0] == dest[0] && start[1] == dest[1])
			sb.append(0 + "\n");
		else
			bfs(start[0], start[1]);
	}

	static void bfs(int y, int x) {
		Queue<int[]> q = new LinkedList<int[]>();

		q.offer(new int[] { y, x, 0 });
		visited[y][x] = true;

		int ny, nx;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int i = 0; i < 8; i++) {
				ny = cur[0] + dy[i];
				nx = cur[1] + dx[i];
				if (nx < 0 || nx >= l || ny < 0 || ny >= l || visited[ny][nx])
					continue;
				if (ny == dest[0] && nx == dest[1]) {
					sb.append(cur[2]+1 + "\n");
					return;
				}
				visited[ny][nx] = true;
				q.offer(new int[] { ny, nx, cur[2] + 1 });
			}
		}

	}

	public static void main(String[] args) throws Exception {
		init();
	}

}
