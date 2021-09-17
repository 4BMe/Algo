package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_22862 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n, k;
	static int[] num;

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		num = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
	}

	static void solve() {
		int ans = 0;

		int start = 0;
		int end = 0;
		int odd = 0;
		int even = 0;
		if (num[start] % 2 == 0)
			even = ans = 1;
		else
			odd++;

		while (true) {
			end++;
			if (end == n)
				break;
			int now = num[end];
			if (now % 2 == 0) {
				even++;
				ans = Math.max(ans, even);
			} else {
				odd++;
				if (odd > k) {
					while (true) {
						if (num[start] % 2 == 0) {
							even--;
							start++;
						} else {
							odd--;
							start++;
							break;
						}
					}
				}
			}
		}

		System.out.println(ans);
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
