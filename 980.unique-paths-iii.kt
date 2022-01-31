class Solution 
val dirs = listOf(-1 to 0,1 to 0,0 to 1,0 to -1)
fun Solution.uniquePathsIII(grid: Array<IntArray>): Int {
    val m = grid.size
    val n = grid[0].size
    var startI = 0
    var startJ = 0
    var zeroNum = 0
    for(i in 0 until m){
        for (j in 0 until n){
            if(grid[i][j]==0) zeroNum++
            else if(grid[i][j]==1) {
                startI = i 
                startJ = j
            }
        }
    }
    val visited = Array(m*n) {false}
    fun dfs(i:Int,j:Int):Int{
        if(i<0 || j<0) return 0
        if(i>=m || j>=n) return 0
        if(grid[i][j]==-1) return 0
        if(grid[i][j]==2) {
            if(visited.fold(0) {r,v->r+if(v) 1 else 0}==zeroNum+1) return 1
            return 0
        }
        val k = i*n+j
        if(visited[k]) return 0
        visited[k]=true
        var ret = dirs.fold(0) {r,(di,dj)->
            r + dfs(i+di,j+dj)
        }
        visited[k]=false
        return ret
    }
    return dfs(startI,startJ)
}