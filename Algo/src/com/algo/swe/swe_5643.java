package com.algo.swe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class swe_5643 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int t;
	static int n, m;
	static List<Integer>[] parent;
	static List<Integer>[] child;
	static boolean[] visited;
	static int answer;

	static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		parent = new ArrayList[n + 1];
		child = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			parent[i] = new ArrayList<>();
			child[i] = new ArrayList<>();
		}

		int p, c;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			p = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			child[p].add(c);
			parent[c].add(p);
		}

		answer = 0;
	}

	static void solve() {

		for (int i = 1; i <= n; i++) {
			visited = new boolean[n + 1];
			bfsP(i);
			bfsC(i);
			if (isKnow())
				answer++;
		}

		sb.append(answer + "\n");
	}

	static boolean isKnow() {
		for (int i = 1; i <= n; i++)
			if (!visited[i])
				return false;
		return true;
	}

	static void bfsP(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(start);
		visited[start] = true;

		int cur, next;
		while (!q.isEmpty()) {
			cur = q.poll();
			for (int i = 0, c = parent[cur].size(); i < c; i++) {
				next = parent[cur].get(i);
				if (visited[next])
					continue;
				q.offer(next);
				visited[next] = true;
			}
		}

	}

	static void bfsC(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(start);
		visited[start] = true;

		int cur, next;
		while (!q.isEmpty()) {
			cur = q.poll();
			for (int i = 0, c = child[cur].size(); i < c; i++) {
				next = child[cur].get(i);
				if (visited[next])
					continue;
				q.offer(next);
				visited[next] = true;
			}
		}

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
