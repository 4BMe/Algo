package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Programmers_최솟값만들기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int[] A = {};
	static int[] B = {};

	static int solve(int[] A, int[] B) {
		Arrays.sort(A);
		Arrays.sort(B);
		int ans = 0;
		for (int i = 0, c = A.length; i < c; i++) {
			ans += A[i] * B[c - 1 - i];
		}
		return ans;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solve(A, B));
	}

}