package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2417 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static long n;

	static void init() throws Exception {
		n = Long.parseLong(br.readLine());
	}

	static void solve() {
		long ans = (long) Math.sqrt(n);
		long ansD = ans * ans;
		System.out.println(ansD >= n ? ans : ans + 1);
	}

	public static void main(String[] args) throws Exception {
		init();
		solve();
	}

}
