class Solution 
// 区间DP可求解
fun Solution.minimumMoves(arr: IntArray): Int {
    val n = arr.size
    val cached = Array(n) {IntArray(n)}
    // 区间[i..j]的结果
    fun dfs(i:Int,j:Int):Int{
        if(i==j) return 1
        if(i==j-1) return if(arr[i]==arr[j]) 1 else 2
        // 两端相同，那么总可以随着里面最后一次操作而删除
        if(arr[i]==arr[j]) return dfs(i+1,j-1)
        if(cached[i][j]>0) return cached[i][j]
        var min = Int.MAX_VALUE
        // 枚举分割点k，求最小结果
        for(k in i until j){
            val v = dfs(i,k)+dfs(k+1,j)
            min = Math.min(min,v)
        }
        cached[i][j] = min
        return min
    }
    return dfs(0,n-1)
}