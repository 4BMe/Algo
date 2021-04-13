package src.com.algo.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1107 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int n, m;
	static boolean[] p = new boolean[12];
	static int[] dp = new int[500001];

	static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		Arrays.fill(p, true);

		if (m > 0)
			st = new StringTokenizer(br.readLine());
		String a;
		for (int i = 0; i < m; i++) {
			a = st.nextToken();
			if (a.equals("+"))
				p[10] = false;
			else if (a.equals("-"))
				p[11] = false;
			else
				p[Integer.parseInt(a)] = false;
		}
	}

	static void solve() {
		if (n == 100) {
			System.out.println(0);
			return;
		}
		int answer = Math.abs(n - 100);

		for (int i = 0; i < 1000001; i++) {
			int len = possible(i);
			if (len > 0) {
				int press = Math.abs(i - n);
				answer = Math.min(answer, len + press);
			}
		}

		System.out.println(answer);
	}

	static int possible(int c) {
		if (c == 0) {
			if (p[0])
				return 1;
			else
				return 0;
		}

		int cnt = 0;
		while (c > 0) {
			if (!p[c % 10])
				return 0;
			cnt++;
			c /= 10;
		}

		return cnt;
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
