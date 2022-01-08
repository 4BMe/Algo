package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Programmers_전력량 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int[][] fees = {};
	static int usage = 0;

	static int solution(int[][] fees, int usage) {
		int ans = 0;
		Arrays.sort(fees, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		for (int i = 0, c = fees.length; i < c; i++) {
			if (fees[i][0] < usage) {
				ans = fees[(i + 1) % c][1];
			}
		}

		int before = 0;
		for (int i = 1, c = fees.length; i < c; i++) {
			if (usage <= 0) {
				break;
			}
			if (usage > fees[i][0] - before) {
				ans += (fees[i][0] - before) * fees[i][2];
				before = fees[i][0];
				System.out.println(" " + (fees[i][0] - before) * fees[i][2]);
			} else {
				ans += usage * fees[i][2];
				System.out.println(" " + usage * fees[i][2]);
			}
			usage -= fees[i][0];
		}
		if (usage > 0) {
			ans += usage * fees[0][2];
		}
		return ans;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solution(fees, usage));
	}

}