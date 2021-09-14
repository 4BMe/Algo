package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15961_2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n, d, k, c;
	static int[] shi;
	static int[] eat;
	static int ans = 0;

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		shi = new int[n];
		eat = new int[d + 1];

		for (int i = 0; i < n; i++) {
			shi[i] = Integer.parseInt(br.readLine());
		}
	}

	static void solve() {
		int res = 0;
		for (int i = 0; i < k; i++) {
			if (eat[shi[i]] == 0) {
				res++;
			}
			eat[shi[i]]++;
		}
		ans = Math.max(ans, eat[c] == 0 ? res + 1 : res);
		for (int i = k; i < n + k; i++) {
			int old = shi[(i - k) % n];
			int ne = shi[i % n];

			int eold = --eat[old];
			if (eold == 0)
				res--;
			int enew = ++eat[ne];
			if (enew == 1)
				res++;
			ans = Math.max(ans, eat[c] == 0 ? res + 1 : res);
		}
		System.out.println(ans);
	}

	public static void main(String[] args) throws Exception {
		init();
		solve();
	}

}
