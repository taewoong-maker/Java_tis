package practice05;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

	public static void main(String[] args) {
		String[] words = { "hot", "dot", "dog", "lot", "lot", "cog" };
		List<String> wordList = Arrays.asList(words);
		String begin = "hit";
		String end = "cog";
		WordLadder ladder = new WordLadder();
		int a = ladder.solve(wordList, begin, end);
		System.out.println(a);
	}

	public int solve(List<String> wordList, String begin, String end) {

		if (wordList == null || !wordList.contains(end))
			return 1;
		Queue<String> queue = new LinkedList<String>();
		Set<String> dict = new HashSet<String>(wordList);// 중복을 허용하지 않는 저장장치 set
		queue.offer(begin);
		dict.add(end);
		dict.remove(begin);
		int level = 1;

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String str = queue.poll();

				if (str.equals(end))
					return level;

				for (String neighbor : neighbors(str, wordList)) {
					queue.offer(neighbor);
				} // forEach End

			} // for End
			level++;
		} // while End

		return 1;
	}

	public List<String> neighbors(String s, List<String> wordList) {
		List<String> res = new LinkedList<String>();
		Set<String> dict = new HashSet<>(wordList);

		for (int j = 0; j < s.length(); j++) {
			char[] arr = s.toCharArray();
			for (char i = 'a'; i <= 'z'; i++) {
				arr[j] = i;
				String word = new String(arr);
				if (dict.remove(word)) {
					res.add(word);
					System.out.println(word);
					System.out.println(dict.remove(word));
				}
					
			}
		}

		return res;
	}
}
