package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3079 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n;
	static long m;
	static long[] arr;
	static long max = 0;

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Long.parseLong(st.nextToken());
		arr = new long[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(br.readLine());
			max = Math.max(0, arr[i]);
		}
	}

	static void solve() {
		long left = 1, right = max * m, ans = -1;

		while (left <= right) {
			long mid = (left + right) / 2;
			long cnt = 0;
			for (long gate : arr) {
				cnt += mid / gate;
			}
			if (cnt >= m) {
				ans = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}

		}
		System.out.println(ans);
	}

	public static void main(String[] args) throws Exception {
		init();
		solve();
	}

}