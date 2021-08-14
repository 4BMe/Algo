package a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TOSS_6 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;

	static void solve() throws NumberFormatException, IOException {
		int numOfStairs = Integer.parseInt(br.readLine());
		int[] dp = new int[numOfStairs +4];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		dp[4] = 7;
		if (numOfStairs >= 5) {
			for (int i = 5; i <= numOfStairs; i++) {
				dp[i] = dp[i - 1] + dp[i - 1] - dp[i - 4];
			}
		}
		System.out.println(dp[numOfStairs]);
	}

	public static void main(String[] args) throws Exception {

		solve();
	}

}
