class Solution 
val dirs = listOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)
fun Solution.getMaximumGold(grid: Array<IntArray>): Int {
    val m = grid.size
    val n = grid[0].size
    val visited = Array(m) {Array(n) {false}}
    fun dfs(i:Int,j:Int):Int{
        visited[i][j] = true
        var ret = 0
        for((di,dj) in dirs){
            val ni = i+di
            val nj = j+dj
            if(ni<0 || nj<0) continue
            if(ni>=m || nj>=n) continue
            if(grid[ni][nj]==0) continue
            if(visited[ni][nj]) continue
            ret = Math.max(ret,dfs(ni,nj))
        }
        visited[i][j] = false
        return ret+grid[i][j]
    }
    var ret = 0
    for(i in 0 until m){
        for(j in 0 until n){
            if(grid[i][j]==0) continue
            ret = Math.max(ret,dfs(i,j))
        }
    }
    return ret
}