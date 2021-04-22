package com.algo.swe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swe_2115 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int t, n, c, m;
	static int[][] honey;
	static int answer;
	static int[] ch;
	static int[] r;

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		honey = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++)
				honey[i][j] = Integer.parseInt(st.nextToken());
		}
		ch = new int[2];
		r = new int[2];
		answer = 0;
	}

	static void solve() {
		choose(0, 0);
		sb.append(answer + "\n");
	}

	static void choose(int idx, int cnt) {
		if (cnt == 2) {
			if (ch[0] / n != (ch[0] + m - 1) / n || ch[1] / n != (ch[1] + m - 1) / n || (ch[1] + m - 1) >= n * n)
				return;
			r[0] = r[1] = 0;
			take(ch[0], 0, 0, 0);
			take(ch[1], 0, 0, 1);
			answer = Math.max(r[0] + r[1], answer);
			return;
		}

		if (cnt == 1)
			idx += m - 1;

		for (int i = idx; i < n * n; i++) {
			ch[cnt] = i;
			choose(i + 1, cnt + 1);
		}
	}

	static void take(int idx, int sum, int total, int foot) {

		r[foot] = Math.max(r[foot], total);
		if (idx >= ch[foot] + m)
			return;
		int h = honey[idx / n][idx % n];
		if (sum + h <= c) {
			take(idx + 1, sum + h, total + h * h, foot);
		}
		take(idx + 1, sum, total, foot);

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
