package hard;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2110 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n, c;
	static int[] house;

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		house = new int[n];

		for (int i = 0; i < n; i++) {
			house[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(house);
	}

	static void solve() {
		int left = 1, right = house[n - 1] - house[0], ans = -1;

		while (left <= right) {
			int mid = (left + right) / 2;
			int start = house[0];
			int cnt = 1;

			for (int i = 1; i < n; i++) {
				int d = house[i] - start;
				if (mid <= d) {
					cnt++;
					start = house[i];
				}
			}

			if (cnt >= c) {
				ans = mid;
				left = mid + 1;
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