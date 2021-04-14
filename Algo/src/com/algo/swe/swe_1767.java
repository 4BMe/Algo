package com.algo.swe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class swe_1767 {

	static class Point {
		int y, x;

		Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}

	static int T;
	static int N;
	static boolean[][] visited;
	static List<Point> p = new LinkedList<Point>();
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };
	static int[] answer;
	static int mcnt = 0;

	static void track(int y, int x, int dir, boolean v) {

		while (true) {
			y += dy[dir];
			x += dx[dir];
			if (y < 0 || y >= N || x < 0 || x >= N || visited[y][x] == v)
				break;
			visited[y][x] = v;
		}

	}

	static boolean check(int y, int x, int dir) {
		while (true) {
			y += dy[dir];
			x += dx[dir];
			if (y < 0 || y >= N || x < 0 || x >= N) {
				return true;
			}
			if (visited[y][x] == true) {
				return false;
			}
		}
	}

	static void go(int idx, int r, int cnt) {

		if (idx == p.size()) {
			answer[cnt] = Math.min(answer[cnt], r);
			mcnt = Math.max(mcnt, cnt);
			return;
		}
		if (p.size() - idx + cnt < mcnt)
			return;

		int y = p.get(idx).y;
		int x = p.get(idx).x;
		if (y == 0 || x == 0 || y == N - 1 || x == N - 1)
			go(idx + 1, r, cnt + 1);
		else
			for (int i = 0; i < 4; i++) {
				if (check(y, x, i)) {
					track(y, x, i, true);
					if (i == 0)
						go(idx + 1, r + N - 1 - x, cnt + 1);
					else if (i == 1)
						go(idx + 1, r + x, cnt + 1);
					else if (i == 2)
						go(idx + 1, r + N - 1 - y, cnt + 1);
					else
						go(idx + 1, r + y, cnt + 1);
					track(y, x, i, false);
				}
				go(idx + 1, r, cnt);

			}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(in.readLine());
		for (int test = 1; test <= T; test++) {
			N = Integer.parseInt(in.readLine());
			visited = new boolean[N][N];
			answer = new int[14];
			for (int i = 1; i <= 13; i++)
				answer[i] = 987654321;
			mcnt = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					if (st.nextToken().equals("1")) {
						p.add(new Point(i, j));
						visited[i][j] = true;
					}
				}
			}
			go(0, 0, 0);
			System.out.println("#" + test + " " + answer[mcnt]);
			p.clear();
		}
	}

}
