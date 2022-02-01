package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Programmers_k진수에서소수개수구하기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n = 437674;
	static int k = 3;

	static int solution(int n, int k) {
		String res = conv(n, k);

		int ans = 0;
		String[] nums = res.split("0+");
		for (int i = 0; i < nums.length; i++) {
			if (isSosu(Long.parseLong(nums[i]))) {
				ans++;
			}
		}
		return ans;
	}

	static boolean isSosu(long num) {
		if (num == 1) {
			return false;
		}
		int cnt = 0;
		for (int i = 2, c = (int) Math.sqrt(num); i <= c; i++) {
			if (num % i == 0) {
				return false;
			}
		}

		return true;
	}

	static String conv(int n, int k) {
		if (k == 6) {
			return Integer.toHexString(n);
		} else if (k == 8) {
			return Integer.toOctalString(n);
		} else if (k == 10) {
			return String.valueOf(n);
		}
		StringBuilder sb = new StringBuilder();
		while (n > 0) {
			sb.insert(0, n % k);
			n -= n % k;
			n /= k;
		}
		return sb.toString();
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solution(n, k));
	}

}