package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Programmers_2개이하로다른비트 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static long[] numbers = { 0, 2, 7 };

	static long[] solve(long[] numbers) {
		long[] ans = new long[numbers.length];
		for (int i = 0, c = numbers.length; i < c; i++) {
			long now = numbers[i];
			if (now % 2 == 0) {
				ans[i] = now + 1;
			} else {
				long zero = findZero(now);
				ans[i] = now + zero - (zero >> 1);
			}
		}
		return ans;
	}

	static long findZero(long num) {
		long cmp = 1;
		while (cmp <= num) {
			if ((num & cmp) == 0) {
				return cmp;
			}
			cmp = cmp << 1;
		}
		return cmp;
	}

	public static void main(String[] args) throws Exception {
		long temp = (long) Math.pow(2, 11) - 1;
		numbers[0] = temp;
		long[] ans = solve(numbers);
		for (int i = 0, c = numbers.length; i < c; i++) {
			System.out.println("0" + Long.toBinaryString(numbers[i]));
			System.out.println(Long.toBinaryString(ans[i]));
		}
	}

}