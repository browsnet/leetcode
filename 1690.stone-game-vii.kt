class Solution 
fun Solution.stoneGameVII(stones: IntArray): Int {
    val n = stones.size
    // 前缀和，用于计算区间和
    var sums = IntArray(n+1)
    for(i in 0 until n)
        sums[i+1] = sums[i]+stones[i]
    val cached = Array(n) {Array<Int>(n) {0}}
    // 我与对手的分值之差
    fun dfs(i:Int,j:Int):Int{
        // 最后一个了，拿走就获得0
        if(i==j) return 0
        if(cached[i][j]>0) return cached[i][j]
        val a = sums[j+1]-sums[i+1] - dfs(i+1,j)
        val b = sums[j]-sums[i] - dfs(i,j-1)
        cached[i][j] = Math.max(a,b)
        return Math.max(a,b)
    }
    return dfs(0,n-1)
}