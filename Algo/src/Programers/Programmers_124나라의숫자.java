package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Programmers_124나라의숫자 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n = 9;

	static String solve(int n) {
		String ans = "";
		while (n > 0) {
			if (n % 3 == 0) {
				ans = "4" + ans;
				n /= 3;
				n--;
			} else if (n % 3 == 2) {
				ans = "2" + ans;
				n /= 3;
			} else {
				ans = "1" + ans;
				n /= 3;
			}
		}
		return ans;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solve(n));
	}

}