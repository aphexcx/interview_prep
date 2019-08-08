package actualinterviews

// Function to find length of Longest Common Subsequence of
// sequences X[0..m-1] and Y[0..n-1]
fun LCSLength(X: String, Y: String, m: Int, n: Int): Int {
    // return if we have reached the end of either sequence
    if (m == 0 || n == 0) {
        return 0
    }

    // if last character of X and Y matches
    if (X[m - 1] == Y[n - 1]) {
        return LCSLength(X, Y, m - 1, n - 1) + 1
    }
    // else if last character of X and Y don't match
    else return Integer.max(
            LCSLength(X, Y, m, n - 1),
            LCSLength(X, Y, m - 1, n)
    )
}

// main function
val X = "ABCBDAB"
val Y = "BDCABA"

print("The length of LCS is " + LCSLength(X, Y, X.length, Y.length))


fun dfs(node: TreeNode?, value: Int): TreeNode? {
    if (node == null) {
        return null
    } else if (node.value == value) {
        return node
    } else {
        val left = dfs(node.left, value)
        val right = dfs(node.right, value)
        if (left != null) return left else return right
    }
}