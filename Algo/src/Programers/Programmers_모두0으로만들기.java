package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Programmers_모두0으로만들기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int[] a = { -2, 8, -5, -5, -3, 0, 5, 2 };
	static int[][] edges = { { 0, 1 }, { 0, 2 }, { 1, 3 }, { 1, 4 }, { 1, 5 }, { 2, 6 }, { 2, 7 } };
	static long[] values;
	static int[] p;
	static boolean[] v;
	static List<Integer>[] map;
	static long ans = 0;

	static long solution(int[] a, int[][] edges) {
		values = new long[a.length];
		for (int i = 0, c = a.length; i < c; i++) {
			values[i] = a[i];
		}
		long sum = 0;
		for (int i = 0, c = a.length; i < c; i++) {
			sum += a[i];
		}
		if (sum != 0) {
			return -1;
		}

		map = new ArrayList[a.length];
		for (int i = 0, c = a.length; i < c; i++) {
			map[i] = new ArrayList<>();
		}
		p = new int[a.length];
		v = new boolean[a.length];

		for (int i = 0, c = edges.length; i < c; i++) {
			int parent = edges[i][1];
			int child = edges[i][0];
			map[parent].add(child);
			map[child].add(parent);
			p[parent]++;
			p[child]++;
		}
		int root = 0;
		for (int b : p) {
			if (b == 1) {
				root = b;
				break;
			}
		}
		v[root] = true;
		for (int i = 0, c = map[root].size(); i < c; i++) {
			dfs(root, map[root].get(i));
		}
		return ans;
	}

	static void dfs(int parent, int now) {
		v[now] = true;
		if (p[now] != 1) {
			for (int i = 0, c = map[now].size(); i < c; i++) {
				int next = map[now].get(i);
				if (v[next]) {
					continue;
				}
				dfs(now, next);
			}
		}
		values[parent] += values[now];
		ans += Math.abs(values[now]);
		p[parent]--;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solution(a, edges));
	}

}