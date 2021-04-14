package com.algo.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2875 {
	static int w, h, x, y, t;
	static int answer = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(in.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(in.readLine());
		x = (x + t) % (2 * w);
		y = (y + t) % (2 * h);
		x = w - Math.abs(w - x);
		y = h - Math.abs(h - y);
		
		System.out.println(x + " " + y);
	}

}
