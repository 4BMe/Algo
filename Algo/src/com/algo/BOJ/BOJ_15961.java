package com.algo.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15961 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n, d, k, c;
	static int[] sh;
	static int[] eat;
	static int answer;

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		sh = new int[n];
		for (int i = 0; i < n; i++) {
			sh[i] = Integer.parseInt(br.readLine());
		}

		eat = new int[d + 1];
		answer = 0;
	}

	static void solve() {

		int cnt = 0;
		for (int i = 0; i < k; i++) {
			if (eat[sh[i % n]] == 0)
				cnt++;
			eat[sh[i % n]]++;
		}
		answer = Math.max(answer, eat[c] == 0 ? cnt + 1 : cnt);

		go(0, cnt);
		System.out.println(answer);
	}

	static void go(int start, int cnt) {
		answer = Math.max(answer, eat[c] == 0 ? cnt + 1 : cnt);

		if (start >= n)
			return;
		eat[sh[start]]--;
		if (eat[sh[start]] == 0)
			cnt--;
		if (eat[sh[(start + k) % n]] == 0)
			cnt++;
		eat[sh[(start + k) % n]]++;
//				
//		System.out.println();
//		System.out.println(start + " " + (start + k) % n);
//		for (int i = start + 1; i <= start + k; i++) {
//			System.out.print(sh[i % n] + " ");
//		}
//		System.out.println();
//		for (int i = start + 1; i <= start + k; i++) {
//			System.out.print(eat[sh[i % n]] + " ");
//		}
//		System.out.println();
//		System.out.println(" " + cnt + " " + eat[c]);

		go(start + 1, cnt);
	}

	public static void main(String[] args) throws Exception {
		init();
		solve();
	}

}
