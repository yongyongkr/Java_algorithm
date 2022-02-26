/**
 * leetcode
 * 55. Jump Game
 * https://leetcode.com/problems/jump-game/
 */

package leetcode;

public class Solution_JumpGame {

	public static boolean canJump(int[] nums) {
		int len = nums.length;
		boolean[] possible = new boolean[len];
		possible[len - 1] = true;

		for (int i = len - 2; i >= 0; i--) {
			check(possible, nums, i);
		}

		return possible[0];
	}

	private static void check(boolean[] possible, int[] nums, int from) {
		for (int i = from + 1; i <= from + nums[from]; i++) {
			if (i >= nums.length) {
				return;
			}
			if (possible[i]) {
				possible[from] = true;
				return;
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = {2, 3, 1, 1, 4};
		System.out.println(canJump(nums));
	}
}
