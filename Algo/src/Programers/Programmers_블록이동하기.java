package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Programmers_블록이동하기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] board = { { 0, 0, 0, 1, 1 }, { 0, 0, 0, 1, 0 }, { 0, 1, 0, 1, 1 }, { 1, 1, 0, 0, 1 },
			{ 0, 0, 0, 0, 0 } };
	static int[][] board1 = { 
//			{ 0, 1, 2, 3, 4, 5, 6 }, 
			{ 0, 0, 0, 0, 0, 0, 1 }, 
			{ 1, 1, 1, 1, 0, 0, 1 }, 
			{ 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 1, 1, 1, 1, 0 }, 
			{ 0, 1, 1, 1, 1, 1, 0 }, 
			{ 0, 0, 0, 0, 0, 1, 1 }, 
			{ 0, 0, 1, 0, 0, 0, 0 } };

	static int solution(int[][] board) {
		int n = board.length;
		boolean[][][][] visited = new boolean[n][n][n][n];

		PriorityQueue<robot> q = new PriorityQueue<robot>(new Comparator<robot>() {
			@Override
			public int compare(robot o1, robot o2) {
				return o1.cnt-o2.cnt;
			}
		});
		q.add(new robot(new int[] { 0, 0 }, new int[] { 0, 1 }, 0, 0));
		visited[0][0][0][1] = true;
		visited[0][1][0][0] = true;

		int[] dy = { 1, -1, 0, 0 };
		int[] dx = { 0, 0, 1, -1 };

		int[][] hsdy = { { 1, -1 }, { -1, -1 }, { -1, 1 }, { 1, 1 } };
		int[][] hsdx = { { 1, 1 }, { 1, -1 }, { -1, -1 }, { -1, 1 } };
		int[][] tsdy = { { -1, 1 }, { 1, 1 }, { 1, -1 }, { -1, -1 } };
		int[][] tsdx = { { -1, -1 }, { -1, 1 }, { 1, 1 }, { 1, -1 } };

		int[][] vy = { { 1, -1 }, { 0, 0 }, { -1, 1 }, { 0, 0 } };
		int[][] vx = { { 0, 0 }, { 1, -1 }, { 0, 0 }, { -1, 1 } };

		int ans = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			robot cur = q.poll();
//			System.out.println(cur);
			if ((cur.head[0] == n - 1 && cur.head[1] == n - 1) || (cur.tail[0] == n - 1 && cur.tail[1] == n - 1)) {
				return cur.cnt;
			}
			for (int i = 0; i < 4; i++) {
				int[] nhead = { cur.head[0] + dy[i], cur.head[1] + dx[i] };
				int[] ntail = { cur.tail[0] + dy[i], cur.tail[1] + dx[i] };
				if (nhead[0] < 0 || nhead[0] >= n || nhead[1] < 0 || nhead[1] >= n || ntail[0] < 0 || ntail[0] >= n
						|| ntail[1] < 0 || ntail[1] >= n || board[nhead[0]][nhead[1]] == 1
						|| board[ntail[0]][ntail[1]] == 1 || visited[nhead[0]][nhead[1]][ntail[0]][ntail[1]]
						|| visited[ntail[0]][ntail[1]][nhead[0]][nhead[1]]) {
					continue;
				}
				visited[nhead[0]][nhead[1]][ntail[0]][ntail[1]]=true;
				visited[ntail[0]][ntail[1]][nhead[0]][nhead[1]]=true;
				robot nrobot = new robot(nhead, ntail, cur.dir, cur.cnt + 1);
				q.add(nrobot);
			}

			// 머리 회전
			for (int i = 0; i < 2; i++) {
				int ndir = (cur.dir + (i * 2) + 1) % 4;
				int[] nhead = { cur.head[0] + hsdy[cur.dir][i], cur.head[1] + hsdx[cur.dir][i] };
				if (nhead[0] < 0 || nhead[0] >= n || nhead[1] < 0 || nhead[1] >= n || visited[nhead[0]][nhead[1]][cur.tail[0]][cur.tail[1]]
						|| visited[cur.tail[0]][cur.tail[1]][nhead[0]][nhead[1]]
						|| board[nhead[0]][nhead[1]] == 1
						|| board[cur.head[0] + vy[cur.dir][i]][cur.head[1] + vx[cur.dir][i]] == 1) {
					continue;
				}
				visited[nhead[0]][nhead[1]][cur.tail[0]][cur.tail[1]] = true;
				visited[cur.tail[0]][cur.tail[1]][nhead[0]][nhead[1]] = true;
				robot nrobot = new robot(nhead, cur.tail, ndir, cur.cnt + 1);
				q.add(nrobot);
//				System.out.println("add h" + nrobot);
			}

			// 꼬리 회전
			for (int i = 0; i < 2; i++) {
				int ndir = (cur.dir + i * 2 + 1) % 4;
				int[] ntail = { cur.tail[0] + tsdy[cur.dir][i], cur.tail[1] + tsdx[cur.dir][i] };
				if (ntail[0] < 0 || ntail[0] >= n || ntail[1] < 0 || ntail[1] >= n
						|| board[ntail[0]][ntail[1]] == 1
						|| visited[cur.head[0]][cur.head[1]][ntail[0]][ntail[1]]
						|| visited[ntail[0]][ntail[1]][cur.head[0]][cur.head[1]]
						|| board[cur.tail[0] + vy[cur.dir][(i + 1) % 2]][cur.tail[1] + vx[cur.dir][(i + 1) % 2]] == 1 ) {
					continue;
				}
				visited[cur.head[0]][cur.head[1]][ntail[0]][ntail[1]] = true;
				visited[ntail[0]][ntail[1]][cur.head[0]][cur.head[1]] = true;
				robot nrobot = new robot(cur.head, ntail, ndir, cur.cnt + 1);
				q.add(nrobot);
//				System.out.println("add t" + nrobot);
			}
		}

		return ans;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solution(board1));
	}

	static class robot {
		int[] head;
		int[] tail;
		int dir;
		int cnt;

		public robot(int[] head, int[] tail, int dir, int cnt) {
			this.head = head;
			this.tail = tail;
			this.dir = dir;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(head[0] + " " + head[1] + " | " + tail[0] + " " + tail[1] + " : " + dir + " | " + cnt);
			return sb.toString();
		}
	}
}