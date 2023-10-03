package hard

import kotlin.math.max

fun candy(ratings: IntArray): Int {
    val n = ratings.size
    val candies = IntArray(n)
    candies.fill(1)
    for (i in 1 until n) {
        if (ratings[i] > ratings[i - 1]) {
            candies[i] = candies[i - 1] + 1
        }
    }

    for (i in n - 2 downTo 0) {
        if (ratings[i] > ratings[i + 1]) {
            candies[i] = max(candies[i], candies[i + 1] + 1)
        }
    }

    return candies.sum()
}

fun main() {
    val ratings1 = intArrayOf(1, 2, 2)
    val r1 = candy(ratings1)
    check(r1 == 4)

    val ratings2 = intArrayOf(1, 0, 2)
    val r2 = candy(ratings2)
    check(r2 == 5)

    val ratings3 = intArrayOf(1, 3, 2, 2, 1)
    val r3 = candy(ratings3)
    check(r3 == 7)
}
