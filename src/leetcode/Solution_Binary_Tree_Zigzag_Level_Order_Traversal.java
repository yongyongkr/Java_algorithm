/**
 * leetcode
 * 103. Binary Tree Zigzag Level Order Traversal
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */

package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution_Binary_Tree_Zigzag_Level_Order_Traversal {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int val) { this.val = val; }
	}

	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null)
			return result;

		int level = 0;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while (!q.isEmpty()) {
			int size = q.size();
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();

				if (node.left != null) {
					q.offer(node.left);
				}
				if (node.right != null) {
					q.offer(node.right);
				}

				if (level % 2 == 0) {
					list.add(node.val);
				} else {
					list.add(0, node.val);
				}
			}
			level++;
			result.add(list);
		}
		return result;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		TreeNode node1 = new TreeNode(9);
		TreeNode node2 = new TreeNode(20);
		TreeNode node3 = new TreeNode(15);
		TreeNode node4 = new TreeNode(7);

		root.left = node1;
		root.right = node2;
		node2.left = node3;
		node2.right = node4;

		List<List<Integer>> lists = zigzagLevelOrder(root);
		for (List<Integer> list : lists) {
			System.out.println(list.toString());
		}
	}
}
