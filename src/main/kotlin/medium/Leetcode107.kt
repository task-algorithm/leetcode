package medium

import common.TreeNode

fun levelOrderBottom(root: TreeNode?): List<List<Int>> {
    val result = mutableListOf<MutableList<Int>>()
    recursive(root, result, 0)
    return result.reversed()
}

private fun recursive(root: TreeNode?, levelTraversal: MutableList<MutableList<Int>>, level: Int) {
    if (root == null) return
    while (levelTraversal.size <= level) {
        levelTraversal.add(mutableListOf())
    }
    recursive(root.left, levelTraversal, level + 1)
    recursive(root.right, levelTraversal, level + 1)
    levelTraversal[level].add(root.value)
}


fun main() {
    val root = TreeNode(3)
    root.left = TreeNode(9)
    root.right = TreeNode(20)
    root.right?.left = TreeNode(15)
    root.right?.right = TreeNode(7)
    val result = levelOrderBottom(root)
}
