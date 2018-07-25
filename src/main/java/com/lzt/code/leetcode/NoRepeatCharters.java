package com.lzt.code.leetcode;

import java.util.HashSet;
import java.util.Set;

public class NoRepeatCharters {

	public static int lengthOfLongestSubstring(String s) {
		Integer size = s.length();
		if (size == 0) {
			return size;
		}
		char chars[] = s.toCharArray();
		int result = sunique(chars);
		if (size == result) {
			return size;
		}
		size = result;
		for (int i = size; i > 1; i--) {
			if (chars(s, i)) {
				return i;
			}
		}
		return 1;
	}
	
	static boolean chars(String s, int k) {
		boolean result = false;
		int size = s.length();
		for (int i = 0; i < size - k + 1; i++) {
			char[] chars = new char[k];
			s.getChars(i, i + k, chars, 0);
			if (allunique(chars)) {
				result = true;
				break;
			}
		}
		return result;
	}

	static boolean allunique(char[] chars) {
		Set<Character> set1 = new HashSet<>();
		for (char tmp : chars) {
			set1.add(tmp);
		}
		if (set1.size() == chars.length) {
			return true;
		}
		return false;
	}

	static int sunique(char[] chars) {
		Set<Character> set1 = new HashSet<>();
		for (char tmp : chars) {
			set1.add(tmp);
		}
		return set1.size();
	}

	public static void main(String args[]) {
		System.out.println(lengthOfLongestSubstring(
				"zwvqsdmfyncaoinuyiikctlwgupmlqhmoccghqlfeohuyvowfyhjuufarxocpvodzsjgiwnomuilryhwxqgtnntekhgz"));
		// System.out.println(lengthOfLongestSubstring("aabcc"));
	}

}
