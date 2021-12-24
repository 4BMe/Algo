package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Programmers_피보나치수 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n = 0;

	static int solve(int n) {
		int[] dp = new int[n];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i < n; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
		}
		return dp[n - 1];
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solve(n));
	}

}