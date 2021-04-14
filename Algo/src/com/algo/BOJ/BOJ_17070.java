package com.algo.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17070 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;
	static int[][] map;
	static int[] dy = { 0, 1, 1 };
	static int[] dx = { 1, 1, 0 };
	static int ans;

	static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	static void solve() {
		Queue<int[]> q = new LinkedList<int[]>();

		q.offer(new int[] { 0, 1, 0 });

		int[] cur;
		int y, x;
		while (!q.isEmpty()) {
			cur = q.poll();
			if (cur[0] == n - 1 && cur[1] == n - 1) {
				ans++;
				continue;
			}
			for (int i = 0; i < 3; i++) {
				if (cur[2] == 0 && i == 2)
					continue;
				if (cur[2] == 2 && i == 0)
					continue;
				y = cur[0] + dy[i];
				x = cur[1] + dx[i];
				if (y < 0 || y >= n || x < 0 || x >= n || map[y][x] == 1)
					continue;
				if (i == 1 && (map[y - 1][x] == 1 || map[y][x - 1] == 1))
					continue;
				q.offer(new int[] { y, x, i });
			}

		}

		System.out.println(ans);

	}

	public static void main(String[] args) throws Exception {

		init();
		solve();

	}

}