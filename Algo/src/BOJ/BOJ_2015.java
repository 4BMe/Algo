package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_2015 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n, k;
	static int[] arr;
	static int[] sum;

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n];
		sum = new int[n];

		st = new StringTokenizer(br.readLine());
		int add = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			add += arr[i];
			sum[i] = add;
		}
	}

	static void solve() {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, 1);
		long ans = 0;
		for (int i = 0; i < n; i++) {
			int cnt = map.getOrDefault(sum[i] - k, 0);
			ans += cnt;

			map.put(sum[i], map.getOrDefault(sum[i], 0) + 1);
		}
		System.out.println(ans);
	}

	public static void main(String[] args) throws Exception {
		init();
		solve();
	}

}