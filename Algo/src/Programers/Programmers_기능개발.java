package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Programmers_기능개발 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int[] progresses = { 99, 99, 55 };
	static int[] speeds = { 1, 30, 5 };

	static int[] solve() {
		int n = progresses.length;
		List<Integer> q = new LinkedList<Integer>();
		List<Integer> res = new ArrayList<Integer>();
		List<Integer> speed = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			q.add(progresses[i]);
			speed.add(speeds[i]);
		}

		while (q.size() > 0) {
			for (int i = 0, c = q.size(); i < c; i++) {
				int next = q.get(0) + speed.get(i);
				next = next >= 100 ? 100 : next;
				q.remove(0);
				q.add(next);
			}
			int cnt = 0;
			while (q.size() > 0) {
				if (q.get(0) >= 100) {
					cnt++;
					speed.remove(0);
					q.remove(0);
				} else {
					break;
				}
			}
			if (cnt != 0) {
				res.add(cnt);
			}
		}

		int size = res.size();
		int[] ans = new int[size];
		for (int i = 0; i < size; i++) {
			ans[i] = res.get(i);
		}
		return ans;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solve());
	}

}