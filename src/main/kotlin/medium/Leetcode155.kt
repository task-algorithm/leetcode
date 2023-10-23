package medium

import java.util.LinkedList
import java.util.Stack
import kotlin.math.min

class MinStack() {
    private val stack = Stack<Pair<Int, Int>>()

    fun push(`val`: Int) {
        val min = if (stack.isEmpty()) `val` else min(stack.peek().second, `val`)
        stack.push(Pair(`val`, min))
    }

    fun pop() {
        stack.pop()
    }

    fun top(): Int {
        return stack.peek().first
    }

    fun getMin(): Int {
        return stack.peek().second
    }

}
