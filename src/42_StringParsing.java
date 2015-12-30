import java.util.Arrays;

/**
 * Given . ? and ! as sentence separators and space as word separator return
 * maximum number of words in a sentence.
 * 
 * @author joshi18
 *
 */
public class Solution {

	public int solution(String S) {

		String sentences[] = S.split("\\.|\\?|\\!");
		int maxWords = 0;
		System.out.println(Arrays.toString(sentences));
		for (String sentence : sentences) {
			String words[] = sentence.split(" ");
			int wordCount = countWords(words);
			if (wordCount > maxWords) {
				maxWords = wordCount;
			}
		}
		return maxWords;
	}

	int countWords(String[] words) {
		int count = 0;
		for (String word : words) {
			if (word != null && !word.trim().isEmpty()) {
				++count;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.solution("We test coders. Give us a try?");
	}
}
