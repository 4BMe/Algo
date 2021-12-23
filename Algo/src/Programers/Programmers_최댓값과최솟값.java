package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Programmers_최댓값과최솟값 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb;
	static String s = "-1 -2 -3 -4";

	static String solve(String s) {
		String ans = "";
		StringTokenizer st = new StringTokenizer(s);
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0, c = st.countTokens(); i < c; i++) {
			int num = Integer.parseInt(st.nextToken());
			max = Math.max(max, num);
			min = Math.min(min, num);
		}
		ans = String.valueOf(min) + " " + String.valueOf(max);
		return ans;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solve(s));
	}

}