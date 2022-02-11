package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution_Validate_Binary_Search_Tree {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}

	public boolean isValidBST(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		inorder(root, list);
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i - 1) >= list.get(i))
				return false;
		}
		return true;
	}

	private static void inorder(TreeNode root, List<Integer> list) {
		if (root == null)
			return;
		inorder(root.left, list);
		list.add(root.val);
		inorder(root.right, list);
	}
}
