class Solution 
fun Solution.maxTaxiEarnings(n: Int, rides: Array<IntArray>): Long {
    val dp = LongArray(n+1)
    val map = Array(n+1){mutableListOf<Int>()}
    for(i in 0 until rides.size)
        map[rides[i][0]].add(i) 
    for(i in n-1 downTo 0){
        // 可以选两种情况，一个是当前不接单
        var max = dp[i+1]
        // 当前接单
        for(j in map[i]){
            val (start,end,tip) = rides[j]
            val money = end-start+tip
            max = Math.max(max,dp[end]+money)
        }
        dp[i] = max
    }
    return dp[0]
}