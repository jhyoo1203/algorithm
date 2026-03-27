import java.util.*

class Solution {
    data class Pos(val x: Int, val y: Int, val count: Int)
    
    fun solution(board: Array<String>): Int {
        val dx = intArrayOf(-1, 1, 0, 0)
        val dy = intArrayOf(0, 0, -1, 1)
        val n = board.size
        val m = board[0].length
        
        val queue: ArrayDeque<Pos> = ArrayDeque()
        val visited = Array(n) { BooleanArray(m) { false } }
        
        for (i in 0 until n) {
            for (j in 0 until m) {
                if (board[i][j] == 'R') {
                    queue.add(Pos(i, j, 0))
                    visited[i][j] = true
                }
            }
        }
        
        while (queue.isNotEmpty()) {
            val (x, y, count) = queue.remove()
            
            if (board[x][y] == 'G') {
                return count
            }
            
            for (i in 0 until 4) {
                var nx = x
                var ny = y
                
                while (true) {
                    val tx = nx + dx[i]
                    val ty = ny + dy[i]
                    
                    if (tx !in 0 until n || ty !in 0 until m || board[tx][ty] == 'D') {
                        break
                    }
                    
                    nx = tx
                    ny = ty
                }
                
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true
                    queue.add(Pos(nx, ny, count + 1))
                }
            }
        }
        
        return -1
    }
}