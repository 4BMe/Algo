package SWE;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swe_0419 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int t, n, r;
	static int mod = 1234567891;
	static long[] fac;

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		fac = new long[n + 1];
		fac[0] = 1;
		for (int i = 1; i <= n; i++)
			fac[i] = (fac[i - 1] * i) % mod;
	}

	static void solve() {
		long a = (fac[r] * fac[n - r]) % mod;
		long b = fermat(a, mod - 2);

		sb.append((fac[n] * b) % mod + "\n");
	}

	static long fermat(long a, int x) {
		if (x == 0)
			return 1;
		long temp = fermat(a, x / 2);
		long result = (temp * temp) % mod;
		if (x % 2 == 0)
			return result;
		else
			return (result * a) % mod;
	}

	public static void main(String[] args) throws Exception {
		t = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		for (int test = 1; test <= t; test++) {
			sb.append("#" + test + " ");
			init();
			solve();
		}
		System.out.println(sb);
	}

}
