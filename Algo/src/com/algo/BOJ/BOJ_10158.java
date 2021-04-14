package com.algo.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10158 {
	static int N, M, K;
	static int answer = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		answer = 0;
		for (int i = 0; i <= K; i++) {
			answer = Math.max(answer, Math.min(M - i, (N - (K - i)) / 2));
			answer = Math.max(answer, Math.min(M - (K - i), (N - i) / 2));
		}
		System.out.println(answer);
	}

}
