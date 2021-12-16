package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Programmers_전력망을둘로나누기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int[][] wires = { { 1, 2 }, { 2, 3 }, { 3, 4 } };
	static int n = 4;
	static boolean[] visited;

	static int solve(int n, int[][] wires) {
		int ans = Integer.MAX_VALUE;
		int len = wires.length;

		List<Integer>[] conn = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			conn[i] = new ArrayList<Integer>();
		}
		for (int[] w : wires) {
			conn[w[0]].add(w[1]);
			conn[w[1]].add(w[0]);
		}

		boolean[] discon = new boolean[len];

		for (int i = 0; i < len; i++) {
			discon[i] = true;
			visited = new boolean[n + 1];
			int[] dis = wires[i];
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(1);
			visited[1] = true;
			int cnt = 1;
			while (!q.isEmpty()) {
				int cur = q.poll();
				for (int j = 0, c = conn[cur].size(); j < c; j++) {
					int next = conn[cur].get(j);
					if (visited[next] || (cur == dis[0] && next == dis[1]) || (cur == dis[1] && next == dis[0])) {
						continue;
					}
					visited[next] = true;
					cnt++;
					q.add(next);
				}
			}
			if (cnt != n) {
				ans = Math.min(ans, Math.abs(((n - cnt) - cnt)));
			}
			discon[i] = false;
		}

		return ans;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solve(n, wires));
	}

}