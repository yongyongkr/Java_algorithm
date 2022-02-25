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

public class Main_5052_1 {

	static class TrieNode {

		Map<Character, TrieNode> children = new HashMap<>();
		boolean isLast;
	}

	static class Trie {

		TrieNode root = new TrieNode();

		public boolean insert(String number) {
			TrieNode thisNode = root;
			for (int i = 0; i < number.length(); i++) {
				char c = number.charAt(i);
				if (thisNode.children.get(c) == null) {
					thisNode.children.put(c, new TrieNode());
				}
				thisNode = thisNode.children.get(c);
				if (thisNode.isLast) {
					return false;
				}
			}
			if (thisNode.children.size() != 0) {
				return false;
			}
			thisNode.isLast = true;
			return true;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());

		while (tc-- > 0) {
			Trie trie = new Trie();
			int n = Integer.parseInt(br.readLine());
			boolean result = true;

			for (int i = 0; i < n; i++) {
				result &= trie.insert(br.readLine());
			}

			if (result) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}
