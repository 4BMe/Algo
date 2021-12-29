package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Programmers_가장먼노드 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n = 6;
	static int[][] edge = { { 3, 6 }, { 4, 3 }, { 3, 2 }, { 1, 3 }, { 1, 2 }, { 2, 4 }, { 5, 2 } };

	static int solve(int n, int[][] edge) {
		List<Integer>[] link = new ArrayList[n + 1];
		int[] dist = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			link[i] = new ArrayList<Integer>();
		}
		for (int i = 0, c = edge.length; i < c; i++) {
			int from = edge[i][0];
			int to = edge[i][1];
			link[from].add(to);
			link[to].add(from);
		}

		Arrays.fill(dist, -1);
		dist[1] = 0;

		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { 1, 0 });
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int i = 0, c = link[cur[0]].size(); i < c; i++) {
				int next = link[cur[0]].get(i);
				if (dist[next] == -1 || dist[next] > cur[1] + 1) {
					q.add(new int[] { next, cur[1] + 1 });
					dist[next] = cur[1] + 1;
				}
			}
		}
		int ans = 0;
		int max = -1;
		for (int a : dist) {
			if (a > max) {
				max = a;
				ans = 1;
			} else if (a == max) {
				ans++;
			}
		}

		return ans;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solve(n, edge));
	}

}