package medium

fun rotate(nums: IntArray, k: Int): Unit {
    val n = k % nums.size
    repeat(n) {
        shiftFrontOneStep(nums)
    }
}

fun shiftFrontOneStep(nums: IntArray): Unit {
    for (i in (1..nums.size - 1).reversed()) {
        val temp = nums[i]
        nums[i] = nums[i - 1]
        nums[i - 1] = temp
    }
}

fun main() {
    val nums = intArrayOf(1, 2, 3, 4, 5, 6, 7)
    val k = 1
    rotate(nums, k)

    nums.forEach { println(it) }
}
