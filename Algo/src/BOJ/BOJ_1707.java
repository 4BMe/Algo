package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1707 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int k;
	static int v, e;
	static List<Integer>[] map;
	static int[] p;

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());

		map = new ArrayList[v + 1];

		for (int i = 1; i <= v; i++) {
			map[i] = new ArrayList<>();
		}

		int start, dest;
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			dest = Integer.parseInt(st.nextToken());
			map[start].add(dest);
			map[dest].add(start);
		}

		p = new int[v + 1];
	}

	static void solve() {
		for (int i = 1; i <= v; i++) {
			if (dfs(i)) {
				sb.append("NO\n");
				return;
			}
		}
		sb.append("YES\n");
	}

	static boolean dfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(start);

		int cur, next;
		while (!q.isEmpty()) {
			cur = q.poll();
			if (p[cur] == 0)
				p[cur] = 1;
//			System.out.println(cur + " " + p[cur]);
			for (int i = 0, c = map[cur].size(); i < c; i++) {
				next = map[cur].get(i);
				if (p[next] == p[cur]) {

					return true;
				} else if (p[next] == -p[cur]) {
					continue;
				} else {
					p[next] = -p[cur];
					q.offer(next);
				}
			}
		}
		
		return false;
	}

	public static void main(String[] args) throws Exception {

		k = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		for (int test = 0; test < k; test++) {
			init();
			solve();
		}
		System.out.println(sb);
	}

}
