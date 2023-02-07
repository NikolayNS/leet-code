package com.dmitrenko.leetcode.problems.resolve;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;

public class ReplaceWords {

    public String replaceWords(List<String> dictionary, String sentence) {
        var root = getRoot();
        var num = new AtomicInteger();
        dictionary.forEach(o -> addToTrie(root, o, num.getAndIncrement()));

        var temp = sentence.split(" ");
        for (int i = 0; i < temp.length; i++) {
            System.out.println(findIds(root, temp[i]));
            var set = findIds(root, temp[i]);
            var min = Integer.MAX_VALUE;
            var id = -1;
            for (int c : set) {
                int l = dictionary.get(c).length();
                if (l < min) {
                    min = l;
                    id = c;
                }
            }
            if(id != -1) temp[i] = dictionary.get(id);
        }
        var builder = new StringBuilder();
        for (String s : temp) {
            builder.append(s);
            builder.append(" ");
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

    private TrieNode getRoot() {
        var root = new TrieNode();
        var space = new TrieNode();
        space.parent = root;
        root.children.put(' ', space);
        return root;
    }

    private void addToTrie(TrieNode root, String word, Integer wordId) {
        var current = root.children.get(' ');
        for (char c : word.toCharArray()) {
            if (!current.children.containsKey(c)) {
                var child = new TrieNode();
                child.parent = current;
                child.parentChar = c;
                current.children.put(c, child);
            }
            current = current.children.get(c);
        }
        current.point = wordId;
    }

    private Set<Integer> findIds(TrieNode root, String line) {
        var result = new TreeSet<Integer>();
        var current = root.children.get(' ');
        char[] lineChars = line.toCharArray();
        for (int i = 0; i < lineChars.length - 1; i++) {
            if (current.children.containsKey(lineChars[i])) {
                current = current.children.get(lineChars[i]);
                if (current.point != null) result.add(current.point);
            } else {
                current = followTheLink(root, current, lineChars[i]);
            }
        }
        return result;
    }

    private TrieNode followTheLink(TrieNode root, TrieNode node, char wordChar) {
        if (node.suffixJump.get(wordChar) == null) {
            if (node.children.get(wordChar) != null) {
                node.suffixJump.put(wordChar, node.children.get(wordChar));
            } else if (node == root) {
                node.suffixJump.put(wordChar, root);
            } else {
                node.suffixJump.put(wordChar, followTheLink(root, buildSuffixLink(root, node), wordChar));
            }
        }
        return node.suffixJump.get(wordChar);
    }

    private TrieNode buildSuffixLink(TrieNode root, TrieNode node) {
        if (node.suffixLink == null) {
            node.suffixLink = (node != root && node.parent != root)
                ? followTheLink(root, buildSuffixLink(root, node.parent), node.parentChar)
                : root;
        }
        return node.suffixLink;
    }

    private static class TrieNode {
        private char parentChar;
        private Integer point;
        private TrieNode parent;
        private TrieNode suffixLink;
        private final Map<Character, TrieNode> children = new HashMap<>();
        private final Map<Character, TrieNode> suffixJump = new HashMap<>();
    }

    public static void main(String[] args) {
        System.out.println(new ReplaceWords().replaceWords(List.of("cat", "ca","bat","rat"), "the cattle was rattled by the battery"));
    }
}
