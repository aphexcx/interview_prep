package leetcode

/** 1008. Construct Binary Search Tree from Preorder Traversal
Medium

Return the root node of a binary search tree that matches the given preorder traversal.

(Recall that a binary search tree is a binary tree where for every node,
any descendant of node.left has a value < node.val,
and any descendant of node.right has a value > node.val.

Also recall that a preorder traversal displays the value of the node first,
then traverses node.left, then traverses node.right.)



Example 1:

Input: [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]



Note:

1 <= preorder.length <= 100
The values of preorder are distinct.
 */

fun bstFromPreorder(preorder: IntArray): TreeNode? {
    if (preorder.isEmpty()) return null
    val value = preorder.first()
    val rest = preorder.drop(1)
    if (rest.isEmpty()) return TreeNode(value)

    val left: IntArray
    val right: IntArray
    when (val pivotIdx = rest.indexOfFirst { it > value }) {
        -1 -> {
            left = rest.toIntArray()
            right = intArrayOf()
        }
        else -> {
            if (pivotIdx == 0) {
                left = intArrayOf()
            } else {
                left = rest.slice(0 until pivotIdx).toIntArray()
            }
            right = rest.slice(pivotIdx..rest.lastIndex).toIntArray()
        }
    }

    return TreeNode(value).apply {
        this.left = bstFromPreorder(left)
        this.right = bstFromPreorder(right)
    }
}

val r = bstFromPreorder(intArrayOf(4, 2))
val r2 = bstFromPreorder(intArrayOf(8, 5, 1, 7, 10, 12))
println(r)


/** Optimal solution:
 * It's quite obvious that the best possible time complexity for this problem is \mathcal{O}(N)O(N)
 * and hence the approach 1 is not the best one.

Basically, the inorder traversal above was used only to check if the element could be placed in this subtree.
Since one deals with a BST here, this could be verified with the help of lower and upper limits
for each element as for the validate BST problem. This way there is no need in inorder traversal
and the time complexity is \mathcal{O}(N)O(N).
 */

fun bstFromPreorderOptimal(preorder: IntArray): TreeNode? {

    var idx = 0

    fun go(lower: Int, upper: Int): TreeNode? {
        // if all elements from preorder are used
        // then the tree is constructed
        if (idx == preorder.size) return null

        val value = preorder[idx]
        // if the current element
        // couldn't be placed here to meet BST requirements
        if (value < lower || value > upper) return null

        // place the current element
        // and recursively construct subtrees
        idx++
        return TreeNode(value).apply {
            this.left = go(lower, value)
            this.right = go(value, upper)
        }
    }

    return go(Integer.MIN_VALUE, Integer.MAX_VALUE)
}