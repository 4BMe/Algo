package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Programmers_교점에별만들기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] line = { { 2, -1, 4 }, { -2, -1, 4 }, { 0, -1, 1 }, { 5, -8, -12 }, { 5, 8, 12 } };
	static int[][] line2 = { { 0, 1, -1 }, { 1, 0, -1 }, { 1, 0, 1 } };
	static int[][] line3 = { { 1, -1, 0 }, { 2, -1, 0 }, { 4, -1, 0 } };

	static String[] solve(int[][] line) {
		int len = line.length;
		Set<String> set = new HashSet<>();

		int minY = Integer.MAX_VALUE;
		int minX = Integer.MAX_VALUE;
		int maxY = Integer.MIN_VALUE;
		int maxX = Integer.MIN_VALUE;

		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				long x1 = (long) line[i][0];
				long y1 = (long) line[i][1];
				long z1 = (long) line[i][2];
				long x2 = (long) line[j][0];
				long y2 = (long) line[j][1];
				long z2 = (long) line[j][2];
				if (x1 * y2 == y1 * x2 || (y1 * z2 - y2 * z1) % (x1 * y2 - y1 * x2) != 0
						|| (x2 * z1 - x1 * z2) % (x1 * y2 - y1 * x2) != 0) {
					continue;
				}
				int x = (int) (y1 * z2 - y2 * z1) / (int) (x1 * y2 - y1 * x2);
				int y = (int) (x2 * z1 - x1 * z2) / (int) (x1 * y2 - y1 * x2);
				String s = y + " " + x;
				if (set.contains(s)) {
					continue;
				}
				set.add(s);
				minY = Math.min(minY, y);
				minX = Math.min(minX, x);
				maxY = Math.max(maxY, y);
				maxX = Math.max(maxX, x);
			}
		}

		String[] ans = new String[(int) (maxY - minY + 1)];
		for (int i = maxY; i >= minY; i--) {
			StringBuilder sb = new StringBuilder();
			for (int j = minX; j <= maxX; j++) {
				sb.append(set.contains(i + " " + j) ? '*' : '.');
			}
			ans[maxY - i] = sb.toString();
		}
		return ans;
	}

	public static void main(String[] args) throws Exception {
		for (String s : solve(line3)) {
			System.out.println(s);
		}
	}

}