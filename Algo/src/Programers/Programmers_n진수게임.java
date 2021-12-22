package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Programmers_n진수게임 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n = 16;
	static int t = 16;
	static int m = 2;
	static int p = 1;

	static String solve(int n, int t, int m, int p) {
		StringBuilder sb = new StringBuilder();
		String s = "01";
		int i = 2;
		while (s.length() <= m * (t + 1)) {
			if (n == 2) {
				s += Integer.toBinaryString(i);
			} else if (n == 8) {
				s += Integer.toOctalString(i);
			} else if (n == 16) {
				s += Integer.toHexString(i);
			} else {
				int num = i;
				String temp = "";
				while (num > 0) {
					int a = num % n;
					if (a >= 10) {
						if (a == 10) {
							temp = "A" + temp;
						} else if (a == 11) {
							temp = "B" + temp;
						} else if (a == 12) {
							temp = "C" + temp;
						} else if (a == 13) {
							temp = "D" + temp;
						} else if (a == 14) {
							temp = "E" + temp;
						} else if (a == 15) {
							temp = "F" + temp;
						}
					} else {
						temp = Integer.toString(a) + temp;
					}
					num /= n;
				}
				s += temp;
			}
			i++;
		}
		s = s.toUpperCase();
		System.out.println(s);
		System.out.println(Integer.toHexString(15));
		for (i = 0; i < t; i++) {
			sb.append(s.charAt(p + m * i));
		}
		return sb.toString();
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solve(n, t, m, p));
	}

}