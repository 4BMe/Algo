package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Programmers_네트워크 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n = 0;
	static int[][] computers = {};
	static int[] p;

	static int solution(int n, int[][] computers) {
		int answer = 0;
		p = new int[n];
		for (int i = 0; i < n; i++) {
			p[i] = i;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j || computers[i][j] == 0) {
					continue;
				}
				union(i, j);
			}
		}
		Set<Integer> set = new HashSet<>();
		for (int a : p) {
			set.add(a);
		}
		return set.size();
	}

	static void union(int y, int x) {
		int yP = parent(y);
		int xP = parent(x);
		int root = Math.min(yP, xP);
		int before = xP;
		if (yP > xP) {
			before = yP;
		}
		for (int i = 0; i < n; i++) {
			if (p[i] != before) {
				continue;
			}
			p[i] = root;
		}
	}

	static int parent(int y) {
		if (p[y] == y) {
			return y;
		}

		return p[y] = parent(p[y]);
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solution(n, computers));
	}

}