package com.algo.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_21773 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int t, n;
	static PriorityQueue<int[]> q;

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		t = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		q = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[2] > o2[2])
					return -1;
				else if (o1[2] == o2[2]) {
					return o1[0] - o2[0];
				}
				return 1;
			}
		});

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			q.offer(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()) });
		}
	}

	static void solve() {
		int[] cur;
		sb = new StringBuilder();
		for (int i = 0; i < t; i++) {
			cur = q.poll();
			sb.append(cur[0] + "\n");
			cur[1]--;
			cur[2]--;
			if (cur[1] != 0)
				q.offer(cur);
		}
		System.out.println(sb);
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
