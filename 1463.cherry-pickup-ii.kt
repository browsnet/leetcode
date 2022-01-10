class Solution 
val dirs = listOf(-1,0,1)
data class Position(val i:Int,val j:Int,val k:Int)
fun Solution.cherryPickup(grid: Array<IntArray>): Int {
    val m = grid.size
    val n = grid[0].size
    val cached = mutableMapOf<Position,Int>()
    fun dfs(i:Int,j:Int,k:Int):Int{
        if(j<0 || k<0) return 0
        if(j>=n || k>=n) return 0
        // 到达最后一行了
        if(i==m) return 0
        val p = Position(i,j,k)
        if(cached[p]!=null) return cached[p]!!
        var max = 0
        for(dj in dirs){
            val nj = j+dj
            for(dk in dirs){
                val nk = k+dk
                max=Math.max(max,dfs(i+1,nj,nk))
            }
        }
        max += grid[i][j]
        if(j!=k) max+=grid[i][k]
        cached[p] = max
        return max
    }
    return dfs(0,0,n-1)
    
}