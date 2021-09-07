package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20922 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n, k;
	static int[] num;
	static int[] cnt;
	static int ans;

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		num = new int[n];
		cnt = new int[100001];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			num[i] = Integer.parseInt(st.nextToken());
		ans = 0;
	}

	static void solve() {
		int start = 0;
		int end = 0;
		cnt[num[start]]++;

		while (true) {
			if (end == n - 1)
				break;
			end++;
			if (cnt[num[end]] < k) {
				cnt[num[end]]++;
				ans = Math.max(ans, end - start + 1);
			} else {
				cnt[num[start]]--;
				start++;
				end--;
			}
		}

		System.out.println(ans);
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
