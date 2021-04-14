package com.algo.swe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swe_3289 {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int t, n, m;
	static int[] p;
	static StringBuilder sb;

	static int find(int x) {
		if (p[x] == x)
			return x;
		else
			return p[x] = find(p[x]);
	}

	static void union(int y, int x) {
		x = find(x);
		y = find(y);
		if (x < y)
			p[y] = x;
		else
			p[x] = y;
	}

	static void init() throws Exception {
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		p = new int[n + 1];
		sb = new StringBuilder();

		for (int i = 1; i < n + 1; i++)
			p[i] = i;
	}

	public static void main(String[] args) throws Exception {

		t = Integer.parseInt(in.readLine());
		for (int test = 1; test <= t; test++) {
			init();
			int a, from, to;
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(in.readLine());
				a = Integer.parseInt(st.nextToken());
				from = Integer.parseInt(st.nextToken());
				to = Integer.parseInt(st.nextToken());
				if (a == 0) {
					union(from, to);
				} else {
					if (find(from) == find(to))
						sb.append("1");
					else
						sb.append("0");
				}
			}
			System.out.println("#" + test + " " + sb);
		}

	}

}
