package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Programmers_합승택시요금 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n = 6;
	static int s = 4;
	static int a = 6;
	static int b = 2;
	static int[][] fares = { { 4, 1, 10 }, { 3, 5, 24 }, { 5, 6, 2 }, { 3, 1, 41 }, { 5, 1, 24 }, { 4, 6, 50 },
			{ 2, 4, 66 }, { 2, 3, 22 }, { 1, 6, 25 } };

	static int solution(int n, int s, int a, int b, int[][] fares) {
		int[][] costs = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			Arrays.fill(costs[i], 100000000);
			costs[i][i] = 0;
		}

		for (int i = 0, c = fares.length; i < c; i++) {
			costs[fares[i][0]][fares[i][1]] = fares[i][2];
			costs[fares[i][1]][fares[i][0]] = fares[i][2];
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				for (int k = 1; k <= n; k++) {
					costs[j][k] = Math.min(costs[j][k], costs[j][i] + costs[i][k]);
				}
			}

		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(costs[i][j] == 100000000 ? "INF " : costs[i][j] + " ");
			}
			System.out.println();
		}

		int ans = Integer.MAX_VALUE;
		for (int i = 1; i <= n; i++) {
			ans = Math.min(ans, costs[s][i] + costs[i][a] + costs[i][b]);
		}
		return ans;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solution(n, s, a, b, fares));
	}

}