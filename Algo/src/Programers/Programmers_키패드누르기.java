package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Programmers_키패드누르기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int[] numbers = { 7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2 };
	static String hand = "left";

	static void solve() {
		int[] left = { 0, 0 };
		int[] right = { 0, 2 };
		int[][] pad = { { 0, 1 }, { 3, 0 }, { 3, 1 }, { 3, 2 }, { 2, 0 }, { 2, 1 }, { 2, 2 }, { 1, 0 }, { 1, 1 },
				{ 1, 2 } };
		StringBuilder sb = new StringBuilder();
		for (int i = 0, c = numbers.length; i < c; i++) {
			int now = numbers[i];
			if (now == 1 || now == 4 || now == 7) {
				sb.append('L');
				left = pad[now];
			} else if (now == 3 || now == 6 || now == 9) {
				sb.append('R');
				right = pad[now];
			} else {
				int ldist = Math.abs(left[0] - pad[now][0]) + Math.abs(left[1] - pad[now][1]);
				int rdist = Math.abs(right[0] - pad[now][0]) + Math.abs(right[1] - pad[now][1]);
				if (ldist < rdist) {
					sb.append('L');
					left = pad[now];
				} else if (ldist > rdist) {
					sb.append('R');
					right = pad[now];
				} else {
					if (hand.charAt(0) == 'r') {
						sb.append('R');
						right = pad[now];
					} else {
						sb.append('L');
						left = pad[now];
					}
				}
			}
		}
		System.out.println(sb.toString());
	}

	public static void main(String[] args) throws Exception {
		solve();
	}

}