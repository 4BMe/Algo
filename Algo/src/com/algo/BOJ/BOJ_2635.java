package com.algo.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2635 {
	static int s;
	static int answer = 0;
	static int mcnt = 0;
	static int f;

	static void go(int first, int cnt) {
		int b = s;
		int n = first;
		int temp;
		while (true) {
			if (b - n >= 0) {
				temp = b - n;
				b = n;
				n = temp;
				cnt++;
			} else {
				if (cnt > mcnt) {
					mcnt = cnt;
					f = first;
				}
				return;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;

		s = Integer.parseInt(in.readLine());
		for (int i = 0; i < s; i++) {
			go(s - i, 2);
		}
		System.out.println(mcnt);
		System.out.print(s + " " + f + " ");
		int b, temp;
		b = s;
		while (b - f >= 0) {
			System.out.print(b - f + " ");
			temp = b - f;
			b = f;
			f = temp;
		}
	}

}
