package com.algo.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m;
	static char[][] map;
	static boolean[][][] visited;
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };
	static int ans;

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];

		String s;
		for (int i = 0; i < n; i++) {
			s = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j);
			}
		}

	}

	static void solve() {
		ans = Integer.MAX_VALUE;
		bfs();
		if (ans == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(ans);
	}

	static void bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		visited = new boolean[n][m][2];

		q.offer(new int[] { 0, 0, 1, 1 });
		visited[0][0][1] = true;

		int ny, nx, br;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			if (cur[0] == n - 1 && cur[1] == m - 1) {
				ans = cur[2];
				return;
			}
			for (int i = 0; i < 4; i++) {
				ny = cur[0] + dy[i];
				nx = cur[1] + dx[i];
				br = cur[3];
				if (ny < 0 || ny >= n || nx < 0 || nx >= m)
					continue;
				if (map[ny][nx] == '1') {
					if (br != 1)
						continue;
					br = 0;
				}
				if (visited[ny][nx][br])
					continue;
				visited[ny][nx][br] = true;

				q.offer(new int[] { ny, nx, cur[2] + 1, br });
			}
		}

	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
