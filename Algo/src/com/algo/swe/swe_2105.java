package com.algo.swe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swe_2105 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int t, n;
	static int[][] map;
	static boolean[] dessert;
	static int answer;

	static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		answer = 0;
	}

	static void solve() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int w = 1; w < n; w++) {
					for (int h = 1; h < n; h++) {
						if (!inbound(i + h, j - h) || !inbound(i + w, j + w) || !inbound(i + h + w, j - h + w))
							continue;
						search(i, j, w, h);
					}
				}
			}
		}
		sb.append(" " + (answer == 0 ? -1 : answer) + "\n");
	}

	static boolean inbound(int y, int x) {
		if (y < 0 || y >= n || x < 0 || x >= n)
			return false;
		return true;
	}

	static void search(int y, int x, int w, int h) {
		dessert = new boolean[101];
		dessert[map[y][x]] = true;
		int cnt = 1;

		for (int i = 1; i <= h; i++) {
			if (dessert[map[y + i][x - i]])
				return;
			dessert[map[y + i][x - i]] = true;
			cnt++;
		}

		for (int i = 1; i <= w; i++) {
			if (dessert[map[y + i][x + i]])
				return;
			dessert[map[y + i][x + i]] = true;
			cnt++;
		}

		for (int i = 1; i <= w; i++) {
			if (dessert[map[y + h + i][x - h + i]])
				return;
			dessert[map[y + h + i][x - h + i]] = true;
			cnt++;
		}

		for (int i = 1; i < h; i++) {
			if (dessert[map[y + w + i][x + w - i]])
				return;
			dessert[map[y + w + i][x + w - i]] = true;
			cnt++;
		}

		answer = Math.max(answer, cnt);
	}

	public static void main(String[] args) throws Exception {

		t = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		for (int test = 1; test <= t; test++) {
			sb.append("#" + test);
			init();
			solve();
		}
		System.out.println(sb);
	}

}
