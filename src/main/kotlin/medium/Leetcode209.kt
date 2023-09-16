package medium

fun minSubArrayLen(target: Int, nums: IntArray): Int {
    var l = 0
    var res = Int.MAX_VALUE
    var s = 0

    for (r in nums.indices) {
        s += nums[r]

        while (s >= target) {
            res = minOf(res, r - l + 1)
            s -= nums[l++]
        }
    }

    return if (res != Int.MAX_VALUE) res else 0
}


fun main() {
    val target = 213
    val nums = intArrayOf(12, 28, 83, 4, 25, 26, 25, 2, 25, 25, 25, 12)
    val result = minSubArrayLen(target, nums)
    println(result)
}
