package com.algo.swe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swe_4615_x {
	static class Point {
		int y, x, c;

		Point(int y, int x, int c) {
			super();
			this.y = y;
			this.x = x;
			this.c = c;
		}
	}

	static int T;
	static int N;
	static int M;
	static String[][] map;
	static int[] dy = { 0, 0, 1, -1, -1, -1, 1, 1 };
	static int[] dx = { 1, -1, 0, 0, -1, 1, -1, 1 };

	static void init() {
		map = new String[N][N];
		int t = N / 2;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				map[i][j] = "0";

		map[t - 1][t - 1] = "2";
		map[t - 1][t] = "1";
		map[t][t - 1] = "1";
		map[t][t] = "2";
	}

	static boolean check(int y, int x, String c, int dir) {
		int ny, nx;
		ny = y;
		nx = x;
		while (true) {
			ny += dy[dir];
			nx += dx[dir];
			if (ny < 0 || ny >= N || nx < 0 || nx >= N) {
				return false;
			}
			if (map[ny][nx].equals(c)) {
				return true;
			}
		}
	}

	static void turn(int y, int x, String c, int dir) {
		while (true) {
			y += dy[dir];
			x += dx[dir];
			if (y < 0 || y >= N || x < 0 || x >= N)
				return;
			if (map[y][x].equals(c))
				return;

			map[y][x] = c;
		}
	}

	static void go(int y, int x, String c) {
//		System.out.println(y + " " + x + " 그리기 " + c);
		for (int i = 0; i < 8; i++) {
			if (check(y, x, c, i)) {
				map[y][x] = c;
//				System.out.println(i);
				turn(y, x, c, i);
			}
		}
//		System.out.println();
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++)
//				System.out.print(map[i][j] + " ");
//			System.out.println();
//		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int y, x;
		String c;
		int bcnt, wcnt;
		bcnt = wcnt = 0;

		T = Integer.parseInt(st.nextToken());
		for (int test = 1; test <= T; test++) {
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			init();

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(in.readLine());
				x = Integer.parseInt(st.nextToken()) - 1;
				y = Integer.parseInt(st.nextToken()) - 1;
				c = st.nextToken();
				go(y, x, c);
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j].equals("1"))
						bcnt++;
					else if (map[i][j].equals("2"))
						wcnt++;
				}
			}

			System.out.println("#" + test + " " + bcnt + " " + wcnt);
		}
	}

}
