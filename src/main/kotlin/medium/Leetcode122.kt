package medium

fun maxProfit(prices: IntArray): Int {
    var profit = 0
    for (i in 1..prices.size - 1) {
        if (prices[i] > prices[i - 1]) {
            profit += (prices[i] - prices[i - 1])
        }
    }
    return profit
}
fun main() {
    val prices = intArrayOf(7, 1, 5, 3, 6, 4)
    val result = maxProfit(prices)

    println(result)
}