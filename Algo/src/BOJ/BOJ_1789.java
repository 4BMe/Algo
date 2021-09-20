package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1789 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static long s;

	static void init() throws Exception {
		s = Long.parseLong(br.readLine());
	}

	static void solve() {
		long sum = 0;
		int ans = 0;
		while (sum <= s) {
			sum += ++ans;
		}
		System.out.println(sum == s ? ans : ans - 1);
	}

	public static void main(String[] args) throws Exception {
		init();
		solve();
	}

}
