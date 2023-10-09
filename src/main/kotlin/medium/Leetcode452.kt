package medium

import java.util.Arrays
import kotlin.math.min

fun findMinArrowShots(points: Array<IntArray>): Int {
    Arrays.sort(points) { a, b ->
        if (a[0] == b[0]) a[1].compareTo(b[1]) else a[0].compareTo(b[0])
    }
    var arrows = 1
    var minEnd = points[0][1]

    for (i in 1..points.lastIndex) {
        val (start, end) = points[i]
        if (minEnd < start) {
            ++arrows
            minEnd = end
        }
        if (end < minEnd) minEnd = end
    }

    return arrows
}

fun isBetween(x: Int, y: Int, target: Int): Boolean {
    return target in x..y
}

fun main() {
    val points = arrayOf(
        intArrayOf(10, 16),
        intArrayOf(2, 8),
        intArrayOf(1, 6),
        intArrayOf(7, 12),
    )
    val result = findMinArrowShots(points)
    println(result)

    val points2 = arrayOf(
        intArrayOf(1, 2),
        intArrayOf(2, 3),
        intArrayOf(3, 4),
        intArrayOf(4, 5),
    )
    val result2 = findMinArrowShots(points2)
    println(result2)
}
