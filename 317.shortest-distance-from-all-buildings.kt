class Solution 
typealias Point = Pair<Int,Int>
val dirs = listOf(-1 to 0,1 to 0, 0 to 1,0 to -1)
fun Solution.shortestDistance(grid: Array<IntArray>): Int {
    val m = grid.size
    val n = grid[0].size
    val zeros = mutableListOf<Point>()
    for(i in 0 until m){
        for(j in 0 until n){
            if(grid[i][j]==0)
                zeros.add(i to j)
        }
    }
    val zeroMap = mutableMapOf<Point,Int>()
    for(i in 0 until zeros.size){
        zeroMap[zeros[i]] = i
    }
    val k = zeros.size
    val lst = mutableListOf<IntArray>()
    fun getDistance(p:Point):IntArray{
        val current = mutableListOf(p to 0)
        val visited = mutableSetOf(p)
        val arr = IntArray(k) {-1}
        while(current.size>0){
            val (p,d) = current.removeAt(0)
            val (x,y) = p
            for((dx,dy) in dirs){
                val nx = x + dx
                val ny = y + dy
                if(nx<0||ny<0) continue
                if(nx>=m || ny>=n) continue
                if(grid[nx][ny]!=0) continue
                val pair = nx to ny
                if(pair in visited) continue
                visited.add(pair)
                current.add(pair to d+1)
                val i = zeroMap[pair]!!
                arr[i] = d+1
            }
        }
        return arr
    }
    for(i in 0 until m){
        for(j in 0 until n){
            if(grid[i][j]==1){
                lst.add(getDistance(i to j))
            }
        }
    }
    var ret = Int.MAX_VALUE
    loop@for(i in 0 until k){
        var total = 0
        for(j in 0 until lst.size){
            if(lst[j][i]==-1) continue@loop
            total += lst[j][i]
        }
        ret = Math.min(ret,total)
    }
    if(ret==Int.MAX_VALUE) return -1
    return ret
}