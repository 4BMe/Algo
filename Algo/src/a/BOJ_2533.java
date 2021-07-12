package a;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2533 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n;
	static int[] lvcnt;
	static int depth = 1;
	static int[] dp;
	static List<Integer>[] graph;
	static boolean[] visited;

	static void init() throws Exception {
		n = Integer.parseInt(br.readLine());

		graph = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++)
			graph[i] = new ArrayList<>();

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}

		lvcnt = new int[n + 2];
		visited = new boolean[n + 1];
		visited[1] = true;
		dfs(1, 1);
		
		dp = new int[depth + 1];
		Arrays.fill(dp, 1000000);
	}

	static void dfs(int idx, int dep) {
		depth = Math.max(depth, dep);
		lvcnt[dep]++;
		for (int i = 0, s = graph[idx].size(); i < s; i++) {
			int next = graph[idx].get(i);
			if (visited[next])
				continue;
			visited[next] = true;
			dfs(next, dep + 1);
		}
	}

	static void solve() {

	}

	public static void main(String[] args) throws Exception {
		init();
		solve();
	}

}
