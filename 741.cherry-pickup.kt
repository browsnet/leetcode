class Solution 
data class Position(val i:Int,val j:Int,val k:Int)
fun Solution.cherryPickup(grid: Array<IntArray>): Int {
    val m = grid.size
    val n = grid[0].size
    val cached = mutableMapOf<Position,Int>()
    fun dfs(i:Int,j:Int,k:Int):Int{
        val l = i+j-k
        if(i<0 || j<0 || k<0 || l<0) return -1
        if(grid[i][j]==-1 || grid[k][l]==-1) return -1
        if(i==0 && j==0) return grid[0][0]
        val p = Position(i,j,k)
        if(cached[p]!=null) return cached[p]!!
        var max = -1
        max = Math.max(max,dfs(i-1,j,k))
        max = Math.max(max,dfs(i-1,j,k-1))
        max = Math.max(max,dfs(i,j-1,k))
        max = Math.max(max,dfs(i,j-1,k-1))
        if(max>=0){
            max += grid[i][j]
            if(i!=k) max+=grid[k][l]
        }
        cached[p] = max
        return max
    }
    val ret =  dfs(m-1,n-1,m-1)
    return if(ret<0) 0 else ret
}