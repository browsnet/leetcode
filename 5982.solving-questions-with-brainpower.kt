class Solution 
fun Solution.mostPoints(questions: Array<IntArray>): Long {
    val n = questions.size
    var dp = LongArray(n) {0L}
    for(i in n-1 downTo 0){
        val (points,brainpower) = questions[i]
        if(i==n-1){
            dp[i] = points.toLong()
            continue
        }
        var j = i+brainpower+1
        var v = if(j<n) dp[j] else 0
        dp[i] = Math.max(dp[i+1],v+points)

    }
    return dp[0]
}