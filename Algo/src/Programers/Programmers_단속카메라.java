package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Programmers_단속카메라 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int[][] routes = {};

	static int solution(int[][] routes) {
		List<int[]> list = new LinkedList<int[]>();
		for (int[] a : routes) {
			list.add(new int[] { a[0], a[1] });
		}
		Collections.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		int before = list.get(0)[1];
		int ans = 0;
		ans++;
		for (int i = 1, c = list.size(); i < c; i++) {
			int[] now = list.get(i);
			if (now[0] > before) {
				ans++;
				before = now[1];
			}
		}
		return ans;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solution(routes));
	}

}