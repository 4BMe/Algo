package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Programmers_가장큰수 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int[] numbers = { 1001, 10 };

	static String solve() {
		int len = numbers.length;
		String[] num = new String[len];
		for (int i = 0; i < len; i++) {
			num[i] = String.valueOf(numbers[i]);
		}
		Arrays.sort(num, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				String c1 = o1 + o2;
				String c2 = o2 + o1;
				return Integer.parseInt(c1) - Integer.parseInt(c2);
			}
		});
		String ans = "";
		for (String s : num) {
			ans = s + ans;
		}

		return ans.charAt(0) == '0' ? "0" : ans;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solve());
	}

}