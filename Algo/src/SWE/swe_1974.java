package SWE;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swe_1974 {
	static int T;
	static int[][] map = new int[9][9];
	static boolean[][][] ex;

	public static boolean check() {
		ex = new boolean[10][9][3];

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
//				System.out.println(i + " " + j);
//				System.out.println(i / 3 + j / 3);
				if (ex[map[i][j]][i][0]) {
//					System.out.println("가로");
					return false;
				}
				if (ex[map[i][j]][j][1]) {
//					System.out.println("세로");
					return false;
				}
				if (ex[map[i][j]][(i / 3) * 3 + j / 3][2]) {
//					System.out.println("네로");
					return false;
				}
				/** 가로 확인 */
				ex[map[i][j]][i][0] = true;
				/** 세로 */
				ex[map[i][j]][j][1] = true;
				/** 네모칸 */
				ex[map[i][j]][(i / 3) * 3 + j / 3][2] = true;
			}
		}

		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		T = Integer.parseInt(st.nextToken());
		for (int test = 1; test <= T; test++) {
			for (int i = 0; i < 9; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < 9; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			System.out.println("#" + test + " " + (check() ? 1 : 0));
		}
	}

}
