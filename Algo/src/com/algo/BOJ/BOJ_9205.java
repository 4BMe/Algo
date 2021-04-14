package com.algo.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9205 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int t, n;
	static int[][] map;
	static String[] ans = { "happy", "sad" };
	static int[][] dist;
	static boolean[][] d;

	static void init() throws Exception {
		n = Integer.parseInt(br.readLine()) + 2;
		map = new int[n][2];
		dist = new int[n][n];
		d = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
		}
	}

	static void solve() {
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				dist[i][j] = Math.abs(map[i][0] - map[j][0]) + Math.abs(map[i][1] - map[j][1]);
				if (dist[i][j] <= 1000)
					d[i][j] = true;
			}

		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				if (i == k)
					continue;
				for (int j = 0; j < n; j++) {
					if (i == j)
						continue;
					if (d[i][k] && d[k][j]) {
						d[i][j] = true;
					}
				}

			}
		}

		if (d[0][n - 1])
			System.out.println("happy");
		else
			System.out.println("sad");

	}

	public static void main(String[] args) throws Exception {

		t = Integer.parseInt(br.readLine());
		for (int test = 1; test <= t; test++) {
			init();
			solve();
		}

	}

}
