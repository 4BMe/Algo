package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Programmers_브라이언의고민 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static String sentence = "HaEaLaLaObWORLDb";

	static String solution(String sentence) {
		StringBuilder answerList = new StringBuilder();
		LinkedHashMap<Character, List<Integer>> lowerCount = new LinkedHashMap<>();
		String invalid = "invalid";
		int len = sentence.length();
		for (int i = 0; i < len; i++) {
			char c = sentence.charAt(i);
			if (Character.isLowerCase(c)) {
				if (!lowerCount.containsKey(c)) {
					lowerCount.put(c, new ArrayList<Integer>());
				}
				lowerCount.get(c).add(i);
			}
		}

		List<Word> words = new ArrayList<>();
		int start_str = 0, start_char, end_char, start_char_pre = -1, end_char_pre = -1, start_word = 0, end_word = 0,
				end_word_pre = -1, num, rule = -1, distance;
		boolean isDistance2;
		for (List<Integer> positions : lowerCount.values()) {
			num = positions.size();
			start_word = start_char = positions.get(0);
			end_word = end_char = positions.get(num - 1);
			isDistance2 = true;
			for (int i = 1; i < num; i++) {
				distance = positions.get(i) - positions.get(i - 1);
				if (distance < 2)
					return invalid; // [X] 기호가 연속으로 붙어있음 (예외 1)
				if (distance > 2) {
					isDistance2 = false;
					break;
				}
			}
			if (num >= 3 && !isDistance2)
				return invalid; // [X] 규칙 1 - 간격 2 아님 (예외 2)
			if (num == 1 || num >= 3) {
				rule = 1;
				start_word--;
				end_word++;
				if (start_word < 0 || len <= end_word)
					return invalid; // [X] 규칙 1 - 맨 앞/뒤 글자 없음 (예외 3)
			}
			if (num == 2)
				rule = isDistance2 ? 0 : 2; // 규칙 0 => 규칙 1 또는 2
			if (start_char_pre < start_char && end_char < end_char_pre) {
				if (rule == 2)
					return invalid; // [X] 규칙 2 - 한 단어에 같은 규칙 2번 적용 (예외 4)
				continue; // 규칙 2 안에 규칙 1
			}
			if (end_word_pre >= start_word)
				return invalid; // [X] 단어 범위 안 맞음 (예외 5)
			words.add(new Word(rule, start_word, end_word));
			start_char_pre = start_char;
			end_char_pre = end_char;
			end_word_pre = end_word;
		}

		StringBuilder answer = new StringBuilder();
		int size = words.size();
		Word word;
		for (int i = 0; i < size; ++i) {
			word = words.get(i);
			rule = word.rule;
			start_word = word.start;
			end_word = word.end;
			if (rule == 0) { // 규칙 1 또는 2
				if ((start_str <= start_word - 1) && (end_word + 1 < (i < size - 1 ? words.get(i + 1).start : len))) { // 규칙
																														// 1
					start_word--;
					end_word++;
				}
			}
			if (start_str < start_word)
				answer.append(makeWord(start_str, start_word - 1));
			answer.append(makeWord(start_word, end_word));
			start_str = end_word + 1;
		}
		if (start_str < len)
			answer.append(makeWord(start_str, len - 1));
		return answer.toString().trim();
	}

	static public String makeWord(int start, int end) {
		StringBuilder str = new StringBuilder();
		char c;
		for (int i = start; i <= end; ++i) {
			c = sentence.charAt(i);
			if (c >= 'A' && c <= 'Z')
				str.append(c);
		}
		return str.toString() + " ";
	}

	static class Word {
		int rule, start, end;

		public Word(int rule, int start, int end) {
			this.rule = rule;
			this.start = start;
			this.end = end;
		}
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solution(sentence));
	}

}