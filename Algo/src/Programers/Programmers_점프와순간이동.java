package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Programmers_점프와순간이동 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n = 5000;

	static int solve(int n) {
		int ans = 0;
		while (n > 0) {
			if (n % 2 == 0) {
				n /= 2;
			} else {
				n -= 1;
				ans++;
			}
		}
		return ans;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solve(n));
	}

}