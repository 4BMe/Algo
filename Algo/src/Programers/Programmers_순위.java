package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Programmers_순위 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n = 5;
	static int[][] results = { { 1, 2 }, { 3, 2 }, { 2, 5 }, { 2, 4 } };

	static int solution(int n, int[][] results) {
		int[][] knows = new int[n + 1][n + 1];
		for (int i = 0, c = results.length; i < c; i++) {
			int[] cur = results[i];
			knows[cur[0]][cur[1]] = 1;
			knows[cur[1]][cur[0]] = -1;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				for (int k = 1; k <= n; k++) {
					if (knows[j][i] * knows[i][k] == 1) {
						knows[j][k] = knows[j][i];
					}
				}
			}
		}

		int ans = 0;
		for (int i = 1; i <= n; i++) {
			int cnt = 0;
			for (int j = 1; j <= n; j++) {
				if (knows[i][j] != 0) {
					cnt++;
				}
			}
			if (cnt == n - 1) {
				ans++;
			}
		}
		return ans;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solution(n, results));
	}

}