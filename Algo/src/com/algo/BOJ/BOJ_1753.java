package com.algo.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1753 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int v, e;
	static List<int[]>[] node;
	static int[] dist;
	static boolean[] check;
	static int start;

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(br.readLine());
		dist = new int[v + 1];
		check = new boolean[v + 1];
		node = new ArrayList[v + 1];

		for (int i = 1; i <= v; i++)
			dist[i] = Integer.MAX_VALUE;

		for (int i = 1; i <= v; i++) {
			node[i] = new ArrayList<int[]>();
		}

		int s, to, cost;
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			cost = Integer.parseInt(st.nextToken());
			node[s].add(new int[] { to, cost });
		}

	}

	static void dijkstra(int start) {
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		q.offer(new int[] { start, 0 });
		dist[start] = 0;

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			if (check[cur[0]])
				continue;
			check[cur[0]] = true;

			for (int i = 0, c = node[cur[0]].size(); i < c; i++) {
				if (dist[node[cur[0]].get(i)[0]] > dist[cur[0]] + node[cur[0]].get(i)[1]) {
					dist[node[cur[0]].get(i)[0]] = dist[cur[0]] + node[cur[0]].get(i)[1];
					q.offer(new int[] { node[cur[0]].get(i)[0], dist[node[cur[0]].get(i)[0]] });
				}
			}
		}
		for (int i = 1; i <= v; i++) {
			if (dist[i] == Integer.MAX_VALUE)
				System.out.println("INF");
			else
				System.out.println(dist[i]);
		}
	}

	public static void main(String[] args) throws Exception {

		init();
		dijkstra(start);
	}

}
