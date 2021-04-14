package com.algo.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_17135 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n, m, d;
	static int[][] map;
	static int ans;

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = 0;
	}

	static void solve() {
		List<Integer> archer = new ArrayList<Integer>();
		choose(0, 0, archer);
		System.out.println(ans);
	}

	static void choose(int idx, int cnt, List<Integer> archer) {
		if (cnt == 3) {
			go(archer);
			return;
		}
		if (idx >= m)
			return;
		archer.add(idx);
		choose(idx + 1, cnt + 1, archer);
		archer.remove(archer.size() - 1);
		choose(idx + 1, cnt, archer);
	}

	static void go(List<Integer> archer) {
		int[][] temp = new int[n][m];
		copyMap(temp);

		int res = 0;

		for (int w = 0; w < n; w++) {
			boolean[][] visited = new boolean[n][m];
			for (int a = 0, c = archer.size(); a < c; a++) {
				int now = archer.get(a);
				int minD = Integer.MAX_VALUE;
				int minY = Integer.MAX_VALUE;
				int minX = Integer.MAX_VALUE;
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						if (temp[i][j] == 1) {
							if (minD >= distance(i, n, j, now)) {
								if (minD > distance(i, n, j, now)) {
									minD = distance(i, n, j, now);
									minY = i;
									minX = j;
								} else {
									if (minX > j) {
										minY = i;
										minX = j;
									}
								}
							}
						}
					}
				}
				if (minD <= d) {
					visited[minY][minX] = true;
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (visited[i][j]) {
						temp[i][j] = 0;
						res++;
					}
				}
			}
			move(temp);
		}
		ans = Math.max(ans, res);
	}

	public static int distance(int r1, int r2, int c1, int c2) {
		return Math.abs(r1 - r2) + Math.abs(c1 - c2);
	}

	static void copyMap(int[][] temp) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++)
				temp[i][j] = map[i][j];
		}
	}

	static void move(int[][] temp) {
		for (int i = n - 1; i > 0; i--) {
			for (int j = 0; j < m; j++)
				temp[i][j] = temp[i - 1][j];
		}

		for (int j = 0; j < m; j++)
			temp[0][j] = 0;

	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
