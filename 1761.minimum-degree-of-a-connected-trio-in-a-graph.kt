class Solution 
// 暴力枚举了i,j,k三元组,求可以得到结果
fun Solution.minTrioDegree(n: Int, edges: Array<IntArray>): Int {
    val pair = mutableSetOf<Pair<Int,Int>>()
    for(edge in edges){
        edge.sort()
        pair.add(edge[0] to edge[1])
    }
    val points = Array(n+1) {mutableListOf<Int>()}
    val lines = IntArray(n+1)
    for((a,b) in edges){
        points[a].add(b)
        lines[a]++
        lines[b]++
    }
    var ret = Int.MAX_VALUE
    for(i in 1..n){
        points[i].sort()
        val m = points[i].size
        for(x in 0 until m-1){
            val j = points[i][x]
            for(y in x+1 until m){
                val k = points[i][y]
                val p = j to k
                if(p in pair){
                    val v = lines[i]+lines[j]+lines[k]
                    ret = Math.min(ret,v-6)
                }
            }
        }
    }
    return if(ret==Int.MAX_VALUE) -1 else ret
}