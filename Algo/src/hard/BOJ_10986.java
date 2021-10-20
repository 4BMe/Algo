package hard;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_10986 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n, m;
	static int[] arr;
	static int[] psum;
	static int[] p;

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		psum = new int[n];

		st = new StringTokenizer(br.readLine());
		int sum = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i] % m;
			psum[i] = sum % m;
		}
	}

	static void solve() {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, 1);
		long ans = 0;
		for (int i = 0; i < n; i++) {
			Long cnt = (long) map.getOrDefault(psum[i] % m == 0 ? 0 : psum[i] % m, 0);
			ans += cnt;

			map.put((psum[i] % m), map.getOrDefault(psum[i] % m, 0) + 1);
		}
		System.out.println(ans);
	}

	public static void main(String[] args) throws Exception {
		init();
		solve();
	}

}