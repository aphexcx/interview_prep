package leetcode

/** Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:

Input:
2
/ \
1   3
Output: true
Example 2:

5
/ \
1   4
/ \
3   6
Output: false
Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
is 5 but its right child's value is 4.
 */
fun isValidBST(root: TreeNode?): Boolean {
    fun isValid(node: TreeNode?, min: Long = Long.MIN_VALUE, max: Long = Long.MAX_VALUE): Boolean {
        return when {
            node == null -> true
            node.`val` <= min || node.`val` >= max -> false
            else -> isValid(node.left, min, node.`val`.toLong()) && isValid(node.right, node.`val`.toLong(), max)
        }
    }
    return isValid(root)
}

fun main(args: Array<String>) {
    println(
        isValidBST(
            TreeNode(
                5,
                TreeNode(1), TreeNode(
                    4,
                    TreeNode(3), TreeNode(6)
                )
            )
        )
    )
}