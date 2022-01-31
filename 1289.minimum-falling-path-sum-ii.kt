class Solution 
fun Solution.minFallingPathSum(grid: Array<IntArray>): Int {
    val n = grid.size
    val cached = Array(n) {Array<Int?>(n) {null}}
    fun dfs(i:Int,j:Int):Int{
        if(i==0) return grid[0][j]
        if(cached[i][j]!=null) return cached[i][j]!!
        var min = Int.MAX_VALUE
        for(k in 0 until n){
            if(k!=j) min = Math.min(min,dfs(i-1,k))
        }
        val ret = min + grid[i][j]
        cached[i][j] = ret
        return ret
    }
    var min = Int.MAX_VALUE
    for(i in 0 until n){
        min = Math.min(min,dfs(n-1,i))
    }
    return min
}