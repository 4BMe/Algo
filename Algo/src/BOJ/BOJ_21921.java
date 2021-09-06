package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_21921 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n, x;
	static int[] arr;
	static int sum, ans, cnt;

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());

		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		sum = 0;
		ans = 0;
		cnt = 0;
	}

	static void solve() {
		for (int i = 0; i < x; i++) {
			sum += arr[i];
		}
		ans = sum;
		cnt = ans == 0 ? 0 : 1;

		for (int i = x; i < n; i++) {
			sum += arr[i] - arr[i - x];
			if (sum > ans) {
				ans = sum;
				cnt = 1;
			} else if (sum == ans)
				cnt++;
		}

		System.out.println(ans == 0 ? "SAD" : ans + "\n" + cnt);
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
