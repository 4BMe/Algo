package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Programmers_카펫 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int brown = 5000;
	static int yellow = 2000000;

	static int[] solve() {
		int[] ans = new int[2];

		for (int x = 1; x < 10000; x++) {
			for (int y = 1; y <= x; y++) {
				if ((x + y) * 2 - 4 == brown) {
					if ((y - 2) * (x - 2) == yellow) {
						ans[0] = x;
						ans[1] = y;
						return ans;
					}
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) throws Exception {
		for (int a : solve()) {
			System.out.print(a + " ");
		}
	}

}