package com.algo.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1194 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n, m;
	static char[][] map;
	static boolean[][][] visited;
	static Queue<int[]> q;
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };
	static int answer = Integer.MAX_VALUE;

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		visited = new boolean[n][m][256];

		q = new LinkedList<int[]>();

		String t;
		for (int i = 0; i < n; i++) {
			t = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = t.charAt(j);
				if (map[i][j] == '0') {
					// y, x, 이동횟수, key값
					q.offer(new int[] { i, j, 0, 0 });
					visited[i][j][0] = true;
					map[i][j] = '.';
				}
			}
		}
	}

	static void solve() {

		int[] cur;
		int ny, nx;
		while (!q.isEmpty()) {
			cur = q.poll();
			for (int i = 0; i < 4; i++) {
				ny = cur[0] + dy[i];
				nx = cur[1] + dx[i];
				if (ny < 0 || ny >= n || nx < 0 || nx >= m)
					continue;
				if (map[ny][nx] == '#' || visited[ny][nx][cur[3]]) {
					continue;
				}
				// y, x, 이동횟수, key값
				if (map[ny][nx] == '1') {
					answer = Math.min(answer, cur[2] + 1);
				} else if (map[ny][nx] == '.') {
					q.offer(new int[] { ny, nx, cur[2] + 1, cur[3] });
					visited[ny][nx][cur[3]] = true;
				} else {
					if (isKey(ny, nx)) {
						if ((cur[3] & 1 << map[ny][nx] - 'a') == 0) {
							q.offer(new int[] { ny, nx, cur[2] + 1, cur[3] + (1 << (map[ny][nx] - 'a')) });
							visited[ny][nx][cur[3] + (1 << (map[ny][nx] - 'a'))] = true;
						} else {
							q.offer(new int[] { ny, nx, cur[2] + 1, cur[3] });
							visited[ny][nx][cur[3]] = true;
						}
					} else {
						if ((cur[3] & (1 << map[ny][nx] - 'A')) >= 1) {
							q.offer(new int[] { ny, nx, cur[2] + 1, cur[3] });
							visited[ny][nx][cur[3]] = true;
						}
					}
				}
			}
		}
	}

	static boolean isKey(int y, int x) {
		int cmp = map[y][x] - 'a';
		if (0 <= cmp && cmp <= 'f' - 'a')
			return true;
		return false;
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
		if (answer == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(answer);
	}

}
