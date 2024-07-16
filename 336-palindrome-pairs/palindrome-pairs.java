class Solution {
    /**
 * @param words array of unique words
 * @return all the pairs of the distinct indices (i, j) in words, so that the concatenation of words[i] + words[j]
 * is a palindrome
 */
public List<List<Integer>> palindromePairs(String[] words) {
	var pairs = new ArrayList<List<Integer>>();
	var reverseIndex = getReverseIndex(words);
	addEmptyAndPalindromes(words, pairs, reverseIndex);
	addReverses(words, pairs, reverseIndex);
	addSplits(words, pairs, reverseIndex);
	return pairs;
}

/**
 * T/S: O(nw)/O(nw), where n = size(words), w = avg_size(words[i])
 *
 * @param words array of words
 * @return a map of reverse words to their indices
 */
private Map<String, Integer> getReverseIndex(String[] words) {
	var reverseIndex = new HashMap<String, Integer>();
	for (var i = 0; i < words.length; i++)
		reverseIndex.put(new StringBuilder(words[i]).reverse().toString(), i);
	return reverseIndex;
}

/**
 * Case 1
 * T/S: O(nw)/O(n), where n = size(words), w = avg_size(words[i])
 */
private void addEmptyAndPalindromes(String[] words, List<List<Integer>> pairs, Map<String, Integer> reverseIndex) {
	var i = reverseIndex.getOrDefault("", -1);
	if (i == -1)
		return;
	for (var j = 0; j < words.length; j++)
		if (j != i && isPalindrome(words[j])) {
			pairs.add(List.of(i, j));
			pairs.add(List.of(j, i));
		}
}

/**
 * Case 2
 * T/S: O(n)/O(n), where n = size(words), w = avg_size(words[i])
 */
private void addReverses(String[] words, List<List<Integer>> pairs, Map<String, Integer> reverseIndex) {
	for (int i = 0; i < words.length; i++) {
		var j = reverseIndex.getOrDefault(words[i], -1);
		if (i != j && j != -1)
			pairs.add(List.of(i, j));
	}
}

/**
 * Case 3
 * T/S: O(nw²)/O(nw²), where n = size(words), w = avg_size(words[i])
 */
private void addSplits(String[] words, List<List<Integer>> pairs, Map<String, Integer> reverseIndex) {
	for (var i = 0; i < words.length; i++) {
		var word = words[i];

		for (var j = 1; j < word.length(); j++) {
			var left = word.substring(0, j);
			var right = word.substring(j);

			if (reverseIndex.containsKey(right) && isPalindrome(left))
				pairs.add(List.of(reverseIndex.get(right), i));
			if (reverseIndex.containsKey(left) && isPalindrome(right))
				pairs.add(List.of(i, reverseIndex.get(left)));
		}
	}
}

/**
 * T/S: O(w)/O(1), where w = size(s)
 *
 * @param s string
 * @return true if the string is a palindrome, else false
 */
private boolean isPalindrome(String s) {
	for (int i = 0, j = s.length() - 1; i < j; i++, j--)
		if (s.charAt(i) != s.charAt(j))
			return false;
	return true;
}
}