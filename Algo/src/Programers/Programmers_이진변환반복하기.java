package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Programmers_이진변환반복하기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static String s = "1111111";

	static int[] solve(String s) {
		int[] ans = new int[2];
		while (!s.equals("1")) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0, c = s.length(); i < c; i++) {
				if (s.charAt(i) == '0') {
					ans[1]++;
				} else {
					sb.append('1');
				}
			}
			s = Integer.toBinaryString(sb.toString().length());
			ans[0]++;
		}
		return ans;
	}

	public static void main(String[] args) throws Exception {
		for (int a : solve(s)) {
			System.out.print(a + " ");
		}
	}

}