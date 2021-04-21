package com.algo.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15683 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n, m;
	static int[][] map;
	static int[][] temp;
	static int answer = Integer.MAX_VALUE;
	static List<int[]> cctvl = new LinkedList<int[]>();
	static int[] cc_dir;

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		temp = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0 || map[i][j] == 6)
					continue;
				cctvl.add(new int[] { i, j, map[i][j] });
			}
		}
		cc_dir = new int[cctvl.size()];
	}

	static void solve() {
		makeDir(0);
		System.out.println(answer);
	}

	static void makeDir(int idx) {
		if (idx == cctvl.size()) {
			copy();
			for (int i = 0, c = cctvl.size(); i < c; i++) {
				check(cctvl.get(i)[0], cctvl.get(i)[1], cctvl.get(i)[2], cc_dir[i]);
			}
			answer = Math.min(answer, cnt());
			return;
		}
		for (int i = 0; i < 4; i++) {
			cc_dir[idx] = i;
			makeDir(idx + 1);
		}
	}

	static void check(int y, int x, int cc, int dir) {
		if (cc == 1) {
			fill(y, x, dir);
		} else if (cc == 2) {
			if (dir % 2 == 0) {
				fill(y, x, 0);
				fill(y, x, 2);
			} else {
				fill(y, x, 1);
				fill(y, x, 3);
			}

		} else if (cc == 3) {
			if (dir == 0) {
				fill(y, x, 3);
				fill(y, x, dir);
			} else {
				fill(y, x, dir - 1);
				fill(y, x, dir);
			}
		} else if (cc == 4) {
			for (int i = 0; i < 4; i++) {
				if (i == (dir + 1) % 4)
					continue;
				fill(y, x, i);
			}
		} else if (cc == 5) {
			for (int i = 0; i < 4; i++)
				fill(y, x, i);
		}
	}

	static void fill(int y, int x, int dir) {
		if (dir == 0) {
			for (;;) {
				x++;
				if (x >= m || temp[y][x] == 6)
					break;
				if (temp[y][x] != 0)
					continue;
				temp[y][x] = -1;
			}
		} else if (dir == 1) {
			for (;;) {
				y++;
				if (y >= n || temp[y][x] == 6)
					break;
				if (temp[y][x] != 0)
					continue;
				temp[y][x] = -1;
			}
		} else if (dir == 2) {
			for (;;) {
				x--;
				if (x < 0 || temp[y][x] == 6)
					break;
				if (temp[y][x] != 0)
					continue;
				temp[y][x] = -1;
			}
		} else if (dir == 3) {
			for (;;) {
				y--;
				if (y < 0 || temp[y][x] == 6)
					break;
				if (temp[y][x] != 0)
					continue;
				temp[y][x] = -1;
			}
		}
	}

	static int cnt() {
		int r = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (temp[i][j] == 0)
					r++;
			}
		}
		return r;
	}

	static void copy() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				temp[i][j] = map[i][j];
			}
		}
	}

	static void print() {
		System.out.println();
		for (int i = 0; i < n; i++) {
			System.out.println();
			for (int j = 0; j < m; j++) {
				System.out.print(temp[i][j] + " ");
			}
		}
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
