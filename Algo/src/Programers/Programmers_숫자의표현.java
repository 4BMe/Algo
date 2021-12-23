package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Programmers_숫자의표현 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n = 10000;

	static int solve(int n) {
		int ans = 1;
		int start = 1;
		int end = 2;
		int sum = 1 + 2;
		while (start < end) {
			if (sum < n) {
				end++;
				sum += end;
			} else if (sum > n) {
				sum -= start;
				start++;
			} else {
				System.out.println(start + " " + end + " " + sum);
				ans++;
				sum -= start;
				start++;
				end++;
				sum += end;
			}
		}
		return ans;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solve(n));
	}

}