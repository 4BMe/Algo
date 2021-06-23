package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260 {

	static int N;
	static int M;
	static int start;
	static ArrayList<Integer>[] map;
	static boolean[] visited;
	static Queue<Integer> q;

	static void bfs(int start) {
		q = new LinkedList<Integer>();

		q.add(start);
		visited[start] = true;

		int now;
		while (!q.isEmpty()) {
			now = q.peek();
			q.poll();
			System.out.print(now + " ");
			for (int i = 0, c = map[now].size(); i < c; i++) {
				if (visited[map[now].get(i)])
					continue;
				q.add(map[now].get(i));
				visited[map[now].get(i)] = true;
			}
		}
	}

	static void dfs(int idx) {
		if (visited[idx])
			return;
		System.out.print(idx + " ");
		visited[idx] = true;

		for (int i = 0, c = map[idx].size(); i < c; i++) {
			if (visited[map[idx].get(i)])
				continue;
			dfs(map[idx].get(i));
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());

		map = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			map[i] = new ArrayList<Integer>(N);
		}

		int from, to;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			map[from].add(to);
			map[to].add(from);
		}

		for (int i = 1; i <= N; i++) {
			map[i].sort(null);
		}

		visited = new boolean[N + 1];
		dfs(start);
		System.out.println();
		visited = new boolean[N + 1];
		bfs(start);

	}

}
