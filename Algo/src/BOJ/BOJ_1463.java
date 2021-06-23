package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1463 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int dp[];
	static int n;

	static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		dp = new int[n + 3];
		dp[1] = 0;
		dp[2] = 1;
		dp[3] = 1;

		for (int i = 4; i <= n; i++) {
			dp[i] = dp[i - 1] + 1;
			dp[i] = Math.min(dp[i], dp[i / 3] + i % 3 + 1);
			dp[i] = Math.min(dp[i], dp[i / 2] + i % 2 + 1);
		}

		System.out.println(dp[n]);
	}

	public static void main(String[] args) throws Exception {

		init();

	}

}
