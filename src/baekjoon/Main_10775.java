/**
 * 백준 10775번
 * 공항
 * https://www.acmicpc.net/problem/10775
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10775 {

	static int gates, planes;
	static int[] parent;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		gates = Integer.parseInt(br.readLine());
		planes = Integer.parseInt(br.readLine());
		parent = new int[gates + 1];

		for (int i = 0; i < gates + 1; i++) {
			parent[i] = i;
		}

		int cnt = 0;
		for (int i = 0; i < planes; i++) {
			int plane = Integer.parseInt(br.readLine());

			int root = find(plane);
			if (root != 0) {
				union(root, root - 1);
				cnt += 1;
			} else {
				break;
			}
		}

		System.out.println(cnt);
	}

	private static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x != y) {
			parent[x] = y;
		}
	}

	private static int find(int plane) {
		if (plane == parent[plane]) {
			return plane;
		}
		return parent[plane] = find(parent[plane]);
	}
}
