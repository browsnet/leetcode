class Solution 
val MOD = 1000000007
fun Solution.numberOfWays(numPeople: Int): Int {
    val dp = LongArray(numPeople+1)
    dp[0] = 1L
    dp[2] = 1L
    for(i in 4..numPeople){
        for(start in 2..i step 2){
            val left = start-2
            val right = i-start
            val count = (dp[left].toLong()*dp[right])%MOD
            dp[i] = (dp[i]+count) % MOD
        }
    }
    return dp[numPeople].toInt()
}