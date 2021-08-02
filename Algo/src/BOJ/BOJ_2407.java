package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ_2407 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n, m;

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

	}

	static void solve() {
		if (m == n || m == 0) {
			System.out.println(1);
			return;
		}

		BigInteger answer = BigInteger.ONE;
		m = n - m < m ? n - m : m;
		for (int i = n; i > n - m; i--) {
			answer = answer.multiply(new BigInteger(String.valueOf(i)));
		}
		for (int i = m; i > 0; i--) {
			answer = answer.divide(new BigInteger(String.valueOf(i)));
		}
		System.out.println(answer);
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
