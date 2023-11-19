package medium

import common.Node
import java.util.LinkedList

fun connect(root: Node?): Node? {
    bfs(root)
    return root
}

fun bfs(root: Node?) {
    if (root == null) {
        return
    }
    val queue = LinkedList<Node>()
    queue.add(root)
    while (queue.isNotEmpty()) {
        val r = queue.size
        val temp = LinkedList<Node>()
        repeat(r) {
            val node = queue.pollFirst()
            node.next = queue.peek()
            node.left?.also { temp.addLast(it) }
            node.right?.also { temp.addLast(it) }
        }

        queue.addAll(temp)
    }
}

fun main() {
    val node = Node(1)
    node.left = Node(2)
    node.right = Node(3)
    node.left?.left = Node(4)
    node.left?.right = Node(5)
    node.right?.left = Node(6)
    node.right?.right = Node(7)
    connect(node)
}