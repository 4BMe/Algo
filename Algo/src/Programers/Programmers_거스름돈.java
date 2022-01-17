package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Programmers_거스름돈 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n = 5;
	static int[] money = { 1, 2, 5 };

	static int solution(int n, int[] money) {
		int[] dp = new int[n + 1];
		dp[0] = 1;

		for (int j = 0, c = money.length; j < c; j++) {
			for (int i = money[j]; i <= n; i++) {
				dp[i] += dp[i - money[j]];
			}
		}

		return dp[n];
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solution(n, money));
	}

}