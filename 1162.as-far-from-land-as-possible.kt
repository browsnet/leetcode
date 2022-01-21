/*
 * @lc app=leetcode.cn id=1162 lang=kotlin
 *
 * [1162] As Far from Land as Possible
 */

// @lc code=start
class Solution 
fun Solution.maxDistance(grid: Array<IntArray>): Int {
    val n = grid.size
    val dirs = listOf(0 to 1,0 to -1,1 to 0,-1 to 0)
    fun bfs(k:Int):Int{
        val queue = mutableListOf(k to 0)
        val visited = Array(n*n) {false} 
        visited[k] = true
        while(queue.size>0){
            val (k,v) = queue.removeAt(0)
            val i = k/n
            val j = k%n
            for((di,dj) in dirs){
                val ni = di+i
                val nj = dj+j
                if(ni<0 || nj<0) continue
                if(ni>=n || nj>=n) continue
                if(grid[ni][nj]==1) return v+1
                val nk = ni*n+nj
                if(visited[nk]) continue
                visited[nk] = true
                queue.add(nk to v+1)
            }
        }
        return -1
    }
    var ret = -1
    for(i in 0 until n){
        for(j in 0 until n){
            if(grid[i][j]==1)continue
            ret = Math.max(ret,bfs(i*n+j))
        }
    }
    return ret
}
// @lc code=end

