package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Programmers_N개의최소공배수 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int[] arr = {};

	static int solve(int[] arr) {
		int ans = arr[arr.length - 1];
		Arrays.sort(arr);
		for (;;) {
			boolean flag = true;
			for (int i = arr.length - 1; i >= 0; i--) {
				if (ans % arr[i] != 0) {
					flag = false;
					break;
				}
			}
			if (flag) {
				return ans;
			}
			ans++;
		}
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solve(arr));
	}

}