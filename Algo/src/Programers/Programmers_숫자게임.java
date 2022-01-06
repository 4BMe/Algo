package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Programmers_숫자게임 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int[] A = { 1, 1, 4, 4 };
	static int[] B = { 1, 1, 3, 3 };

	static int solution(int[] A, int[] B) {
		Arrays.sort(A);
		Arrays.sort(B);
		int idx = B.length - 1;
		int ans = 0;
		for (int i = A.length - 1; i >= 0; i--) {
			if (A[i] < B[idx]) {
				idx--;
				ans++;
			}
		}
		return ans;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solution(A, B));
	}

}