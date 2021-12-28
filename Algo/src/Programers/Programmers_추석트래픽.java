package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Programmers_추석트래픽 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb;
	static String[] lines = { "2016-09-15 20:59:57.421 0.351s",
			"2016-09-15 20:59:58.233 1.181s",
			"2016-09-15 20:59:58.299 0.8s",
			"2016-09-15 20:59:58.688 1.041s",
			"2016-09-15 20:59:59.591 1.412s",
			"2016-09-15 21:00:00.464 1.466s",
			"2016-09-15 21:00:00.741 1.581s",
			"2016-09-15 21:00:00.748 2.31s",
			"2016-09-15 21:00:00.966 0.381s",
			"2016-09-15 21:00:02.066 2.62s" };

	static int solve(String[] lines) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
		int[] cnt = new int[lines.length];
		int ans = 0;
		long[] sSecs = new long[lines.length];
		long[] eSecs = new long[lines.length];

		for (int i = 0, c = lines.length; i < c; i++) {
			String[] sp = lines[i].split(" ");

			String end = sp[1];
			LocalTime dt = LocalTime.parse(end, formatter);
			eSecs[i] = dt.toNanoOfDay() / 1000000;
			long len = (long) (Double.parseDouble(sp[2].substring(0, sp[2].length() - 1)) * 1000);
			sSecs[i] = eSecs[i] - len + 1;
		}

		for (int i = 0, c = lines.length; i < c; i++) {
			long end = eSecs[i] + 1000;
			for (int j = i; j < c; j++) {
				if (sSecs[j] < end) {
					cnt[i]++;
				}
			}
		}

		for (int a : cnt) {
			ans = Math.max(ans, a);
		}

		return ans;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solve(lines));
	}

}