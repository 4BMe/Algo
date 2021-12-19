package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Programmers_n2배열자르기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n = 4;
	static long left = 7;
	static long right = 14;

	static int[] solve(int n, long left, long right) {
		List<long[]> ans = new LinkedList<long[]>();
		for (long i = left / n, c = right / n; i <= c; i++) {
			for (long j = 0; j < n; j++) {
				if (left <= i * n + j && i * n + j <= right) {
					ans.add(new long[] { Math.max(i, j) + 1 });
				}
			}
		}

		return ans.stream().mapToInt(i -> (int) i[0]).toArray();
	}

	public static void main(String[] args) throws Exception {
		for (int a : solve(n, left, right)) {
			System.out.print(a + " ");
		}
	}

}