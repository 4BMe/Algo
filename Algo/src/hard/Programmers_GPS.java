package hard;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Programmers_GPS {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n = 7;
	static int m = 10;
	static int[][] edge_list = { { 1, 2 }, { 1, 3 }, { 2, 3 }, { 2, 4 }, { 3, 4 }, { 3, 5 }, { 4, 6 }, { 5, 6 },
			{ 5, 7 }, { 6, 7 } };
	static int k = 6;
	static int[] gps_log = { 1, 2, 3, 3, 6, 7 };

	static int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
		List<Integer> links[] = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			links[i] = new ArrayList<Integer>();
		}
		for (int[] edge : edge_list) {
			links[edge[0]].add(edge[1]);
			links[edge[1]].add(edge[0]);
		}

		int[][] dp = new int[k][n + 1];
		for (int i = 0; i < k; i++) {
			Arrays.fill(dp[i], 200);
		}

		dp[0][gps_log[0]] = 0;
		for (int i = 1; i < k; i++) {
			for (int j = 1; j <= n; j++) {
				dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);
				for (int before : links[j]) {
					dp[i][j] = Math.min(dp[i][j], dp[i - 1][before]);
				}
				if (j != gps_log[i]) {
					dp[i][j]++;
				}
			}
		}

		return dp[k - 1][gps_log[k - 1]] >= 200 ? -1 : dp[k - 1][gps_log[k - 1]];
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solution(n, m, edge_list, k, gps_log));
	}

}