package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_20366 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n;
	static int[] num;

	static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		num = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			num[i] = Integer.parseInt(st.nextToken());
	}

	static void solve() {
		Arrays.sort(num);
		int ans = Integer.MAX_VALUE;

		for (int i = 0; i < n - 3; i++) {
			for (int j = i + 3; j < n; j++) {
				int left = i + 1;
				int right = j - 1;

				while (left < right) {
					int res = num[left] + num[right] - num[i] - num[j];
					if (ans > Math.abs(res)) {
						ans = Math.abs(res);
					}
					if (res > 0)
						right = right - 1;
					else
						left = left + 1;
				}
			}
		}
		System.out.println(ans);
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
