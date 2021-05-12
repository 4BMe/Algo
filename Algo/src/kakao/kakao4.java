package kakao;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

class Point {
	int now;
	int cost;
	boolean[] trap;

	public Point(int now, int cost, boolean[] trap) {
		super();
		this.now = now;
		this.cost = cost;
		this.trap = trap;
	}
}

public class kakao4 {

	static void solve(int n, int start, int end, int[][] roads, int[] traps) {
		PriorityQueue<Point> q = new PriorityQueue<>(new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				// TODO Auto-generated method stub
				return o1.cost - o2.cost;
			}
		});

		List<int[]>[] adj = new LinkedList[n + 1];
		for (int i = 1; i <= n; i++)
			adj[i] = new LinkedList<>();
		for (int i = 0, c = roads.length; i < c; i++) {
			adj[roads[i][0]].add(new int[] { roads[i][1], roads[i][2] });
		}

		q.offer(new Point(start, 0, new boolean[n + 1]));

		Point cur;
		boolean[] trap;
		int[] next;
		while (!q.isEmpty()) {
			cur = q.poll();
			if (cur.cost < 10)
				System.out.println("지금 " + cur.now + " " + cur.cost);
			if (cur.now == end) {
				System.out.println(cur.cost);
				return;
			}
			for (int i = 0, c = adj[cur.now].size(); i < c; i++) {
				trap=cur.trap;
				next=adj[cur.now].get(i);
			}
		}

	}

	static boolean isTrap(int idx, int[] traps) {
		for (int i = 0, c = traps.length; i < c; i++) {
			if (traps[i] == idx)
				return true;
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		int[][] roads = { { 1, 2, 1 }, { 3, 2, 1 }, { 2, 4, 1 } };
		int[] traps = { 2, 3 };
		solve(4, 1, 4, roads, traps);
	}
}
