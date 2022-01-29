class Solution 
val dirs = listOf(-1 to 0,1 to 0,0 to 1, 0 to -1)
fun Solution.highestPeak(isWater: Array<IntArray>): Array<IntArray> {
    val m = isWater.size
    val n = isWater[0].size
    var current = mutableListOf<Pair<Int,Int>>()
    val visited = Array(m) {Array(n) {false}}
    val ret = Array(m) {IntArray(n)}
    for(i in 0 until m){
        for(j in 0 until n){
            if(isWater[i][j]==1){
                current.add(i to j)
                visited[i][j] = true
            }
        }
    }
    var d = 0
    while(current.size>0){
        val lst = mutableListOf<Pair<Int,Int>>()
        for((i,j) in current){
            for((di,dj) in dirs){
                val ni = i+di
                val nj = j+dj
                if(ni<0||nj<0) continue
                if(ni>=m || nj>=n) continue
                if(visited[ni][nj]) continue
                visited[ni][nj] = true
                lst.add(ni to nj)
                ret[ni][nj] = d+1
            }
        }
        current = lst
        d++
    }
    return ret
}