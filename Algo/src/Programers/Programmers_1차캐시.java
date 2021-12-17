package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Programmers_1차캐시 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int cacheSize = 3;
	static String[] cities = { "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA" };

	static int solve(int cacheSize, String[] cities) {
		int ans = 0;
		LinkedHashMap<String, Boolean> cache = new LinkedHashMap<String, Boolean>(cacheSize, 0.75f, true);
		List<String> cache2 = new LinkedList<>();

		for (int i = 0, c = cities.length; i < c; i++) {
			String city = cities[i].toLowerCase();
			if (cache2.contains(city)) {
				cache2.remove(cache2.indexOf(city));
				ans++;
			} else {
				ans += 5;
			}
			cache2.add(city);
			if (cache2.size() > cacheSize) {
				cache2.remove(0);
			}
		}
		return ans;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solve(cacheSize, cities));
	}

}