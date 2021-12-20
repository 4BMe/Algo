package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Programmers_방문길이 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static String dirs = "LRLRL";

	static int solve(String dirs) {
		int ans = 0;
		boolean[][][] visited = new boolean[11][11][4];

		int[] dy = { -1, 1, 0, 0 };
		int[] dx = { 0, 0, 1, -1 };
		int y = 5;
		int x = 5;
		int dir = 0;
		for (int i = 0, c = dirs.length(); i < c; i++) {
			char ch = dirs.charAt(i);
			dir = getDir(ch);
			int ny = y + dy[dir];
			int nx = x + dx[dir];
			if (ny < 0 || ny >= 11 || nx < 0 || nx >= 11) {
				continue;
			}
			if (!visited[ny][nx][dir]) {
				ans++;
				visited[ny][nx][dir] = true;
				visited[y][x][dir % 2 == 0 ? dir + 1 : dir - 1] = true;
			}
			y = ny;
			x = nx;
		}
		return ans;
	}

	static int getDir(char c) {
		if (c == 'U') {
			return 0;
		} else if (c == 'D') {
			return 1;
		} else if (c == 'R') {
			return 2;
		} else {
			return 3;
		}
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solve(dirs));
	}

}