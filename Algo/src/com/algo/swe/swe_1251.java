package com.algo.swe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class P {
	int y, x;
	double dist;

	public P(int y, int x, double dist) {
		this.y = y;
		this.x = x;
		this.dist = dist;
	}
}

public class swe_1251 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int t, n;
	static int[][] point;
	static double e;
	static PriorityQueue<P> q;
	static int[] parent;
	static boolean[] visited;
	static double ans;

	static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		point = new int[n][2];
		parent = new int[n];
		visited = new boolean[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			point[i][0] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			point[i][1] = Integer.parseInt(st.nextToken());

		e = Double.parseDouble(br.readLine());

		q = new PriorityQueue<>(new Comparator<P>() {
			@Override
			public int compare(P o1, P o2) {
				// TODO Auto-generated method stub
				if (o1.dist <= o2.dist)
					return -1;
				return 1;
			}
		});

		double x, y;
		for (int i = 0; i < n; i++)
			for (int j = i + 1; j < n; j++) {
				x = Math.abs(point[i][0] - point[j][0]);
				y = Math.abs(point[i][1] - point[j][1]);
				q.offer(new P(i, j, x * x + y * y));
			}

		for (int i = 0; i < n; i++)
			parent[i] = i;
		ans = 0;
	}

	static void solve() {
		P cur;
		while (!q.isEmpty()) {
			cur = q.poll();
			if (find(cur.y) == find(cur.x))
				continue;
			union(cur.y, cur.x);
			ans += e * cur.dist;
		}
		ans += 0.5;
	}

	static int find(int x) {
		if (parent[x] == x)
			return x;
		return parent[x] = find(parent[x]);
	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x <= y)
			parent[y] = x;
		else
			parent[x] = y;
	}

	public static void main(String[] args) throws Exception {

		t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			init();
			solve();
			System.out.println("#" + i + " " + (long) ans);
		}

	}

}
