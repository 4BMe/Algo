package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Programmers_다리를지나는트럭 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int bridge_length = 100;
	static int weight = 100;
	static int[] truck_weights = { 7, 4, 5, 6 };

	static int solve() {
		Queue<int[]> q = new LinkedList<int[]>();
		int cnt = truck_weights.length;
		int len = truck_weights.length;
		int idx = 0;
		int time = 0;
		int w = 0;
		q.add(new int[] { 0, 0 });
		w += truck_weights[0];
		idx++;
		while (cnt > 0) {
			time++;
			if (!q.isEmpty() && time - q.peek()[1] == bridge_length) {
				int[] now = q.poll();
				cnt--;
				w -= truck_weights[now[0]];
			}
			if (idx < len && w + truck_weights[idx] <= weight) {
				q.add(new int[] { idx, time });
				w += truck_weights[idx];
				idx++;
			}
		}
		return time + 1;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solve());
	}

}