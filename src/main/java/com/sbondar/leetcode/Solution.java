package com.sbondar.leetcode;

import java.util.*;


//https://leetcode.com/problems/letter-combinations-of-a-phone-number/
/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

Input: digits = ""
Output: []

Input: digits = "2"
Output: ["a","b","c"]

7
["p","q","r","s"]

""
[]
* */


class Solution {

    Map<Character, String> d2charsMap = Map.of(
            '2', "abc",
            '3', "def",
            '4', "ghi",
            '5', "jkl",
            '6', "mno",
            '7', "pqrs",
            '8', "tuv",
            '9', "wxyz"
    );

    public static void main(String[] args) {
        new Solution().process();
    }

    private void process() {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        System.out.println(String.join(",", letterCombinations(input)));
    }

    public List<String> letterCombinations(String digits) {
        if (digits.isBlank()) {
            return new ArrayList<>();
        }
        String str = "";
        Set<String> result = new HashSet<>();
        rec(str, digits, result);

        return new ArrayList<>(result);
    }

    private void rec(final String str, final String leftDigits, final Set<String> result) {
        if (leftDigits.length() == 0) {
            result.add(str);
        } else {
            char currentDigit = leftDigits.charAt(0);
            for (char letter : d2charsMap.get(currentDigit).toCharArray()) {
                rec(str + letter, leftDigits.substring(1), result);
            }
        }
    }
}