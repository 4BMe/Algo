package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Programmers_보석쇼핑 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static String[] gems = { "AA", "AB", "AC", "AA", "AC" };

	static int[] solution(String[] gems) {
		Map<String, Integer> gemNum = new HashMap<String, Integer>();
		int idx = 0;
		for (int i = 0, c = gems.length; i < c; i++) {
			String gem = gems[i];
			if (!gemNum.containsKey(gem)) {
				gemNum.put(gem, idx);
				idx++;
			}
		}

		int[] ans = new int[2];
		int[] gemArr = new int[idx];
		gemArr[gemNum.get(gems[0])]++;
		int start = 0;
		int end = 0;
		int cnt = 1;
		int size = gems.length;
		int len = gems.length+1;
		while (start < size) {
			if (cnt == idx) {
				if (len > end - start + 1) {
					len = end - start + 1;
					ans[0] = start + 1;
					ans[1] = end + 1;
				}
				int num = gemNum.get(gems[start]);
				start++;
				if (--gemArr[num] == 0) {
					cnt--;
					continue;
				}
			} else {
				end++;
				if (end == size) {
					break;
				}
				int num = gemNum.get(gems[end]);
				if (++gemArr[num] != 1) {
					continue;
				}
				cnt++;
				if (cnt < idx || end - start + 1 >= len) {
					continue;
				}
				len = end - start + 1;
				ans[0] = start + 1;
				ans[1] = end + 1;
			}
		}
		return ans;
	}

	public static void main(String[] args) throws Exception {
		for (int a : solution(gems)) {
			System.out.print(a + " ");
		}
	}

}