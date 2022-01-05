package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Programmers_최고의집합 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n = 2;
	static int s = 9;

	static int[] solution(int n, int s) {
		if (n > s) {
			return new int[] { -1 };
		}
		int goal = s;
		int idx = n;
		int[] ans = new int[n];
		for (int i = n; i > 0; i--) {
			ans[n - i] = s / i;
			s -= ans[n - i];
		}
		return ans;
	}

	public static void main(String[] args) throws Exception {
		for (int a : solution(n, s)) {
			System.out.println(a + " ");
		}
	}

}