package a;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Mario {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n;
	static int[] map = new int[1000];
	static int[] memo = new int[1000];

	static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++)
			map[i] = Integer.parseInt(st.nextToken());
	}

	static void solve() {
		System.out.println(jump(n));
	}

	static int jump(int now) {
		if (now < 0)
			return 0;
		if (memo[now] != 0)
			return memo[now];
		if (now < n) {

			return memo[now] = map[now] + Math.max(jump(now - 7), jump(now - 2));
		}
		return Math.max(jump(now - 7), jump(now - 2));
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
