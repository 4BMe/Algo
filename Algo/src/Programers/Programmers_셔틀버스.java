package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Programmers_셔틀버스 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n = 2;
	static int t = 10;
	static int m = 2;
	static String[] timetable = { "09:10", "09:09", "08:00" };

	static String solution(int n, int t, int m, String[] timetable) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0, c = timetable.length; i < c; i++) {
			int time = Integer.parseInt(timetable[i].substring(0, 2)) * 60
					+ Integer.parseInt(timetable[i].substring(3, 5));
			pq.add(time);
		}
		int start = 9 * 60;
		int res = pq.peek() - 1;
		for (int i = 0; i < n; i++) {
			int cnt = 0;
			int before = 0;
			for (int j = 0; j < m; j++) {
				if (pq.isEmpty() || pq.peek() > start) {
					break;
				}
				int now = pq.poll();
				if (now != before) {
					before = now;
				}
				cnt++;
			}
			if (cnt < m) {
				res = start;
			} else if (cnt == m) {
				res = before - 1;
			}
			start += t;
		}

		String ans = "";
		if (res / 600 < 1) {
			ans += "0" + String.valueOf(res / 60) + ":";
		} else {
			ans += String.valueOf(res / 60) + ":";
		}
		if (res % 60 / 10 < 1) {
			ans += "0" + String.valueOf(res % 60);
		} else {
			ans += String.valueOf(res % 60);
		}
		return ans;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solution(n, t, m, timetable));
	}

}