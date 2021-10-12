package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14929 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n;
	static long[] arr;
	static long asum = 0;

	static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		arr = new long[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
			asum += arr[i];
		}
	}

	static void solve() {
		long ans = 0;
		for (int i = 0; i < n; i++) {
			asum -= arr[i];
			ans += asum * arr[i];
		}

		System.out.println(ans);
	}

	public static void main(String[] args) throws Exception {
		init();
		solve();
	}

}