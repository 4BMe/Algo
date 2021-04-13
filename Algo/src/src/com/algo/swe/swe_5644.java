package src.com.algo.swe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class B {
	int y, x;
	int c, p;

	public B(int x, int y, int c, int p) {
		super();
		this.y = y;
		this.x = x;
		this.c = c;
		this.p = p;
	}

}

public class swe_5644 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int[][] map;
	static int t, m, a;
	static int[] dy = { 0, -1, 0, 1, 0 };
	static int[] dx = { 0, 0, 1, 0, -1 };
	static Queue<Integer> moveA, moveB;
	static B[] bettery;

	static void print() {
		System.out.println();
		for (int i = 1; i < 11; i++) {
			System.out.println();
			for (int j = 1; j < 11; j++) {
				System.out.print(map[i][j] + " ");
			}

		}
	}

	static void init() throws Exception {
		map = new int[11][11];
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		a = Integer.parseInt(st.nextToken());

		moveA = new LinkedList<Integer>();
		moveB = new LinkedList<Integer>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			moveA.offer(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			moveB.offer(Integer.parseInt(st.nextToken()));
		}

		bettery = new B[a];
		for (int i = 0; i < a; i++) {
			st = new StringTokenizer(br.readLine());
			bettery[i] = new B(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		for (int i = 0; i < a; i++) {
			markB(bettery[i], (1 << i));
		}
	}

	static void markB(B temp, int idx) {

		int y = temp.y;
		int x = temp.x;
		for (int i = 0; i <= temp.c; i++) {
			for (int j = temp.c - i; j >= 0; j--) {
				if (y + i >= 0 && y + i < 11 && x + j >= 0 && x + j < 11) {
					if ((map[y + i][x + j] & idx) == 0)
						map[y + i][x + j] += idx;
				}
				if (y + i >= 0 && y + i < 11 && x - j >= 0 && x - j < 11) {
					if ((map[y + i][x - j] & idx) == 0)
						map[y + i][x - j] += idx;
				}
				if (y - i >= 0 && y - i < 11 && x + j >= 0 && x + j < 11) {
					if ((map[y - i][x + j] & idx) == 0)
						map[y - i][x + j] += idx;
				}
				if (y - i >= 0 && y - i < 11 && x - j >= 0 && x - j < 11) {
					if ((map[y - i][x - j] & idx) == 0)
						map[y - i][x - j] += idx;
				}
			}
		}

	}

	static void solve() {
		int answer = 0;

		int A, B;
		int Ay, Ax, By, Bx;
		Ay = Ax = 1;
		By = Bx = 10;

		for (int i = 0; i < m; i++) {
			A = moveA.poll();
			B = moveA.poll();
		}

		sb.append(answer);
	}

	public static void main(String[] args) throws Exception {

		t = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		for (int test = 1; test <= t; test++) {
			sb.append("#" + test + " ");
			init();
			solve();
		}
	}

}
