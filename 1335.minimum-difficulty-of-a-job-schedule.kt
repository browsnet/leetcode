/*
 * @lc app=leetcode.cn id=1335 lang=kotlin
 *
 * [1335] Minimum Difficulty of a Job Schedule
 */

// @lc code=start
class Solution
fun Solution.minDifficulty(jobDifficulty: IntArray, d: Int): Int {
    val n = jobDifficulty.size
    val maxs = Array(n){IntArray(n)}
    for(i in 0 until n) maxs[i][i] = jobDifficulty[i]
    for(i in 0 until n){
        for(j in i+1 until n){
            maxs[i][j] = Math.max(jobDifficulty[j],maxs[i][j-1])
        }
    }
    if(n<d) return -1
    val cached = Array(n){IntArray(d) {-1}}
    fun dfs(i:Int,d:Int):Int{
        // 只有一个了
        if(d==0) return maxs[0][i]
        if(cached[i][d]>=0) return cached[i][d]
        // 找到一个k使得i-k>=d-1
        var min = Int.MAX_VALUE
        for(k in 1..i-d+1){
            val j = i-k
            min=Math.min(min,maxs[j+1][i]+dfs(j,d-1))
        }
        cached[i][d] = min
        return min
    }
    return dfs(n-1,d-1)
}
// @lc code=end

