package actualinterviews.Facebook

import leetcode.TreeNode

/** 236. Lowest Common Ancestor of a Binary Tree
Medium

Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia:
“The lowest common ancestor is defined between two nodes p and q as the lowest node in T
that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]

Example 1:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.

Example 2:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself
according to the LCA definition.


Note:

All of the nodes' values will be unique.
p and q are different and both values will exist in the binary tree.


 */

fun lowestCommonAncestor(root: TreeNode, p: TreeNode, q: TreeNode): TreeNode {
    // the lca is the node that has two of the following:
    // - p or q in left subtree
    // - p or q in root
    // - p or q in right subtree
    var lca: TreeNode? = null
    fun dfs(node: TreeNode?, targetValue: Int): TreeNode? {
        if (node == null) {
            return null
        } else if (node.`val` == targetValue) {
            return node
        } else {
            val left = dfs(node.left, targetValue)
            if (left != null) {
                return left
            } else {
                val right = dfs(node.right, targetValue)
                return right
            }
        }
    }

    val inLeft: Int = if ((dfs(root.left, p.`val`) != null) || dfs(root.left, q.`val`) != null) 1 else 0
    val inRight: Int = if ((dfs(root.right, p.`val`) != null) || (dfs(root.right, q.`val`) != null)) 1 else 0
    val inRoot: Int = if ((root.`val` == p.`val`) || (root.`val` == q.`val`)) 1 else 0

    if (inLeft + inRight + inRoot >= 2) {
        lca = root
    } else {
        root.left?.let { lowestCommonAncestor(it, p, q) }
        root.right?.let { lowestCommonAncestor(it, p, q) }
    }
    return lca!!
}


val r = lowestCommonAncestor(
        root = TreeNode(3,
                TreeNode(5, TreeNode(6), TreeNode(2, TreeNode(7), TreeNode(4))),
                TreeNode(1, TreeNode(0), TreeNode(8))),
        p = TreeNode(5),
        q = TreeNode(4))

println(r)
