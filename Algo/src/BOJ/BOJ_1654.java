package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1654 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n;
	static int k;
	static long[] len;

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		k = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		len = new long[k];
		for (int i = 0; i < k; i++) {
			len[i] = Long.parseLong(br.readLine());
		}
	}

	static void solve() {
		long ans = 0;
		Arrays.sort(len);
		long left = 1;
		long right = len[k - 1];

		while (left <= right) {
			long mid = (left + right) / 2;
			long mcnt = 0;

			for (long a : len) {
				mcnt += a / mid;
			}

			if (mcnt >= n) {
				left = mid + 1;
				ans = Math.max(ans, mid);
			} else if (mcnt < n) {
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
