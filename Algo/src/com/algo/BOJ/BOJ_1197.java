package com.algo.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1197 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int v, e;
	static int[] p;
	static PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
		@Override
		public int compare(int[] o1, int[] o2) {
			// TODO Auto-generated method stub
			return o1[2] - o2[2];
		}
	});

	static int answer, cnt;

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		p = new int[v + 1];
		answer = cnt = 0;

		int s, t, d;
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			q.offer(new int[] { s, t, d });
		}

		for (int i = 1; i <= v; i++)
			p[i] = i;
		solve();
	}

	static void solve() {
		while (true) {
			int[] cur = q.poll();
			if (find(cur[0]) == find(cur[1]))
				continue;
			union(cur[0], cur[1]);
			answer += cur[2];
			cnt++;
			if (cnt == v - 1)
				break;
		}
		System.out.println(answer);
	}

	static int find(int x) {
		if (p[x] == x)
			return x;
		return p[x] = find(p[x]);
	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x < y)
			p[y] = x;
		else
			p[x] = y;
	}

	public static void main(String[] args) throws Exception {

		init();

	}

}
