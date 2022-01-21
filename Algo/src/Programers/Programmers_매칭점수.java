package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Programmers_매칭점수 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static String word = "Muzi";
	static String[] pages = {
			"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://careers.kakao.com/interview/list\"/>\n</head>  \n<body>\n<a href=\"https://programmers.co.kr/learn/courses/4673\"></a>#!MuziMuzi!)jayg07con&&\n\n</body>\n</html>",
			"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://www.kakaocorp.com\"/>\n</head>  \n<body>\ncon%\tmuzI92apeach&2<a href=\"https://hashcode.co.kr/tos\"></a>\n\n\t^\n</body>\n</html>" };

	static int solution(String word, String[] pages) {
		int len = pages.length;
		word = "\\b(?i)" + word.toLowerCase() + "\\b";
		Map<String, Page> map = new HashMap<String, Page>();

		for (int i = 0; i < len; i++) {
			Matcher nameM = Pattern.compile("<meta property=\"og:url\" content=\"(\\S*)\"")
					.matcher(pages[i].toLowerCase());
			nameM.find();
			String name = nameM.group().split("=")[2].replaceAll("\"", "");
			Matcher score = Pattern.compile(word)
					.matcher(pages[i].split("<body>")[1].split("</body>")[0].replaceAll("[0-9]", " ").toLowerCase());
			int res = 0;
			while (score.find()) {
				res++;
			}

			Page page = map.getOrDefault(name, new Page(0, 0, new LinkedList<String>()));
			page.score = res;

			Pattern link = Pattern.compile("<a href=\"https://(\\S*)\"");
			Matcher m = link.matcher(pages[i]);
			int out = 0;
			while (m.find()) {
				String linkPage = m.group().split("\"")[1];
				Page lPage = map.getOrDefault(linkPage, new Page(0, 0, new LinkedList<String>()));
				lPage.links.add(name);
				if (!map.containsKey(linkPage)) {
					map.put(linkPage, lPage);
				}
				out++;
			}
			page.outLink = out;
			if (!map.containsKey(name)) {
				map.put(name, page);
			}
		}

		int ans = 0;
		double max = 0;
		for (int i = 0; i < len; i++) {
			Matcher nameM = Pattern.compile("<meta property=\"og:url\" content=\"(\\S*)\"")
					.matcher(pages[i].toLowerCase());
			nameM.find();
			String name = nameM.group().split("=")[2].replaceAll("\"", "");
			Page page = map.get(name);
			double score = page.score;
			for (String s : page.links) {
				Page lPage = map.get(s);
				score += (double) lPage.score / lPage.outLink;
			}
			if (score > max) {
				max = score;
				ans = i;
			}
		}

		return ans;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solution(word, pages));
	}

	static class Page {
		int score;
		int outLink;
		List<String> links;

		public Page(int score, int outLink, List links) {
			this.score = score;
			this.outLink = outLink;
			this.links = links;
		}
	}
}