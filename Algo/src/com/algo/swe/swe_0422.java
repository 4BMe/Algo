package com.algo.swe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swe_0422 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int t, n;
	static char[][] map;
	static int[][] J;
	static int[] dy = { 1, 1, 1, -1, -1, -1, 0, 0 };
	static int[] dx = { -1, 0, 1, -1, 0, 1, 1, -1 };
	static int answer;

	static void init() throws Exception {
		n = Integer.parseInt(br.readLine());

		map = new char[n][n];
		J = new int[n][n];

		String s;
		for (int i = 0; i < n; i++) {
			s = br.readLine();
			for (int j = 0; j < n; j++)
				map[i][j] = s.charAt(j);
		}

		answer = 0;
	}

	static void solve() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				if (map[i][j] == '.')
					J[i][j] = find(i, j);
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				if (J[i][j] == 0 && map[i][j] == '.') {
					answer++;
					bfs(i, j);
				}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				if (map[i][j] == '.')
					answer++;
		}
		sb.append(answer + "\n");
	}

	static void bfs(int y, int x) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { y, x });
		map[y][x] = '0';

		int[] cur;
		while (!q.isEmpty()) {
			cur = q.poll();
			for (int i = 0; i < 8; i++) {
				y = cur[0] + dy[i];
				x = cur[1] + dx[i];
				if (y < 0 || y >= n || x < 0 || x >= n || map[y][x] != '.')
					continue;
				if (J[y][x] == 0)
					q.offer(new int[] { y, x });
				map[y][x] = (char) (J[y][x] + '0');

			}
		}

	}

	static int find(int y, int x) {
		int ny, nx;
		int cnt = 0;
		for (int i = 0; i < 8; i++) {
			ny = y + dy[i];
			nx = x + dx[i];
			if (ny < 0 || ny >= n || nx < 0 || nx >= n)
				continue;
			if (map[ny][nx] == '*')
				cnt++;
		}

		return cnt;
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
