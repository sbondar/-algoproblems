package com.sbondar.hackerrank;

import java.util.*;

//https://www.hackerrank.com/challenges/balanced-brackets/problem
/*
1
{[(])}

1
}}}

3
{[()]}
{[(])}
{{[[(())]]}}
* */

public class BalancedBrackets {
    public static void main(String[] args) {
        new BalancedBrackets().processStrings();
    }

    public void processStrings() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        for (int l = 0; l < n; l++) {
            String s = scan.nextLine();
            System.out.println(isBalanced(s));
        }
    }

    private String isBalanced(final String s) {
        Map<Character, Character> br = new HashMap<>();
        br.put('{', '}');
        br.put('(', ')');
        br.put('[', ']');

        Deque<Character> openBr = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (br.containsKey(c)) {
                openBr.push(c);
            } else {
                if (openBr.isEmpty() || br.get(openBr.pop()) != c) {
                    return "NO";
                }
            }
        }
        return openBr.isEmpty() ? "YES" : "NO";
    }
}