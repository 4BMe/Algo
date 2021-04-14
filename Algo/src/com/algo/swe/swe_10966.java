package com.algo.swe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swe_10966 {
	static class P {
		int y, x, cnt;

		P(int y, int x, int cnt) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
	}

	static int T, N, M;
	static Queue<P> q = new LinkedList<P>();;
	static String[] map;
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };
	static int[][] wcnt;

	static void go() {

		boolean[][] visited = new boolean[N][M];

		int y, x, ny, nx, cnt;
		while (!q.isEmpty()) {
			y = q.peek().y;
			x = q.peek().x;
			cnt = q.peek().cnt;
			q.poll();

			for (int i = 0; i < 4; i++) {
				ny = y + dy[i];
				nx = x + dx[i];
				if (ny < 0 || ny >= N || nx < 0 || nx >= M || visited[ny][nx] || map[ny].charAt(nx) == 'W')
					continue;
				wcnt[ny][nx] = cnt + 1;
				q.add(new P(ny, nx, cnt + 1));
				visited[ny][nx] = true;
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(in.readLine());
		for (int test = 1; test <= T; test++) {
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new String[N];

			for (int i = 0; i < N; i++) {
				map[i] = in.readLine();
				for (int j = 0, c = map[i].length(); j < c; j++) {
					if (map[i].charAt(j) == 'W') {
						q.add(new P(i, j, 0));
					}
				}
			}
			wcnt = new int[N][M];
			go();
			int answer = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i].charAt(j) == 'L') {
						answer += wcnt[i][j];
					}
				}
			}
			System.out.println("#" + test + " " + answer);
		}
	}

}
