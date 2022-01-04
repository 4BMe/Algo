package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Programmers_하노이의탑 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n = 2;
	static List<int[]> res;

	static int[][] solution(int n) {
		res = new ArrayList<int[]>();
		hanoi(n, 1, 3, 2);
		int[][] ans = new int[res.size()][2];
		for (int i = 0, c = res.size(); i < c; i++) {
			int[] now = res.get(i);
			ans[i][0] = now[0];
			ans[i][1] = now[1];
		}
		return ans;
	}

	static void hanoi(int n, int from, int to, int mid) {
		if (n == 1) {
			res.add(new int[] { from, to });
		} else {
			hanoi(n - 1, from, mid, to);
			res.add(new int[] { from, to });
			hanoi(n - 1, mid, to, from);
		}
	}

	public static void main(String[] args) throws Exception {
		for (int[] a : solution(n)) {
			System.out.println(a[0] + " " + a[1]);
		}
	}

}