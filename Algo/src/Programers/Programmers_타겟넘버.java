package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Programmers_타겟넘버 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int[] numbers = {1,1,1,1,1};
	static int target = 3;

	static int solve() {
		int len = numbers.length;
		int cnt = 1;
		for (int i = 0; i < len; i++) {
			cnt *= 2;
		}

		int ans = 0;
		for (int i = 0; i <= cnt; i++) {
			int sum = 0;
			for (int j = 0; j < len; j++) {
				if ((i & (1 << j)) != 0) {
					sum += numbers[j];
				} else {
					sum -= numbers[j];
				}
			}
			if (sum == target) {
				ans++;
			}
		}
		return ans;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solve());
	}

}