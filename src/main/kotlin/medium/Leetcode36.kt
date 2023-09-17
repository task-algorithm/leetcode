package medium

fun isValidSudoku(board: Array<CharArray>): Boolean {
    for (i in board.indices) {
        for (j in board[i].indices) {
            val target = board[i][j]
            if (target != '.' && !isValid(board, i, j, target)) {
                return false
            }
        }
    }
    return true
}

fun isValid(board: Array<CharArray>, row: Int, col: Int, target: Char): Boolean {
    if (target !in ('1'..'9')) {
        return false
    }
    for (i in board[row].indices) {
        val cur = board[row][i]
        if (cur == target && i != col) return false
    }

    for (i in board.indices) {
        val cur = board[i][col]
        if (cur == target && i != row) return false
    }

    val boxRow = row - row % 3
    val boxCol = col - col % 3
    for (i in boxRow until boxRow + 3) {
        for (j in boxCol until boxCol + 3) {
            val cur = board[i][j]
            if (cur == target && (j != col && i != row)) {
                return false
            }
        }
    }
    return true
}


fun main() {
    val board = arrayOf(
        charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
        charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
        charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
        charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
        charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
        charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
        charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
        charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
        charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9'),
    )
    val valid = isValidSudoku(board)
    check(valid)
}
