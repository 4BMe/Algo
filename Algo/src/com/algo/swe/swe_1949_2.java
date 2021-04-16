package com.algo.swe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swe_1949_2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int t, n, k;
	static int[][] map;
	static boolean[][] visited;
	static int answer;
	static Queue<int[]> q;
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		int max = 0;
		map = new int[n][n];
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] > max)
					max = map[i][j];
			}
		}

		answer = 0;
		q = new LinkedList<int[]>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == max) {
					visited[i][j] = true;
					dfs(i, j, k, 1);
					visited[i][j] = false;
				}
			}
		}
		sb.append(answer + "\n");
	}

	static void dfs(int y, int x, int dr, int cnt) {
		answer = Math.max(answer, cnt);
		int ny, nx, temp;
		for (int i = 0; i < 4; i++) {
			ny = y + dy[i];
			nx = x + dx[i];
			if (ny < 0 || ny >= n || nx < 0 || nx >= n || visited[ny][nx])
				continue;
			if (map[ny][nx] >= map[y][x]) {
				if (map[ny][nx] - dr < map[y][x]) {
					temp = map[ny][nx];
					map[ny][nx] = map[y][x] - 1;
					visited[ny][nx] = true;
					dfs(ny, nx, 0, cnt + 1);
					map[ny][nx] = temp;
					visited[ny][nx] = false;
				}
			} else {
				visited[ny][nx] = true;
				dfs(ny, nx, dr, cnt + 1);
				visited[ny][nx] = false;
			}
		}

	}

	public static void main(String[] args) throws Exception {

		sb = new StringBuilder();
		t = Integer.parseInt(br.readLine());
		for (int test = 1; test <= t; test++) {
			sb.append("#" + test + " ");
			init();
		}
		System.out.println(sb);
	}

}
