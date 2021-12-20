package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Programmers_스킬트리 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static String skill = "CBD";
	static String[] skill_trees = { "BACDE", "CBADF", "AECB", "BDA" };

	static int solve(String skill, String[] skill_trees) {
		int ans = 0;
		for (String skillTree : skill_trees) {
			String temp = skillTree;
			for (int i = 0, c = skillTree.length(); i < c; i++) {
				String s = skillTree.substring(i, i + 1);
				if (!skill.contains(s)) {
					temp = temp.replace(s, "");
				}
			}
			if (skill.indexOf(temp) == 0) {
				ans++;
			}
		}

		return ans;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solve(skill, skill_trees));
	}

}