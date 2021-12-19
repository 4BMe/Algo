package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Programmers_쿼드압축후개수세기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int[][] arr = { { 1, 1, 0, 0 }, { 1, 0, 0, 0 }, { 1, 0, 0, 1 }, { 1, 1, 1, 1 } };
	static int[] ans = new int[2];

	static int[] solve(int[][] ar) {
		arr = ar;
		divide(0, 0, ar.length);
		return ans;
	}

	static void divide(int y, int x, int size) {
		int cmp = arr[y][x];
		for (int i = y; i < y + size; i++) {
			for (int j = x; j < x + size; j++) {
				if (arr[i][j] != cmp) {
					divide(y, x, size / 2);
					divide(y + size / 2, x, size / 2);
					divide(y, x + size / 2, size / 2);
					divide(y + size / 2, x + size / 2, size / 2);
					return;
				}
			}
		}
		ans[cmp] += 1;
	}

	public static void main(String[] args) throws Exception {
		for (int a : solve(arr)) {
			System.out.print(a + " ");
		}
	}

}