package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Programmers_행렬의곱셈 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int[][] arr1 = {};
	static int[][] arr2 = {};

	static int[][] solve(int[][] arr1, int[][] arr2) {
		int[][] ans = new int[arr1.length][arr2[0].length];
		for (int i = 0, c = arr1.length; i < c; i++) {
			for (int j = 0, w = arr2[0].length; j < w; j++) {
				for (int k = 0, z = arr1[0].length; k < z; k++) {
					ans[i][j] += arr1[i][k] * arr2[k][j];
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solve(arr1, arr2));
	}

}