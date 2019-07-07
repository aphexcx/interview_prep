package leetcode

/** 938. Range Sum of BST
Easy

Given the root node of a binary search tree,
return the sum of values of all nodes with value between L and R (inclusive).

The binary search tree is guaranteed to have unique values.

Example 1:
Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
Output: 32


Example 2:
Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
Output: 23


Note:
The number of nodes in the tree is at most 10000.
The final answer is guaranteed to be less than 2^31.

 */


fun rangeSumBST(root: TreeNode?, L: Int, R: Int): Int {
    if (root == null) {
        return 0
    } else {
        if (root.`val` < L) {
            return rangeSumBST(root.right, L, R)
        } else if (root.`val` > R) {
            return rangeSumBST(root.left, L, R)
        } else { // root.`val` in L..R
            return root.`val` + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R)
        }
    }
}

// [10,5,15,3,7,null,18]
//7
//15

println(rangeSumBST(TreeNode(10, TreeNode(5, TreeNode(3), TreeNode(7, TreeNode(18))), TreeNode(15)), 7, 15))