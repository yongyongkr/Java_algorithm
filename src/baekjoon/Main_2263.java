/**
 * 백준 2263번
 * 트리의 순회
 * https://www.acmicpc.net/problem/2263
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2263 {

	static int[] inorder, postorder, inorderIdx;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());

		inorder = new int[n];
		postorder = new int[n];
		inorderIdx = new int[n];

		for (int i = 0; i < n; i++) {
			inorder[i] = Integer.parseInt(st1.nextToken());
			postorder[i] = Integer.parseInt(st2.nextToken());
		}

		for (int i = 0; i < n; i++) {
			inorderIdx[inorder[i] - 1] = i;
		}

		preorder(0, n - 1, 0, n - 1);
	}

	private static void preorder(int is, int ie, int ps, int pe) {
		if (ie < is || pe < ps)
			return;

		int root = postorder[pe];
		int rootIndex = inorderIdx[root - 1];

		System.out.print(root + " ");

		int len = rootIndex - is;
		preorder(is, rootIndex - 1, ps, ps + len - 1);
		preorder(rootIndex + 1, ie, ps + len, pe - 1);
	}
}
