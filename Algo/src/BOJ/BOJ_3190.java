package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

class work {
	int t;
	char d;

	public work(int t, char d) {
		super();
		this.t = t;
		this.d = d;
	}
}

class snake {
	int y, x;
	int dir;

	public snake(int y, int x, int dir) {
		super();
		this.y = y;
		this.x = x;
		this.dir = dir;
	}
}

public class BOJ_3190 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;
	static int k;
	static int l;
	static int[][] map;
	static List<work> spin = new LinkedList<work>();
	static List<int[]> s = new LinkedList<>();
	static int[] dy = { 0, 1, 0, -1 };
	static int[] dx = { 1, 0, -1, 0 };

	static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		map = new int[n][n];

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 1;
		}
		l = Integer.parseInt(br.readLine());
		for (int i = 0; i < l; i++) {
			st = new StringTokenizer(br.readLine());
			spin.add(new work(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0)));
		}

	}

	static int solve() {

		s.add(new int[] { 0, 0 });
		int dir = 0;

		int time = 0;
		int curY, curX, nextY, nextX;

		curY = curX = 0;

		for (time = 0;;) {
			time++;
			nextY = curY + dy[dir];
			nextX = curX + dx[dir];
//			System.out.println(nextY + " " + nextX);
			if (!possible(nextY, nextX))
				break;
			if (map[nextY][nextX] == 1) {
				s.add(new int[] { nextY, nextX });
				map[nextY][nextX] = 0;
			} else {
				s.add(new int[] { nextY, nextX });
				s.remove(0);
			}
			curY = nextY;
			curX = nextX;
			if (spin.size() > 0) {
				work temp = spin.get(0);
				if (time == temp.t) {
					spin.remove(0);
					if (temp.d == 'L') {
						dir -= 1;
						if (dir == -1)
							dir = 3;
					} else {
						dir += 1;
						if (dir == 4)
							dir = 0;
					}

				}
			}
		}

		return time;

	}

	static boolean possible(int y, int x) {
		if (y < 0 || y >= n || x < 0 || x >= n)
			return false;
		int[] body;
		for (int i = 0, c = s.size(); i < c; i++) {
			body = s.get(i);
			if (y == body[0] && x == body[1])
				return false;
		}
		return true;
	}

	public static void main(String[] args) throws Exception {

		init();
		System.out.println(solve());
	}

}
