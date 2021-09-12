package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2470 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n;
	static long[] num;

	static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		num = new long[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			num[i] = Long.parseLong(st.nextToken());
	}

	static void solve() {
		Arrays.sort(num);

		int left = 0;
		int right = n - 1;
		long[] ans = new long[2];
		long diff = 2000000001;

		while (left < right) {
			long ndiff = num[left] + num[right];

			if (Math.abs(ndiff) < diff) {
				diff = ndiff;
				ans[0] = num[left];
				ans[1] = num[right];
			}

			if (ndiff <= 0) {
				left++;
			} else
				right--;
		}
		System.out.println(ans[0] + " " + ans[1]);
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
