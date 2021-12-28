package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Programmers_입국심사 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n = 1;
	static int[] times = { 2, 2, 2 };

	static long solve(int n, int[] times) {
		long ans = Long.MAX_VALUE;
		long start = 0;
		long end = Long.MAX_VALUE / times.length;
		while (start <= end) {
			long mid = (start + end) / 2;
			long cnt = 0;
			for (int a : times) {
				cnt += mid / (long) a;
			}
			if (cnt >= n) {
				end = mid - 1;
				ans = Math.min(ans, mid);
			} else if (cnt < n) {
				start = mid + 1;
			}
		}
		return ans;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solve(n, times));
	}

}