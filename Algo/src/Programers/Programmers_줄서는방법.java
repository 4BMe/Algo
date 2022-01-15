package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Programmers_줄서는방법 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n = 20;
	static long k = 12000;

	static int[] solution(int n, long k) {
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			list.add(i);
		}

		long[] cnt = new long[n];
		Arrays.fill(cnt, 1);
		for (int i = 2; i <= n; i++) {
			for (int j = n - i; j >= 0; j--) {
				cnt[j] *= (long) i;
			}
		}

		int[] ans = new int[n];
		for (int i = 0; i < n - 1; i++) {
			int m = (int) ((k - 1) / cnt[i + 1]);
			ans[i] = list.remove(m);
			k -= (long) m * cnt[i + 1];
		}
		ans[n - 1] = list.remove(0);

		return ans;
	}

	public static void main(String[] args) throws Exception {
		for (int a : solution(n, k)) {
			System.out.print(a + " ");
		}
	}

}