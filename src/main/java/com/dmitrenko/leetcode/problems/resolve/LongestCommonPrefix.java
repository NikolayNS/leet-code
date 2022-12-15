package com.dmitrenko.leetcode.problems.resolve;

public class LongestCommonPrefix {

	public String longestCommonPrefix(String[] strs) {
		var minStr = strs[0];
		for (String s : strs) {
			if (minStr.length() > s.length()) {
				minStr = s;
			}
		}

		var result = new StringBuilder();
		for (int i = 0; i < minStr.length(); i++) {
			for (String s : strs) {
				if (minStr.charAt(i) != s.charAt(i)) {
					return result.toString();
				}
			}
			result.append(minStr.charAt(i));
		}

		return result.toString();
	}

	public static void main(String[] args) {

		System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[]{"Pref", "Pr", "Prte"}));
	}
}
