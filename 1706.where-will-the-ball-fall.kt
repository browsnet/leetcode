/*
 * @lc app=leetcode.cn id=1706 lang=kotlin
 *
 * [1706] Where Will the Ball Fall
 */

// @lc code=start
class Solution 
fun Solution.findBall(grid: Array<IntArray>): IntArray {
    val m = grid.size
    val n = grid[0].size
    var arr = (0 until n).toList()
    for(i in m-1 downTo 0){
        arr = (0 until n).map {
            val nk = grid[i][it]+it
            when{
                nk<0 -> -1
                nk>=n -> -1
                grid[i][nk]==-grid[i][it] -> -1
                else -> arr[nk]
            }
        }
    }
    return arr.toIntArray()
}
// @lc code=end

