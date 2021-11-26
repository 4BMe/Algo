package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Programmers_로또의최고순위와최저순위 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int[] lottos = { 44, 1, 0, 0, 31, 25 };
	static int[] win_nums = { 31, 10, 45, 1, 6, 19 };

	static void solve() {
		Arrays.sort(lottos);
		Arrays.sort(win_nums);

		int idx = 0, i = 0;
		int cnt = 0;
		int zero = 0;
		while (idx < 6 && i < 6) {
			if (lottos[i] == 0) {
				zero++;
				i++;
			} else {
				if (lottos[i] == win_nums[idx]) {
					cnt++;
					i++;
					idx++;
				} else if (lottos[i] < win_nums[idx]) {
					i++;
				} else {
					idx++;
				}
			}
		}
		int min = cnt == 0 ? 6 : 7 - cnt;
		int max = min - zero == 0 ? 1 : min - zero;
		System.out.println(max + " " + min);
	}

	public static void main(String[] args) throws Exception {
		solve();
	}

}
