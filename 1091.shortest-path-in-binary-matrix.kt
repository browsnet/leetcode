class Solution 
val dirs = listOf(-1 to -1, -1 to 0, -1 to 1,0 to -1, 0 to 1,1 to -1, 1 to 0, 1 to 1)
fun Solution.shortestPathBinaryMatrix(grid: Array<IntArray>): Int {
    val n = grid.size
    if(grid[0][0]==1 || grid[n-1][n-1]==1) return -1
    if(n==1) return 1
    val current = mutableListOf(0 to 1)
    val visited = Array(n*n) {false}
    visited[0] = true
    while(current.size>0){
        val (v,d) = current.removeAt(0)
        val i = v/n
        val j = v%n
        for((di,dj) in dirs){
            val ni = i+di
            val nj = j+dj
            if(ni<0 || nj<0) continue
            if(ni>=n || nj>=n) continue
            if(ni==n-1 && nj==n-1) return d+1
            val nv = ni*n+nj
            if(grid[ni][nj]==1) continue
            if(visited[nv]) continue
            visited[nv] = true
            current.add(nv to d+1)
        }
    }
    return -1
    
}