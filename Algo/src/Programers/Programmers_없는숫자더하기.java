package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Programmers_없는숫자더하기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int[] numbers;

	static void solve() {
		boolean[] num = new boolean[10];
		for (int i = 0, c = numbers.length; i < c; i++) {
			num[numbers[i]] = true;
		}
		int ans = 0;
		for (int i = 1; i < 10; i++) {
			if (!num[i]) {
				ans += i;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		solve();
	}

}