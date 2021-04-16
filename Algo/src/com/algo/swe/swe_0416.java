package com.algo.swe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swe_0416 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int t, y, x, k;
	static int[][] f;
	static int answer;
	static int[][] temp;

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		f = new int[y][x];
		temp = new int[y][x];
		for (int i = 0; i < y; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < x; j++) {
				f[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		answer = Integer.MAX_VALUE;

	}

	static void solve() {
		go(0, 0, 0, 0);
		sb.append(answer + "\n");
	}

	static boolean OK(int[][] temp) {

		int cnt, cmp;
		for (int j = 0; j < x; j++) {
			cnt = cmp = 1;
			for (int i = 1; i < y; i++) {
				if (temp[i][j] == temp[i - 1][j]) {
					cnt++;
				} else {
					cnt = 1;
				}
				cmp = Math.max(cnt, cmp);
			}
			if (cmp < k)
				return false;
		}

		return true;
	}

	static void go(int idx, int cnt, int Achange, int Bchange) {
		if (cnt > answer || cnt > k)
			return;
		if (idx == y) {
			copy(temp);
			for (int i = 0; i < y; i++) {
				if ((1 << i & Achange) > 0) {
					for (int j = 0; j < x; j++)
						temp[i][j] = 1;
				} else if ((1 << i & Bchange) > 0) {
					for (int j = 0; j < x; j++)
						temp[i][j] = 0;
				}
			}
			if (OK(temp))
				answer = Math.min(answer, cnt);
			return;
		}

		go(idx + 1, cnt + 1, Achange, Bchange + (1 << idx));
		go(idx + 1, cnt + 1, Achange + (1 << idx), Bchange);
		go(idx + 1, cnt, Achange, Bchange);
	}

	static void copy(int[][] temp) {
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				temp[i][j] = f[i][j];
			}
		}
	}

	public static void main(String[] args) throws Exception {
		sb = new StringBuilder();
		t = Integer.parseInt(br.readLine());
		for (int test = 1; test <= t; test++) {
			sb.append("#" + test + " ");
			init();
			solve();
		}
		System.out.println(sb);
	}

}
