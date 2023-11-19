package hard

import javax.swing.Spring.height
import kotlin.math.max


fun largestRectangleArea(heights: IntArray): Int {
    if (heights.isEmpty()) { return 0 }

    val lessFromLeft = IntArray(heights.size)

    val lessFromRight = IntArray(heights.size)

    lessFromRight[heights.size - 1] = heights.size
    lessFromLeft[0] = -1

    for (i in 1 until heights.size) {
        var p = i - 1
        while (p >= 0 && heights[p] >= heights[i]) {
            p = lessFromLeft[p]
        }
        lessFromLeft[i] = p
    }

    for (i in heights.size - 2 downTo 0) {
        var p: Int = i + 1
        while (p < heights.size && heights[p] >= heights[i]) {
            p = lessFromRight[p]
        }
        lessFromRight[i] = p
    }

    var maxArea = 0
    for (i in 0 until heights.size) {
        maxArea = max(maxArea, heights[i] * (lessFromRight[i] - lessFromLeft[i] - 1))
    }

    return maxArea
}

fun main() {
    val heights = intArrayOf(2, 1, 5, 6, 2, 3)
    val result = largestRectangleArea(heights)
    check(result == 10)

    val heights2 = intArrayOf(4, 2, 3)
    val result2 = largestRectangleArea(heights2)
    check(result2 == 6)

    val heights3 = intArrayOf(5, 4, 1, 2)
    val result3 = largestRectangleArea(heights3)
    check(result3 == 8)

    val heights4 = intArrayOf(0, 9)
    val result4 = largestRectangleArea(heights4)
    check(result4 == 9)

    val heights5 = intArrayOf(1)
    val result5 = largestRectangleArea(heights5)
    check(result5 == 1)
}