package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Programmers_주차요금계산 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int[] fees = { 180, 5000, 10, 600 };
	static String[] records = { "05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN",
			"18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT" };

	static int[] solution(int[] fees, String[] records) {
		Map<String, List<Integer>> cars = new HashMap<>();

		for (String s : records) {
			String number = s.substring(6, 10);
			int m = Integer.parseInt(s.substring(0, 2)) * 60 + Integer.parseInt(s.substring(3, 5));
			if (cars.containsKey(number)) {
				List<Integer> times = cars.get(number);
				times.add(m);
			} else {
				List<Integer> times = new ArrayList<Integer>();
				times.add(m);
				cars.put(number, times);
			}
		}

		String[] sortedKey = cars.keySet().stream().sorted(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return Integer.parseInt(o1) - Integer.parseInt(o2);
			}
		}).toArray(String[]::new);

		int[] ans = new int[sortedKey.length];
		for (int i = 0, c = sortedKey.length; i < c; i++) {
			List<Integer> times = cars.get(sortedKey[i]);
			if (times.size() % 2 != 0) {
				times.add(1439);
			}
			int time = 0;
			for (int j = times.size() - 1; j >= 0; j -= 2) {
				time += times.get(j) - times.get(j - 1);
			}
			ans[i] = fees[1];
			if (time > fees[0]) {
				ans[i] += Math.ceil((double) (time - fees[0]) / fees[2]) * fees[3];
			}
		}

		return ans;
	}

	public static void main(String[] args) throws Exception {
		for (int a : solution(fees, records)) {
			System.out.print(a + " ");
		}
	}

}