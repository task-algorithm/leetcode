package medium

fun productExceptSelf(nums: IntArray): IntArray {
    val ans = IntArray(nums.size)
    ans.fill(1)

    var curr = 1
    for (i in nums.indices) {
        ans[i] *= curr
        curr *= nums[i]
    }

    curr = 1
    for (i in (0..nums.size - 1).reversed()) {
        ans[i] *= curr
        curr *= nums[i]
    }
    return ans
}

fun main() {
    val nums = intArrayOf(-1, 1, 0, -3, 3)
    val result = productExceptSelf(nums)
    result.forEach { println(it) }
}
