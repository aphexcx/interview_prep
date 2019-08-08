package leetcode

import leetcode.CloneGraph.Node
import java.util.*

/** 133. Clone Graph
Medium

Given a reference of a node in a connected undirected graph, return a deep copy (clone)
of the graph. Each node in the graph contains a val (int) and a list (List[Node])of
its neighbors.


Example:
https://assets.leetcode.com/uploads/2019/02/19/113_sample.png

Input:
{"$id":"1","neighbors":[
{"$id":"2","neighbors":[{"$ref":"1"},{"$id":"3","neighbors":[{"$ref":"2"},{"$id":"4",
"neighbors":[{"$ref":"3"},{"$ref":"1"}],"val":4}],"val":3}],"val":2},{"$ref":"4"}],"val":1}

Explanation:
Node 1's value is 1, and it has two neighbors: Node 2 and 4.
Node 2's value is 2, and it has two neighbors: Node 1 and 3.
Node 3's value is 3, and it has two neighbors: Node 2 and 4.
Node 4's value is 4, and it has two neighbors: Node 1 and 3.


Note:

The number of nodes will be between 1 and 100.
The undirected graph is a simple graph, which means no repeated edges and no self-loopsin the graph.
Since the graph is undirected, if node p has node q as neighbor, then node q must have node p
as neighbor too.
You must return the copy of the given node as a reference to the cloned graph.

 */

// Definition for a Node.
data class Node(var `val`: Int, var neighbors: MutableList<Node> = mutableListOf())

fun cloneGraph(node: Node): Node? {
//    val visited: MutableSet<Node> = mutableSetOf(node)

    val queue: Queue<Node> = ArrayDeque()

    val newNodesMap = mutableMapOf<Int, Node>()

    queue.add(node)
    newNodesMap[node.`val`] = Node(node.`val`)

    while (queue.isNotEmpty()) {
        val current: Node = queue.remove()
        for (neighbor in current.neighbors) {
            if (neighbor.`val` !in newNodesMap) {
                newNodesMap[neighbor.`val`] = Node(neighbor.`val`)
                queue.add(neighbor)
            }
            newNodesMap[current.`val`]?.neighbors?.add(newNodesMap[neighbor.`val`]!!)
        }
    }

    return newNodesMap[node.`val`]
}

val v1 = Node(1)
val v2 = Node(2)
val v3 = Node(3)
val v4 = Node(4)

v1.neighbors.add(v2)
v1.neighbors.add(v4)

v2.neighbors.add(v1)
v2.neighbors.add(v3)

v3.neighbors.add(v2)
v3.neighbors.add(v4)

v4.neighbors.add(v1)
v4.neighbors.add(v3)

val r = cloneGraph(v1)
println(r)