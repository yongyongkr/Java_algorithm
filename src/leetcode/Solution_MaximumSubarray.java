/**
 * leetcode
 * 53. Maximum Subarray
 * https://leetcode.com/problems/maximum-subarray/
 */

package leetcode;

public class Solution_MaximumSubarray {
	public int maxSubArray(int[] nums) {
		int currentSum = nums[0];
		int maxSum = nums[0];
		for (int i = 1; i < nums.length; i++) {
			currentSum = Math.max(currentSum + nums[i], nums[i]);
			maxSum = Math.max(maxSum, currentSum);
		}
		return maxSum;
	}
}
