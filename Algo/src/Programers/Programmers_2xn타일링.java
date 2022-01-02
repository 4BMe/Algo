package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Programmers_2xn타일링 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n = 60000;

	static int solution(int n) {
		int[] dp = new int[60001];
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= n; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
		}
		return dp[n] % 1000000007;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solution(n));
	}

}