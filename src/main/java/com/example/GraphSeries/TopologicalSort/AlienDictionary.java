package com.example.GraphSeries.TopologicalSort;

import java.util.*;

/*

Given a sorted dictionary of an alien language having N words and k starting alphabets of standard dictionary.
Find the order of characters in the alien language.
Note: Many orders may be possible for a particular test case, thus you may return any valid order and output
will be 1 if the order of string returned by the function is correct else 0 denoting incorrect string returned.

Example 1:

Input:
N = 5, K = 4
dict = {"baa","abcd","abca","cab","cad"}
Output:
1
Explanation:
Here order of characters is
'b', 'd', 'a', 'c' Note that words are sorted
and in the given language "baa" comes before
"abcd", therefore 'b' is before 'a' in output.
Similarly we can find other orders.
 */
public class AlienDictionary {

    public static void main(String[] args) {

        String[] dict = {"baa","abcd","abca","cab","cad"};
        int N = dict.length;
        int K = 26; // Assuming only lowercase English alphabets

        String res = findOrder(dict, N, K);
        System.out.println(res);

    }

    private static String findOrder(String[] dict, int n, int k) {

        Map<Character, List<Character>> map = new HashMap<>();

        for (String word : dict) {
            for (char ch : word.toCharArray()) {
                if(!map.containsKey(ch)) {
                    map.put(ch, new ArrayList<>());
                }
            }
        }

        for (int i = 0; i< n-1; i++) {
            String word1 = dict[i];
            String word2 = dict[i+1];

            int len = Math.min(word1.length(), word2.length());

            for (int j = 0; j < len; j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);

                if(c1 != c2) {
                    map.get(c1).add(c2);
                    break;
                }
            }
        }

        //perform topological sort
        Stack<Character> st = new Stack<>();
        Set<Character> visited = new HashSet<>();

        for (char c : map.keySet()) {
            if (!visited.contains(c)) {
                dfsUtil(c, map, visited, st);
            }
        }

        // Construct order from stack
        StringBuilder order = new StringBuilder();
        while (!st.isEmpty()) {
            order.insert(0, st.pop());
        }

        return order.toString();
    }

    private static void dfsUtil(char src, Map<Character, List<Character>> map, Set<Character> visited, Stack<Character> st) {

        visited.add(src);

        List<Character> list = map.get(src);

        for (char nbr : list) {
            if(visited.contains(nbr)) {
                dfsUtil(nbr, map, visited, st);
            }
        }

        st.push(src);
    }
}
