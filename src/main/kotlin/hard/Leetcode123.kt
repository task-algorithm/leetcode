package hard

import kotlin.math.max
import kotlin.math.min

fun maxProfit(prices: IntArray): Int {
    if (prices.isEmpty()) return 0

    val left = IntArray(prices.size) { 0 }
    val right = IntArray(prices.size) { 0 }
    var min = prices[0]

    for (i in 1..prices.size - 1) {
        val curr = prices[i]
        val profit = max(left[i - 1], prices[i] - min)
        min = min(min, curr)
        left[i] = profit
    }

    var max = prices[prices.size - 1]

    for (i in prices.size - 2 downTo 0) {
        val curr = prices[i]
        val profit = max(right[i + 1], max - prices[i])
        max = max(max, curr)
        right[i] = profit
    }

    var maxProfit = Int.MIN_VALUE

    for (i in prices.indices) {
        val leftPrice = left[i]
        val rightPrice = right[i]

        maxProfit = max(maxProfit, leftPrice + rightPrice)
    }

    return maxProfit
}

fun main() {
    val prices = intArrayOf(3, 3, 5, 0, 0, 3, 1, 4)
    val profit = maxProfit(prices)

    println(profit)
}