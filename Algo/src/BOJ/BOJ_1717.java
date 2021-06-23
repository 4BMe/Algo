package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1717 {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M;
	static int[] parent;

	static int findP(int x) {
		if (parent[x] == x)
			return x;
		else
			return parent[x] = findP(parent[x]);
	}

	static void union(int x, int y) {
		x = findP(x);
		y = findP(y);
		if (x < y)
			parent[y] = x;
		else
			parent[x] = y;

	}

	static void solve() throws Exception {
		int a, from, to;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			a = Integer.parseInt(st.nextToken());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			if (a == 1) {
				if (findP(from) == findP(to)) {
					System.out.println("YES");
				} else
					System.out.println("NO");
			} else {
				union(from, to);
			}
		}
	}

	static void init() throws Exception {
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		solve();
	}

	public static void main(String[] args) throws Exception {

		init();

	}

}
