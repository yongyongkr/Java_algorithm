/**
 * leetcode
 * 5. Longest Palindromic Substring
 * https://leetcode.com/problems/longest-palindromic-substring/
 */

package leetcode;

public class Solution_LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		if (s == null || s.length() < 1) return "";

		int start = 0;
		int end = 0;
		for (int i = 0; i < s.length(); i++) {
			int len1 = expandFromMiddle(s, i, i);
			int len2 = expandFromMiddle(s, i, i + 1);
			int len = Math.max(len1, len2);
			if (len > end - start + 1) {
				start = i - ((len - 1) / 2);
				end = i + (len / 2);
			}
		}
		return s.substring(start, end + 1);
	}

	private static int expandFromMiddle(String s, int left, int right) {
		while (0 <= left && right < s.length() && left <= right && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		return right - left - 1;
	}
}

/*
public class Solution_LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		String answer = "";
		for (int i = 0; i < s.length() - 1; i++) {
			for (int j = i + 1; j < s.length(); j++) {
				if (s.charAt(i) != s.charAt(j))
					continue;
				if ((j - i + 1 > answer.length()) && checkPalindrome(s, i, j)) {
					answer = s.substring(i, j + 1);
				}
			}
		}
		if (answer.equals("")) {
			return s.substring(0, 1);
		} else {
			return answer;
		}
	}

	private static boolean checkPalindrome(String s, int x, int y) {
		while (x < y) {
			if (s.charAt(x++) != s.charAt(y--))
				return false;
		}
		return true;
	}
}*/
