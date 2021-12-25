package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Programmers_N으로표현 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int number = 0;
	static int N = 0;
	static int ans = Integer.MAX_VALUE;

	static int solve(int N, int number) {
		dfs(N, number, 0, 0);
		return ans;
	}

	static void dfs(int N, int number, int cnt, int res) {
		if (cnt > 8) {
			return;
		}
		if (res == number) {
			ans = Math.min(ans, cnt);
		}

		int nn = 0;
		for (int i = 0; i < 8; i++) {
			nn *= 10;
			nn += N;
			dfs(N, number, cnt + 1 + i, res + nn);
			dfs(N, number, cnt + 1 + i, res - nn);
			dfs(N, number, cnt + 1 + i, res / nn);
			dfs(N, number, cnt + 1 + i, res * nn);
		}
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solve(N, number));
	}

}