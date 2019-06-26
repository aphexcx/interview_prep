package leetcode

import java.lang.Math.abs

/**
 * Given a binary tree, return the tilt of the whole tree.

The tilt of a tree node is defined as the absolute difference between the sum of
all left subtree node values and the sum of all right subtree node values.
Null node has tilt 0.

The tilt of the whole tree is defined as the sum of all nodes' tilt.

Example:
Input:
1
/  \
2    3
Output: 1
Explanation:
Tilt of node 2 : 0
Tilt of node 3 : 0
Tilt of node 1 : |2-3| = 1
Tilt of binary tree : 0 + 0 + 1 = 1
Note:

The sum of node values in any subtree won't exceed the range of 32-bit integer.
All the tilt values won't exceed the range of 32-bit integer.

 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

fun size(node: TreeNode?): Int {
    if (node == null) {
        return 0
    } else {
        return 1 + size(node.left) + size(node.right)
    }
}

fun minValue(node: TreeNode?): Int {
    fun go(node: TreeNode?, min: Int): Int {
        if (node == null) {
            return min
        } else {
            val newMin = if (node.`val` < min) {
                node.`val`
            } else min
            val minLeft = go(node.left, newMin)
            val minRight = go(node.right, newMin)

            return kotlin.math.min(minLeft, minRight)
        }
    }
    return go(node, 0)
}

fun findTilt(root: TreeNode?): Int {
    fun tiltOf(node: TreeNode?): Int {
        return when {
            node == null -> 0
            else -> {
                fun sum(node: TreeNode?): Int =
                        when {
                            node == null -> 0
                            else -> node.`val` + sum(node.left) + sum(node.right)
                        }

                val leftSum = sum(node.left)
                val rightSum: Int = sum(node.right)
                val thisNodesTilt = abs(leftSum - rightSum)
                return thisNodesTilt + tiltOf(node.left) + tiltOf(node.right)
            }
        }
    }
    return tiltOf(root)
}


fun main(args: Array<String>) {
    println(
            findTilt(
                    TreeNode(5,
                            left = TreeNode(1), right = TreeNode(4,
                            left = TreeNode(3), right = TreeNode(6))
                    )
            )
    )
}