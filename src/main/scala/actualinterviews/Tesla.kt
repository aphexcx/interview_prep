package actualinterviews

import kotlin.test.assertEquals

/*
Count the number of leaves in a binary tree
*/

class TreeNode(val value: Int, val left: TreeNode?, val right: TreeNode?)

fun countLeaves(node: TreeNode?): Int {
    if (node == null) {
        return 0
    }
    if (node?.left == null && node?.right == null) {
        return 1
    }

    return countLeaves(node?.left) + countLeaves(node?.right)
}

fun main(args: Array<String>) {
    val tree0 = null
    assertEquals(countLeaves(tree0), 0)

    // One node with no children
    val tree1 = TreeNode(0, null, null)
    assertEquals(countLeaves(tree1), 1)

    val tree2 = TreeNode(1, TreeNode(0, null, null), TreeNode(2, null, null))
    assertEquals(countLeaves(tree2), 2)

    /* 1
      / \
     0  2
    /
    4  */
    val tree3 = TreeNode(1, TreeNode(0, TreeNode(4, null, null), null), TreeNode(2, null, null))
    assertEquals(countLeaves(tree3), 2)
}