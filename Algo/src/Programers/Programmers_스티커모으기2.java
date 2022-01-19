package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Programmers_스티커모으기2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int[] sticker = { 14, 6, 5, 11, 3, 9, 2, 10 };

	static int solution(int sticker[]) {
		int len = sticker.length;
		if (len == 1) {
			return sticker[0];
		}

		int[] fdp = new int[len - 1];
		for (int i = 0; i < len - 1; i++) {
			fdp[i] = sticker[i];
		}
		int[] ldp = new int[len - 1];
		for (int i = 1; i < len; i++) {
			ldp[i - 1] = sticker[i];
		}

		len--;

		for (int i = 1; i < len; i++) {
			if (i == 1) {
				fdp[i] = Math.max(fdp[i], fdp[i - 1]);
				ldp[i] = Math.max(ldp[i], ldp[i - 1]);
				continue;
			}
			ldp[i] = Math.max(ldp[i - 2] + ldp[i], ldp[i - 1]);
			fdp[i] = Math.max(fdp[i - 2] + fdp[i], fdp[i - 1]);
		}

		return Math.max(ldp[len - 1], fdp[len - 1]);
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solution(sticker));
	}

}