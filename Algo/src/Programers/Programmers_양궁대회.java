package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Programmers_양궁대회 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n = 5;
	static int[] info = { 2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0 };
	static int max = 0;
	static int[] ans;

	static int[] solution(int n, int[] info) {
		dfs(10, 0, new int[11]);

		return max == 0 ? new int[] { -1 } : ans;
	}

	static void dfs(int idx, int sum, int[] res) {
		if (sum == n) {
			int lion = 0;
			int ap = 0;
			for (int i = 0; i < 11; i++) {
				if (res[i] == 0 && info[i] == 0) {
					continue;
				} else if (res[i] > info[i]) {
					lion += 10 - i;
				} else {
					ap += 10 - i;
				}
			}
			int diff = lion - ap;
			if (diff > max) {
				max = diff;
				ans = Arrays.copyOf(res, 11);
			}
			return;
		}
		if (idx < 0) {
			return;
		}
		for (int i = n - sum; i >= 0; i--) {
			res[idx] = i;
			dfs(idx - 1, sum + i, res);
		}
	}

	public static void main(String[] args) throws Exception {
		for (int a : solution(n, info)) {
			System.out.print(a + " ");
		}
	}

}