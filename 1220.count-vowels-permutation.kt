// 0:a  1:e  2:i  3:o  4:u
class Solution 
val arr = listOf(listOf(1),listOf(0,2),listOf(0,1,3,4),listOf(2,4),listOf(0))
val MOD = 1000000007
fun Solution.countVowelPermutation(n: Int): Int {
    val dp = Array(n+1){LongArray(5) {0}}
    dp[n] = longArrayOf(1,1,1,1,1)
    for(m in n-1 downTo 1){
        for(i in 0 until 5){
            dp[m][i] = 0L
            for(k in arr[i])
                dp[m][i] +=dp[m+1][k]
            dp[m][i] = dp[m][i]%MOD
        }
    }
    val ret =  (0 until 5).fold(0L) {acc,i -> acc+dp[1][i]}
    return (ret%MOD).toInt()
}