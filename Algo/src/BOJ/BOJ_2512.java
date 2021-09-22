package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2512 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n;
	static long[] budget;
	static long m;

	static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		budget = new long[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			budget[i] = Long.parseLong(st.nextToken());
		m = Long.parseLong(br.readLine());
	}

	static void solve() {
		Arrays.sort(budget);
		long left = 1;
		long right = budget[n - 1];
		long ans = 0;

		while (left <= right) {
			long mid = (left + right) / 2;
			long sum = 0;
			long max = 0;
			for (long a : budget) {
				long add = mid >= a ? a : mid;
				max = Math.max(max, add);
				sum += add;
			}
			if (sum <= m) {
				left = mid + 1;
				ans = Math.max(max, ans);
			} else {
				right = mid - 1;
			}
		}
		System.out.println(ans);
	}

	public static void main(String[] args) throws Exception {
		init();
		solve();
	}

}
