package medium

class RandomizedSet() {

    private val set = mutableListOf<Int>()
    private val hashMap = mutableMapOf<Int, Int>()

    fun insert(`val`: Int): Boolean {
        return if (hashMap[`val`] == null) {
            set.add(`val`)
            hashMap[`val`] = set.size - 1
            true
        } else {
            false
        }
    }

    fun remove(`val`: Int): Boolean {
        return if (hashMap[`val`] == null) {
            false
        } else {
            val index = hashMap[`val`]!!
            set[index] = set[set.size - 1]
            hashMap[set[index]] = index
            set.removeAt(set.size - 1)
            hashMap.remove(`val`)
            true
        }
    }

    fun getRandom(): Int {
        return set.random()
    }
}
