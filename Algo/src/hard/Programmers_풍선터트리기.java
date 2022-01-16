package hard;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Programmers_풍선터트리기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int[] a = { -16, 27, 65, -2, 58, -92, -71, -68, -61, -33 };
	static boolean[] v;
	static boolean[] poss;

	static int solution(int[] a) {
		int len = a.length;
		if (len == 1) {
			return 1;
		}

		int[] lMin = new int[len];
		int[] rMin = new int[len];

		int min = a[0];
		for (int i = 1; i < len - 1; i++) {
			min = Math.min(min, a[i]);
			lMin[i] = min;
		}

		min = a[len - 1];
		for (int i = len - 2; i > 0; i--) {
			min = Math.min(min, a[i]);
			rMin[i] = min;
		}

		int ans = 2;
		for (int i = 1; i < len - 1; i++) {
			if (a[i] > lMin[i] && a[i] > rMin[i]) {
				continue;
			}
			ans++;
		}

		return ans;
	}

	static void dfs() {

	}

	public static void main(String[] args) throws Exception {
		System.out.println(solution(a));
	}

}