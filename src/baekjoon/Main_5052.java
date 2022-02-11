/**
 * 백준 5052번
 * 전화번호 목록
 * https://www.acmicpc.net/problem/5052
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main_5052 {

	static class TrieNode {
		Map<Character, TrieNode> childNodes = new HashMap<>();
		boolean isLast;
	}

	static class Trie {

		TrieNode root = new TrieNode();

		boolean insert(String number) {
			TrieNode thisNode = root;
			for (int i = 0; i < number.length(); i++) {
				char c = number.charAt(i);
				if (thisNode.childNodes.get(c) == null) {
					thisNode.childNodes.put(c, new TrieNode());
				}
				thisNode = thisNode.childNodes.get(c);
				if (thisNode.isLast) {
					return false;
				}
			}
			if (thisNode.childNodes.size() != 0) {
				return false;
			}
			thisNode.isLast = true;
			return true;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			Trie trie = new Trie();
			boolean flag = true;

			int n = Integer.parseInt(br.readLine());
			for (int i = 0; i < n; i++) {
				if (!trie.insert(br.readLine())) {
					flag = false;
				}
			}
			if (flag) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}
