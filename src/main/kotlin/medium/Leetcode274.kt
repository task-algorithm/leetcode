package medium

fun hIndex(citations: IntArray): Int {
    var low = 0
    var high = citations.size
    while (low < high) {
        val mid = (low + high + 1) / 2
        var count = 0
        for (i in citations.indices) {
            if (citations[i] >= mid) ++count
        }
        if (count >= mid) {
            low = mid
        } else {
            high = mid - 1
        }
    }
    return low
}

fun main() {
    val citations = intArrayOf(3, 0, 6, 5, 1)
    val result = hIndex(citations)
    println(result)
}
