class Solution 
fun Solution.maxHeight(cuboids: Array<IntArray>): Int {
    val n = cuboids.size
    for(arr in cuboids) arr.sort()
    cuboids.sortWith( compareBy({it[0]}, {it[1]}, {it[2]}))
    //记录以第i个长方体为底的符合规范的高度
    val cached = IntArray(n)
    fun dfs(i:Int):Int{
        if(i==0) return cuboids[0][2]
        if(cached[i]>0) return cached[i]
        var ret = 0
        for(j in i-1 downTo 0){
            if(cuboids[j][1]<=cuboids[i][1]&&cuboids[j][2]<=cuboids[i][2])
                ret = Math.max(ret,dfs(j)) 
        }
        ret += cuboids[i][2] 
        cached[i] = ret
        return ret
    }
    var ret = 0
    for(i in 0 until n)
        ret = Math.max(ret,dfs(i))
    return ret
}