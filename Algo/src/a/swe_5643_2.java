package a;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class swe_5643_2 {

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

	static boolean isExist(int start) {

		int p;
		for (int i = 0, c = parent[start].size(); i < c; i++) {
			p = parent[start].get(i);
			if (child[p].size() > 1)
				return false;
		}

		return false;
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
