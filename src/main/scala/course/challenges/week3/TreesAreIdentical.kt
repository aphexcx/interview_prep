package course.challenges.week3


class TreeNode(val value: Int, val left: TreeNode, val right: TreeNode)

fun areIdentical(tree1: TreeNode?, tree2: TreeNode?): Boolean {
    if (tree1 == null && tree2 == null) return true

    if (tree1 != null && tree2 != null && tree1.value == tree2.value) {
        return areIdentical(tree1.left, tree2.left) && areIdentical(tree1.right, tree2.right)
    } else {
        return false
    }
}
