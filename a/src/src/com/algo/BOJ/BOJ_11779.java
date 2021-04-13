package src.com.algo.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_11779 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m;
	static List<int[]>[] connect;
	static int[] dist;
	static int[] parent;
	static boolean[] visited;
	static int start, dest;

	static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		connect = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			connect[i] = new ArrayList<>();
		}

		dist = new int[n + 1];
		parent = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		visited = new boolean[n + 1];

		int from, to, cost;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			cost = Integer.parseInt(st.nextToken());
			connect[from].add(new int[] { to, cost });
		}
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		dest = Integer.parseInt(st.nextToken());

	}

	static void dijkstra(int start) {
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[1] - o2[1];
			}
		});

		q.offer(new int[] { start, 0 });
		dist[start] = 0;
		parent[1] = start;
		while (!q.isEmpty()) {
			int[] cur = q.poll();

			if (visited[cur[0]])
				continue;
			visited[cur[0]] = true;

			for (int i = 0, c = connect[cur[0]].size(); i < c; i++) {
				if (dist[connect[cur[0]].get(i)[0]] > dist[cur[0]] + connect[cur[0]].get(i)[1]) {
					dist[connect[cur[0]].get(i)[0]] = dist[cur[0]] + connect[cur[0]].get(i)[1];
					parent[connect[cur[0]].get(i)[0]] = cur[0];
					q.offer(new int[] { connect[cur[0]].get(i)[0], dist[connect[cur[0]].get(i)[0]] });
				}
			}
		}

		System.out.println(dist[dest]);
		Stack<Integer> s = find();
		System.out.println(s.size());
		StringBuilder sb = new StringBuilder();
		while (!s.empty()) {
			sb.append(s.pop() + " ");
		}
		System.out.println(sb);
	}

	static Stack<Integer> find() {
		Stack<Integer> stack = new Stack<>();
		int cur = dest;
		while (cur != start) {
			stack.push(cur);
			cur = parent[cur];
		}
		stack.push(cur);
		return stack;
	}

	public static void main(String[] args) throws Exception {

		init();
		dijkstra(start);
	}
}
