package com.sbondar.leetcode.slidingWindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
/*
Given a string s, find the length of the longest substring without repeating characters.
Constraints: 0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
Input: s = ""
Output: 0

every time I expand the window:
   check if the value at e is already in the dictionary
      - not in the dictionary, add it with the position
      - calculate max_length
every time I shrink the window
    - I've seen a duplicate character
      - move s to the index after the first instance I've seen the character
* */

class LongestSubstring {
    public static void main(String[] args) {
        new LongestSubstring().process();
    }

    public int lengthOfLongestSubstring(String s) {
        int length = 0;
        int start = 0;
        Map<Character, Integer> dict = new HashMap<>();//dictionary with the position
        for (int i = 0; i < s.toCharArray().length; i++) {
            char letter = s.toCharArray()[i];
            if (dict.containsKey(letter)) {
                start = Math.max(start, dict.get(letter) + 1);
            }
            dict.put(letter, i);
            length = Math.max(length, i - start + 1);
        }
        return length;
    }

    public void process() {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        System.out.println(lengthOfLongestSubstring(input));
    }
}