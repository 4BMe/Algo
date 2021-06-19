package com.algo.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_21771 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int r, c;
	static int rg, cg;
	static int rp, cp;
	static String[] map;

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new String[r];

		st = new StringTokenizer(br.readLine());
		rg = Integer.parseInt(st.nextToken());
		cg = Integer.parseInt(st.nextToken());
		rp = Integer.parseInt(st.nextToken());
		cp = Integer.parseInt(st.nextToken());

		for (int i = 0; i < r; i++)
			map[i] = br.readLine();
	}

	static void solve() {
		int cnt = rp * cp;

		for (int i = 0; i < r; i++)
			for (int j = 0; j < c; j++)
				if (map[i].charAt(j) == 'P') {
					cnt--;
				}
		if (cnt != 0)
			System.out.println(1);
		else
			System.out.println(0);
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
