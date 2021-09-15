package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1806_2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n, s;
	static int[] num;

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		num = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
	}

	static void solve() {
		int ans = Integer.MAX_VALUE;

		int start = 0;
		int end = 0;

		int sum = num[start];

		while (start <= end) {
			if (sum < s) {
				if (end == n - 1)
					break;
				end++;
				sum += num[end];
			} else {
				ans = Math.min(ans, end - start + 1);
				sum -= num[start];
				start++;
			}
		}
		System.out.println(ans == Integer.MAX_VALUE ? 0 : ans);
	}

	public static void main(String[] args) throws Exception {
//		long beforeTime = System.currentTimeMillis();
		init();
		solve();
//		long afterTime = System.currentTimeMillis();
//		long secDiffTime = (afterTime - beforeTime) / 1000;
//		System.out.println("시간차이(m) : " + secDiffTime);
	}

}
