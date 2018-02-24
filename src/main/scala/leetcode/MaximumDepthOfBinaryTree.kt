package leetcode

import java.lang.Math.max


/** Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

For example:
Given binary tree [3,9,20,null,null,15,7],

3
/ \
9  20
/    \
15    7

return its depth = 3.
 */

class TreeNode(var `val`: Int = 0) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution2 {
    fun maxDepth(root: TreeNode?): Int {
        fun go(root: TreeNode?, depth: Int): Int =
            when {
                root == null -> 0
                root.left == null && root.right == null -> depth + 1
                else -> max(go(root.left, depth + 1), go(root.right, depth + 1))
            }

        return go(root, depth = 0)
    }
}