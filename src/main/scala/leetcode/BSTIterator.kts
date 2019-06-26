import leetcode.TreeNode

/**
 * 173. Binary Search Tree Iterator
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Example:
https://assets.leetcode.com/uploads/2018/12/25/bst-tree.png

BSTIterator iterator = new BSTIterator(root);
iterator.next();    // return 3
iterator.next();    // return 7
iterator.hasNext(); // return true
iterator.next();    // return 9
iterator.hasNext(); // return true
iterator.next();    // return 15
iterator.hasNext(); // return true
iterator.next();    // return 20
iterator.hasNext(); // return false


Note:

next() and hasNext() should run in average O(1) time and uses O(h) memory,
where h is the height of the tree.

You may assume that next() call will always be valid, that is, there will be at
least a next smallest number in the BST when next() is called.
 */

// Traverse tree, store all elements and then sort list; next() will simply iterate over this list
class BSTIterator(root: TreeNode?) {

    val values: List<Int> = collectValues(root).sorted()
    val iterator = values.iterator()
    private fun collectValues(root: TreeNode?): List<Int> {
        fun go(node: TreeNode?): List<Int> {
            if (node == null) {
                return listOf()
            } else {
                return go(node.left) + node.`val` + go(node.right)
            }
        }

        return go(root) //, listOf())
    }


    /** @return the next smallest number */
    fun next(): Int {
        return iterator.next()
    }

    /** @return whether we have a next smallest number */
    fun hasNext(): Boolean {
        return iterator.hasNext()
    }

}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * var obj = BSTIterator(root)
 * var param_1 = obj.next()
 * var param_2 = obj.hasNext()
 */
fun runner(bstIterator: BSTIterator, list: List<String>) {
    list.forEach {
        when (it) {
            "next" -> println(bstIterator.next())
            "hasNext" -> println(bstIterator.hasNext())
        }
    }
}

runner(
        BSTIterator(TreeNode(7, TreeNode(3), TreeNode(15, TreeNode(9), TreeNode(20)))),
        listOf("BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext")
)
