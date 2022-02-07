/**
 * leetcode
 * 95. Unique Binary Search Trees II
 * https://leetcode.com/problems/unique-binary-search-trees-ii/
 */

package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution_Unique_Binary_Search_Trees_2 {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int val) { this.val = val; }
	}

	public List<TreeNode> generateTrees(int n) {
		if (n == 0) return new ArrayList<>();

		return generateTrees(1, n);
	}

	private static List<TreeNode> generateTrees(int left, int right) {
		List<TreeNode> roots = new ArrayList<>();
		if (left > right) {
			roots.add(null);
		} else {
			for (int i = left; i <= right; i++) {
				List<TreeNode> leftSubtrees = generateTrees(left, i - 1);
				List<TreeNode> rightSubtrees = generateTrees(i + 1, right);

				for (TreeNode leftSubtree : leftSubtrees) {
					for (TreeNode rightSubtree : rightSubtrees) {
						TreeNode root = new TreeNode(i);
						root.left = leftSubtree;
						root.right = rightSubtree;
						roots.add(root);
					}
				}
			}
		}
		return roots;
	}
}
